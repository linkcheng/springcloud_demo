package cn.xyf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"cn.xyf.service"})
public class FeignDeptConsumer {
    public static void main(String[] args) {
        SpringApplication.run(FeignDeptConsumer.class, args);
    }
}
