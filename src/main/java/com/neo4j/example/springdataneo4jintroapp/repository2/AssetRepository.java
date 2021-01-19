package com.neo4j.example.springdataneo4jintroapp.repository2;

import com.neo4j.example.springdataneo4jintroapp.model2.Asset;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.Optional;

@NoRepositoryBean
public interface AssetRepository<T extends Asset, ID extends Serializable> extends Neo4jRepository<T, ID> {

    Optional<T> findByName(String name);
}
