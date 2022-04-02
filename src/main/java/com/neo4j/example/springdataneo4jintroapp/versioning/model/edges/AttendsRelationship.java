package com.neo4j.example.springdataneo4jintroapp.versioning.model.edges;

import com.neo4j.example.springdataneo4jintroapp.versioning.model.Edge;
import com.neo4j.example.springdataneo4jintroapp.versioning.model.nodes.ClassRoom;
import com.neo4j.example.springdataneo4jintroapp.versioning.model.nodes.Person;
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
@RelationshipEntity("ATTENDS")
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class AttendsRelationship extends Edge {
    @StartNode
    private Person startNode;
    @EndNode
    private ClassRoom endNode;
}
