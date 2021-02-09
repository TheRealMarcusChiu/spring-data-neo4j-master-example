package com.neo4j.example.springdataneo4jintroapp.model2;

import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;

@Data
public class Model2 {
    @Id
    @GeneratedValue
    private Long id;

    private Model3 model3;
}
