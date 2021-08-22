package com.mjie.jvm.classloader;

public class KdClassLoaderClient {
    public static void main(String[] args) throws Exception {
        KdClassLoader l = new KdClassLoader();
        Class<?> clazz = l.loadClass("com.mjie.jvm.classloader.Hello");
        Object o = clazz.newInstance();

        System.out.println(o.getClass().getClassLoader());
        System.out.println(l.getParent());
    }
}
