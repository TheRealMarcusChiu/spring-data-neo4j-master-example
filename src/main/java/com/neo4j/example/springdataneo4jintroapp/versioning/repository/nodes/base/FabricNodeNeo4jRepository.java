package com.neo4j.example.springdataneo4jintroapp.versioning.repository.nodes.base;

import com.neo4j.example.springdataneo4jintroapp.versioning.model.Node;
import com.neo4j.example.springdataneo4jintroapp.versioning.repository.MissingNonNullFabricKeyGroup;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.Optional;

public interface FabricNodeNeo4jRepository<T extends Node, ID extends Long> extends Neo4jRepository<T, ID> {

    <S extends T> Optional<S> get(S filterModel) throws MissingNonNullFabricKeyGroup;
}