package com.neo4j.example.springdataneo4jintroapp.versioning.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;

@Data
@SuperBuilder
@NoArgsConstructor
public class Asset {

    private Long id;

    @Id
    @GeneratedValue
    private String uuid;
}
