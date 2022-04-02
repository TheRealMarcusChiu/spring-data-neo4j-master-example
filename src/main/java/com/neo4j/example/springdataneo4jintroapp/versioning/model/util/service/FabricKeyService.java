package com.neo4j.example.springdataneo4jintroapp.versioning.model.util.service;

import com.neo4j.example.springdataneo4jintroapp.versioning.model.nodes.Person;
import com.neo4j.example.springdataneo4jintroapp.versioning.model.util.FabricKey;
import com.neo4j.example.springdataneo4jintroapp.versioning.model.util.service.FabricKeyGroupValue.FabricKeyValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class FabricKeyService {

    private final Map<Class<?>, List<FabricKeyGroup>> keyGroupsMap = new HashMap<>();

    public FabricKeyService(final Set<Class<?>> nodeClasses,
                            final Set<Class<?>> edgeClasses) {
        nodeClasses.forEach(this::process);
        edgeClasses.forEach(this::process);
    }

    public List<FabricKeyGroupValue> getKeyGroupValues(final Object object) {
        if (object != null) {
            List<FabricKeyGroup> keyGroups = keyGroupsMap.get(object.getClass());
            if (keyGroups != null) {
                return getKeyGroupValues(keyGroups, object);
            }
        }
        return Collections.emptyList();
    }

    private List<FabricKeyGroupValue> getKeyGroupValues(final List<FabricKeyGroup> keyGroups, final Object object) {
        List<FabricKeyGroupValue> t = new ArrayList<>();

        keyGroups.forEach(keyGroup -> {
            List<FabricKeyValue> keyValues = keyGroup.getFields().stream()
                    .map(field -> FabricKeyValue.builder().fieldName(field.getName()).fieldValue(get(object, field)).build())
                    .collect(Collectors.toList());
            t.add(FabricKeyGroupValue.builder().groupPriority(keyGroup.getGroupPriority()).keyValues(keyValues).build());
        });

        return t;
    }

    @SneakyThrows
    private Object get(final Object object, final Field field) {
        return field.get(object);
    }

    private void process(final Class<?> clazz) {
        Map<Integer, List<Field>> collect = getAllFields(clazz).stream()
                .filter(field -> field.isAnnotationPresent(FabricKey.class))
                .peek(field -> field.setAccessible(true))
                .collect(groupingBy(field -> field.getAnnotation(FabricKey.class).priority()));
        List<FabricKeyGroup> keyGroups = collect.entrySet().stream()
                .map(e -> new FabricKeyGroup(e.getKey(), e.getValue()))
                .sorted(FabricKeyGroup.COMPARATOR)
                .collect(Collectors.toList());
        keyGroupsMap.put(clazz, keyGroups);
    }

    private List<Field> getAllFields(Class<?> clazz) {
        if (clazz == null) {
            return Collections.emptyList();
        } else {
            List<Field> fields = new ArrayList<>();
            ReflectionUtils.doWithFields(Person.class, fields::add);
            return fields;
        }
    }

    @Data
    @AllArgsConstructor
    private static class FabricKeyGroup {
        public static final Comparator<FabricKeyGroup> COMPARATOR = Comparator.comparing(FabricKeyGroup::getGroupPriority).reversed();

        private Integer groupPriority;
        private List<Field> fields;
    }
}
