package com.neo4j.example.springdataneo4jintroapp._sandbox;

import com.neo4j.example.springdataneo4jintroapp._sandbox.model.nodes.Person;
import com.neo4j.example.springdataneo4jintroapp._sandbox.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.time.LocalDateTime;
import java.util.Iterator;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringDataNeo4jIntroAppApplication implements CommandLineRunner {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .profiles("sandbox")
                .sources(SpringDataNeo4jIntroAppApplication.class)
                .run(args);
    }

    private final PersonRepository personRepository;

    @Override
    public void run(String... args) throws Exception {
        Iterable<Person> all = personRepository.findAll();
        Iterator<Person> iterator = all.iterator();
        personRepository.save(Person.builder().observationEndDateTime(LocalDateTime.now()).build());
        System.exit(0);
    }
}
