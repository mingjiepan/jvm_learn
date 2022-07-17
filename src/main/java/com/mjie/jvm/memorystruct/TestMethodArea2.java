package com.mjie.jvm.memorystruct;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * 元空间内存溢出
 * -XX:MaxMetaspaceSize=10M
 *
 * Exception in thread "main" java.lang.OutOfMemoryError: Metaspace
 *
 * 这个和TestMethodArea1的区别
 */
public class TestMethodArea2 extends ClassLoader {
    public static void main(String[] args) {
       while (true) {
           Enhancer enhancer = new Enhancer();
           enhancer.setSuperclass(OOMObject.class);
           enhancer.setUseCache(false);
           enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> methodProxy.invokeSuper(o, objects));
           enhancer.create();
       }
    }
    static class OOMObject {

    }
}
