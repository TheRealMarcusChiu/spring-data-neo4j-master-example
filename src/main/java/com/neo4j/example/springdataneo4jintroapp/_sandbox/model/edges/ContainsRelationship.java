package com.neo4j.example.springdataneo4jintroapp._sandbox.model.edges;

import com.neo4j.example.springdataneo4jintroapp._sandbox.model.Edge;
import com.neo4j.example.springdataneo4jintroapp._sandbox.model.nodes.Attribute;
import com.neo4j.example.springdataneo4jintroapp._sandbox.model.nodes.Model;
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
@RelationshipEntity("CONTAINS")
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ContainsRelationship extends Edge {
    @StartNode
    private Model startNode;
    @EndNode
    private Attribute endNode;

    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
