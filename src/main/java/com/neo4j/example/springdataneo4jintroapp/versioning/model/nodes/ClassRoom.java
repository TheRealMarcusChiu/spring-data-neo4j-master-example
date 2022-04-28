package com.neo4j.example.springdataneo4jintroapp.versioning.model.nodes;

import com.neo4j.example.springdataneo4jintroapp.versioning.model.Node;
import com.neo4j.example.springdataneo4jintroapp.versioning.model.edges.AttendsRelationship;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

import static org.neo4j.ogm.annotation.Relationship.INCOMING;

@Getter
@Setter(AccessLevel.PACKAGE)
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NodeEntity("ClassRoom")
public class ClassRoom extends Node {
    private String subject;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @Relationship(value = "ATTENDS", direction = INCOMING)
    private List<AttendsRelationship> attendsRelationships;
}
