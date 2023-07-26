package com.example.a13;

//模拟JDK动态代理类
public class $Proxy0 implements A13.Foo {

    private A13.InvocationHandler h;

    public $Proxy0(A13.InvocationHandler h) {
        this.h = h;
    }

    @Override
    public void foo() {

        //把不确定的实现抽象出来，交给使用者去实现
        h.invoke();
    }
}
