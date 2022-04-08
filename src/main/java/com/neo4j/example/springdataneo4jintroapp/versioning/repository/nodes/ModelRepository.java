package com.neo4j.example.springdataneo4jintroapp.versioning.repository.nodes;

import com.neo4j.example.springdataneo4jintroapp.versioning.model.nodes.Model;
import com.neo4j.example.springdataneo4jintroapp.versioning.repository.nodes.base.FabricNodeNeo4jRepository;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ModelRepository extends FabricNodeNeo4jRepository<Model, Long> {

    @Query("MATCH (m:Model) WHERE m.uuid = $uuid "
            + "OPTIONAL MATCH (m)-[r:CONTAINS]->(a:Attribute) "
            + "RETURN m, collect(r), collect(a)")
    Optional<Model> getWithAttributesByUuid(String uuid);

    @Query("MATCH (m:Model) WHERE m.uuid IN $uuids "
            + "OPTIONAL MATCH (m)-[r:CONTAINS]->(a:Attribute) "
            + "RETURN m, collect(r), collect(a)")
    List<Model> getAllWithAttributesByUuids(List<String> uuids);
}
