package com.neo4j.example.springdataneo4jintroapp._sandbox.model.nodes;

import com.neo4j.example.springdataneo4jintroapp._sandbox.model.edges.AttendsRelationship;
import com.neo4j.example.springdataneo4jintroapp._sandbox.model.edges.CurrentRelationship;
import com.neo4j.example.springdataneo4jintroapp._sandbox.model.edges.HasStateRelationship;
import com.neo4j.example.springdataneo4jintroapp._sandbox.model.nodes.base.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NodeEntity("Person")
@Getter
@Setter(AccessLevel.PACKAGE)
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true, exclude = {"currentStateRelationship", "allStatesRelationships", "attendsRelationships"})
@EqualsAndHashCode(callSuper = true, exclude = {"currentStateRelationship", "allStatesRelationships", "attendsRelationships"})
public class Person extends Entity {

    private LocalDateTime observationStartDateTime;
    private LocalDateTime observationEndDateTime;

    private String firstName;
    private String middleName;
    private String lastName;

    @Relationship("CURRENT")
    private CurrentRelationship currentStateRelationship;

    @Relationship("HAS_STATE")
    private List<HasStateRelationship> allStatesRelationships = new ArrayList<>();

    @Relationship("ATTENDS")
    private List<AttendsRelationship> attendsRelationships = new ArrayList<>();

}
