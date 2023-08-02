package a39;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebApplicationContext;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericApplicationContext;

public class A39 {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication();
        app.addInitializers(applicationContext -> System.out.println("执行初始化器增强......"));

        System.out.println(">>>>>>>>>>>>>>>>>>> 2. 封装启动 args");

        System.out.println(">>>>>>>>>>>>>>>>>>> 8. 创建容器");
        GenericApplicationContext context = createApplicationContext(WebApplicationType.SERVLET);

        System.out.println(">>>>>>>>>>>>>>>>>>> 9. 准备容器");
        for (ApplicationContextInitializer initializer : app.getInitializers()) {
            initializer.initialize(context);//执行初始化器增强 在此处真正执行
        }

        System.out.println(">>>>>>>>>>>>>>>>>>> 10. 加载 bean 定义");
        AnnotatedBeanDefinitionReader reader = new AnnotatedBeanDefinitionReader(context.getDefaultListableBeanFactory());
        reader.register(Config.class);//读取配置类

        System.out.println(">>>>>>>>>>>>>>>>>>> 11. refresh 容器");
        context.refresh();

        for (String name : context.getBeanDefinitionNames()) {
            System.out.println("name: " + name+" 来源："+context.getBeanFactory().getBeanDefinition(name).getResourceDescription());
        }

        System.out.println(">>>>>>>>>>>>>>>>>>> 12. 执行 runner");

    }

    private static GenericApplicationContext createApplicationContext(WebApplicationType type) {
        GenericApplicationContext context = null;
        switch (type) {
            case SERVLET:
                context = new AnnotationConfigServletWebApplicationContext();
            case REACTIVE:
                context = new AnnotationConfigReactiveWebApplicationContext();
            case NONE:
                context = new AnnotationConfigApplicationContext();
        }
        return context;
    }

    static class Bean4 {

    }

    static class Bean5 {

    }

    static class Bean6 {

    }

    @Configuration
    static class Config {
        @Bean
        public Bean5 bean5() {
            return new Bean5();
        }

        @Bean
        public ServletWebServerFactory servletWebServerFactory() {
            return new TomcatServletWebServerFactory();
        }
    }
}
