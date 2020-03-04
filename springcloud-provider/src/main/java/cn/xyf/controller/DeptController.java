package cn.xyf.controller;


import cn.xyf.pojo.Dept;
import cn.xyf.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {
    private DeptService deptService;

    @Autowired
    public void setDeptService(DeptService deptService) {
        this.deptService = deptService;
    }


    @PostMapping("/dept")
    public int add(Dept dept) {
        return deptService.add(dept);
    }


    @GetMapping("/dept/{pid}")
    public Dept getDept(@PathVariable("pid") int pid) {
        return deptService.queryById(pid);
    }

    @GetMapping("/depts")
    public List<Dept> getAllDept() {
        return deptService.queryAll();
    }

}


