package cn.sfy.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 不能入 SpringApplication 在同级目录下，不能被 @ComponentScan 扫描的，需要手动为每个 provider 单独指定
 */
@Configuration
public class RuleConfig {
    @Bean
    public IRule iRule() {
        return new RandomRule();
    }
}
