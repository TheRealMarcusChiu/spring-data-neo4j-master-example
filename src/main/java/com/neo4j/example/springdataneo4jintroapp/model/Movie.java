package com.neo4j.example.springdataneo4jintroapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.neo4j.ogm.annotation.Relationship.INCOMING;

@Data
@NoArgsConstructor
@NodeEntity
public class Movie {
    @Id
    @GeneratedValue
    private Long id;

    @Property("title")
    private String title;
    @Property("released")
    private int released;
    @Property("tagline")
    private String description;

    @JsonIgnoreProperties("movie")
    @Relationship(type = "ACTED_IN", direction = INCOMING)
    private List<Role> actors = new ArrayList<>();

    @JsonIgnoreProperties({"actedIn", "directed"})
    @Relationship(type = "DIRECTED", direction = INCOMING)
    private List<Person> directors = new ArrayList<>();

    @Relationship(type = "HAS", direction = "OUTGOING")
    private List<HasRelationship> hasRelationships;
}
