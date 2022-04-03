package com.neo4j.example.springdataneo4jintroapp.versioning.model.processor;

import com.neo4j.example.springdataneo4jintroapp.versioning.model.Asset;
import com.neo4j.example.springdataneo4jintroapp.versioning.model.Edge;
import com.neo4j.example.springdataneo4jintroapp.versioning.model.Node;
import com.neo4j.example.springdataneo4jintroapp.versioning.model.processor.FabricKeyGroupValue.FabricKeyValue;
import com.neo4j.example.springdataneo4jintroapp.versioning.model.processor.annotations.FabricKey;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.SneakyThrows;
import org.neo4j.ogm.annotation.NodeEntity;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class FabricAssetProcessor {

    private final Map<Class<? extends Edge>, List<FabricKeyGroup>> edgeKeyGroupsMap = new HashMap<>();
    private final Map<Class<? extends Node>, List<FabricKeyGroup>> nodeKeyGroupsMap = new HashMap<>();
    private final Map<Class<? extends Node>, String> nodeTopLevelLabels = new HashMap<>();

    public FabricAssetProcessor(final Set<@NonNull Class<? extends Node>> nodeClasses,
                                final Set<@NonNull Class<? extends Edge>> edgeClasses) {
        nodeClasses.forEach(this::processNodeClass);
        edgeClasses.forEach(this::processEdgeClass);
    }

    public List<FabricKeyGroupValue> getKeyGroupsValues(final Object object, final boolean returnOnlyGroupsWithNonNullValues) {
        if (object != null) {
            List<FabricKeyGroup> keyGroups = nodeKeyGroupsMap.get(object.getClass());
            if (keyGroups != null) {
                return getKeyGroupsValues(keyGroups, object, returnOnlyGroupsWithNonNullValues);
            }
        }
        return Collections.emptyList();
    }

    public String getTopLevelLabel(final @NonNull Class<?> clazz) {
//        if (nodeTopLevelLabels.get(clazz) == null) {
//            throw new Exception(clazz.getCanonicalName() + " was not processed");
//        }
        return nodeTopLevelLabels.get(clazz);
    }

    public void processNodeClass(final @NonNull Class<? extends Node> clazz) {
        nodeKeyGroupsMap.put(clazz, initializeKeyGroups(clazz));
        nodeTopLevelLabels.put(clazz, initializeNodeLabel(clazz));
    }

    public void processEdgeClass(final @NonNull Class<? extends Edge> clazz) {
        edgeKeyGroupsMap.put(clazz, initializeKeyGroups(clazz));
    }

    private List<FabricKeyGroupValue> getKeyGroupsValues(final List<FabricKeyGroup> keyGroups, final Object object, final boolean returnOnlyGroupsWithNonNullValues) {
        List<FabricKeyGroupValue> t = new ArrayList<>();

        keyGroups.forEach(keyGroup -> {
            List<FabricKeyValue> keyValues = keyGroup.getFields().stream()
                    .map(field -> FabricKeyValue.builder().propertyName(field.getName()).propertyValue(get(object, field)).build())
                    .collect(Collectors.toList());
            if (returnOnlyGroupsWithNonNullValues) {
                long nullValueCount = keyValues.stream().filter(kv -> Objects.isNull(kv.getPropertyValue())).count();
                if (nullValueCount == 0) {
                    t.add(FabricKeyGroupValue.builder().groupPriority(keyGroup.getGroupPriority()).keyValues(keyValues).build());
                }
            } else {
                t.add(FabricKeyGroupValue.builder().groupPriority(keyGroup.getGroupPriority()).keyValues(keyValues).build());
            }
        });

        return t;
    }

    @SneakyThrows
    private Object get(final Object object, final Field field) {
        return field.get(object);
    }

    private String initializeNodeLabel(Class<?> clazz) {
        NodeEntity annotation = clazz.getAnnotation(NodeEntity.class);
        if (isNotNullOrBlank(annotation.label())) {
            return annotation.label();
        } else if (isNotNullOrBlank(annotation.value())) {
            return annotation.value();
        } else {
            return clazz.getSimpleName();
        }
    }

    private List<FabricKeyGroup> initializeKeyGroups(final @NonNull Class<? extends Asset> clazz) {
        Map<Integer, List<Field>> fabricKeyFields = getAllFields(clazz).stream()
                .filter(field -> field.isAnnotationPresent(FabricKey.class))
                .peek(field -> field.setAccessible(true))
                .collect(groupingBy(field -> field.getAnnotation(FabricKey.class).priority()));
        return fabricKeyFields.entrySet().stream()
                .map(e -> new FabricKeyGroup(e.getKey(), e.getValue()))
                .sorted(FabricKeyGroup.COMPARATOR)
                .collect(Collectors.toList());
    }

    private List<Field> getAllFields(final @NonNull Class<? extends Asset> clazz) {
        List<Field> fields = new ArrayList<>();
        ReflectionUtils.doWithFields(clazz, fields::add);
        return fields;
    }

    private boolean isNotNullOrBlank(final String str) {
        return str != null && !str.trim().isEmpty();
    }

    @Data
    @AllArgsConstructor
    private static class FabricKeyGroup {
        public static final Comparator<FabricKeyGroup> COMPARATOR = Comparator.comparing(FabricKeyGroup::getGroupPriority).reversed();

        private Integer groupPriority;
        private List<Field> fields;
    }
}
