package com.neo4j.example.springdataneo4jintroapp.versioning.model.util.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class FabricKeyGroupValue {

    private Integer groupPriority;
    private List<FabricKeyValue> keyValues;

    @Data
    @Builder
    @AllArgsConstructor
    public static class FabricKeyValue {
        private String fieldName;
        private Object fieldValue;
    }
}
