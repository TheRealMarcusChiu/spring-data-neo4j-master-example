package com.neo4j.example.springdataneo4jintroapp.repository2;

//import com.neo4j.example.springdataneo4jintroapp.model2.ApplicationModule;
//
//import java.util.Optional;
//
//public interface ApplicationModuleRepository extends AssetRepository<ApplicationModule, String> {
//
//    default Optional<ApplicationModule> retrieve(ApplicationModule s) {
//        Optional<ApplicationModule> returnService = findByUuid(s.getUuid());
//        if (returnService.isEmpty()) {
//            returnService = findByName(s.getName());
//        }
//        return returnService;
//    }
////    @Query("MERGE (e:entity{name:$am.name}) SET e.applicationModuleName = $am.applicationModuleName")
////    void upsert(@Param("am") ApplicationModule am);
//}
