package com.neo4j.example.springdataneo4jintroapp;

import com.neo4j.example.springdataneo4jintroapp.repository.MovieRepository;
import com.neo4j.example.springdataneo4jintroapp.repository.PersonRepository;
import com.neo4j.example.springdataneo4jintroapp.repository.RoleRepository;
import com.neo4j.example.springdataneo4jintroapp.repository2.*;
import com.neo4j.example.springdataneo4jintroapp.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.PostConstruct;

@Component
@EnableTransactionManagement
@SpringBootApplication
public class SpringDataNeo4jIntroAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataNeo4jIntroAppApplication.class, args);
	}

	@Autowired
	ApplicationModuleRepository applicationModuleRepository;
	@Autowired
	ServiceRepository serviceRepository;
	@Autowired
	ServiceService serviceService;
	@Autowired
	Composite1Repository composite1Repository;
	@Autowired
	Composite2Repository composite2Repository;
	@Autowired
	Composite3Repository composite3Repository;
	@Autowired
	Model1Repository model1Repository;
	@Autowired
	PersonRepository personRepository;
	@Autowired
	MovieRepository movieRepository;
	@Autowired
	RoleRepository roleRepository;

	@PostConstruct
	public void test5() {
	}
}
