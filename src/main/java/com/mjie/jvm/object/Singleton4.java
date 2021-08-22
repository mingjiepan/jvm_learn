package com.mjie.jvm.object;

public class Singleton4 {
    private static Singleton4 singleton2;

    private Singleton4() {}

    public static Singleton4 newInstance() {
        if (singleton2 == null) {
            //锁粒度缩小，这里还是会出现线程同步问题
            synchronized (Singleton4.class) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                singleton2 = new Singleton4();
            }
        }
        return singleton2;
    }
}
