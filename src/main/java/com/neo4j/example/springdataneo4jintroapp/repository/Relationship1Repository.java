package com.neo4j.example.springdataneo4jintroapp.repository;

import com.neo4j.example.springdataneo4jintroapp.model3.Relationship1;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface Relationship1Repository extends Neo4jRepository<Relationship1, String> {

    @Query("MATCH (n1 {uuid: $startUuid})-[$properties]-(n2 {uuid: $startUuid}) RETURN *")
    List<Relationship1> test(String startUuid, String endUuid, Map<String, Object> properties);
}
