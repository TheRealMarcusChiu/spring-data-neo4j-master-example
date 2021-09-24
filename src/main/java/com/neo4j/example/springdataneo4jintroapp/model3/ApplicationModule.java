package com.neo4j.example.springdataneo4jintroapp.model3;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

import static org.neo4j.ogm.annotation.Relationship.INCOMING;

@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@Data
@NodeEntity
public class ApplicationModule extends Asset {

    @Relationship(type = "REL_0", direction = INCOMING)
    private List<Relationship0> relationship0List = new ArrayList<>();

    @Relationship("REL_1")
    private List<Relationship1> relationship1List = new ArrayList<>();
    @Relationship("REL_2")
    private Relationship2 relationship2List; // = new ArrayList<>();
}
