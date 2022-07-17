package com.mjie.jvm.memorystruct;

import java.util.ArrayList;
import java.util.List;

/**
 * -Xms: 初始分配大小
 * -Xmx: 最大分配内存
 *
 * 堆内存溢出 OutOfMemoryError
 * -Xmx8m
 *
 * jps 查看当前系统中有哪些Java进程
 * jmap 查看某个Java进程的堆内存占用情况（某一时刻）  jmap -heap pid
 * jconsole 图形界面，连续检测
 */
public class TestHeap1 {
    public static void main(String[] args) {
        int i = 0;
        try {

            List<String> list = new ArrayList<>();
            String a = "hello";
            while (true) {
                list.add(a);
                a  = a + a;
                i++;
            }
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println(i);
        }
    }
}
