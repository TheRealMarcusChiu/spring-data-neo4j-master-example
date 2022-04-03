package com.neo4j.example.springdataneo4jintroapp.versioning.model.processor.annotations;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface FabricKey {

    int priority();

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    class Priority {
        public static final int LOWEST = Integer.MIN_VALUE;
        public static final int DEFAULT = 0;
        public static final int HIGHEST = Integer.MAX_VALUE;
    }
}
