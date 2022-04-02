package com.neo4j.example.springdataneo4jintroapp.versioning.model.nodes;

import com.neo4j.example.springdataneo4jintroapp.versioning.model.Entity;
import com.neo4j.example.springdataneo4jintroapp.versioning.model.edges.AttendsRelationship;
import com.neo4j.example.springdataneo4jintroapp.versioning.model.edges.CurrentRelationship;
import com.neo4j.example.springdataneo4jintroapp.versioning.model.edges.HasStateRelationship;
import com.neo4j.example.springdataneo4jintroapp.versioning.model.util.FabricKey;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@NodeEntity("Person")
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Person extends Entity {

    @FabricKey(priority = FabricKey.Priority.DEFAULT)
    private String studentId;

    @FabricKey(priority = FabricKey.Priority.LOWEST)
    private String firstName;
    @FabricKey(priority = FabricKey.Priority.LOWEST)
    private String middleName;
    @FabricKey(priority = FabricKey.Priority.LOWEST)
    private String lastName;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @Relationship("CURRENT")
    private CurrentRelationship currentStateRelationship;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @Relationship("HAS_STATE")
    private List<HasStateRelationship> allStatesRelationships = new ArrayList<>();

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @Relationship("ATTENDS")
    private List<AttendsRelationship> attendsRelationships = new ArrayList<>();
}
