package com.neo4j.example.springdataneo4jintroapp.config;

import org.neo4j.ogm.config.Configuration;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory; //ClassNotFoundException: org.neo4j.ogm.result.ResultRestModel
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Connection;

public class CustomNeo4jSessionFactory {

    private static final Configuration configuration = new Configuration.Builder()
            .uri("bolt://localhost")
            .credentials("neo4j", "password")
            .build();
    private static final SessionFactory sessionFactory = new SessionFactory(configuration, "com.neo4j.example.springdataneo4jintroapp.model");
    private static final CustomNeo4jSessionFactory factory = new CustomNeo4jSessionFactory();

    public static CustomNeo4jSessionFactory getInstance() {
        return factory;
    }

    // prevent external instantiation
    private CustomNeo4jSessionFactory() {
    }

    public Session getNeo4jSession() {
        return sessionFactory.openSession();
    }
}
