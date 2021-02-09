package com.neo4j.example.springdataneo4jintroapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.neo4j.ogm.annotation.*;

import java.util.ArrayList;
import java.util.List;

@NodeEntity
public class Person {
    @Id
    @GeneratedValue
    private Long id;

    @Property("name")
    private String name;
    @Property("born")
    private int birthyear;

    @Relationship(type="ACTED_IN")
    private Role test;

    @JsonIgnoreProperties("person")
    private List<Role> roles = new ArrayList<>();

    @JsonIgnoreProperties({"directors", "actors"})
    private List<Movie> movies = new ArrayList<>();

    public Person() {
    }

    public Person(String name, int birthyear) {
        this.name = name;
        this.birthyear = birthyear;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) { this.name = name; }

    public int getBirthyear() {
        return birthyear;
    }

    public void setBirthyear(int birthyear) {
        this.birthyear = birthyear;
    }

    public Role getTest() {
        return test;
    }
    public void setTest(Role test) {
        this.test = test;
    }

    public List<Role> getRoles() { return roles; }
    public void setRoles(List<Role> roles) { this.roles = roles; }
    public void addRole(Role role) {
        roles.add(role);
    }

    public List<Movie> getMovies() { return movies; }
    public void setMovies(List<Movie> movies) { this.movies = movies; }
}
