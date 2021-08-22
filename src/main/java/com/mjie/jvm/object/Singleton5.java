package com.mjie.jvm.object;

public class Singleton5 {
    private static Singleton5 singleton2;

    private Singleton5() {}

    public static Singleton5 newInstance() {
        //外层加判断主要是效率问题，如果不加的话，
        // 相当于所有线程掉这个方法都必须先获取到锁
        if (singleton2 == null) {
            //上锁
            synchronized (Singleton5.class) {
                //在这里再次判断是否为null（有点类似CAS）
                if (singleton2 == null) {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    singleton2 = new Singleton5();
                }
            }
        }
        return singleton2;
    }
}
