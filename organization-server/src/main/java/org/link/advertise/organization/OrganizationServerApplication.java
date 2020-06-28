package org.link.advertise.organization;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = "org.link.advertise.organization.dao")
public class OrganizationServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrganizationServerApplication.class, args);
    }

}
