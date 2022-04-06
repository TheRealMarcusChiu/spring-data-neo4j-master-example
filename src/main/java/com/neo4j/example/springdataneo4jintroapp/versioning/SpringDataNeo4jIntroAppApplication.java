package com.neo4j.example.springdataneo4jintroapp.versioning;

import com.neo4j.example.springdataneo4jintroapp.versioning.model.nodes.Person;
import com.neo4j.example.springdataneo4jintroapp.versioning.repository.MissingNonNullFabricKeyGroup;
import com.neo4j.example.springdataneo4jintroapp.versioning.repository.edges.CurrentRelationshipRepository;
import com.neo4j.example.springdataneo4jintroapp.versioning.repository.nodes.PersonRepository;
import com.neo4j.example.springdataneo4jintroapp.versioning.repository.nodes.PersonStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class SpringDataNeo4jIntroAppApplication implements CommandLineRunner {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private PersonStateRepository personStateRepository;
    @Autowired
    private CurrentRelationshipRepository currentRelationshipRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataNeo4jIntroAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws MissingNonNullFabricKeyGroup {
        List<Person> persons = List.of(
                Person.builder().firstName("Marcus1").uuid("1hello").build(),
                Person.builder().firstName("Unknown").uuid(null).build(),
                Person.builder().firstName(null).uuid("2hello").build()
        );
        List<Person> personList = personRepository.getAll(persons);

//        Person p = Person.builder()
//                .uuid("3hello")
//                .firstName("jiggly puff")
//                .middleName("jo")
//                .lastName("turkey")
//                .build();
//
////        Person p0 = personRepository.save(p);
//        Optional<Person> p1 = personRepository.tester("3hello");
//        Optional<Person> p2 = personRepository.get(p);
//        Optional<Person> p4 = personRepository.findAllStatesByUuid("3hello");
//        List<Person> p5s = personRepository.findAllStatesByUuids(List.of("3hello", "4hello", "5hello", "6hello", "7hello", "8hello", "9hello", "10hello"));

        System.exit(0);
    }

    private void sandbox() {
//        Person p = Person.builder().uuid("turkeylegs").build();
//        PersonState s = PersonState.builder().build();
//        CurrentRelationship c = CurrentRelationship.builder()
//                .startNode(p)
//                .endNode(s)
//                .build();
//        p.setCurrentStateRelationship(c);
//        s.setCurrentRelationship(c);
//        personEntityRepository.save(p);
    }
}
