//package com.neo4j.example.springdataneo4jintroapp.repository2;
//
//import com.neo4j.example.springdataneo4jintroapp.model2.SubService;
//import org.springframework.data.neo4j.repository.Neo4jRepository;
//
//public interface SubServiceRepository extends Neo4jRepository<SubService, Long> {
//    Integer count = 0;
//
//    @Override
//    default <S extends SubService> S save(S s) {
//        if (count.equals(5)) return null;
//        System.out.println("hello");
//        return save(s);
//    }
//}
