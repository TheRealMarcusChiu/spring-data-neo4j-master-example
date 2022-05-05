package com.neo4j.example.springdataneo4jintroapp._sandbox.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;

import java.io.Serializable;

@Getter
@Setter(AccessLevel.PACKAGE)
@SuperBuilder
@NoArgsConstructor
public abstract class Asset implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String uuid;

    @Setter
    private Integer index; // used for batch get
}
