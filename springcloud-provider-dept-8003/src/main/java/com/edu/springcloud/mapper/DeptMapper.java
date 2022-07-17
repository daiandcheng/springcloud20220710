package com.edu.springcloud.mapper;

import com.edu.springcloud.entries.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface DeptMapper {
    // 查询所有的部门信息
    public List<Dept> getAll();
    // 根据id去查询部门信息
    public Dept getDeptById(Long id);
    // 进行新增操作
    public int saveDept(Dept dept) ;
}
