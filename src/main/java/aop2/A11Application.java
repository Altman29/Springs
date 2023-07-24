package aop2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@Slf4j
public class A11Application {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(A11Application.class);
        MyService service = context.getBean(MyService.class);

        //MyService并非代理，但foo方法也被增强了，做增强的是java agent，在加载类时,修改了字节码
        log.info("service class: {}", service.getClass());
        service.foo();

    }
}
