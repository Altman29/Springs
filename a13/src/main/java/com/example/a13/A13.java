package com.example.a13;

public class A13 {
    interface Foo {
        void foo();
    }

    static class Target implements Foo {
        @Override
        public void foo() {
            System.out.println("target foo()");
        }
    }

    interface InvocationHandler {
        void invoke();
    }

    public static void main(String[] args) {
        Foo proxy0 = new $Proxy0(new InvocationHandler() {
            @Override
            public void invoke() {
                //具体的实现

                //1.功能增强
                System.out.println("before...");
                //2.调用目标
                new Target().foo();
            }
        });
        proxy0.foo();

    }
}
