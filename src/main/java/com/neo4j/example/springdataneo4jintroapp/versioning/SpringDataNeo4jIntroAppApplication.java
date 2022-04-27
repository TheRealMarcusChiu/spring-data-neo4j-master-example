package com.neo4j.example.springdataneo4jintroapp.versioning;

import com.neo4j.example.springdataneo4jintroapp.multidbconnection.MainApplication;
import com.neo4j.example.springdataneo4jintroapp.versioning.model.edges.ContainsRelationship;
import com.neo4j.example.springdataneo4jintroapp.versioning.model.nodes.Attribute;
import com.neo4j.example.springdataneo4jintroapp.versioning.model.nodes.Model;
import com.neo4j.example.springdataneo4jintroapp.versioning.model.nodes.Person;
import com.neo4j.example.springdataneo4jintroapp.versioning.repository.MissingNonNullFabricKeyGroup;
import com.neo4j.example.springdataneo4jintroapp.versioning.repository.nodes.PersonRepository;
import com.neo4j.example.springdataneo4jintroapp.versioning.service.FabricVersionService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringDataNeo4jIntroAppApplication implements CommandLineRunner {

    private final PersonRepository personRepository;
    private final FabricVersionService fabricVersionService;

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .profiles("versioning")
                .sources(SpringDataNeo4jIntroAppApplication.class)
                .run(args);
    }

    private Model test(String appModId, String schema, String uuid) {
        Model model = Model.builder().applicationModuleId(appModId).schema(schema).build();
        ContainsRelationship c1 = ContainsRelationship.builder().startNode(model).endNode(Attribute.builder().value("attribute1").build()).build();
        ContainsRelationship c2 = ContainsRelationship.builder().startNode(model).endNode(Attribute.builder().value("attribute2").build()).build();
        ContainsRelationship c3 = ContainsRelationship.builder().startNode(model).endNode(Attribute.builder().value("attribute3").build()).build();
        model.setContainsRelationships(List.of(c1, c2, c3));
        model.setUuid(uuid);
        return model;
    }

    @Override
    public void run(String... args) throws MissingNonNullFabricKeyGroup {
//        List<Model> models = List.of(
//                test("1", "schema1", "mockUuid1"),
//                test("1", "schema2", "mockUuid2"),
//                test("1", "schema3", "mockUuid3"));
//
//        fabricVersionService.persist(models);

//        List<Person> persons = List.of(
//                Person.builder().firstName("Marcus1").uuid("1hello").build(),
//                Person.builder().firstName("Unknown").uuid(null).build(),
//                Person.builder().firstName(null).uuid("2hello").build()
//        );
//        List<Person> personList = personRepository.getAll(persons);

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
        List<Person> p5s = personRepository.findAllStatesByUuids(List.of("3hello", "4hello", "5hello", "6hello", "7hello", "8hello", "9hello", "10hello"));

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
