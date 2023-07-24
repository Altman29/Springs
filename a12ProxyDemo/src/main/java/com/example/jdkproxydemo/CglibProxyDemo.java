package com.example.jdkproxydemo;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxyDemo {

    static class Target {
        public void foo() {
            System.out.println("target foo()");
        }
    }

    // cglib代理
        // 特点：和目标类是父子关系，代理类继承了目标类，代理类调用方法时就相当于调用了目标类的方法
        // 目标类不能是final的
        // 目标类中方法不能是final的, 虽然不报错，但是不会增强
    public static void main(String[] args) {
        Target target = new Target();
        Target proxy = (Target) Enhancer.create(Target.class, new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("before...");
//                Object result = method.invoke(target, args);// 方式1：用方法反射调用目标对象的方法
                // 在cglib中，用methodProxy.invokeSuper()调用目标对象的方法，可以避免反射调用带来的性能问题
//                Object result = methodProxy.invoke(target, args);// 方式2：内部不使用反射 需要目标（Spring选用的方式）
                Object result = methodProxy.invokeSuper(o, args);// 方式3：内部不使用反射 需要代理
                System.out.println("after...");
                return result;
            }
        });
        proxy.foo();
    }
}
