package com.neo4j.example.springdataneo4jintroapp.versioning.repository.nodes.base;

import com.neo4j.example.springdataneo4jintroapp.versioning.model.Node;
import com.neo4j.example.springdataneo4jintroapp.versioning.model.util.service.FabricKeyGroupValue;
import com.neo4j.example.springdataneo4jintroapp.versioning.model.util.service.FabricKeyGroupValue.FabricKeyValue;
import com.neo4j.example.springdataneo4jintroapp.versioning.model.util.service.FabricKeyService;
import org.neo4j.ogm.cypher.BooleanOperator;
import org.neo4j.ogm.cypher.ComparisonOperator;
import org.neo4j.ogm.cypher.Filter;
import org.neo4j.ogm.cypher.Filters;
import org.neo4j.ogm.session.Session;
import org.springframework.data.neo4j.repository.support.SimpleNeo4jRepository;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FabricNodeNeo4jRepositoryClass<T extends Node, ID extends Serializable> extends SimpleNeo4jRepository<T, ID> {

    private final Class<T> domainClass;
    private final Session session;
    private final FabricKeyService fabricKeyService;

    public FabricNodeNeo4jRepositoryClass(final Class<T> domainClass,
                                          final Session session,
                                          final FabricKeyService fabricKeyService) {
        super(domainClass, session);
        this.domainClass = domainClass;
        this.session = session;
        this.fabricKeyService = fabricKeyService;
//        throw new RuntimeException("Domain class " + domainClass.getCanonicalName()
//                + " has not been processed by FabricAssetProcessor");
    }

    public <S extends T> Optional<S> get(final S filterModel) {
        // get list of non-null keyGroup values and generate query
        List<FabricKeyGroupValue> keyGroupValues = fabricKeyService.getKeyGroupValues(filterModel);
        List<FabricKeyValue> keyValues = keyGroupValues.get(0).getKeyValues();
        List<Filter> filterList = keyValues.stream()
                .map(fkv -> new Filter(fkv.getFieldName(), ComparisonOperator.EQUALS, fkv.getFieldValue()))
                .collect(Collectors.toList());
        filterList.forEach(filter -> filter.setBooleanOperator(BooleanOperator.AND));
        var combinedFilters = new Filters(filterList);
        Collection<T> collection = session.loadAll(domainClass, combinedFilters, 0);
        if (collection.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of((S) collection.iterator().next());
        }
    }

    public <S extends T> List<S> getAll(final List<S> filterModels) {
        return null;
//        if (filterModels == null || filterModels.isEmpty()) {
//            return Collections.emptyList();
//        }
//
//        // get list of non-null keyGroup values and generate query
//        List<FabricKeyGroup> keyGroups = fabricKeyService.getKeyGroups(filterModels.get(0).getClass());
//        List<Filter> filterList = keyGroups.get(0).getFields().stream()
//                .map(field -> new Filter(field.getName(), ComparisonOperator.EQUALS, fabricAssetProcessor.get(filterModel, field)))
//                .collect(Collectors.toList());
//        filterList.forEach(filter -> filter.setBooleanOperator(BooleanOperator.AND));
//        var combinedFilters = new Filters(filterList);
//        Collection<T> collection = session.loadAll(domainClass, combinedFilters);
//        if (collection.isEmpty()) {
//            return Optional.empty();
//        } else {
//            return Optional.of((S) collection.iterator().next());
//        }
    }
}
