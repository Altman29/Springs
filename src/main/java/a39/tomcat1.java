package a39;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collections;
import java.util.Set;

public class tomcat1 {
    public static void main(String[] args) throws IOException, LifecycleException {
        //1. 创建tomcat对象
        Tomcat tomcat = new Tomcat();
        tomcat.setBaseDir("tomcat");//设置tomcat的基本目录，必须

        //2. 创建项目文件夹，即docBase文件夹
        File docBase = Files.createTempDirectory("boot.").toFile();
        docBase.deleteOnExit();//程序退出时删除该文件夹

        //3. 创建tomcat项目，在Tomcat中称为Context
        Context context = tomcat.addContext("", docBase.getAbsolutePath());

        //4. 编程添加Servlet
        context.addServletContainerInitializer(new ServletContainerInitializer() {
            @Override
            public void onStartup(Set<Class<?>> set, ServletContext ctx) throws ServletException {
                HelloServlet helloServlet = new HelloServlet();
                ctx.addServlet("aaa", helloServlet).addMapping("/hello");
            }
        }, Collections.emptySet());

        //5. 启动Tomcat
        tomcat.start();

        //6. 创建连接器，设置监听端口
        Connector connector = new Connector();
        connector.setPort(8080);
        tomcat.setConnector(connector);
    }
}
