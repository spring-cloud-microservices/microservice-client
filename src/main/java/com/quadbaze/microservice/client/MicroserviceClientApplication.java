package com.quadbaze.microservice.client;

import com.quadbaze.microservice.client.browser.BrowserUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackages = {
        "com.quadbaze.microservice.client",
        "com.quadbaze.microservice.domain"
})
public class MicroserviceClientApplication {

    public static void main(String[] args) {
        BrowserUtil.browse(
                SpringApplication.run(MicroserviceClientApplication.class, args)
                        .getEnvironment()
                        .getProperty("config.server.status.uri")
        );
    }
}
