package com.edu.springcloud.controller;

import com.edu.springcloud.entries.Dept;
import com.edu.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {
    @Autowired
    private DeptService deptService ;

    @RequestMapping(value = "/dept/list",method = RequestMethod.GET)
    public List<Dept> list() {
        return deptService.getAll() ;
    }
    @RequestMapping(value = "/dept/{deptno}",method = RequestMethod.GET)
    public Dept getDeptById(@PathVariable("deptno") Long deptno) {

        return deptService.getDeptById(deptno) ;
    }
    @RequestMapping(value = "/dept",method = RequestMethod.POST)
    public String saveDept(@RequestBody Dept dept) {
        return deptService.saveDept(dept) ==1 ? "success":"error" ;
    }
}
