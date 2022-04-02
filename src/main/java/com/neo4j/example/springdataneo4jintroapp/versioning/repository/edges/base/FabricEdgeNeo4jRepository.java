package com.neo4j.example.springdataneo4jintroapp.versioning.repository.edges.base;

import com.neo4j.example.springdataneo4jintroapp.versioning.model.Edge;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.Optional;

public interface FabricEdgeNeo4jRepository<T extends Edge, ID extends Long> extends Neo4jRepository<T, ID> {

    <S extends T> Optional<S> get(S filterModel);
}