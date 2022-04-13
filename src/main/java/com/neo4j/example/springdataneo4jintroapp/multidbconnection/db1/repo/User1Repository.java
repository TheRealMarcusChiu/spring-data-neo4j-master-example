package com.neo4j.example.springdataneo4jintroapp.multidbconnection.db1.repo;

import com.neo4j.example.springdataneo4jintroapp.multidbconnection.db1.model.User1;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface User1Repository extends Neo4jRepository<User1, Long> {
}
