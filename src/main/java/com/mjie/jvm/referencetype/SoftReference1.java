package com.mjie.jvm.referencetype;

import com.mjie.utils.SleepHelper;

import java.lang.ref.SoftReference;

/**
 * 软引用适合缓存使用
 * 软引用当内存不够时，在下一次回收才被回收
 * -Xmx20M 设置堆大小为20M
 */
public class SoftReference1 {
    public static void main(String[] args) {
        //m是强引用，指向softReference对象，而softReference（软引用）指向了字节数组
        SoftReference<byte[]> m = new SoftReference<>(new byte[1024 * 1024 * 10]);

        SoftReference<M> a = new SoftReference<>(new M());//finalize会被执行

        System.out.println(m.get());
        System.gc();
        SleepHelper.sleep(500);

        //这里还可以打印出软引用
        System.out.println(m.get());

        //再分配一个数组，heap将装不下，这时候系统会垃圾回收，先回收一次，如果不够，再将软引用干掉
        byte[] b = new byte[1024 * 1024 * 12];
        System.out.println(m.get());
//        SoftReference<byte[]> c = new SoftReference<>(new byte[1024 * 1024 * 12]);
//        System.out.println(c.get());
    }
}
