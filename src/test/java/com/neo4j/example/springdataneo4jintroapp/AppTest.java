package com.neo4j.example.springdataneo4jintroapp;

import com.neo4j.example.springdataneo4jintroapp.model.Person;
import com.neo4j.example.springdataneo4jintroapp.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.neo4j.DataNeo4jTest;
import org.springframework.boot.test.context.SpringBootTest;

@DataNeo4jTest
public class AppTest {

    @Autowired
    PersonRepository personRepository;

    @Test
    public void test() {
        Person p = new Person();
        p.setName("jesus christ");
        personRepository.save(p);
        System.out.println("works");
    }
}
