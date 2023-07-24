package a09;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("a09")
@Slf4j
public class A09Application {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context;
        context = new AnnotationConfigApplicationContext(A09Application.class);

        E e = context.getBean(E.class);
        log.info("{}",e.getF1().getClass());
        log.info("{}",e.getF1());
        log.info("{}",e.getF1());
        log.info("{}",e.getF1());


        log.info("{}",e.getF2().getClass());
        log.info("{}",e.getF2());
        log.info("{}",e.getF2());
        log.info("{}",e.getF2());

        log.info("{}",e.getF3().getClass());
        log.info("{}",e.getF3());
        log.info("{}",e.getF3());
        log.info("{}",e.getF3());

        log.info("{}",e.getF4().getClass());
        log.info("{}",e.getF4());
        log.info("{}",e.getF4());
        log.info("{}",e.getF4());

        context.close();
    }
}
