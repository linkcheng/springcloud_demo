package cn.xyf.mapper;

import cn.xyf.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface DeptMapper {
    int add(Dept dept);

    Dept queryById(@Param("pid") int id);

    List<Dept> queryAll();
}
