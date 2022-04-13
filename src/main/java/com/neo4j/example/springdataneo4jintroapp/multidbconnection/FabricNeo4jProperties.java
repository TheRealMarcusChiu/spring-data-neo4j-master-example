package com.neo4j.example.springdataneo4jintroapp.multidbconnection;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FabricNeo4jProperties {
    private String uri;
    private String username;
    private String password;
    private String database;
}
