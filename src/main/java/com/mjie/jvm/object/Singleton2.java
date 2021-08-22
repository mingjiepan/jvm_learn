package com.mjie.jvm.object;

public class Singleton2 {
    private static Singleton2 singleton2;

    private Singleton2() {}

    public static Singleton2 newInstance() {
        //线程不安全
        if (singleton2 == null) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            singleton2 = new Singleton2();
        }
        return singleton2;
    }
}
