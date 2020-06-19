package org.link.advertise.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class LinkEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(LinkEurekaServerApplication.class, args);
    }

}
