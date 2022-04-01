package com.neo4j.example.springdataneo4jintroapp.versioning.repository;

import com.neo4j.example.springdataneo4jintroapp.versioning.model.nodes.Person;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonEntityRepository extends Neo4jRepository<Person, String> {
    @Query("MATCH (e:Person {uuid: $uuid}) WITH e CALL graph.versioner.get.all(e) YIELD path RETURN path")
    Optional<Person> findAllStatesByUuid(String uuid);
}
