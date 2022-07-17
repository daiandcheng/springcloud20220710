package com.edu.springcloud.service;


import com.edu.springcloud.entries.Dept;

import java.util.List;

public interface DeptService {
    // 查询所有的部门的信息
    public List<Dept> getAll();
    // 根据id去查询指定部门的信息
    public Dept getDeptById(Long id) ;
    // 进行新增的操作
    public int saveDept(Dept dept) ;
}
