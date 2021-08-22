package com.mjie.jvm.referencetype;

public class M {
    /**
     * 当这个类的对象被GC回收时，会调用此方法
     * @throws Throwable
     */
    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize");
    }
}
