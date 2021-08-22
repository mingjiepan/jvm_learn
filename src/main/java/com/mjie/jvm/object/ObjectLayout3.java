package com.mjie.jvm.object;

import org.openjdk.jol.info.ClassLayout;

/**
 * 64位的机器，内存寻址空间是2的64次方，因此理论上类型指针应该是8个字节（64位），但是实际打印出来的是4个字节
 * 这里是因为jvm默认启用了压缩指针，通过此命令可查看，
 * java -XX:+PrintCommandLineFlags -version
 *
 * -XX:InitialHeapSize=266237632 -XX:MaxHeapSize=4259802112 -XX:+PrintCommandLineFlags
 * -XX:+UseCompressedClassPointers
 * -XX:+UseCompressedOops -XX:-UseLargePagesIndividualAllocation -XX:+UseParallelGC
 * java version "1.8.0_281"
 *
 * 因此，可通过-XX:-UseCompressedClassPointers来关闭压缩指针，这样对象头的class pointer就占了8个字节
 * -XX:+UseCompressedOops 压缩普通对象指针，如下面T的str成员变量，
 *
 */
public class ObjectLayout3 {

    private static class C {
        int a;
        int b;
        //占1个字节，内部用int表示，因此要填充3个字节，object alignment gap
        boolean flag;
    }

    private static class T {
        int a;
        int b;
        //占1个字节，内部用int表示，因此要填充3个字节，alignment/padding gap
        //Space losses: 3 bytes internal + 4 bytes external = 7 bytes total
        boolean flag;
        //类型指针，为什么这里是4个字节，不是8个字节（64位的机器）
        String str = "hello";
    }

    public static void main(String[] args) {
        T t = new T();
        System.out.println(ClassLayout.parseInstance(t).toPrintable());
        System.out.println("---------------------------");
        C c = new C();
        System.out.println(ClassLayout.parseInstance(c).toPrintable());
    }
}