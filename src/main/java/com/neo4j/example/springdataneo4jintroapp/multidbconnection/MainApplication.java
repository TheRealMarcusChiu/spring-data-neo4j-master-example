package com.neo4j.example.springdataneo4jintroapp.multidbconnection;

import com.neo4j.example.springdataneo4jintroapp.multidbconnection.db1.model.User1;
import com.neo4j.example.springdataneo4jintroapp.multidbconnection.db1.repo.User1Repository;
import com.neo4j.example.springdataneo4jintroapp.multidbconnection.db2.model.User2;
import com.neo4j.example.springdataneo4jintroapp.multidbconnection.db2.repo.User2Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@RequiredArgsConstructor
@SpringBootApplication
public class MainApplication implements CommandLineRunner {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .profiles("multidbconnection") // picks up application-multidbconnection.properties
                .sources(MainApplication.class)
                .run(args);
    }

    private final User1Repository user1Repository;
    private final User2Repository user2Repository;

    @Override
    public void run(String... args) throws Exception {
        user1Repository.save(User1.builder().name("user1").build());
        user2Repository.save(User2.builder().name("user2").build());
    }
}
