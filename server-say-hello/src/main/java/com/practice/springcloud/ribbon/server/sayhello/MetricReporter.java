package com.practice.springcloud.ribbon.server.sayhello;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.management.*;

/**
 * @author Luo Bao Ding
 * @since 2019/1/30
 */
@Component
public class MetricReporter implements EnvironmentAware, InitializingBean {
    private Environment environment;

    private MBeanServer mBeanServer;
    private ObjectName oNameTomcatConnector;

    public MetricReporter(MBeanServer mBeanServer) {
        this.mBeanServer = mBeanServer;
    }

    //    @Scheduled(fixedRate = 1000)
    public void printConnectionCount() throws AttributeNotFoundException, MBeanException, ReflectionException, InstanceNotFoundException {
        Object objConnectionCount = this.mBeanServer.getAttribute(oNameTomcatConnector, "connectionCount");
        int connectionCount = Integer.parseInt("" + objConnectionCount);
        System.out.println("connectionCount = " + connectionCount);

    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        String port = this.environment.getProperty("server.port");

        oNameTomcatConnector = new ObjectName("Tomcat:type=ThreadPool,name=\"http-nio-" + port + "\"");

    }
}
