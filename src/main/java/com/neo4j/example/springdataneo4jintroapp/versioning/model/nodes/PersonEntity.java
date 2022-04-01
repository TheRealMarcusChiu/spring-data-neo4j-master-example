package com.neo4j.example.springdataneo4jintroapp.versioning.model.nodes;

import com.neo4j.example.springdataneo4jintroapp.versioning.model.State;
import com.neo4j.example.springdataneo4jintroapp.versioning.model.edges.CurrentRelationship;
import com.neo4j.example.springdataneo4jintroapp.versioning.model.edges.HasStateRelationship;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NodeEntity
@SuperBuilder
@NoArgsConstructor
public class PersonEntity extends State {
    private String firstName;
    private String middleName;
    private String lastName;

    @Relationship
    private CurrentRelationship currentStateRelationships;

    @Relationship
    private List<HasStateRelationship> stateRelationships;
}
