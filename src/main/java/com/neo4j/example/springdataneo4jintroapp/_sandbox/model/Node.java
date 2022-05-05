package com.neo4j.example.springdataneo4jintroapp._sandbox.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter(AccessLevel.PACKAGE)
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public abstract class Node extends Asset {
}
