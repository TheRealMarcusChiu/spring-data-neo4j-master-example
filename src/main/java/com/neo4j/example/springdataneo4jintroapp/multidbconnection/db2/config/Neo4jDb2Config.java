package com.neo4j.example.springdataneo4jintroapp.multidbconnection.db2.config;

import com.neo4j.example.springdataneo4jintroapp.multidbconnection.FabricNeo4jProperties;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.boot.autoconfigure.data.neo4j.Neo4jProperties;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;

import static com.neo4j.example.springdataneo4jintroapp.multidbconnection.db2.config.Neo4jDb2Config.SESSION_BEAN_NAME;
import static com.neo4j.example.springdataneo4jintroapp.multidbconnection.db2.config.Neo4jDb2Config.TRANSACTION_MANAGER;

@Configuration
@EntityScan("com.neo4j.example.springdataneo4jintroapp.multidbconnection.db2.model")
@EnableNeo4jRepositories(
        sessionFactoryRef = Neo4jDb2Config.SESSION_FACTORY,
        basePackages = Neo4jDb2Config.BASE_PACKAGE,
        transactionManagerRef = TRANSACTION_MANAGER,
        sessionBeanName = SESSION_BEAN_NAME
)
public class Neo4jDb2Config {

    public static final String BASE_PACKAGE = "com.neo4j.example.springdataneo4jintroapp.multidbconnection.db2.repo";
    public static final String SESSION_FACTORY = "sessionFactoryForDomain2";
    public static final String SESSION_BEAN_NAME = "aSessionToInstance2";
    public static final String TRANSACTION_MANAGER = "transactionManagerForDomain2";

    @Bean
    @ConfigurationProperties("spring.data.neo4j.db2")
    public FabricNeo4jProperties neo4jPropertiesDomain2() {
        return new FabricNeo4jProperties();
    }

    @Bean
    public org.neo4j.ogm.config.Configuration ogmConfigurationDomain2() {
        FabricNeo4jProperties neo4jProperties = neo4jPropertiesDomain2();
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
//        return neo4jPropertiesDomain2().createConfiguration();
    }

    @Bean(name = SESSION_FACTORY)
    public SessionFactory sessionFactory() {
        return new SessionFactory(ogmConfigurationDomain2(), BASE_PACKAGE, "com.neo4j.example.springdataneo4jintroapp.multidbconnection.db2.model");
    }

    @Bean(name = TRANSACTION_MANAGER)
    public Neo4jTransactionManager neo4jTransactionManager() {
        return new Neo4jTransactionManager(sessionFactory());
    }
}
