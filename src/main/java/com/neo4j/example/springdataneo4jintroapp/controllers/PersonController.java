package com.neo4j.example.springdataneo4jintroapp.controllers;

import com.neo4j.example.springdataneo4jintroapp.model.Person;
import com.neo4j.example.springdataneo4jintroapp.repository.PersonRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping
    public Iterable<Person> findAllPersons() { return personRepository.findAll(); }

    @GetMapping("/{name}")
    public Person getPersonByName(@PathVariable String name) {
        return personRepository.getPersonByName(name);
    }

    @GetMapping("/search/{name}")
    public Iterable<Person> findPersonByNameLike(@PathVariable String name) {
        return personRepository.findPersonByNameLike(name);
    }

    @GetMapping("/actanddirect")
    public List<Person> getPersonsWhoActAndDirect() {
        List<Person> persons = personRepository.getPersonsWhoActAndDirect();
        return persons;
    }

//    @PostConstruct
//    public void test() {
//        Person p = new Person();
//        p.setName("Jelly Bean");
//        List<Movie> movies = new ArrayList<>();
//        Movie movie = new Movie();
//        movie.setTitle("Eatery");
//        List<Person> directors = new ArrayList<>();
//        directors.add(p);
//        movie.setDirectors(directors);
//        movies.add(movie);
//        p.setMovies(movies);
//        personRepository.save(p);
//    }
}
