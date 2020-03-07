package cn.xyf.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
public class ConfigBean {

    @Bean("restTemplate")
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    /**
     * 配置负载均衡实现 RestTemplate
     */
    @Bean("restTemplateRibbon")
    @LoadBalanced
    public RestTemplate restTemplateRibbon() {
        return new RestTemplate();
    }
}
