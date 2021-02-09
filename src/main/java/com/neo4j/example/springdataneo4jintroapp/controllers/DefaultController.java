package com.neo4j.example.springdataneo4jintroapp.controllers;

import com.neo4j.example.springdataneo4jintroapp.model2.ApplicationModule;
import com.neo4j.example.springdataneo4jintroapp.model2.Service;
import com.neo4j.example.springdataneo4jintroapp.repository2.ApplicationModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Objects;

@RestController
public class DefaultController {

//    @Autowired
//    SpringDataNeo4jIntroAppApplication springDataNeo4jIntroAppApplication;

//    @GetMapping("/trigger")
//    public void test() {
//        springDataNeo4jIntroAppApplication.test();
//    }

    public static void main(String[] args) {
        Integer[] ints = new Integer[10];
        for (int i = 0; i < 10; i++) {
            ints[i] = Objects.hash(i+2, i+"sdbhjsbd");
        }
        System.out.println(Objects.hash(ints, 1));
    }

    private ApplicationModule generate() {
        Service s1 = new Service();
        s1.setServiceName("without-lombok-service-name");
        Service s2 = new Service();
        s2.setServiceName("without-lombok-service-name");
        s2.setService(s1);
        ApplicationModule am = new ApplicationModule();
        am.setApplicationModuleName("without-lombok-app-module-name");
        am.setServices(Collections.singletonList(s2));
        return am;
    }

    @Autowired
    ApplicationModuleRepository applicationModuleRepository;

    @Transactional
    public void testt() {
//        applicationModuleRepository.save(generate());
        for (int i = 0; i < 10000; i++) {
            if (i % 100 == 0) {
                System.out.println("iteration: " + i);
            }
            applicationModuleRepository.save(generate());
        }
    }
}
