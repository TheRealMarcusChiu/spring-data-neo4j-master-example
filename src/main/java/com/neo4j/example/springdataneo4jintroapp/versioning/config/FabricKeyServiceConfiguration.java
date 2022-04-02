package com.neo4j.example.springdataneo4jintroapp.versioning.config;

import com.neo4j.example.springdataneo4jintroapp.versioning.model.util.service.FabricKeyService;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.stream.Collectors;

import static com.neo4j.example.springdataneo4jintroapp.versioning.config.EdgeRepoConfiguration.EDGE_ENTITY_BASE_PACKAGE;
import static com.neo4j.example.springdataneo4jintroapp.versioning.config.NodeRepoConfiguration.NODE_ENTITY_BASE_PACKAGE;

@Configuration
public class FabricKeyServiceConfiguration {

    @Bean
    public FabricKeyService fabricKeyService() {
        Set<Class<?>> nodeClasses = findAllClassesUsingClassLoader(NODE_ENTITY_BASE_PACKAGE).stream()
                .filter(c -> c.isAnnotationPresent(NodeEntity.class))
                .collect(Collectors.toSet());
        Set<Class<?>> edgeClasses = findAllClassesUsingClassLoader(EDGE_ENTITY_BASE_PACKAGE).stream()
                .filter(c -> c.isAnnotationPresent(RelationshipEntity.class))
                .collect(Collectors.toSet());
        return new FabricKeyService(nodeClasses, edgeClasses);
    }

    private Set<Class<?>> findAllClassesUsingClassLoader(final String packageName) {
        InputStream stream = ClassLoader.getSystemClassLoader()
                .getResourceAsStream(packageName.replaceAll("[.]", "/"));
        assert stream != null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        return reader.lines()
                .filter(line -> line.endsWith(".class"))
                .map(line -> getClass(line, packageName))
                .collect(Collectors.toSet());
    }

    private Class<?> getClass(String className, String packageName) {
        try {
            return Class.forName(packageName + "." + className.substring(0, className.lastIndexOf('.')));
        } catch (ClassNotFoundException e) {
            // handle the exception
        }
        return null;
    }
}
