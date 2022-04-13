package com.neo4j.example.springdataneo4jintroapp.multidbconnection.db1.config;

import com.neo4j.example.springdataneo4jintroapp.multidbconnection.FabricNeo4jProperties;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.boot.autoconfigure.data.neo4j.Neo4jProperties;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;

import static com.neo4j.example.springdataneo4jintroapp.multidbconnection.db1.config.Neo4jDb1Config.*;

@Configuration
//@EnableNeo4jRepositories(basePackages = {})
@EntityScan("com.neo4j.example.springdataneo4jintroapp.multidbconnection.db1.model")
@EnableNeo4jRepositories(
        sessionFactoryRef = SESSION_FACTORY,
        basePackages = BASE_PACKAGE,
        transactionManagerRef = TRANSACTION_MANAGER
)
public class Neo4jDb1Config {

    public static final String SESSION_FACTORY = "sessionFactory";
    public static final String TRANSACTION_MANAGER = "transactionManager";
    public static final String BASE_PACKAGE = "com.neo4j.example.springdataneo4jintroapp.multidbconnection.db1.repo";

    @Primary
    @Bean
    @ConfigurationProperties("spring.data.neo4j.db1")
    public FabricNeo4jProperties neo4jPropertiesDomain1() {
        return new FabricNeo4jProperties();
    }

    @Primary
    @Bean
    public org.neo4j.ogm.config.Configuration ogmConfigurationDomain1() {
        FabricNeo4jProperties neo4jProperties = neo4jPropertiesDomain1();
        return new org.neo4j.ogm.config.Configuration.Builder()
                .uri(neo4jProperties.getUri())
                .credentials(neo4jProperties.getUsername(), neo4jProperties.getPassword())
                .database(neo4jProperties.getDatabase())
//            .autoIndex("assert")
//            .generatedIndexesOutputDir("dir")
//            .generatedIndexesOutputFilename("filename")
//            .connectionPoolSize(200)
//            .encryptionLevel("REQUIRED")
//            .trustStrategy("TRUST_SIGNED_CERTIFICATES")
//            .trustCertFile("/tmp/cert")
//            .connectionLivenessCheckTimeout(1000)
                .build();
//        return neo4jPropertiesDomain1().createConfiguration();
    }

    @Primary
    @Bean(name = SESSION_FACTORY)
    public SessionFactory sessionFactory() {
        return new SessionFactory(ogmConfigurationDomain1(), BASE_PACKAGE, "com.neo4j.example.springdataneo4jintroapp.multidbconnection.db1.model");
    }

    @Bean(name = TRANSACTION_MANAGER)
    public Neo4jTransactionManager neo4jTransactionManager() {
        return new Neo4jTransactionManager(sessionFactory());
    }
}
