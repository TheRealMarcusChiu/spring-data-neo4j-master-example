package com.neo4j.example.springdataneo4jintroapp.versioning.model.nodes;

import com.neo4j.example.springdataneo4jintroapp.versioning.model.State;
import com.neo4j.example.springdataneo4jintroapp.versioning.model.edges.PreviousRelationship;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.annotation.Transient;

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

    @Relationship(direction = OUTGOING)
    @Transient
    private PreviousRelationship previousStateRelationship;

    @Relationship(direction = INCOMING)
    @Transient
    private PreviousRelationship nextStateRelationship;
}
