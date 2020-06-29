package org.link.advertise.form.collection;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author jcm1024@163.com
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = "org.link.advertise.form.collection.dao")
public class FormCollectionServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FormCollectionServerApplication.class, args);
    }

}
