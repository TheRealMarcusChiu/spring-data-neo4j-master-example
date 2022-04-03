package com.neo4j.example.springdataneo4jintroapp.versioning.repository.edges.base;

import com.neo4j.example.springdataneo4jintroapp.versioning.model.Edge;
import com.neo4j.example.springdataneo4jintroapp.versioning.model.processor.FabricAssetProcessor;
import org.neo4j.ogm.session.Session;
import org.springframework.data.neo4j.repository.support.SimpleNeo4jRepository;

import java.io.Serializable;
import java.util.Optional;

public class FabricEdgeNeo4jRepositoryClass<T extends Edge, ID extends Serializable> extends SimpleNeo4jRepository<T, ID> {

    private final Class<T> domainClass;
    private final Session session;
    private final FabricAssetProcessor fabricAssetProcessor;

    public FabricEdgeNeo4jRepositoryClass(final Class<T> domainClass,
                                          final Session session,
                                          final FabricAssetProcessor fabricAssetProcessor) {
        super(domainClass, session);
        fabricAssetProcessor.processEdgeClass(domainClass);
        this.domainClass = domainClass;
        this.session = session;
        this.fabricAssetProcessor = fabricAssetProcessor;
//        if (fabricNodeKeyService.isNode(domainClass)) {
//            this.getFunction = this::getFunctionNode;
//        } else if (fabricNodeKeyService.isEdge(domainClass)) {
//            this.getFunction = this::getFunctionEdge;
//        } else {
//            throw new RuntimeException("Domain class " + domainClass.getCanonicalName()
//                    + " has not been processed by FabricAssetProcessor");
//        }
    }

    public <S extends T> Optional<S> get(final S filterModel) {
        return Optional.empty();
    }

//    private <S extends T> Optional<S> getFunctionEdge(final S filterModel) {
//        List<Field> keys = fabricAssetProcessor.getEdgeFirstMatchingKeys(filterModel);
//
//        if (keys == null) {
//            throw new MissingRequiredFieldException("Must define non-null values for class " + filterModel.getClass().getCanonicalName() + " (TODO specify fields)");
//        }
//
//        var model = (RelationshipAsset) filterModel;
//        if (Objects.nonNull(model.getStartNode())
//                && Objects.nonNull(model.getStartNode().getUuid())
//                && Objects.nonNull(model.getEndNode())
//                && Objects.nonNull(model.getEndNode().getUuid())) {
//            String startUuid = model.getStartNode().getUuid();
//            String endUuid = model.getEndNode().getUuid();
//            String query = "MATCH (n1 {uuid:'" + startUuid + "'})-[r" + generatePropertiesMap(keys, model) + "]->(n2 {uuid:'" + endUuid + "'}) RETURN *";
//            var edge = session.queryForObject(domainClass, query, Map.of());
//            if (Objects.nonNull(edge)) {
//                return (Optional<S>) Optional.of(edge);
//            }
//        }
//        return Optional.empty();
//    }
//
//    private String generatePropertiesMap(final List<Field> keys, final RelationshipAsset filterModel) {
//        List<String> propertyMap = keys.stream().map(field -> generatePropertyMap(field, filterModel)).collect(Collectors.toList());
//        String propertiesMap = propertyMap.stream()
//                .filter(Strings::isNotBlank)
//                .collect(Collectors.joining(","));
//        return "{" + propertiesMap + "}";
//    }
//
//    private String generatePropertyMap(final Field field, final RelationshipAsset filterModel) {
//        var value = fabricAssetProcessor.get(filterModel, field);
//        if (field.getType().equals(String.class)) {
//            value = "'" + value + "'";
//        }
//        return field.getName() + ":" + value;
//    }
}
