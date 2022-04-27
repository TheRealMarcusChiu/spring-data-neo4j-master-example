package com.neo4j.example.springdataneo4jintroapp.versioning.config;

import com.neo4j.example.springdataneo4jintroapp.versioning.repository.nodes.base.FabricNodeNeo4jRepositoryClass;
import com.neo4j.example.springdataneo4jintroapp.versioning.repository.nodes.base.FabricNodeNeo4jRepositoryFactoryBean;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@Configuration
@Import(FabricAssetProcessorConfiguration.class)
@EnableNeo4jRepositories(
        repositoryBaseClass = FabricNodeNeo4jRepositoryClass.class,
        repositoryFactoryBeanClass = FabricNodeNeo4jRepositoryFactoryBean.class,
        basePackages = {FabricNodeRepoConfiguration.NODE_REPO_BASE_PACKAGE})
@EntityScan(
        basePackages = {FabricNodeRepoConfiguration.NODE_ENTITY_BASE_PACKAGE, FabricNodeRepoConfiguration.NODE_ENTITY_SUPER_BASE_PACKAGE})
public class FabricNodeRepoConfiguration {
    public static final String NODE_ENTITY_BASE_PACKAGE = "com.neo4j.example.springdataneo4jintroapp.versioning.model.nodes";
    public static final String NODE_ENTITY_SUPER_BASE_PACKAGE = "com.neo4j.example.springdataneo4jintroapp.versioning.model";
    public static final String NODE_REPO_BASE_PACKAGE = "com.neo4j.example.springdataneo4jintroapp.versioning.repository.nodes";

    public static final String[] NODE_ENTITY_BASE_PACKAGES = {
            NODE_ENTITY_BASE_PACKAGE, NODE_ENTITY_SUPER_BASE_PACKAGE
    };
}
