package com.neo4j.example.springdataneo4jintroapp.versioning.testutil;

import org.apache.commons.lang3.ArrayUtils;

import static com.neo4j.example.springdataneo4jintroapp.versioning.config.FabricEdgeRepoConfiguration.EDGE_ENTITY_BASE_PACKAGES;
import static com.neo4j.example.springdataneo4jintroapp.versioning.config.FabricNodeRepoConfiguration.NODE_ENTITY_BASE_PACKAGES;

public class Neo4jTestConfiguration {
    String DELETE_ALL_QUERY = "MATCH (n) DETACH DELETE n";
    String[] NEO4J_ENTITY_BASE_PACKAGES = ArrayUtils.addAll(NODE_ENTITY_BASE_PACKAGES, EDGE_ENTITY_BASE_PACKAGES);;

    public void clearDB() {}

    public void executeScript(String scriptPath) {}
}