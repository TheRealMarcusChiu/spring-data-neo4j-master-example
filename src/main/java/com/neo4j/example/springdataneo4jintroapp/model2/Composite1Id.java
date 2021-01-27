package com.neo4j.example.springdataneo4jintroapp.model2;

import java.io.Serializable;
import java.util.Objects;

public class Composite1Id implements Serializable {
    private String accountNumber;
    private String accountType;

    public Composite1Id() {
    }

    public Composite1Id(String accountNumber, String accountType) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Composite1Id accountId = (Composite1Id) o;
        return accountNumber.equals(accountId.accountNumber) &&
                accountType.equals(accountId.accountType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, accountType);
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
