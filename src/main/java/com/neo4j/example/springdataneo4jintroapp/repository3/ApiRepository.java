package com.neo4j.example.springdataneo4jintroapp.repository3;

import com.neo4j.example.springdataneo4jintroapp.model3.Api;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiRepository extends Neo4jRepository<Api, String> {
}
