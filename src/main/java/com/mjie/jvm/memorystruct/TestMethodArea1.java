package com.mjie.jvm.memorystruct;


import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.Opcodes;

/**
 * 元空间内存溢出
 * -XX:MaxMetaspaceSize=18M
 *
 * Exception in thread "main" java.lang.OutOfMemoryError: Compressed class space
 *
 * Compressed class space 这个是Metaspace的一部分
 *
 * jdk1.6的话，永久代
 * -XX:MaxPermSize=10M
 */
public class TestMethodArea1 extends ClassLoader {
    public static void main(String[] args) {
        TestMethodArea1 area1 = new TestMethodArea1();
        int count = 0;
        try {
            for (int i = 0; i < 100000; i++) {
                //ClassWriter作用是生成类的二进制字节码
                ClassWriter cw = new ClassWriter(0);
                //版本号，public，类名，包名，父类，接口
                cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, "Class"+i, null, "java/lang/Object", null);
                byte[] array = cw.toByteArray();
                //执行类的加载
                area1.defineClass("Class" + i, array, 0, array.length);
                count++;
            }
        } finally {
            System.out.println(count);
        }
    }
}
