package org.link.advertise.dot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author jcm1024@163.com
 */
@SpringBootApplication
@EnableDiscoveryClient
public class DotServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DotServerApplication.class, args);
    }

}
