package com.neo4j.example.springdataneo4jintroapp.versioning.model.nodes;

import com.neo4j.example.springdataneo4jintroapp.versioning.model.nodes.base.Entity;
import com.neo4j.example.springdataneo4jintroapp.versioning.model.processor.annotations.FabricKey;
import com.neo4j.example.springdataneo4jintroapp.versioning.model.edges.ContainsRelationship;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

import static org.neo4j.ogm.annotation.Relationship.OUTGOING;

@NodeEntity("Model")
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Model extends Entity {

    @FabricKey(priority = FabricKey.Priority.DEFAULT)
    private String applicationModuleId;

    private String schema;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Relationship(value = "CONTAINS", direction = OUTGOING)
    private List<ContainsRelationship> containsRelationships = new ArrayList<>();
}
