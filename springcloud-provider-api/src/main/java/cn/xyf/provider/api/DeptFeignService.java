package cn.xyf.provider.api;

import cn.xyf.pojo.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(value = "${request.provider-server}", fallbackFactory = ServiceFallbackFactory.class)
public interface DeptFeignService {

    @PostMapping("/dept")
    int add(Dept dept);

    @GetMapping("/dept/{pid}")
    Dept queryById(@PathVariable("pid") int pid);

    @GetMapping("/depts")
    List<Dept> queryAll();
}
