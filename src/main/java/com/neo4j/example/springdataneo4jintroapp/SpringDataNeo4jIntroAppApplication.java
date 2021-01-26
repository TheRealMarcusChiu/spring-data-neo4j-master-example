package com.neo4j.example.springdataneo4jintroapp;

import com.neo4j.example.springdataneo4jintroapp.controllers.DefaultController;
import com.neo4j.example.springdataneo4jintroapp.converters.Location;
import com.neo4j.example.springdataneo4jintroapp.model2.ApplicationModule;
import com.neo4j.example.springdataneo4jintroapp.model2.Composite2;
import com.neo4j.example.springdataneo4jintroapp.model2.Service;
import com.neo4j.example.springdataneo4jintroapp.repository2.ApplicationModuleRepository;
import com.neo4j.example.springdataneo4jintroapp.repository2.Composite2Repository;
import com.neo4j.example.springdataneo4jintroapp.repository2.ServiceRepository;
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
	DefaultController defaultController;

	@Autowired
	ServiceService serviceService;

	@Autowired
	Composite2Repository composite2Repository;

	@PostConstruct
	public void test3() {
		Location l = new Location(10d, 11d);
		Composite2 c2 = new Composite2();
		c2.setLocation(l);
		composite2Repository.save(c2);
	}

//	@PostConstruct
//	public void test2() {
//		Composite c1 = new Composite();
//		c1.setAccountType("t1");
//		c1.setAccountNumber("n1");
//
//		compositeRepository.save(c1);
//	}

//	@PostConstruct
	public void test1() {
		ApplicationModule am = new ApplicationModule();
		am.setApplicationModuleName("am-name");

		Location location = new Location(10d, 11d);

		Service s = new Service();
		s.setServiceName("s-name");
//		s.setOwner(am);
		s.setLocation(location);

		serviceRepository.save(s);
	}

//	@PostConstruct
	public void tester() {
		Service service1 = new Service();
		service1.setServiceName("service-name-1");
		serviceRepository.save(service1);

		Service service2 = new Service();
		service2.setServiceName("service-name-2");
		service2.setTest(false);
		serviceRepository.save(service2);

		Service service3 = new Service();
		service3.setServiceName("service-name-3");
		service3.setTest(true);
		serviceRepository.save(service3);
	}

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
