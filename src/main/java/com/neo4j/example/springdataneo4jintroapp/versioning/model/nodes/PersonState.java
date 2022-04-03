package com.neo4j.example.springdataneo4jintroapp.versioning.model.nodes;

import com.neo4j.example.springdataneo4jintroapp.versioning.model.edges.CurrentRelationship;
import com.neo4j.example.springdataneo4jintroapp.versioning.model.edges.HasStateRelationship;
import com.neo4j.example.springdataneo4jintroapp.versioning.model.edges.PreviousRelationship;
import com.neo4j.example.springdataneo4jintroapp.versioning.model.nodes.base.State;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import static org.neo4j.ogm.annotation.Relationship.INCOMING;
import static org.neo4j.ogm.annotation.Relationship.OUTGOING;

@EqualsAndHashCode(callSuper = true)
@Data
@NodeEntity("PersonState")
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class PersonState extends State {

    private String firstName;
    private String middleName;
    private String lastName;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @Relationship(value = "CURRENT", direction = INCOMING)
    private CurrentRelationship currentRelationship;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @Relationship(value = "HAS_STATE", direction = INCOMING)
    private HasStateRelationship hasStateRelationship;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @Relationship(value = "PREVIOUS", direction = OUTGOING)
    private PreviousRelationship previousStateRelationship;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @Relationship(value = "PREVIOUS", direction = INCOMING)
    private PreviousRelationship nextStateRelationship;
}
