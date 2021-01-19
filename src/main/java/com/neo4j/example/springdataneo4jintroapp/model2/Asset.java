package com.neo4j.example.springdataneo4jintroapp.model2;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.typeconversion.Convert;
import org.neo4j.ogm.id.UuidStrategy;
import org.neo4j.ogm.typeconversion.UuidStringConverter;

public class Asset {

    public Long id;

    @Id
    @GeneratedValue(strategy = UuidStrategy.class)
    private String uuid;

//    @Index(indexName="productId", unique=true, indexType=IndexType.SIMPLE)
    String name;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUuid() { return uuid; }
    public void setUuid(String uuid) { this.uuid = uuid; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
