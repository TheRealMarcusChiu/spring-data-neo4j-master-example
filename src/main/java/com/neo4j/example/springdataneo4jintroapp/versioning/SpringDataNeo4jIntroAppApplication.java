package com.neo4j.example.springdataneo4jintroapp.versioning;

import com.neo4j.example.springdataneo4jintroapp.versioning.model.nodes.Person;
import com.neo4j.example.springdataneo4jintroapp.versioning.repository.nodes.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class SpringDataNeo4jIntroAppApplication implements CommandLineRunner {

    @Autowired
    private PersonRepository personRepository;
//    @Autowired
//    private PersonStateRepository personStateRepository;
//    @Autowired
//    private CurrentRelationshipRepository currentRelationshipRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataNeo4jIntroAppApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Person p = Person.builder().uuid("turkeylegs").firstName("jiggly puff").build();
//        PersonState s = PersonState.builder().build();
//        CurrentRelationship c = CurrentRelationship.builder()
//                .startNode(p)
//                .endNode(s)
//                .build();
//        p.setCurrentStateRelationship(c);
//        s.setCurrentRelationship(c);
//        personEntityRepository.save(p);

        Person p0 = personRepository.save(p);
        Optional<Person> p1 = personRepository.tester("turkeylegs");
//        Optional<Person> p2 = personRepository.get(p);
//        currentRelationshipRepository.get(null);
//
//        Optional<Person> person1 = personRepository.tester("3fa094d2-20d8-461c-a11d-f3124de1a198");
//        Optional<Person> person2 = personRepository.findAllStatesByUuid("3hello");
//        List<Person> persons = personRepository.findAllStatesByUuids(List.of("3hello", "4hello", "5hello", "6hello", "7hello", "8hello", "9hello", "10hello"));

        System.exit(0);
    }
}
