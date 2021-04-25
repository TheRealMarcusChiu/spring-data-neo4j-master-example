//package com.neo4j.example.springdataneo4jintroapp.model2;
//
//import com.neo4j.example.springdataneo4jintroapp.model2.relationship.Gender;
//import org.neo4j.ogm.annotation.NodeEntity;
//import org.neo4j.ogm.annotation.Relationship;
//
//import java.util.List;
//
//@NodeEntity
//public class ApplicationModule extends Asset {
//
//    String applicationModuleName;
//
//    @Relationship(Gender.Constants.MALE_VALUE)
//    List<Service> services;
//
////    public ApplicationModule(String name, String applicationModuleName, List<Service> services) {
////        this.name = name;
////        this.applicationModuleName = applicationModuleName;
////        this.services = services;
////    }
//
//    public String getApplicationModuleName() { return applicationModuleName; }
//    public void setApplicationModuleName(String applicationModuleName) { this.applicationModuleName = applicationModuleName; }
//
//    public List<Service> getServices() { return services; }
//    public void setServices(List<Service> services) { this.services = services; }
//}
