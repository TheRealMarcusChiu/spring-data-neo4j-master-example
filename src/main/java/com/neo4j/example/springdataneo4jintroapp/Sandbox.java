package com.neo4j.example.springdataneo4jintroapp;

import java.util.Arrays;

public class Sandbox {
    public static void main(String[] args) {
        Shape s = new Shape();
        Shape ss = new Triangle();
//        System.out.println(s.getClass());
//        System.out.println(ss.getClass());
        Triangle t = new Triangle();
        Object o = new Object();
        if (t == null || ss.getClass() != t.getClass()) {
        }

        Triangle tt = new Triangle() {
            @Override public void hello() {
                System.out.println("hello");
                super.hello();
            }
        };
        tt.hello();

//        if (t instanceof Triangle) {
//            System.out.println("t instanceof Triangle");
//        }
//        if (t instanceof Shape) {
//            System.out.println("t instanceof Shape");
//        }
//        if (t instanceof Object) {
//            System.out.println("t instanceof Object");
//        }
//        if (s instanceof Triangle) {
//            System.out.println("s instanceof Triangle");
//        }
//        if (s instanceof Shape) {
//            System.out.println("s instanceof Shape");
//        }
//        if (s instanceof Object) {
//            System.out.println("s instanceof Object");
//        }
//        if (o instanceof Triangle) {
//            System.out.println("o instanceof Triangle");
//        }
//        if (o instanceof Shape) {
//            System.out.println("o instanceof Shape");
//        }
//        if (o instanceof Object) {
//            System.out.println("o instanceof Object");
//        }
    }

    public static class Shape extends Object {

    }

    public static class Triangle extends Shape {
        public void hello() {

        }
    }
}
