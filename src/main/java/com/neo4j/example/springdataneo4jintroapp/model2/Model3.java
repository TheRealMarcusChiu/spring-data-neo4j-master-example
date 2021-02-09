package com.neo4j.example.springdataneo4jintroapp.model2;

import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;

@Data
public class Model3 {
    @Id
    @GeneratedValue
    private Long id;
}
