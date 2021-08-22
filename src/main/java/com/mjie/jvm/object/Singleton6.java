package com.mjie.jvm.object;
/**
 * 0 new #3 <com/mjie/jvm/object/T>
 * 3 dup
 * 4 invokespecial #4 <com/mjie/jvm/object/T.<init> : ()V>
 * 7 astore_1   （将引用指向了对象）
 * 8 return
 *
 * 假如不加volatile的话，有可能发生指令重排序，导致对象的创建过程发生如下变化
 * 0 new #3 <com/mjie/jvm/object/T>
 * 3 dup
 * 7 astore_1   （将引用指向了对象）
 * 4 invokespecial #4 <com/mjie/jvm/object/T.<init> : ()V>
 * 8 return
 *
 * astore_1 指令在 invokespecial前面，这个就会出现
 *
 * if (singleton2 != null) xxx -> 使用了半初始化状态的对象
 */
public class Singleton6 {
    //加了volatile，为什么需要加
    private static volatile Singleton6 singleton2;

    private Singleton6() {}

    public static Singleton6 newInstance() {
        //外层加判断主要是效率问题，如果不加的话，
        // 相当于所有线程掉这个方法都必须先获取到锁
        if (singleton2 == null) {
            //上锁
            synchronized (Singleton6.class) {
                //在这里再次判断是否为null（有点类似CAS）
                if (singleton2 == null) {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    singleton2 = new Singleton6();
                }
            }
        }
        return singleton2;
    }
}
