package com.mjie.jvm.referencetype;

import java.io.IOException;

public class NormalReference {
    public static void main(String[] args) throws IOException {
        M m = new M();
        m = null;

        //gc单独的线程
        System.gc();
        System.out.println(m);

        //阻塞main线程，给垃圾回收线程时间执行
        System.in.read();
    }
}
