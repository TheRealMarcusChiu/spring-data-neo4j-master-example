package com.neo4j.example.springdataneo4jintroapp.model2;

import com.neo4j.example.springdataneo4jintroapp.converters.Location;
import com.neo4j.example.springdataneo4jintroapp.converters.LocationConverter;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.typeconversion.Convert;

@NodeEntity
public class Composite2 {

    @Id
    @Convert(LocationConverter.class)
    private Location location;

    public Location getLocation() {
        return location;
    }
    public void setLocation(Location location) {
        this.location = location;
    }
}
