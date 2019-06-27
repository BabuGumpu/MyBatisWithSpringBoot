package com.bank.java8concepts;/*
 *
 * @project - mybatiswithspringboot
 * @author - Babu Gumpu , on 06/06/2019
 *
 */

public class DefaultInterfaceImpl implements DefaultInterface {
    public static void main(String args[]){
        DefaultInterface di = new DefaultInterfaceImpl();
        di.test1();
        di.test2(20);
        di.show();
    }

    @Override
    public void show() {
        System.out.println("Show Testing - Abstract Method in Interface");
    }
}
