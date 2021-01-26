package com.neo4j.example.springdataneo4jintroapp.model2;

import java.io.Serializable;
import java.util.Objects;

public class CompositeId implements Serializable {
    private String accountNumber;
    private String accountType;

    public CompositeId() {
    }

    public CompositeId(String accountNumber, String accountType) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompositeId accountId = (CompositeId) o;
        return accountNumber.equals(accountId.accountNumber) &&
                accountType.equals(accountId.accountType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, accountType);
    }
}
