package com.neo4j.example.springdataneo4jintroapp.repository;

import com.neo4j.example.springdataneo4jintroapp.model.Person;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends Neo4jRepository<Person, Long> {

    Person getPersonByName(String name);

    Iterable<Person> findPersonByNameLike(String name);

    @Query("MATCH (p1:Prop)<-[h1:HAS]-(am:Movie)<-[ai:ACTED_IN]-(p:Person)-[d:DIRECTED]->(dm:Movie)-[h2:HAS]->(p2:Prop)" +
            " return p, collect(ai), collect(d), collect(h1), collect(h2), collect(am), collect(dm), collect(p1), collect(p2)")
    List<Person> getPersonsWhoActAndDirect();
}
