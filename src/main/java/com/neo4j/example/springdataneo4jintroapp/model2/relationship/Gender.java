package com.neo4j.example.springdataneo4jintroapp.model2.relationship;

public enum Gender {
    MALE(Constants.MALE_VALUE), FEMALE(Constants.FEMALE_VALUE);

    Gender(String genderString) {
    }

    public static class Constants {
        public static final String MALE_VALUE = "MALE";
        public static final String FEMALE_VALUE = "FEMALE";
    }
}