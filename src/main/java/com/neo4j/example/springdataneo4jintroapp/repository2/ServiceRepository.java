package com.neo4j.example.springdataneo4jintroapp.repository2;

import com.neo4j.example.springdataneo4jintroapp.model2.Service;

import java.util.Optional;

public interface ServiceRepository extends AssetRepository<Service, String> {

    Optional<Service> findByName(String name);

    Optional<Service> findByServiceName(String serviceName);

//    @Query("MERGE (e:Service {name:$s.name}) SET e.extra = $s.extra")
//    void upsert(@Param("s") Service s);
//
//    @Query("MERGE (e:Service {name:$s.name}) SET e.extra = $s.extra RETURN e")
//    List<Service> upsertAndReturn1(@Param("s") Service s);
//
//    @Query("MERGE (e:Service {name:$s.name}) SET e.extra = $s.extra RETURN e")
//    Optional<Service> upsertAndReturn2(@Param("s") Service s);
//
//    @Query("MATCH (e:Service) RETURN e")
//    List<Service> match();
}
