package com.neo4j.example.springdataneo4jintroapp.versioning.testutil;

import lombok.extern.slf4j.Slf4j;
import org.neo4j.ogm.config.Configuration;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.fail;

@Slf4j
@TestConfiguration
//@PropertySource(TestUtil.SPRING_BOOT_DEVTOOLS_PROPERTIES)
public class NonEmbeddedNeo4jTestConfiguration extends Neo4jTestConfiguration {

    @Value("${spring.data.neo4j.uri:bolt://localhost:7687}")
    private String neo4jUri;
    @Value("${spring.data.neo4j.username:neo4j}")
    private String neo4jUsername;
    @Value("${spring.data.neo4j.password:password}")
    private String neo4jPassword;

    @Bean
    public SessionFactory sessionFactory() {
        final Configuration configuration = new Configuration.Builder()
                .uri(neo4jUri)
                .credentials(neo4jUsername, neo4jPassword)
                .build();
        return new SessionFactory(configuration, NEO4J_ENTITY_BASE_PACKAGES);
    }

    @Bean
    public PlatformTransactionManager transactionManager(SessionFactory sessionFactory) {
        return new Neo4jTransactionManager(sessionFactory);
    }

    @Override
    public void clearDB() {
        sessionFactory().openSession().query(DELETE_ALL_QUERY, Map.of());
    }

    @Override
    public void executeScript(final String scriptPath) {
        try {
            final String[] statements = TestUtil.getResourceAsLines(scriptPath);
            for (String statement : statements) {
                if (!statement.trim().isEmpty() && !statement.trim().startsWith("--")) {
                    sessionFactory().openSession().query(statement, Map.of());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            fail("failed to executeScript graph database");
        }
    }
}

