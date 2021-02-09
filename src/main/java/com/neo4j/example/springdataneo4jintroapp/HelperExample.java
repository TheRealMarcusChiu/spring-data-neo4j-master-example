package com.neo4j.example.springdataneo4jintroapp;

public class HelperExample {

    int someMethod(int arg1) {
        int localVar = 5;

        class Helpers {
            int helperMethod(int arg) {
                return arg + localVar;
            }
        }
        Helpers elpers = new Helpers();

        return elpers.helperMethod(10);
    }

    public static void main(String[] args) {
        HelperExample he = new HelperExample();
        he.someMethod(10);
    }
}
