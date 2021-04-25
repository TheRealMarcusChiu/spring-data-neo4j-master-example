package com.neo4j.example.springdataneo4jintroapp.model3;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded=true)
@Data
@NodeEntity
public class Application extends Asset {
    @Relationship("REL_0")
    private List<Relationship0> relationship0List = new ArrayList<>();
}
