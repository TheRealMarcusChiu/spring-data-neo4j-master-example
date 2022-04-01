package com.neo4j.example.springdataneo4jintroapp.versioning;

import com.neo4j.example.springdataneo4jintroapp.versioning.repository.PersonEntityRepository;
import com.neo4j.example.springdataneo4jintroapp.versioning.repository.PersonStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@SpringBootApplication
@EntityScan("com.neo4j.example.springdataneo4jintroapp.versioning.model")
@EnableNeo4jRepositories("com.neo4j.example.springdataneo4jintroapp.versioning.repository")
public class SpringDataNeo4jIntroAppApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataNeo4jIntroAppApplication.class, args);
    }

    @Autowired
    private PersonEntityRepository personEntityRepository;
    @Autowired
    private PersonStateRepository personStateRepository;

    @Override
    public void run(String... args) {
        System.exit(0);
    }
}
