package com.neo4j.example.springdataneo4jintroapp.versioning.model.nodes;

import com.neo4j.example.springdataneo4jintroapp.versioning.model.State;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.neo4j.ogm.annotation.NodeEntity;

@EqualsAndHashCode(callSuper = true)
@Data
@NodeEntity
@SuperBuilder
@NoArgsConstructor
public class PersonState extends State {
    private String firstName;
    private String middleName;
    private String lastName;
}
