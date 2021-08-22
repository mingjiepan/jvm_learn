package com.mjie.jvm.memorystruct;

/**
 * 栈溢出（过多的栈帧）  StackOverFlowError
 * -Xss256k
 */
public class TestStack1 {

    private static int count;

    public static void main(String[] args) {
        try {
            method1();
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println(count);
        }
    }

    private static void method1() {
        count++;
        method1();
    }
}
