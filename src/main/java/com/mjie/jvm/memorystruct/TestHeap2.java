package com.mjie.jvm.memorystruct;

/**
 * jps 查看当前系统中有哪些Java进程
 * jmap 查看某个Java进程的堆内存占用情况（某一时刻）  jmap -heap pid
 */
public class TestHeap2 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("1.......");
        byte[] buffer = new byte[10 * 1024 * 1024];
        Thread.sleep(30000);
        System.out.println("2.............");
        buffer = null;
        Thread.sleep(30000);
        System.out.println("3.....");
        System.gc();
        Thread.sleep(100000);
    }
}
