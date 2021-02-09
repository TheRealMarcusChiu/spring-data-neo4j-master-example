package com.neo4j.example.springdataneo4jintroapp.repository2;

import com.neo4j.example.springdataneo4jintroapp.model2.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ServiceCustomRepositoryImpl implements ServiceCustomRepository {

    @Autowired
    ServiceRepository serviceRepository;

    @Override
    public Optional<Service> customFind() {
        System.out.println("inside custom find");
        return Optional.empty();
    }
}
