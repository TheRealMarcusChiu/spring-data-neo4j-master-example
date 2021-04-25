package com.neo4j.example.springdataneo4jintroapp;

import com.google.common.collect.Lists;
import com.neo4j.example.springdataneo4jintroapp.model3.*;
import com.neo4j.example.springdataneo4jintroapp.repository3.ApiRepository;
import com.neo4j.example.springdataneo4jintroapp.repository3.ApplicationModuleRepository;
import com.neo4j.example.springdataneo4jintroapp.repository3.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SpringDataNeo4jIntroAppApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataNeo4jIntroAppApplication.class, args);
	}

	@Autowired
	ApplicationRepository applicationRepository;
	@Autowired
	ApplicationModuleRepository applicationModuleRepository;
	@Autowired
	ApiRepository apiRepository;

	@Override
	public void run(String... args) throws Exception {
		Application app = new Application(); app.setName("app");
		ApplicationModule am1 = new ApplicationModule(); am1.setName("am1");
		ApplicationModule am2 = new ApplicationModule(); am2.setName("am2");
		Api api = new Api(); api.setName("api");

		Relationship0 r01 = new Relationship0(); app.getRelationship0List().add(r01); r01.setApplication(app); r01.setApplicationModule(am1);
		Relationship0 r02 = new Relationship0(); app.getRelationship0List().add(r02); r02.setApplication(app); r02.setApplicationModule(am2);

		Relationship1 r11 = new Relationship1(); am1.getRelationship1List().add(r11); r11.setApplicationModule(am1); r11.setApi(api);
		Relationship1 r12 = new Relationship1(); am2.getRelationship1List().add(r12); r12.setApplicationModule(am2); r12.setApi(api);

		applicationRepository.save(app);

		List<Application> apps = Lists.newArrayList(applicationRepository.findAll(1));
		List<Api> apis = Lists.newArrayList(apiRepository.findAll(2));
		System.out.println("");
	}
}
