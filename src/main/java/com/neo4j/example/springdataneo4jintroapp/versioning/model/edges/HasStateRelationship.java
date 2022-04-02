package com.neo4j.example.springdataneo4jintroapp.versioning.model.edges;

import com.neo4j.example.springdataneo4jintroapp.versioning.model.Edge;
import com.neo4j.example.springdataneo4jintroapp.versioning.model.Entity;
import com.neo4j.example.springdataneo4jintroapp.versioning.model.State;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

@EqualsAndHashCode(callSuper = true)
@Data
@RelationshipEntity("HAS_STATE")
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class HasStateRelationship extends Edge {
    @StartNode
    private Entity startNode;
    @EndNode
    private State endNode;
}