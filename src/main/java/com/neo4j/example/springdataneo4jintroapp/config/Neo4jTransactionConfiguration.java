package com.neo4j.example.springdataneo4jintroapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.PostConstruct;

@Configuration
@EnableTransactionManagement
public class Neo4jTransactionConfiguration {

//    @Autowired
//    Neo4jTransactionManager neo4jTransactionManager;
//    @Autowired
//    TransactionTemplate transactionTemplate;
//    // transactionTemplate.getTransactionManager() == neo4jTransactionManager
//
//    @PostConstruct
//    public void postConstruct() {
//        getTransaction();
//        getTransaction();
//    }
//
//    private void getTransaction() {
//        TransactionStatus ts = neo4jTransactionManager.getTransaction(new DefaultTransactionDefinition());
//        if (ts.isNewTransaction()) {
//            System.out.println("is new transaction");
//        } else {
//            System.out.println("is existing transaction");
//        }
//    }
}
