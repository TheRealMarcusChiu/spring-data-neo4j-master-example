package com.neo4j.example.springdataneo4jintroapp.converters;

import com.neo4j.example.springdataneo4jintroapp.model2.CompositeId;

import java.io.Serializable;
import java.util.Objects;

public class Location implements Serializable {
    private Double latitude;
    private Double longitude;

    public Location(Double longitude, Double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
    public Double getLongitude() {
        return longitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
    public Double getLatitude() {
        return latitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location l = (Location) o;
        return longitude.equals(l.getLongitude()) &&
                latitude.equals(l.getLatitude());
    }

    @Override
    public int hashCode() {
        return Objects.hash(longitude, latitude);
    }
}
