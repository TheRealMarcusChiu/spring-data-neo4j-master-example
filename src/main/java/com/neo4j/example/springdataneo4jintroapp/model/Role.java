package com.neo4j.example.springdataneo4jintroapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.neo4j.ogm.annotation.*;

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

    public Role() {
    }

    public void setCustom(String custom) {
        this.custom = custom;
    }
    public String getCustom() {
        return custom;
    }

    public Role(Person person, Movie movie) {
        this.person = person;
        this.movie = movie;
    }

    public Long getId() {
        return id;
    }

    public Person getPerson() {
        return person;
    }

    public Movie getMovie() {
        return movie;
    }
}
