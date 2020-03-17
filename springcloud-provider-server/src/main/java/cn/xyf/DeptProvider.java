package cn.xyf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker  // 启用 hystrix 熔断机制
public class DeptProvider {
    public static void main(String[] args) {
        SpringApplication.run(DeptProvider.class, args);
    }
}
