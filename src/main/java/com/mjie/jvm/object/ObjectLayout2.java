package com.mjie.jvm.object;

import org.openjdk.jol.info.ClassLayout;

/**
 * markword 8个字节  class pointer 4个字节 实例数据 4个数据  对其填充 4个字节
 *
 * markword 主要包含3部分 锁信息、GC信息、hashcode
 */
public class ObjectLayout2 {
    public static void main(String[] args) {
        Object obj = new Object();
        String s = ClassLayout.parseInstance(obj).toPrintable();
        System.out.println(s);

        //上锁之后的内存布局，给对象上锁，就是修改markword的内容
        synchronized (obj) {
            s = ClassLayout.parseInstance(obj).toPrintable();
            System.out.println(s);
        }

        //调用完一次hashcode后，以后调用hashcode方法，直接从markword获取
        obj.hashCode();
        s = ClassLayout.parseInstance(obj).toPrintable();
        System.out.println(s);
    }
}
