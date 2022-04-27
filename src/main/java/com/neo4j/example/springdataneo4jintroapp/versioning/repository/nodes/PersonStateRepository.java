package com.neo4j.example.springdataneo4jintroapp.versioning.repository.nodes;

import com.neo4j.example.springdataneo4jintroapp.versioning.repository.nodes.base.FabricNodeNeo4jRepository;
import com.neo4j.example.springdataneo4jintroapp.versioning.model.nodes.PersonState;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonStateRepository extends FabricNodeNeo4jRepository<PersonState, Long> {
}
