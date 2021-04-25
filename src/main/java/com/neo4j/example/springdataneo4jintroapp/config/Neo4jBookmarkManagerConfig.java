package com.neo4j.example.springdataneo4jintroapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.annotation.EnableBookmarkManagement;
import org.springframework.data.neo4j.bookmark.BookmarkManager;
import org.springframework.data.neo4j.bookmark.CaffeineBookmarkManager;

@Configuration
@EnableBookmarkManagement
public class Neo4jBookmarkManagerConfig {
//
//    @Bean
//    public BookmarkManager bookmarkManager() {
//        return new CaffeineBookmarkManager();
//    }
}
