//package com.neo4j.example.springdataneo4jintroapp.repository2;
//
//import com.neo4j.example.springdataneo4jintroapp.model2.Asset;
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.BeanWrapper;
//import org.springframework.beans.BeanWrapperImpl;
//import org.springframework.data.neo4j.repository.Neo4jRepository;
//import org.springframework.data.repository.NoRepositoryBean;
//
//import java.io.Serializable;
//import java.util.HashSet;
//import java.util.Optional;
//import java.util.Set;
//
//@NoRepositoryBean
//public interface AssetRepository<T extends Asset, ID extends Serializable> extends Neo4jRepository<T, ID> {
//
//    default <S extends T> S upsert(S newS) {
//        S returnS;
//        S oldS = retrieve(newS).orElse(null);
//        if (oldS != null) {
//            copyNonNullProperties(newS, oldS);
//            returnS = save(oldS);
//        } else {
//            returnS = save(newS);
//        }
//        return returnS;
//    }
//
//    <S extends T> Optional<S> retrieve(S s);
//
//    <S extends T> Optional<S> findByUuid(String uuid);
//    <S extends T> Optional<S> findByName(String name);
//
//    default void copyNonNullProperties(Object source, Object destination){
//        BeanUtils.copyProperties(source, destination, getNullPropertyNames(source));
//    }
//
//    private String[] getNullPropertyNames (Object source) {
//        final BeanWrapper src = new BeanWrapperImpl(source);
//        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();
//        Set emptyNames = new HashSet();
//        for(java.beans.PropertyDescriptor pd : pds) {
//            //check if value of this property is null then add it to the collection
//            Object srcValue = src.getPropertyValue(pd.getName());
//            if (srcValue == null) emptyNames.add(pd.getName());
//        }
//        String[] result = new String[emptyNames.size()];
//        return (String[]) emptyNames.toArray(result);
//    }
//}
