package com.neo4j.example.springdataneo4jintroapp.repository3;

import com.neo4j.example.springdataneo4jintroapp.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomRepositoryTest implements CustomRepository {

    @Autowired
    private ExampleService exampleService;

    @Override
    public String someCustomMethod(String input) {
        return exampleService.test() + " " + input;
    }

    private String privateMethod() {
        return "private here";
    }
}
