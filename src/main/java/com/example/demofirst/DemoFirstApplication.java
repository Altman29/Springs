package com.example.demofirst;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultSingletonBeanRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Locale;
import java.util.Map;

@SpringBootApplication
public class DemoFirstApplication {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, IOException {
        ConfigurableApplicationContext context = SpringApplication.run(DemoFirstApplication.class, args);

        //反射获取属性
        Field singletonObjects = DefaultSingletonBeanRegistry.class.getDeclaredField("singletonObjects");
        singletonObjects.setAccessible(true);
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        Map<String, Object> map = (Map<String, Object>) singletonObjects.get(beanFactory);
//        map.entrySet().stream().filter(e -> e.getKey().startsWith("component")).forEach(
//                e -> System.out.println(e.getKey() + "====" + e.getValue())
//        );
        /*
        sout:
        component1====com.example.demofirst.Component1@604c5de8
        component2====com.example.demofirst.Component2@37091312
         */

//        System.out.println(context.getMessage("hi", null, Locale.CHINA));
//        System.out.println(context.getMessage("hi", null, Locale.JAPAN));
//        System.out.println(context.getMessage("hi", null, Locale.ENGLISH));

//        Resource[] resources = context.getResources("classpath*:META-INF/spring.factories");
//        for (Resource resource : resources) {
//            System.out.println(resource);
//        }


        Resource[] resources = context.getResources("classpath*:META-INF/*.properties");


        System.out.println(context.getEnvironment().getProperty("server.port"));
    }

}
