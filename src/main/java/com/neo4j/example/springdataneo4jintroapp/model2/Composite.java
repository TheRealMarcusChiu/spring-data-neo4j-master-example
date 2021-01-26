package com.neo4j.example.springdataneo4jintroapp.model2;

import org.neo4j.ogm.annotation.NodeEntity;

import javax.persistence.Id;
import javax.persistence.IdClass;

@NodeEntity
@IdClass(CompositeId.class)
public class Composite {

    public Long id;

    @Id
    private String accountNumber;
    @Id
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
