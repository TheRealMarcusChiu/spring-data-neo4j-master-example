package com.neo4j.example.springdataneo4jintroapp.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@Data
@NodeEntity
@NoArgsConstructor
public class Prop {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Relationship(type = "HAS", direction = Relationship.INCOMING)
    private HasRelationship hasRelationship;
}
