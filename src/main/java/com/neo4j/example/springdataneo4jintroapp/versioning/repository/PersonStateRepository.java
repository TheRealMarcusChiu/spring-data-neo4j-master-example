package com.neo4j.example.springdataneo4jintroapp.versioning.repository;

import com.neo4j.example.springdataneo4jintroapp.versioning.model.nodes.PersonState;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonStateRepository extends Neo4jRepository<PersonState, String> {
}
