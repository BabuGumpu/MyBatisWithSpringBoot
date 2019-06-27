package com.bank.java8concepts;/*
 *
 * @project - mybatiswithspringboot
 * @author - Babu Gumpu , on 06/06/2019
 *
 */

import java.util.stream.IntStream;

public class StreamsExample {
    public static void main(String args[]) {
        IntStream
                .range(1, 10)
                .forEach(System.out::println);
        System.out.println();
        IntStream
                .range(1, 10)
                .skip(5)
                .forEach(System.out::println);

    }
}
