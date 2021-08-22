package com.mjie.jvm.object;

import org.openjdk.jol.info.ClassLayout;

/**
 * OFF  SZ   TYPE DESCRIPTION               VALUE
 *   0   8        (object header: mark)     0x0000000000000001 (non-biasable; age: 0)
 *   8   4        (object header: class)    0xf80001e5
 *  12   4        (object alignment gap)
 * Instance size: 16 bytes
 * Space losses: 0 bytes internal + 4 bytes external = 4 bytes total
 *
 * markword 8个字节  class pointer 4个字节 实例数据 4个数据  对其填充 4个字节
 * 整个对象的字节数不能被8整除，那么就需要对其填充
 *
 * markword 主要包含3部分 锁信息、GC信息、hashcode
 *
 */
public class ObjectLayout1 {
    public static void main(String[] args) {
        Object obj = new Object();
        String s = ClassLayout.parseInstance(obj).toPrintable();
        System.out.println(s);
    }
}
