package com.neo4j.example.springdataneo4jintroapp.versioning.config;

import com.neo4j.example.springdataneo4jintroapp.versioning.model.Edge;
import com.neo4j.example.springdataneo4jintroapp.versioning.model.Asset;
import com.neo4j.example.springdataneo4jintroapp.versioning.model.Node;
import com.neo4j.example.springdataneo4jintroapp.versioning.model.processor.FabricAssetProcessor;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.reflections.Reflections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static com.neo4j.example.springdataneo4jintroapp.versioning.config.FabricEdgeRepoConfiguration.EDGE_ENTITY_BASE_PACKAGE;

@Configuration
public class FabricAssetProcessorConfiguration {

    @Bean
    public FabricAssetProcessor fabricKeyService() {
        Set<Class<? extends Node>> nodeClasses = findAllClasses(FabricNodeRepoConfiguration.NODE_ENTITY_BASE_PACKAGE, Node.class,
                clazz -> clazz.isAnnotationPresent(NodeEntity.class));
        Set<Class<? extends Edge>> edgeClasses = findAllClasses(EDGE_ENTITY_BASE_PACKAGE, Edge.class,
                clazz -> clazz.isAnnotationPresent(RelationshipEntity.class));
        return new FabricAssetProcessor(nodeClasses, edgeClasses);
    }

    private <T extends Asset> Set<Class<? extends T>> findAllClasses(final String basePackage,
                                                                     final Class<T> type,
                                                                     final Predicate<Class<?>> filter) {
        Reflections reflections = new Reflections(basePackage);
        return reflections.getSubTypesOf(type).stream()
                .filter(filter)
                .collect(Collectors.toSet());
    }
}
