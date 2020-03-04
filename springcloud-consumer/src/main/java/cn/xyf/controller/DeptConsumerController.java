package cn.xyf.controller;

import cn.xyf.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController
public class DeptConsumerController {
    @Autowired
    RestTemplate restTemplate;

    private static final String BASE_URL = "http://localhost:8000";

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
}
