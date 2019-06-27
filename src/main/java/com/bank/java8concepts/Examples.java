package com.bank.java8concepts;/*
 *
 * @project - mybatiswithspringboot
 * @author - Babu Gumpu , on 06/06/2019
 *
 */

import java.util.ArrayList;

public class Examples {

    public static void main(String args[]) {

        System.out.println("::Main Started");
        Examples examples = new Examples();
        MathOperation addition = (int a, int b) -> a + b;
        System.out.println("100 + 200 = " + examples.operate(100, 200, addition));

        SendMessage sendMessage = (message) -> System.out.println("Hello !! " + message);

        sendMessage.sayMessage("Babu");

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.add(6);

        //Using Lambda to display arrayList
        arrayList.forEach(n -> System.out.println(n));

        //
        arrayList.forEach(n -> {
            if (n % 2 == 0) {
                System.out.println(n + " is an Even Number");
            }
        });

        System.out.println(arrayList.stream().count());
    }

    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }

    @FunctionalInterface
    interface MathOperation {
        int operation(int a, int b);
    }

    @FunctionalInterface
    interface SendMessage {
        void sayMessage(String message);
    }

}
