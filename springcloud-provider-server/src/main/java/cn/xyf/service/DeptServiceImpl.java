package cn.xyf.service;

import cn.xyf.mapper.DeptMapper;
import cn.xyf.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DeptServiceImpl implements DeptService {

    private DeptMapper deptMapper;

    @Autowired
    public void setDeptMapper(DeptMapper deptMapper) {
        this.deptMapper = deptMapper;
    }

    public int add(Dept dept) {
        return deptMapper.add(dept);
    }

    public Dept queryById(int pid) {
        return deptMapper.queryById(pid);
    }

    public List<Dept> queryAll() {
        return deptMapper.queryAll();
    }
}
