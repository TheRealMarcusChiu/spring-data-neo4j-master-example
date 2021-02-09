package com.neo4j.example.springdataneo4jintroapp;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
//@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Person2 {
    @EqualsAndHashCode.Include
    private String name;

    public static void main(String[] args) {
        Person2 p = Person2.builder().name("Marcus Chiu").build();
        Marcus m = Marcus.builder().name("Marcus Chiu").build();

        System.out.println(p.equals(m));
        System.out.println(m.equals(p));
    }
}
