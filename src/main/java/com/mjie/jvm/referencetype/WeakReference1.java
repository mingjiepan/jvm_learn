package com.mjie.jvm.referencetype;

import com.mjie.utils.SleepHelper;

import java.lang.ref.WeakReference;

/**
 * 弱遇到GC就会被回收
 */
public class WeakReference1 {
    public static void main(String[] args) {
        WeakReference<M> m = new WeakReference<>(new M());
        System.out.println(m.get());
        System.gc();
        SleepHelper.sleep(300);
        System.out.println(m.get());
    }
}
