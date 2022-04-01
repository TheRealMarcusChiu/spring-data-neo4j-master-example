package com.neo4j.example.springdataneo4jintroapp.versioning.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.id.UuidStrategy;

import java.io.Serializable;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public abstract class Asset implements Serializable {

    private Long id;

    @Id
    @GeneratedValue(strategy = UuidStrategy.class)
    private String uuid;
}
