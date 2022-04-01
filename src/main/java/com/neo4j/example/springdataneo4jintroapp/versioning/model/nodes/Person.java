package com.neo4j.example.springdataneo4jintroapp.versioning.model.nodes;

import com.neo4j.example.springdataneo4jintroapp.versioning.model.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.neo4j.ogm.annotation.NodeEntity;

@EqualsAndHashCode(callSuper = true)
@Data
@NodeEntity("Person")
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Person extends Entity {
    private String firstName;
    private String middleName;
    private String lastName;


}
