package com.edu.springcloud.controller;

import com.edu.springcloud.entries.Dept;
import com.edu.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    @RequestMapping(value = "/dept/{deptno}",method = RequestMethod.GET)
    public Dept getDeptById(@PathVariable("deptno") Long deptno) {
        Dept dept = deptService.getDeptById(deptno) ;
        if(null == dept) {
            throw new RuntimeException("该deptno:"+deptno+",没有对应的信息") ;
        }
        return dept ;
    }

    public Dept processHystrix_Get(@PathVariable("deptno") Long deptno) {
        return new Dept().setDeptno(deptno).setDb_source("该deptno没有对应的信息:@HystrixCommond")
                .setDname(null) ;
    }

    @RequestMapping(value = "/dept",method = RequestMethod.POST)
    public String saveDept(@RequestBody Dept dept) {
        return deptService.saveDept(dept) ==1 ? "success":"error" ;
    }

}
