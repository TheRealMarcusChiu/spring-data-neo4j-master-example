package com.neo4j.example.springdataneo4jintroapp.model2;

import org.neo4j.ogm.annotation.CompositeIndex;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
@CompositeIndex(value= {"accountNumber","accountType"}, unique=true)
public class Composite3 {

    public Long id;

    private String accountNumber;
    private String accountType;

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
