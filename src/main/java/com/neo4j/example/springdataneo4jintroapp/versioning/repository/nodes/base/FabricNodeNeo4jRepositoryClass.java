package com.neo4j.example.springdataneo4jintroapp.versioning.repository.nodes.base;

import com.neo4j.example.springdataneo4jintroapp.versioning.model.Node;
import com.neo4j.example.springdataneo4jintroapp.versioning.model.util.service.FabricAssetService;
import com.neo4j.example.springdataneo4jintroapp.versioning.model.util.service.FabricKeyGroupValue;
import com.neo4j.example.springdataneo4jintroapp.versioning.repository.MissingNonNullFabricKeyGroup;
import lombok.Data;
import lombok.NonNull;
import org.neo4j.ogm.session.Session;
import org.springframework.data.neo4j.repository.support.SimpleNeo4jRepository;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FabricNodeNeo4jRepositoryClass<T extends Node, ID extends Serializable> extends SimpleNeo4jRepository<T, ID> {

    private final Class<T> nodeClass;
    private final Session session;
    private final FabricAssetService fabricAssetService;
    private final String nodeLabel;

    public FabricNodeNeo4jRepositoryClass(final Class<T> nodeClass,
                                          final Session session,
                                          final FabricAssetService fabricAssetService) {
        super(nodeClass, session);
        this.nodeClass = nodeClass;
        this.session = session;
        this.fabricAssetService = fabricAssetService;
        this.nodeLabel = fabricAssetService.getTopLevelLabel(nodeClass);
    }

    public <S extends T> Optional<S> get(final S filterModel) throws MissingNonNullFabricKeyGroup {
        List<FabricKeyGroupValue> keyGroupValues = fabricAssetService.getKeyGroupsValues(filterModel, true);
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

        String cypher = generateQuery(keyGroupValues);
        Iterator<T> iterator = session.query(nodeClass, cypher, params).iterator();
        if (iterator.hasNext()) {
            return Optional.of((S) iterator.next());
        } else {
            return Optional.empty();
        }
    }

    private String generateQuery(final List<FabricKeyGroupValue> keyGroups) {
        List<String> filters = keyGroups.stream().map(this::generateGroupedFilter).collect(Collectors.toList());
        String combinedFilter = String.join(" OR ", filters);
        return "MATCH (n:" + nodeLabel + ") WHERE " + combinedFilter + " RETURN n";
    }

    private String generateGroupedFilter(final @NonNull FabricKeyGroupValue keyGroup) {
        List<String> filters = keyGroup.getKeyValues().stream()
                .map(k -> "n." + k.getPropertyName() + " = $" + k.getParamName())
                .collect(Collectors.toList());
        String combinedFilter = String.join(" AND ", filters);
        return "(" + combinedFilter + ")";
    }
}
