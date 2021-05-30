package com.neo4j.example.springdataneo4jintroapp;

import com.neo4j.example.springdataneo4jintroapp.model3.Api;
import com.neo4j.example.springdataneo4jintroapp.model3.Application;
import com.neo4j.example.springdataneo4jintroapp.repository3.ApiRepository;
import com.neo4j.example.springdataneo4jintroapp.repository3.ApplicationModuleRepository;
import com.neo4j.example.springdataneo4jintroapp.repository3.ApplicationRepository;
import org.neo4j.ogm.annotation.Transient;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mapping.PersistentEntity;
import org.springframework.data.mapping.PersistentProperty;
import org.springframework.data.mapping.PersistentPropertyAccessor;
import org.springframework.data.neo4j.mapping.Neo4jMappingContext;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	Neo4jMappingContext mappingContext;

	@Override
	public void run(String... args) {
		Api api = new Api(); //....; // the domain model instance
		api.setName("Marcus");
		PersistentEntity entity = mappingContext.getPersistentEntity(Api.class); //....; the PersistentEntity for the class of the domain model instance
		PersistentProperty property = entity.getPersistentProperty("name"); // get the name property
		PersistentPropertyAccessor accessor = entity.getPropertyAccessor(api);
		accessor.setProperty(property, "someValue"); // set the name property to someValue

		System.out.println(accessor.getProperty(property).toString());


//		List<Class> supportedTypes = Arrays.asList(String.class, Number.class);
//		Set<Field> set = new HashSet<>();
//
//		Class clazz = Application.class;
//		do {
//			Field[] fields = clazz.getDeclaredFields();
//			set.addAll(Arrays.asList(fields));
//			clazz = clazz.getSuperclass();
//		} while (clazz != null);
//
//		set = set.stream()
//				.filter(f -> f.getAnnotation(Transient.class) == null)
//				.filter(f -> supportedTypes.contains(f.getType()))
//				.collect(Collectors.toSet());
//
//		set.forEach(f -> System.out.println(f.getName()));



//		ObjectMapper om = new ObjectMapper();
//		om.writeValueAsString(new Application());

//		Neo4jSession session = (Neo4jSession) sessionFactory.openSession();
//		var entityGraphMapper = new EntityGraphMapper(session.metaData(), session.context());
//		var app = new Application();
//		app.setName("marcus");
//		CompileContext c = entityGraphMapper.map(app, 0);


//		sessionFactory.openSession().save(app);
//		Result r = sessionFactory.openSession().query("CREATE (n:Person)", new HashMap<>());


//		Application app = new Application(); app.setName("app");
//		ApplicationModule am1 = new ApplicationModule(); am1.setName("am1");
//		ApplicationModule am2 = new ApplicationModule(); am2.setName("am2");
//		Api api = new Api(); api.setName("api");
//
//		Relationship0 r01 = new Relationship0(); app.getRelationship0List().add(r01); r01.setApplication(app); r01.setApplicationModule(am1);
//		Relationship0 r02 = new Relationship0(); app.getRelationship0List().add(r02); r02.setApplication(app); r02.setApplicationModule(am2);
//
//		Relationship1 r11 = new Relationship1(); am1.getRelationship1List().add(r11); r11.setApplicationModule(am1); r11.setApi(api);
//		Relationship1 r12 = new Relationship1(); am2.getRelationship1List().add(r12); r12.setApplicationModule(am2); r12.setApi(api);
//
//		applicationRepository.save(app);
//
//		List<Application> apps = Lists.newArrayList(applicationRepository.findAll(1));
//		List<Api> apis = Lists.newArrayList(apiRepository.findAll(2));
//		System.out.println("");
	}
}
