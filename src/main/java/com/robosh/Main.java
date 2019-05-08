package com.robosh;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Task 1");
        List<String> names = Arrays.asList("orest", "andtriy", "vasia", "petia", "vova",
                "vitalik", "uira", "nikita");
        System.out.println(task1(names));

        System.out.println("\nTask 2");
        System.out.println(task2(names));

        System.out.println("\nTask 3");
        System.out.println(Arrays.toString(task3(Arrays.asList("1, 3, 5", "5, 1, 7, 7"))));

        System.out.println("\nTask 4");
        myRandom(25214903917L, 11, (long) Math.pow(2,48), 43)
                .limit(5)
                .forEach(System.out::println);

        System.out.println("\nTask 5");
        Stream<Integer> integerStream1 = Stream.of(1, 2, 7, 8, 9);
        Stream<Integer> integerStream2 = Stream.of(11, 22, 77, 88, 55,34,233,12);
        zip(integerStream1, integerStream2).forEach(output -> System.out.print(output + " "));
    }

/*
    task1
     */

    private static List<String> task1(List<String> names) {
        return Stream.iterate(0, n -> n + 1)
                .limit(names.size())
                .filter(x -> x % 2 == 0)
                .map(number -> number + 1 + ". " + names.get(number))
                .collect(toList());
    }

    /*
    task 2
     */
    private static List<String> task2(List<String> str) {
        return str.stream()
                .map(String::toUpperCase)
                .sorted()
                .collect(toList());
    }

    /*
    task 3
     */
    private static Integer[] task3(List<String> str) {
        String regex = "[\\s.,]+";
        return str.stream()
                .flatMap((p) -> Arrays.stream(p.split(regex)))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
    }

    /*
    task4
    linear congruential generator
     */
    private static Stream<Long> myRandom(long a, long c, long m, long seed) {
        return Stream.iterate(seed, n -> (a * n + c) % m);
    }

    /*
    task5
     */
    private static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Stream<T> returnStream = Stream.empty();
        Iterator<T> iterator1 = first.iterator();
        Iterator<T> iterator2 = second.iterator();
        while (iterator1.hasNext()
                && iterator2.hasNext()) {
            returnStream = Stream.concat(returnStream,
                    Stream.of(iterator1.next(), iterator2.next()));

        }
        return returnStream;
    }
}
