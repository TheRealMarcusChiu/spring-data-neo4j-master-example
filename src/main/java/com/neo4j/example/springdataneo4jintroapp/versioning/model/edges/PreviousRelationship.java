package com.neo4j.example.springdataneo4jintroapp.versioning.model.edges;

import com.neo4j.example.springdataneo4jintroapp.versioning.model.RelationshipAsset;
import com.neo4j.example.springdataneo4jintroapp.versioning.model.State;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;
import org.neo4j.ogm.annotation.Transient;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@RelationshipEntity("PREVIOUS")
public class PreviousRelationship extends RelationshipAsset {
    @StartNode
    @Transient
    private State startNode;
    @EndNode
    @Transient
    private State endNode;
}
