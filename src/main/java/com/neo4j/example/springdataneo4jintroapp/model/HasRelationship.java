package com.neo4j.example.springdataneo4jintroapp.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.*;

@Data
@NoArgsConstructor
@RelationshipEntity(type = "HAS")
public class HasRelationship {
    @Id
    @GeneratedValue
    private Long id;

    @StartNode
    private Movie movie;

    @EndNode
    private Prop props;
}
