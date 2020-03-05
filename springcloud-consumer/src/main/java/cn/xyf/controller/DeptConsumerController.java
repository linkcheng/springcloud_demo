package cn.xyf.controller;

import cn.xyf.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController
public class DeptConsumerController {
    @Autowired
    @Qualifier("restTemplate")
    RestTemplate restTemplate;

    @Autowired
    @Qualifier("restTemplateRibbon")
    RestTemplate restTemplateRibbon;


    // 不是使用负载均衡的情况下请求地址是固定的
    private static final String BASE_URL = "http://localhost:8000";
    // 使用 ribbon loadBalanced 的情况下，地址为注册在 eureka 上的 provider 的 application.name
    private static final String BASE_PROVIDER_URL = "http://springcloud-provider";

    @PostMapping("/dept")
    public int add(Dept dept) {
        return restTemplate.postForObject(BASE_URL + "/dept", dept, int.class);
    }

    @GetMapping("/dept/{pid}")
    public Dept getDept(@PathVariable("pid") int pid) {
        return restTemplate.getForObject(BASE_URL+"/dept/"+pid, Dept.class);
    }

    @GetMapping("/depts")
    public List<Dept> getAllDept() {
        return restTemplate.getForObject(BASE_URL+"/depts", List.class);
    }

    @PostMapping("/ribbon/dept")
    public int add1(Dept dept) {
        return restTemplateRibbon.postForObject(BASE_PROVIDER_URL + "/dept", dept, int.class);
    }

    @GetMapping("/ribbon/dept/{pid}")
    public Dept getDept1(@PathVariable("pid") int pid) {
        return restTemplateRibbon.getForObject(BASE_PROVIDER_URL+"/dept/"+pid, Dept.class);
    }

    @GetMapping("/ribbon/depts")
    public List<Dept> getAllDept1() {
        return restTemplateRibbon.getForObject(BASE_PROVIDER_URL+"/depts", List.class);
    }
}
