package com.neo4j.example.springdataneo4jintroapp.versioning.repository.nodes.base;

import com.neo4j.example.springdataneo4jintroapp.versioning.model.Asset;
import com.neo4j.example.springdataneo4jintroapp.versioning.model.Node;
import com.neo4j.example.springdataneo4jintroapp.versioning.model.processor.FabricAssetProcessor;
import com.neo4j.example.springdataneo4jintroapp.versioning.model.processor.FabricKeyGroupValue;
import com.neo4j.example.springdataneo4jintroapp.versioning.model.processor.FabricKeyGroupValue.FabricKeyValue;
import com.neo4j.example.springdataneo4jintroapp.versioning.repository.MissingNonNullFabricKeyGroup;
import lombok.NonNull;
import org.neo4j.ogm.session.Session;
import org.springframework.data.neo4j.repository.support.SimpleNeo4jRepository;

import java.io.Serializable;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.*;

public class FabricNodeNeo4jRepositoryClass<T extends Node, ID extends Serializable> extends SimpleNeo4jRepository<T, ID> {

    private final Class<T> nodeClass;
    private final Session session;
    private final FabricAssetProcessor fabricAssetProcessor;
    private final String nodeLabel;

    public FabricNodeNeo4jRepositoryClass(final Class<T> nodeClass,
                                          final Session session,
                                          final FabricAssetProcessor fabricAssetProcessor) {
        super(nodeClass, session);
        this.nodeClass = nodeClass;
        this.session = session;
        this.fabricAssetProcessor = fabricAssetProcessor;
        this.nodeLabel = fabricAssetProcessor.getTopLevelLabel(nodeClass);
    }

    // MATCH (n:NodeLabel) WHERE (n.firstName = person.firstName) OR (n.uuid = person.uuid)
    private static String generateQueryGetAllMatchStatement(final String nodeLabel,
                                                            final List<FabricKeyGroupValue> ll) {
        String t = "MATCH (n:" + nodeLabel + ") WHERE ";
        String filter = ll.stream().map(fkg -> {
            String str = fkg.getKeyValues().stream()
                    .map(fk -> "n." + fk.getPropertyName() + " = map." + fk.getPropertyName())
                    .collect(joining(" AND "));
            return "(" + str + ")";
        }).collect(joining(" OR "));
        return t + filter;
    }

    public <S extends T> Optional<S> get(final S filterModel) throws MissingNonNullFabricKeyGroup {
        List<FabricKeyGroupValue> keyGroupValues = fabricAssetProcessor.getKeyGroupsValues(filterModel, true);
        if (keyGroupValues.isEmpty()) {
            throw new MissingNonNullFabricKeyGroup("");
        }

        HashMap<String, Object> params = new HashMap<>();
        keyGroupValues.stream()
                .flatMap(fkgv -> fkgv.getKeyValues().stream())
                .forEach(fkv -> {
                    String paramName = fkv.getPropertyName();
                    while (params.containsKey(paramName)) {
                        paramName += "1";
                    }
                    params.put(paramName, fkv.getPropertyValue());
                    fkv.setParamName(paramName);
                });

        String cypher = generateGetQuery(keyGroupValues);
        Iterator<T> iterator = session.query(nodeClass, cypher, params).iterator();
        if (iterator.hasNext()) {
            return Optional.of((S) iterator.next());
        } else {
            return Optional.empty();
        }
    }

    private String generateGetQuery(final List<FabricKeyGroupValue> keyGroups) {
        List<String> filters = keyGroups.stream().map(this::generateGetQueryGroupedFilter).collect(toList());
        String combinedFilter = String.join(" OR ", filters);
        return "MATCH (n:" + nodeLabel + ") WHERE " + combinedFilter + " RETURN n";
    }

    private String generateGetQueryGroupedFilter(final @NonNull FabricKeyGroupValue keyGroup) {
        List<String> filters = keyGroup.getKeyValues().stream()
                .map(k -> "n." + k.getPropertyName() + " = $" + k.getParamName())
                .collect(toList());
        String combinedFilter = String.join(" AND ", filters);
        return "(" + combinedFilter + ")";
    }

    public <S extends T> List<S> getAll(final List<S> filterModels) {
        // get key values
        List<List<FabricKeyGroupValue>> keyGroupValuesList = filterModels.stream()
                .map(fm -> fabricAssetProcessor.getKeyGroupsValues(fm, false))
                .collect(toList());

        // set index for models
        IntStream.range(0, filterModels.size()).forEach(i -> filterModels.get(i).setIndex(i));
        // set index for paramNames
        IntStream.range(0, keyGroupValuesList.size()).forEach(i -> {
            keyGroupValuesList.get(i).stream()
                    .flatMap(fkgv -> fkgv.getKeyValues().stream())
                    .forEach(fkv -> fkv.setParamName(fkv.getPropertyName() + i));
        });

        List<Map<String, String>> maps = keyGroupValuesList.stream().map(l -> l.stream().flatMap(ll -> ll.getKeyValues().stream())
                .collect(toMap(FabricKeyValue::getPropertyName, f -> propertyValueToString(f.getPropertyValue())))
        ).collect(toList());
        IntStream.range(0, maps.size()).forEach(i -> maps.get(i).put("index", Integer.toString(i)));
        String cypherQuery = maps.stream().map(map -> {
            String t = map.entrySet().stream().map(m -> m.getKey() + ":" + m.getValue()).collect(joining(", "));
            return "{" + t + "}";
        }).collect(joining(", "));

        String matchQuery = generateQueryGetAllMatchStatement(nodeLabel, fabricAssetProcessor.getAllKeyGroups(nodeClass));

        String cypher = "WITH [" + cypherQuery + "] AS maps "
                + "UNWIND maps AS map "
                + matchQuery + " SET n.index = map.index RETURN n";
        Iterable<T> iterable = session.query(nodeClass, cypher, Map.of());
        Map<Integer, T> responseMap = StreamSupport
                .stream(iterable.spliterator(), false)
                .collect(toMap(Asset::getIndex, r -> r));

        return filterModels.stream().map(m -> (S) responseMap.get(m.getIndex())).collect(toList());
    }

    private String propertyValueToString(final Object o) {
        if (o == null) {
            return "null";
        } else if (String.class.equals(o.getClass())) {
            return "'" + o + "'";
        } else {
            return o.toString();
        }
    }
}
