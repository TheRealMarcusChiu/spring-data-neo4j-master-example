package com.neo4j.example.springdataneo4jintroapp.versioning.model.nodes;

import com.neo4j.example.springdataneo4jintroapp.versioning.model.edges.ContainsRelationship;
import com.neo4j.example.springdataneo4jintroapp.versioning.model.nodes.base.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import static org.neo4j.ogm.annotation.Relationship.INCOMING;

@Getter
@Setter(AccessLevel.PACKAGE)
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NodeEntity("Attribute")
public class Attribute extends Entity {
    private String value;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Relationship(value = "CONTAINS", direction = INCOMING)
    private ContainsRelationship containsRelationship;
}
