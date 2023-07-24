package aop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Slf4j
@SpringBootApplication
public class A10Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(A10Application.class, args);

        MyService service = context.getBean(MyService.class);
        log.info("service class: {}", service.getClass());
        service.foo();

        context.close();
    }
}
