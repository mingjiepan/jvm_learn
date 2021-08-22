package com.mjie.jvm.classloader;

/**
 * sun.boot.class.path、java.ext.dirs、java.class.path
 * 三个路径是从Launcher源码看的
 */
public class ClassLoader3 {
    public static void main(String[] args) {
        String pathBoot = System.getProperty("sun.boot.class.path");
        System.out.println(pathBoot.replaceAll(";", System.lineSeparator()));
        System.out.println("--------------");

        String pathExt = System.getProperty("java.ext.dirs");
        System.out.println(pathExt.replaceAll(";", System.lineSeparator()));
        System.out.println("--------------");

        String pathApp = System.getProperty("java.class.path");
        System.out.println(pathApp.replaceAll(";", System.lineSeparator()));
    }
}