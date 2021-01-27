package com.neo4j.example.springdataneo4jintroapp.repository2;

import com.neo4j.example.springdataneo4jintroapp.model2.Composite1;
import com.neo4j.example.springdataneo4jintroapp.model2.Composite1Id;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface Composite1Repository extends Neo4jRepository<Composite1, Composite1Id> {
}
