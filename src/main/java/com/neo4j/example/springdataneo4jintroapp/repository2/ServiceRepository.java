//package com.neo4j.example.springdataneo4jintroapp.repository2;
//
//import com.neo4j.example.springdataneo4jintroapp.model2.Service;
//
//import java.util.Optional;
//
//public interface ServiceRepository extends AssetRepository<Service, String> {
//
//    default <S extends Service> Optional<S> retrieve(S s) {
//        return (Optional<S>) Optional.ofNullable(findByUuid(s.getUuid())
//                .orElseGet(() -> findByName(s.getName())
//                .orElse(null)));
//    }
//
//    <S extends Service> Optional<S> findByServiceName(String serviceName);
//
////    @Query("MERGE (e:Service {name:$s.name}) SET e.extra = $s.extra")
////    void upsert(@Param("s") Service s);
////
////    @Query("MERGE (e:Service {name:$s.name}) SET e.extra = $s.extra RETURN e")
////    List<Service> upsertAndReturn1(@Param("s") Service s);
////
////    @Query("MERGE (e:Service {name:$s.name}) SET e.extra = $s.extra RETURN e")
////    Optional<Service> upsertAndReturn2(@Param("s") Service s);
////
////    @Query("MATCH (e:Service) RETURN e")
////    List<Service> match();
//}
