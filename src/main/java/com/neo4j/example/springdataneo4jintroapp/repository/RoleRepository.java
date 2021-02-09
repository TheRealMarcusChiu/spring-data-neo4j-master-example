package com.neo4j.example.springdataneo4jintroapp.repository;

import com.neo4j.example.springdataneo4jintroapp.model.Role;
import com.neo4j.example.springdataneo4jintroapp.util.CustomBeanUtils;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.Optional;

public interface RoleRepository extends Neo4jRepository<Role, Long> {

    default Role upsert(Role role) {
        Optional<Role> rOptional = findByPersonNameAndMovieTitle(role.getPerson().getName(), role.getMovie().getTitle());
        if (rOptional.isEmpty()) {
            return save(role);
        } else {
            Role r = rOptional.get();
            CustomBeanUtils.copyNonNullProperties(role, r);
            return save(r);
        }
    }

    @Query("MATCH (p:Person {name: $name})-[r:ACTED_IN]->(m:Movie {title: $title}) RETURN p,r,m")
    Optional<Role> findByPersonNameAndMovieTitle(String name, String title);
}
