package com.neo4j.example.springdataneo4jintroapp.versioning.model.nodes.base;

import com.neo4j.example.springdataneo4jintroapp.versioning.model.Node;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
//@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class State extends Node {
}
