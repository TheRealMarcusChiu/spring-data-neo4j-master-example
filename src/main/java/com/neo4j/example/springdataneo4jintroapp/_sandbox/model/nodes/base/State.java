package com.neo4j.example.springdataneo4jintroapp._sandbox.model.nodes.base;

import com.neo4j.example.springdataneo4jintroapp._sandbox.model.Node;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@Setter(AccessLevel.PACKAGE)
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class State extends Node {
}
