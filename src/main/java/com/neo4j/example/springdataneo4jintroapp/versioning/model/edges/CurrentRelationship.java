package com.neo4j.example.springdataneo4jintroapp.versioning.model.edges;

import com.neo4j.example.springdataneo4jintroapp.versioning.model.Edge;
import com.neo4j.example.springdataneo4jintroapp.versioning.model.nodes.base.Entity;
import com.neo4j.example.springdataneo4jintroapp.versioning.model.nodes.base.State;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@RelationshipEntity("CURRENT")
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class CurrentRelationship extends Edge {
    @StartNode
    private Entity startNode;
    @EndNode
    private State endNode;

    private LocalDateTime date;
}
