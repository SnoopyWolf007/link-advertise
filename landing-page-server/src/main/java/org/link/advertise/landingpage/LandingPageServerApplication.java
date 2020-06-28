package org.link.advertise.landingpage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: jcm1024@163.com
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = "org.link.advertise.landingpage.dao")
public class LandingPageServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(LandingPageServerApplication.class, args);
    }

}
