package com.example.aopaspectj01;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Aspect
@Slf4j
public class MyAspect {
    /*
    切面类，但是@Aspect并未被Spring管理
     */


    @Before("execution(* com.example.aopaspectj01.MyService.foo())")
    public void before() {
        log.info("before()");
    }
}
