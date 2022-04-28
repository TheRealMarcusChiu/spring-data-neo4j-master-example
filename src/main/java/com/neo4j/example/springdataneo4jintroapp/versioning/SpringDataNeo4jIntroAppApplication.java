package com.neo4j.example.springdataneo4jintroapp.versioning;

import com.neo4j.example.springdataneo4jintroapp.versioning.service.FabricVersionService;
import com.neo4j.example.springdataneo4jintroapp.versioning.model.edges.ContainsRelationship;
import com.neo4j.example.springdataneo4jintroapp.versioning.model.nodes.Attribute;
import com.neo4j.example.springdataneo4jintroapp.versioning.model.nodes.Model;
import com.neo4j.example.springdataneo4jintroapp.versioning.model.nodes.Person;
import com.neo4j.example.springdataneo4jintroapp.versioning.repository.MissingNonNullFabricKeyGroup;
import com.neo4j.example.springdataneo4jintroapp.versioning.repository.nodes.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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

    @Override
    public void run(String... args) throws MissingNonNullFabricKeyGroup {
        Iterable<Person> ps = personRepository.findAll();
        List<Person> pss = StreamSupport.stream(ps.spliterator(), false)
                .collect(Collectors.toList());

        System.out.println("xc");
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

        Person p = Person.builder()
                .uuid("w")
                .firstName("w")
                .middleName("w")
                .lastName("w")
                .build();

        Person p0 = personRepository.save(p);
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
