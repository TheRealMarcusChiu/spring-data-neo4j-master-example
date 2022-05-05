package com.neo4j.example.springdataneo4jintroapp._sandbox.repository;

import com.neo4j.example.springdataneo4jintroapp._sandbox.model.nodes.Person;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends Neo4jRepository<Person, Long> {
}
