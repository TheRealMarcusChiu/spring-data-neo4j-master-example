package com.neo4j.example.springdataneo4jintroapp.model2;

import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@Data
@NodeEntity
public class Model1 {

    @Id
    @GeneratedValue
    private Long id;

    private Model2 model2;
}
