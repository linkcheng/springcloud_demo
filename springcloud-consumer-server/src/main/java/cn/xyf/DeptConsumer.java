package cn.xyf;

import cn.sfy.config.RuleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;


/**
 * Ribbon 和 Eureka 整合后，消费端通过 provider 的 application.name 直接调用，不用关系 provider 真正的 ip 跟 port
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "${request.provider-server}", configuration = RuleConfig.class)
public class DeptConsumer {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer.class, args);
    }
}
