package com.neo4j.example.springdataneo4jintroapp;

import com.google.common.collect.Lists;
import com.neo4j.example.springdataneo4jintroapp.model.Person;
import com.neo4j.example.springdataneo4jintroapp.model3.Api;
import com.neo4j.example.springdataneo4jintroapp.model3.ApplicationModule;
import com.neo4j.example.springdataneo4jintroapp.model3.Relationship1;
import com.neo4j.example.springdataneo4jintroapp.repository.PersonRepository;
import com.neo4j.example.springdataneo4jintroapp.repository.Relationship1Repository;
import com.neo4j.example.springdataneo4jintroapp.repository3.ApiRepository;
import com.neo4j.example.springdataneo4jintroapp.repository3.ApplicationModuleRepository;
import com.neo4j.example.springdataneo4jintroapp.repository3.ApplicationRepository;
import com.neo4j.example.springdataneo4jintroapp.repository3.RepositoryBaseClass;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

import java.util.List;
import java.util.Map;

@SpringBootApplication
@EnableNeo4jRepositories(repositoryBaseClass = RepositoryBaseClass.class,
        repositoryImplementationPostfix = "Test")
public class SpringDataNeo4jIntroAppApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataNeo4jIntroAppApplication.class, args);
    }

    @Autowired
    ApplicationRepository applicationRepository;
    @Autowired
    ApplicationModuleRepository applicationModuleRepository;
    @Autowired
    ApiRepository apiRepository;
    @Autowired
    Relationship1Repository relationship1Repository;
    @Autowired
    SessionFactory sessionFactory;
    @Autowired
    PersonRepository personRepository;

    @Override
    public void run(String... args) {
        test();
//        multipleRelationships2();
//        multipleRelationships();
//        System.out.println("DONE");
        System.exit(0);
    }

    private void test() {
        List<Person> person = personRepository.getPersonsWhoActAndDirect();
        System.out.println("hello");
    }

    private void multipleRelationships2() {
//        var appMod = new ApplicationModule();
//        var api1 = new Api();
//
//        var relationship11 = new Relationship2();
//
//        relationship11.setApplicationModule(appMod);
//        relationship11.setApi(api1);
//
//        applicationModuleRepository.save(appMod, 3);

        List<ApplicationModule> appMods = Lists.newArrayList(applicationModuleRepository.findAll(3));
        System.out.println("Sdsg");
    }

    private void multipleRelationships() {
        var appMod = new ApplicationModule();
        var api1 = new Api();

        var relationship11 = new Relationship1();
        var relationship12 = new Relationship1();

        relationship11.setApplicationModule(appMod);
        relationship11.setApi(api1);
        relationship11.setCiaVersion(null);

        relationship12.setApplicationModule(appMod);
        relationship12.setApi(api1);
        relationship12.setCiaVersion(2L);

        applicationModuleRepository.save(appMod, 3);

//        List<ApplicationModule> appMods = Lists.newArrayList(applicationModuleRepository.findAll(3));

        String query = "MATCH (n1 {uuid:'" + appMod.getUuid() + "'})-[r]->(n2 {uuid:'" + api1.getUuid() + "'}) WHERE NOT EXISTS(r.ciaVersion) RETURN *";
        Relationship1 relationship1 = sessionFactory.openSession().queryForObject(Relationship1.class, query, Map.of());
        System.out.println("hdjcbjhd");
    }
}
