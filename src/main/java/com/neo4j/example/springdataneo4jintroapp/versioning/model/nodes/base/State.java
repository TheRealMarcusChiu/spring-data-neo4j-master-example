package com.neo4j.example.springdataneo4jintroapp.versioning.model.nodes.base;

import com.neo4j.example.springdataneo4jintroapp.versioning.model.Node;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter(AccessLevel.PACKAGE)
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class State extends Node {
}
