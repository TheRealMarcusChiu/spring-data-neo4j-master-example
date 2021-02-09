package com.neo4j.example.springdataneo4jintroapp;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class Marcus extends Person2 {
    @EqualsAndHashCode.Include
    private String marcus;

    protected boolean canEqual(final Object other) {
        return other instanceof Person2;
    }
}
