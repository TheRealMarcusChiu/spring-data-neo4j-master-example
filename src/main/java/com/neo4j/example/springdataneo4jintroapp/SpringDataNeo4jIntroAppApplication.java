package com.neo4j.example.springdataneo4jintroapp;

import com.neo4j.example.springdataneo4jintroapp.config.Neo4jSessionFactory;
import com.neo4j.example.springdataneo4jintroapp.controllers.DefaultController;
import com.neo4j.example.springdataneo4jintroapp.converters.Location;
import com.neo4j.example.springdataneo4jintroapp.model.Person;
import com.neo4j.example.springdataneo4jintroapp.model2.ApplicationModule;
import com.neo4j.example.springdataneo4jintroapp.model2.Service;
import com.neo4j.example.springdataneo4jintroapp.repository.MovieRepository;
import com.neo4j.example.springdataneo4jintroapp.repository.PersonRepository;
import com.neo4j.example.springdataneo4jintroapp.repository.RoleRepository;
import com.neo4j.example.springdataneo4jintroapp.repository2.*;
import com.neo4j.example.springdataneo4jintroapp.service.ServiceService;
import org.neo4j.ogm.config.Configuration;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.neo4j.ogm.transaction.Transaction;
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
		Session session = Neo4jSessionFactory.getInstance().getNeo4jSession();
		Transaction transaction = session.beginTransaction();
		Person p = new Person();
		p.setName("marcus chiu");
		session.save(p);
		transaction.status();
		if (transaction.canCommit()) {
			transaction.commit();
		} else {
			transaction.rollback();
		}
		transaction.close();
	}

//	@PostConstruct
//	public void test5() {
//		Person p = new Person();
//		p.setName("marcus chiu");
//
//		Movie m = new Movie();
//		m.setTitle("movie");
//
//		Person pSaved = personRepository.save(p);
//		Movie mSaved = movieRepository.save(m);
//
//		Role r = new Role(p, m);
//		r.setCustom("hello world");
//		p.setTest(r);
//		m.addActors(r);
//		Role rSaved = roleRepository.upsert(r);
//
//		Role r2 = new Role(p, m);
//		r2.setCustom("hello world");
//		p.setTest(r2);
//		m.addActors(r2);
//		Role rSaved2 = roleRepository.upsert(r2);
//
//		System.out.println("done");
//	}

//	@PostConstruct
	public void test4() {
//		Model1 m1 = new Model1();
//		Model2 m2 = new Model2();
//		Model3 m3 = new Model3();
//
//		m2.setModel3(m3);
//		m1.setModel2(m2);
//
//		Model1 m1saved = model1Repository.save(m1);
//		Model1 m1returned = model1Repository.findById(131L, 2).get();
//		System.out.println("done");
	}

//	@PostConstruct
	public void test3() {
//		Service s = new Service();
//		s.setName("Marcus Chiu");
//		s.setModelType(Service.ModelType.REQUEST);
//		SubService sss = new SubService();
//		sss.setId(47L);
//		s.setSubService(sss);
////		s.setServiceName("tttttt");
//		Service ss = serviceRepository.upsert(s);
//		Optional<Service> optionalService = serviceRepository.customFind();
	}

//	@PostConstruct
//	public void testt() {
//		Service s = new Service();
//		s.setModelType(Service.ModelType.REQUEST);
//		Service ss = serviceRepository.save(s);
//		System.out.println("adhjfbd");
//	}

//	@PostConstruct
//	public void test4() {
//		t();
//		t();
//	}
//
//	public void t() {
//		Composite3 c3 = new Composite3();
//		c3.setAccountNumber("number");
//		c3.setAccountType("type");
//		composite3Repository.save(c3);
//	}

//	@PostConstruct
//	public void test3() {
//		Location l = new Location(10d, 11d);
//		Composite2 c2 = new Composite2();
//		c2.setName("marcus chiiu");
//		c2.setLocation(l);
//		composite2Repository.save(c2);
//	}

//	@PostConstruct
//	public void test2() {
//		Composite c1 = new Composite();
//		c1.setName("jesus");
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
//		long start = System.currentTimeMillis();
//		defaultController.testt();
//		System.out.println("HELLO HELLO");
//		defaultController.testt();
//		double total = ((double)(System.currentTimeMillis() - start)) / 1000d;
//
//		System.out.println("total " + total);
	}
}
