package com.neo4j.example.springdataneo4jintroapp;

import lombok.val;
import org.springframework.scheduling.support.CronTrigger;

import javax.swing.*;
import java.io.UnsupportedEncodingException;
import java.lang.management.ManagementFactory;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Sandbox {
    static class CheckingAccount extends Account {

        public CheckingAccount(String name) {
            super(name);
        }
        public void login() {
            System.out.println("override");
            this.loggedIn = true;
        }
    }
    static class Account {
        Boolean loggedIn = true;
        String name;
        public void login() {
            loggedIn = new Random().nextBoolean();
        }
        public Account(String name) {
            this.name = name;
        }
    }
    static class BoxInt {
        int i;
        public BoxInt(int i) { this.i = i; }
    }
    public static void main(String[] args) throws UnsupportedEncodingException {
        new StringBuilder().append("str").toString().equals(new StringBuilder().append("str").toString());
        List<Account> accounts = IntStream.range(0, 10)
                .mapToObj(i -> new Account(String.valueOf(i)))
                .collect(Collectors.toList());
        List<Account> loggedInAccounts = accounts.stream()
                .peek(a -> {
                    System.out.println("peek1: account" + a.name + " value:" + a.loggedIn);
//                    a.login();
                })
//                .peek(a -> {
//                    System.out.println("peek2: account" + a.name + " value:" + a.loggedIn);
//                })
                .filter(a -> {
                    System.out.println("filter: account" + a.name + " value:" + a.loggedIn);
                    return a.loggedIn;
                })
//                .peek(a -> {
//                    System.out.println("peek3: account" + a.name + " value:" + a.loggedIn);
//                })
                .collect(Collectors.toList());

        loggedInAccounts.stream().forEach(a -> System.out.println(a.name));
        val runtimeMxBean = ManagementFactory.getRuntimeMXBean();
        val listOfArguments = runtimeMxBean.getInputArguments();
        for (String s : listOfArguments) {
            System.out.println("ARG: " + s);
        }

        List<BoxInt> list = Arrays.asList(new BoxInt(1), new BoxInt(10), new BoxInt(3), new BoxInt(7), new BoxInt(5));
        BoxInt a = list.stream()
                .peek(num -> System.out.println("will filter " + num))
                .filter(x -> x.i > 5)
                .findFirst()
                .get();
        System.out.println(a.i);

        List<Person> persons =
                Arrays.asList(
                        new Person("Max", 18),
                        new Person("Peter", 23),
                        new Person("Pamela", 23),
                        new Person("David", 12));
        String phrase = persons
                .stream().unordered()
                .filter(p -> p.age >= 18)
                .map(p -> p.name)
                .collect(Collectors.joining(" and ", "In Germany ", " are of legal age."));

        System.out.println(phrase);

        Collector<Person, StringJoiner, String> personNameCollector =
                Collector.of(
                        () -> new StringJoiner(" | "),  // supplier
                        (j, p) -> j.add(p.name.toUpperCase()),  // accumulator
                        StringJoiner::merge,               // combiner
                        StringJoiner::toString);                // finisher

        String names = persons
                .stream()
                .collect(personNameCollector);

        System.out.println(names);

        Outer outer = new Outer();
        if (outer != null && outer.nested != null && outer.nested.inner != null) {
            System.out.println(outer.nested.inner.foo);
        }

        Optional.of(new Outer())
                .flatMap(o -> Optional.ofNullable(o.nested))
                .flatMap(n -> Optional.ofNullable(n.inner))
                .flatMap(i -> Optional.ofNullable(i.foo))
                .ifPresentOrElse(System.out::println, () -> System.out.println("Is Empty"));



        Integer ageSum = persons
                .stream().parallel()
                .reduce(0,
                        (sum, p) -> {
                            System.out.format("accumulator: sum=%s; person=%s\n", sum, p);
                            return sum += p.age;
                        },
                        (sum1, sum2) -> {
                            System.out.format("combiner: sum1=%s; sum2=%s\n", sum1, sum2);
                            return sum1 + sum2;
                        });

        ForkJoinPool commonPool = ForkJoinPool.commonPool();
        System.out.println(commonPool.getParallelism());    // 3

        Arrays.asList("a1", "a2", "b1", "c2", "c1", "a1", "a2", "b1", "c2", "c1", "a1", "a2", "b1", "c2", "c1", "a1", "a2", "b1", "c2", "c1", "a1", "a2", "b1", "c2", "c1")
                .parallelStream()
                .forEach(s -> System.out.format("forEach: %s [%s]\n",
                        s, Thread.currentThread().getName()));

        IntStream.range(0, 100).parallel().forEachOrdered(System.out::println);

        List<Integer> list2 = new ArrayList<>();
        Stream.of(1, 5, 2, 7, 3, 9, 8, 4, 6).filter((i) -> true).sorted().peek(list2::add).count();
        System.out.println(list2.toString());

        Account a1 = new CheckingAccount("1");
        a1.login();

        Stream.of(1, 5, 2, 7, 3, 9, 8, 4, 6).parallel().sequential().sorted().forEach(System.out::println);

        Stream.of(1, 5, 2, 7, 3, 9, 8, 4, 6).parallel().sorted().collect(Collectors.toList()).forEach(System.out::println);
    }

    static class Outer {
        Nested nested;
        Nested nested2;
    }

    static class Nested {
        Inner inner;
        Inner inner2;
    }

    static class Inner {
        String foo;
        String foo2;
    }

    static class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
