package com.neo4j.example.springdataneo4jintroapp.versioning.model.util.service;

import lombok.*;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class FabricKeyGroupValue {

    private Integer groupPriority;
    private List<FabricKeyValue> keyValues;

    @Getter
    @Builder
    @AllArgsConstructor
    public static class FabricKeyValue {
        private String propertyName;
        private Object propertyValue;
        @Setter
        private String paramName;
    }
}
