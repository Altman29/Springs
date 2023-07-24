package aop2;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect // 切面类，但是@Aspect并未被Spring管理
@Slf4j
public class MyAspect {

    @Before("execution(* aop2.MyService.*(..))")
    public void before() {
        log.info("before()");
    }
}
