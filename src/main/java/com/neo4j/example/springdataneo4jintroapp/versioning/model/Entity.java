package com.neo4j.example.springdataneo4jintroapp.versioning.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
//@NoArgsConstructor
@AllArgsConstructor
public class Entity extends Asset {
}
