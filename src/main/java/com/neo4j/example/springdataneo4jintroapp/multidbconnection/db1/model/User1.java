package com.neo4j.example.springdataneo4jintroapp.multidbconnection.db1.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@NodeEntity
public class User1 {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
}
