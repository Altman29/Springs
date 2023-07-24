package com.example.jdkproxydemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxyDemo {

    interface Foo {
        void foo();
    }

    static class Target implements Foo {
        @Override
        public void foo() {
            System.out.println("target foo()");
        }
    }

    //代理的俩种方式
    //jdk java自带的，限制：只能针对接口代理
        //特点：和目标类实现了相同的接口，和目标类是兄弟关系，代理类调用方法时就相当于调用了目标类的方法
    //cglib 第三方的，无限制，没有实现接口也可以代理
    public static void main(String[] args) {
        // 代理对象
        Target target = new Target();

        // 获取当前的类加载器,用来加载在运行期间动态生成的字节码
        ClassLoader loader = JdkProxyDemo.class.getClassLoader();

        // 三个参数：类加载器，接口(代理类要实现那些接口)，InvocationHandler（代理类要执行的行为）
        // 强转换成接口类型
        Foo proxy = (Foo) Proxy.newProxyInstance(loader, new Class[]{Foo.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] objects) throws Throwable {
                //参数列表：代理对象，方法，方法参数
                System.out.println("before...");

                // 调用目标方法，通过方法反射调用
                Object result = method.invoke(target, args);

                System.out.println("after...");

                return result; // 让代理也返回目标对象的返回值
            }
        });
        proxy.foo();

    }
}
