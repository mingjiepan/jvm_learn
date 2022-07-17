package com.mjie.jvm.memorystruct;

/**
 * 栈溢出  StackOverFlowError
 * -Xss256k
 *
 * 1. 栈帧太大，一个栈帧便超过了一个栈的内存大小限制
 * 2. 栈帧数过多，比如不停的递归调用
 *
 * 栈内存变大的话，在总的物理内存不变的情况下，线程并发数会变小
 *
 * 栈内存会存在并发问题么？
 * 局部变量不会逃离本方法，便是线程安全的
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
