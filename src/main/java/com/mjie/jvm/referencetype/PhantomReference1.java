package com.mjie.jvm.referencetype;

import com.mjie.utils.SleepHelper;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;

/**
 * 虚引用在被gc回收时会被放入一个队列中，GC有一个专门监听这个队列的线程，来处理，
 * 可以看ByteBuffer.allocateDirect
 * 当buffer被回收时，内部有一个虚引用会加入到队列中
 * 然后GC线程再从队列拉取到该引用，清除由kernel管理的堆外内存
 */
public class PhantomReference1 {

    private static final List<Object> LIST = new LinkedList<>();
    private static final ReferenceQueue<M> QUEUE = new ReferenceQueue<>();
    public static void main(String[] args) {

        PhantomReference<M> phantomReference = new PhantomReference<>(new M(), QUEUE);
        System.out.println(phantomReference.get());

        //内部有使用到虚引用
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(2014);

        new Thread(() -> {
            while (true) {
                LIST.add(new byte[2014 * 1024]);
                SleepHelper.sleep(1000);
                System.out.println(phantomReference.get());
            }
        }).start();


        new Thread(() -> {
            while (true) {
                Reference<? extends M> poll = QUEUE.poll();
                if (poll != null) {
                    System.out.println("----虚引用对象被JVM回收了----" + poll);
                }
            }
        }).start();

        SleepHelper.sleep(1000);
    }
}
