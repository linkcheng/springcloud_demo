package cn.xyf.service;

import cn.xyf.pojo.Dept;

import java.util.List;

public interface DeptService {
    int add(Dept dept);

    Dept queryById(int pid);

    List<Dept> queryAll();
}
