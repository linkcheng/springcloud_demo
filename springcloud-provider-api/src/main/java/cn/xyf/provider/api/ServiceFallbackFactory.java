package cn.xyf.provider.api;

import cn.xyf.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * hystrix 服务降级
 */
@Component
public class ServiceFallbackFactory implements FallbackFactory {

    public Object create(Throwable cause) {
        return new DeptFeignService() {
            public int add(Dept dept) {
                return 0;
            }

            public Dept queryById(int pid) {
                return new Dept().setId(pid).setName("unknown").setDbSource("none");
            }

            public List<Dept> queryAll() {
                return null;
            }
        };
    }
}
