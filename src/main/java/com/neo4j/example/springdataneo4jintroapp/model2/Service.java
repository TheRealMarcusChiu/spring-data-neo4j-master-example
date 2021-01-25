package com.neo4j.example.springdataneo4jintroapp.model2;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@NodeEntity
public class Service extends Asset {

    private Boolean test;

    @NotBlank
    private String serviceName;

    @Valid
    @Relationship("HAS")
    private Service service;

    public void setTest(final Boolean test) {
        this.test = test;
    }

    public String getServiceName() { return serviceName; }
    public void setServiceName(String serviceName) { this.serviceName = serviceName; }

    public Service getService() { return service; }
    public void setService(Service service) { this.service = service; }
}
