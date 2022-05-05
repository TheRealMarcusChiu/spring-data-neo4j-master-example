package com.neo4j.example.springdataneo4jintroapp._sandbox.model.nodes;

import com.neo4j.example.springdataneo4jintroapp._sandbox.model.edges.ContainsRelationship;
import com.neo4j.example.springdataneo4jintroapp._sandbox.model.nodes.base.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

import static org.neo4j.ogm.annotation.Relationship.OUTGOING;

@Getter
@Setter(AccessLevel.PACKAGE)
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NodeEntity("Model")
public class Model extends Entity {

    private String applicationModuleId;

    private String schema;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Relationship(value = "CONTAINS", direction = OUTGOING)
    private List<ContainsRelationship> containsRelationships = new ArrayList<>();
}
