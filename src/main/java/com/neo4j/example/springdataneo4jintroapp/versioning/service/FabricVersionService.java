package com.neo4j.example.springdataneo4jintroapp.versioning.service;

import com.neo4j.example.springdataneo4jintroapp.versioning.model.Asset;
import com.neo4j.example.springdataneo4jintroapp.versioning.model.nodes.Model;
import com.neo4j.example.springdataneo4jintroapp.versioning.repository.nodes.ModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FabricVersionService {

    private final ModelRepository modelRepository;

    public void persist(final List<Model> models) {
        List<Model> m = modelRepository.getAll(models);

//        for (int i = 0; i < m.size(); i++) {
//            if ()
//        }

        List<String> l = models.stream().map(Asset::getUuid).collect(Collectors.toList());
        modelRepository.getAllWithAttributesByUuids(l);
    }
}
