package com.mjie.jvm.memorystruct;


/**
 *   串池 StringTable
 *   生成一个String对象的方式很多种，只有三种方法会将String对象放入串池
 *   1. String字面量  如，String s = "a";
 *   2. String常量值的表达式 如， String s = "a" + "b"
 *   3. 调用String对象的intern方法，这种方式，假如pool中已经有了该String对象，那么就返回pool的String对象引用，
 *   若没有，则将String对象加入到串池中，并返回这个对象的引用，就是堆中的String对象和串池的是同一个对象
 *
 *   jdk1.6 StringTable在常量池中，在永久代中
 *   jdk1.7之后，StringTable在堆中
 */
public class StringTable1 {
    public static void main(String[] args) {
        String s1 = "a";  //pool a
        String s2 = "b"; //pool a、b
        String s3 = "a" + "b"; // a、b、ab
        String s4 = s1 + s2; //堆中  ab
        String s5 = "ab"; // 池中的ab
        String s6 = s4.intern(); // 池中的ab

        System.out.println(s3 == s4);  //true
        System.out.println(s3 == s5); //true
        System.out.println(s3 == s6); //true

        String x2 = new String("c") + new String("d");  //堆中的cd
        String x1 = "cd"; // 池中的cd
        String x3 = x2.intern(); //池中的cd

        //问，如果调换了【最后两行代码】的位置呢，如果是jdk6呢
        System.out.println(x1 == x2); //false
        System.out.println(x1 == x3); //true
        System.out.println(x2 == x3); //false
    }
}