package com.mjie.jvm.referencetype;

import com.mjie.utils.SleepHelper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * spring的@Transional事务管理用到了ThreadLocal
 */
public class ThreadLocal1 {

    static class Person {
        public String name;
        public Person(String name) {
            this.name = name;
        }
    }
    static ThreadLocal<Person> t1 = new ThreadLocal<>();
    static List<Person> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        new Thread(() -> {
//            list.add(new Person("zhangsan"));
            SleepHelper.sleep(500);
            t1.set(new Person("lisi"));
            System.out.println(t1.get());
//            t1.remove();
        }).start();

        new Thread(() -> {
            SleepHelper.sleep(2000);
            System.out.println(t1.get());
        }).start();

        System.in.read();
    }
}
