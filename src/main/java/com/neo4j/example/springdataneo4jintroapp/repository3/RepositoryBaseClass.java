package com.neo4j.example.springdataneo4jintroapp.repository3;

import org.neo4j.ogm.session.Session;
import org.springframework.data.neo4j.repository.support.SimpleNeo4jRepository;

import java.io.Serializable;

public class RepositoryBaseClass<T, ID extends Serializable> extends SimpleNeo4jRepository<T, ID> {

    public RepositoryBaseClass(Class<T> domainClass, Session session) {
        super(domainClass, session);
    }

    @Override
    public <S extends T> S save(S entity) {
        System.out.println("Hello, World!");
        return super.save(entity);
    }
}
