package com.neo4j.example.springdataneo4jintroapp.model2;

import org.neo4j.ogm.annotation.NodeEntity;

import javax.persistence.Id;
import javax.persistence.IdClass;

@NodeEntity
@IdClass(Composite1Id.class)
public class Composite1 {

    private Long id;

    @Id
    private String accountNumber;
    @Id
    private String accountType;

    public String name;

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
    public String getAccountType() {
        return accountType;
    }
}
