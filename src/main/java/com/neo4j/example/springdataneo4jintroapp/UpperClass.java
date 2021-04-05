package com.neo4j.example.springdataneo4jintroapp;

public class UpperClass {

    private String str = "hello, world!";

    public void test() {
        str = "set";

        System.out.println("outer class: " + str);
        InnerClass innerClass = new InnerClass();
        innerClass.test();
    }
    public static class StaticInnerClass {}

    public class InnerClass {
        public void test() {
            System.out.println("inner class" + str);
        }
    }

    public static void main(String[] args) {
        // works
        StaticInnerClass stat = new StaticInnerClass();
        // doesn't compile
//        InnerClass inner = new InnerClass();
        UpperClass uc = new UpperClass();
        uc.test();
        UpperClass t = new UpperClass();
    }
}