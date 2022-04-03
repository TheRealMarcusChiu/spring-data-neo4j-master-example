package com.neo4j.example.springdataneo4jintroapp.versioning.model.processor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

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
