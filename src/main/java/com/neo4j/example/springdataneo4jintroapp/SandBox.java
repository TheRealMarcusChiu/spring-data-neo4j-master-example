package com.neo4j.example.springdataneo4jintroapp;

import com.neo4j.example.springdataneo4jintroapp.model3.Api;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.data.convert.EntityConverter;
import org.springframework.data.mapping.PersistentEntity;
import org.springframework.data.mapping.PersistentProperty;
import org.springframework.data.mapping.context.MappingContext;
import org.springframework.data.neo4j.mapping.Neo4jMappingContext;
import org.springframework.data.neo4j.mapping.Neo4jPersistentProperty;
import org.springframework.data.neo4j.repository.support.Neo4jRepositoryFactory;
import org.springframework.data.neo4j.repository.support.SimpleNeo4jRepository;

import java.lang.reflect.Field;
import java.util.*;

public class SandBox {
    public static void main(String[] args) {
//        List<Field> fields = getAllFields(Api.class);
//        for (Field f : fields) {
//            Boolean isPresent = Optional.of(f).map(field -> AnnotatedElementUtils.findMergedAnnotation(field, Id.class)).isPresent();
//            System.out.println(f.getName() + ":" + isPresent);
//        }
    }

    public static List<Field> getAllFields(Class<?> type) {
        return getAllFields(new ArrayList<>(), type);
    }

    public static List<Field> getAllFields(List<Field> fields, Class<?> type) {
        fields.addAll(Arrays.asList(type.getDeclaredFields()));

        if (type.getSuperclass() != null) {
            getAllFields(fields, type.getSuperclass());
        }

        return fields;
    }
}
