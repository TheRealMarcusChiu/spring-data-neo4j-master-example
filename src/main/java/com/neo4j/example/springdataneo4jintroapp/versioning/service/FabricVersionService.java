package com.neo4j.example.springdataneo4jintroapp.versioning.service;

import com.neo4j.example.springdataneo4jintroapp.versioning.model.nodes.Person;
import com.neo4j.example.springdataneo4jintroapp.versioning.repository.nodes.ClassRoomRepository;
import com.neo4j.example.springdataneo4jintroapp.versioning.repository.nodes.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FabricVersionService {

    private final PersonRepository personRepository;
    private final ClassRoomRepository classRoomRepository;

    public void persist(final List<Person> persons) {
        persons.stream().map(Person::getUuid);
    }
}
