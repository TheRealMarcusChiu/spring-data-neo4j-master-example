package com.neo4j.example.springdataneo4jintroapp.model2;

import com.neo4j.example.springdataneo4jintroapp.converters.Location;
import com.neo4j.example.springdataneo4jintroapp.converters.LocationConverter;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.annotation.typeconversion.Convert;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@NodeEntity
public class Service extends Asset<ApplicationModule> {

    private Boolean test;

    @NotBlank
    private String serviceName;

    @Valid
    @Relationship("HAS")
    private Service service;

    private String test2;

    @Convert(LocationConverter.class)
    private Location location;

    public void setTest(final Boolean test) {
        this.test = test;
    }

    public String getServiceName() { return serviceName; }
    public void setServiceName(String serviceName) { this.serviceName = serviceName; }

    public Service getService() { return service; }
    public void setService(Service service) { this.service = service; }

    public Location getLocation() {
        return location;
    }
    public void setLocation(Location location) {
        this.location = location;
    }
}
