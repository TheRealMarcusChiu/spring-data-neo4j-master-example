package com.neo4j.example.springdataneo4jintroapp.versioning.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
//@NoArgsConstructor
@AllArgsConstructor
public class RelationshipAsset extends Asset {
}
