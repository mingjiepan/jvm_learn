package com.mjie.jvm.classloader;

public class ClassLoader2 {
    public static void main(String[] args) {
        System.out.println(ClassLoader2.class.getClassLoader());
        System.out.println(ClassLoader2.class.getClassLoader().getClass().getClassLoader());
        System.out.println(ClassLoader2.class.getClassLoader().getParent());
        System.out.println(ClassLoader2.class.getClassLoader().getParent().getParent());
    }
}
