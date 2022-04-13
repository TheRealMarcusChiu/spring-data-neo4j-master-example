package com.neo4j.example.springdataneo4jintroapp.multidbconnection.db2.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@NodeEntity
public class User2 {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
}
