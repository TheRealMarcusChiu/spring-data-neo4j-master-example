package com.neo4j.example.springdataneo4jintroapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NodeEntity
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue
    private Long id;

    @Property("name")
    private String name;
    @Property("born")
    private int birthyear;

    @Relationship(type="ACTED_IN")
    private Role role;

    @JsonIgnoreProperties("person")
    private List<Role> roles = new ArrayList<>();

    @JsonIgnoreProperties({"directors", "actors"})
    private List<Movie> movies = new ArrayList<>();
}
