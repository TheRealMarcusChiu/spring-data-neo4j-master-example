package com.neo4j.example.springdataneo4jintroapp.versioning.config;

import com.neo4j.example.springdataneo4jintroapp.versioning.repository.edges.base.FabricEdgeNeo4jRepositoryClass;
import com.neo4j.example.springdataneo4jintroapp.versioning.repository.edges.base.FabricEdgeNeo4jRepositoryFactoryBean;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@Configuration
@EnableNeo4jRepositories(
        repositoryBaseClass = FabricEdgeNeo4jRepositoryClass.class,
        repositoryFactoryBeanClass = FabricEdgeNeo4jRepositoryFactoryBean.class,
        basePackages = {FabricEdgeRepoConfiguration.EDGE_REPO_BASE_PACKAGE})
@EntityScan(
        basePackages = {FabricEdgeRepoConfiguration.EDGE_ENTITY_BASE_PACKAGE, FabricEdgeRepoConfiguration.EDGE_ENTITY_SUPER_BASE_PACKAGE})
public class FabricEdgeRepoConfiguration {
    public static final String EDGE_ENTITY_BASE_PACKAGE = "com.neo4j.example.springdataneo4jintroapp.versioning.model.edges";
    public static final String EDGE_ENTITY_SUPER_BASE_PACKAGE = "com.neo4j.example.springdataneo4jintroapp.versioning.model";
    public static final String EDGE_REPO_BASE_PACKAGE = "com.neo4j.example.springdataneo4jintroapp.versioning.repository.edges";
}
