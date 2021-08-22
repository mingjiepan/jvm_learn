package com.mjie.jvm.object;

/**
 * 对象分配在栈上的2个条件
 * 1. 逃逸分析
 *  对象的指针只在当前栈帧有引用（换句话说，对象只在方法内部使用，没有其他方法调用）
 * 2. 标量替换
 *
 *
 * Class实例是在method area 还是在 heap？
 *
 * Class实例存在方法区
 * 方法区， 可以理解为一个接口，，1.7及之前，实现方式叫做永久代  1.8及之后，实现方式叫做metaspace（元数据区）
 *
 *
 */
public class ObjectAllocate {
    public static void main(String[] args) {
    }
}