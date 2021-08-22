package com.mjie.jvm.classloader;

public class Hello {
    public void echo() {
        System.out.println("hello world");
        System.out.println("my classLoader = " + this.getClass().getClassLoader());
    }
}
