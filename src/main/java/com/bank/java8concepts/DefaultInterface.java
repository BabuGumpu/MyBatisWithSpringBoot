package com.bank.java8concepts;/*
 *
 * @project - mybatiswithspringboot
 * @author - Babu Gumpu , on 06/06/2019
 *
 */

public interface DefaultInterface {
    void show();

    default void test1() {
        System.out.println("Babu Testing Default Method in Interface");
    }

    default void test2(int i) {
        System.out.println("Test 2 ");
    }

    static void staticTest(){
        System.out.println("Static Test");
    }
}
