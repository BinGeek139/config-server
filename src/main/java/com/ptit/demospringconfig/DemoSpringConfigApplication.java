package com.ptit.demospringconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.ConfigurableApplicationContext;

@EnableConfigServer
@SpringBootApplication
public class DemoSpringConfigApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context=SpringApplication.run(DemoSpringConfigApplication.class, args);
//        DemoKaka startupListener=context.getBean(DemoKaka.class);
//        startupListener.run();

    }

}
