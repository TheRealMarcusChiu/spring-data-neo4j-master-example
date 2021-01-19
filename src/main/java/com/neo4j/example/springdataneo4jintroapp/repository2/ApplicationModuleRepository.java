package com.neo4j.example.springdataneo4jintroapp.repository2;

import com.neo4j.example.springdataneo4jintroapp.model2.ApplicationModule;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.repository.query.Param;

public interface ApplicationModuleRepository extends AssetRepository<ApplicationModule, String> {

    @Query("MERGE (e:entity{name:$am.name}) SET e.applicationModuleName = $am.applicationModuleName")
    void upsert(@Param("am") ApplicationModule am);
}
