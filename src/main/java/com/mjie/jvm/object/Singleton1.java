package com.mjie.jvm.object;

/**
 * 单例，线程安全
 * 缺点：只要类一被加载进虚拟机，jvm就会创建一个对象，不管有没用到
 */
public class Singleton1 {

    private static Singleton1 singleton1 = new Singleton1();

    private Singleton1() {}

    public static Singleton1 newInstance() {
        return singleton1;
    }
}
