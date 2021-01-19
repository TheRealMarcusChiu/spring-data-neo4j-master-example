package com.neo4j.example.springdataneo4jintroapp;

import com.neo4j.example.springdataneo4jintroapp.controllers.DefaultController;
import com.neo4j.example.springdataneo4jintroapp.repository2.ApplicationModuleRepository;
import com.neo4j.example.springdataneo4jintroapp.repository2.ServiceRepository;
import com.neo4j.example.springdataneo4jintroapp.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

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
	DefaultController defaultController;

	@Autowired
	ServiceService serviceService;

//	@PostConstruct
//	public void tester() {
//		Service service = new Service();
//		service.setServiceName("Hello");
//		Service service1 = new Service();
//		service1.setServiceName("");
//		service.setService(service1);
//		serviceService.test(service);
//	}

//	@PostConstruct
//	public void testt() {
//		serviceRepository.deleteAll();
//		Service s = new Service();
//		s.setServiceName("CHICKEN");
//		s.setName("CHICKEN");
//		s.setUuid("66ee971b-5349-4adf-9649-bb55fd27628");
//		serviceRepository.save(s);
//		Optional<Service> s1 = serviceRepository.findByServiceName("Hello");
//		Optional<Service> s2 = serviceRepository.findByName("Marcus Chiu");
//		Optional<Service> s3 = serviceRepository.findByName("Marcus Chiu 3");
//		System.out.println(s1.isPresent());
//		System.out.println(s2.isPresent());
//		System.out.println(s3.isPresent());
//	}

	public void test() {
		long start = System.currentTimeMillis();
		defaultController.testt();
		System.out.println("HELLO HELLO");
		defaultController.testt();
		double total = ((double)(System.currentTimeMillis() - start)) / 1000d;

		System.out.println("total " + total);
	}
}
