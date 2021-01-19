package com.neo4j.example.springdataneo4jintroapp.repository2;

import com.neo4j.example.springdataneo4jintroapp.model2.Service;
import org.springframework.data.repository.RepositoryDefinition;

import java.util.Optional;


@RepositoryDefinition(domainClass = Service.class, idClass = String.class)
public interface ServiceRepositoryDefinition {

    void deleteAll();

    void save(Service s);

    Optional<Service> findByName(String name);

    Optional<Service> findByServiceName(String serviceName);
}