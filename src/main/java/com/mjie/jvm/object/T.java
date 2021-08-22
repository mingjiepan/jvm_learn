package com.mjie.jvm.object;

public class T {
    int m = 8;

    /**
     * 对象半初始化
     * 0 new #3 <com/mjie/jvm/object/T>
     * 3 dup
     * 4 invokespecial #4 <com/mjie/jvm/object/T.<init> : ()V>
     * 7 astore_1
     * 8 return
     * @param args
     */
    public static void main(String[] args) {
        T t = new T();
    }
}
