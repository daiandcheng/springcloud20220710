package com.edu.springcloud.service.impl;

import com.edu.springcloud.entries.Dept;
import com.edu.springcloud.mapper.DeptMapper;
import com.edu.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper ;
    @Override
    public List<Dept> getAll() {
        return deptMapper.getAll();
    }

    @Override
    public Dept getDeptById(Long id) {
        return deptMapper.getDeptById(id);
    }

    @Override
    public int saveDept(Dept dept) {
        return deptMapper.saveDept(dept);
    }
}
