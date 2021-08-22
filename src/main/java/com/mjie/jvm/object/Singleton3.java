package com.mjie.jvm.object;

public class Singleton3 {
    private static Singleton3 singleton2;

    private Singleton3() {}

    /**
     * 方法加synchronized
     * 缺点：整个方法都上锁，没必要的代码（业务逻辑）也进行同步了，锁粒度太粗了
     * @return
     */
    public static synchronized Singleton3 newInstance() {
        if (singleton2 == null) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            singleton2 = new Singleton3();
        }
        return singleton2;
    }
}
