package com.neo4j.example.springdataneo4jintroapp.versioning.model;

import com.neo4j.example.springdataneo4jintroapp.versioning.model.processor.annotations.FabricKey;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;

import java.io.Serializable;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public abstract class Asset implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @FabricKey(priority = FabricKey.Priority.HIGHEST)
    private String uuid;

    private Integer index; // used for batch get
}
