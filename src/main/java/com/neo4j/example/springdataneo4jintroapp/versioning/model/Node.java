package com.neo4j.example.springdataneo4jintroapp.versioning.model;

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
