package com.mjie.jvm.classloader;

public class ClassLoader4 {
    public static void main(String[] args)throws Exception {
        Class clazz = ClassLoader4.class.getClassLoader().loadClass("com.mjie.jvm.classloader.ClassLoader1");
        System.out.println(clazz.getName());
    }
}
