package com.neo4j.example.springdataneo4jintroapp.versioning.repository.nodes;

import com.neo4j.example.springdataneo4jintroapp.versioning.config.FabricNodeRepoConfiguration;
import com.neo4j.example.springdataneo4jintroapp.versioning.testutil.NonEmbeddedNeo4jTestConfiguration;
import com.neo4j.example.springdataneo4jintroapp.versioning.model.nodes.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;

@EnableAutoConfiguration
@SpringBootTest(classes = {NonEmbeddedNeo4jTestConfiguration.class, FabricNodeRepoConfiguration.class})
@EntityScan(
        basePackages = {FabricNodeRepoConfiguration.NODE_ENTITY_BASE_PACKAGE, FabricNodeRepoConfiguration.NODE_ENTITY_SUPER_BASE_PACKAGE})
class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    void test() {
        Person p = Person.builder()
                .uuid("3hello")
                .firstName("jiggly puff")
                .middleName("jo")
                .lastName("turkey")
                .build();

        Person p0 = personRepository.save(p);
    }
}