package com.neo4j.example.springdataneo4jintroapp.versioning.repository;

import com.neo4j.example.springdataneo4jintroapp.versioning.model.nodes.PersonEntity;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonEntityRepository extends Neo4jRepository<PersonEntity, String> {
}
