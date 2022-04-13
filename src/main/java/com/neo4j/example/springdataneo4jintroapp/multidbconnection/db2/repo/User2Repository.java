package com.neo4j.example.springdataneo4jintroapp.multidbconnection.db2.repo;

import com.neo4j.example.springdataneo4jintroapp.multidbconnection.db2.model.User2;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface User2Repository extends Neo4jRepository<User2, Long> {
}
