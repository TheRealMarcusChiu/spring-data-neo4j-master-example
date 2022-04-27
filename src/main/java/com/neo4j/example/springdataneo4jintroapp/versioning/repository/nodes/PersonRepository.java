package com.neo4j.example.springdataneo4jintroapp.versioning.repository.nodes;

import com.neo4j.example.springdataneo4jintroapp.versioning.repository.nodes.base.FabricNodeNeo4jRepository;
import com.neo4j.example.springdataneo4jintroapp.versioning.model.nodes.Person;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends FabricNodeNeo4jRepository<Person, Long> {

    @Query("MATCH (e:Person {uuid: $uuid}) RETURN e")
    Optional<Person> tester(String uuid);

    @Query("MATCH (p:Person) " +
            "WHERE p.uuid = $uuid " +
            "CALL apoc.path.subgraphAll(p, { " +
            "relationshipFilter: 'CREATE|HAS_STATE|PREVIOUS', " +
            "    minLevel: 0, " +
            "    maxLevel: 1 " +
            "}) YIELD nodes, relationships " +
            "RETURN nodes, relationships")
    Optional<Person> findAllStatesByUuid(String uuid);

    @Query("MATCH (p:Person) " +
            "WHERE p.uuid IN $uuids " +
            "CALL apoc.path.subgraphAll(p, { " +
            "relationshipFilter: 'CREATE|HAS_STATE|PREVIOUS', " +
            "    minLevel: 0, " +
            "    maxLevel: 1 " +
            "}) YIELD nodes, relationships " +
            "RETURN nodes, relationships")
    List<Person> findAllStatesByUuids(List<String> uuids);

    @Deprecated
    @Query("MATCH (e:Person {uuid: $uuid}) WITH e CALL graph.versioner.get.all(e) YIELD path RETURN path")
    Optional<Person> findAllStatesByUuidD(String uuid);
}
