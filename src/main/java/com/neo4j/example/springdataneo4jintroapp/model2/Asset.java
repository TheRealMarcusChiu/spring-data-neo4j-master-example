package com.neo4j.example.springdataneo4jintroapp.model2;

//import org.neo4j.ogm.annotation.GeneratedValue;
//import org.neo4j.ogm.annotation.Id;
//import org.neo4j.ogm.annotation.NodeEntity;
//import org.neo4j.ogm.annotation.Relationship;
//import org.neo4j.ogm.id.UuidStrategy;
//
//@NodeEntity
//public class Asset<T extends Asset> {
//
//    public Long id;
//
//    @Id
//    @GeneratedValue(strategy = UuidStrategy.class)
//    private String uuid;
//
//    @Relationship(type = "IS_OWNED_BY")
//    private T owner;
//
////    @Index(indexName="productId", unique=true, indexType=IndexType.SIMPLE)
//    private String name;
//
//    public Long getId() { return id; }
//    public void setId(Long id) { this.id = id; }
//
//    public String getUuid() { return uuid; }
//    public void setUuid(String uuid) { this.uuid = uuid; }
//
//    public String getName() { return name; }
//    public void setName(String name) { this.name = name; }
//
//    public void setOwner(T owner) {
//        this.owner = owner;
//    }
//    public T getOwner() {
//        return owner;
//    }
//}
