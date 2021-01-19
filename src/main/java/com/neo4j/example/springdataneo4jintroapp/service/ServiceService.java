package com.neo4j.example.springdataneo4jintroapp.service;

import com.neo4j.example.springdataneo4jintroapp.model2.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Validated
@org.springframework.stereotype.Service
public class ServiceService {

    /**
     * @Valid throws javax.validation.ConstraintViolationException
     * @param service Service
     */
    public void test(@Valid Service service) {
        System.out.println("validated");
    }

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>(Arrays.asList("afanhf", "dsd"));
        stringList.add("sfbsdjfbs");
        stringList.add("guf");
        stringList.removeIf(str -> str.length() < 4);
        System.out.println(stringList);
    }
}
