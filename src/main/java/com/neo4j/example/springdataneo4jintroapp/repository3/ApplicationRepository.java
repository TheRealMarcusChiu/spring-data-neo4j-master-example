package com.neo4j.example.springdataneo4jintroapp.repository3;

import com.neo4j.example.springdataneo4jintroapp.model3.Application;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepository extends Neo4jRepository<Application, String> {
}
