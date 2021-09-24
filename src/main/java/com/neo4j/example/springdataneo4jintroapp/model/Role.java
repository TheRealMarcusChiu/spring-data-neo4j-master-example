package com.neo4j.example.springdataneo4jintroapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.*;

@Data
@NoArgsConstructor
@RelationshipEntity(type = "ACTED_IN")
public class Role {
    @Id
    @GeneratedValue
    private Long id;

    private String custom;

    @StartNode
    @JsonIgnoreProperties({"actedIn", "directed"})
    private Person person;

    @EndNode
    @JsonIgnoreProperties({"actors", "directors"})
    private Movie movie;
}
