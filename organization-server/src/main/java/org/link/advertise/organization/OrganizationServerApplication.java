package org.link.advertise.organization;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "org.link.advertise.organization.dao")
public class OrganizationServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrganizationServerApplication.class, args);
    }

}
