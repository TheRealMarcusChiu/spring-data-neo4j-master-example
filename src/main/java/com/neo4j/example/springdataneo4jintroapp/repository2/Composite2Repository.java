package com.neo4j.example.springdataneo4jintroapp.repository2;

import com.neo4j.example.springdataneo4jintroapp.converters.Location;
import com.neo4j.example.springdataneo4jintroapp.model2.Composite2;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface Composite2Repository extends Neo4jRepository<Composite2, Location> {
}
