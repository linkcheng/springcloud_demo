package cn.xyf.controller;

import cn.xyf.pojo.Dept;
import cn.xyf.provider.api.DeptFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/feign")
public class DeptController {

    @Autowired
    DeptFeignService feignService;

    @PostMapping("/dept")
    public int add(Dept dept) {
        return feignService.add(dept);
    }

    @GetMapping("/dept/{pid}")
    public Dept getDept(@PathVariable("pid") int pid) {
        return feignService.queryById(pid);
    }

    @GetMapping("/depts")
    public List<Dept> getAllDept() {
        return feignService.queryAll();
    }

}
