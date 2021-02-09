package com.neo4j.example.springdataneo4jintroapp.repository2;

import com.neo4j.example.springdataneo4jintroapp.model2.Model1;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface Model1Repository extends Neo4jRepository<Model1, Long> {
}
