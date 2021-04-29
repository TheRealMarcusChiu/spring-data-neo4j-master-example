package com.neo4j.example.springdataneo4jintroapp;

import com.google.common.collect.Lists;
import com.neo4j.example.springdataneo4jintroapp.model.Person;
import com.neo4j.example.springdataneo4jintroapp.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.neo4j.DataNeo4jTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataNeo4jTest
class AppTest {

    @Autowired
    PersonRepository personRepository;

    @Test
    void test() {
        Person p = new Person();
        p.setName("jesus christ");

        personRepository.save(p);

        List<Person> personList = Lists.newArrayList(personRepository.findAll());
        assertEquals(1, personList.size());
    }
}
