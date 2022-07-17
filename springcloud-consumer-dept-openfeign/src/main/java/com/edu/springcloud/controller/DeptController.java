package com.edu.springcloud.controller;

import com.edu.springcloud.commonservice.DeptService;
import com.edu.springcloud.entries.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/consumer")
public class DeptController {
    @Autowired
    private DeptService deptService ;
    @RequestMapping(value = "/dept/list",method = RequestMethod.GET)
    public List<Dept> list() {
        return deptService.list() ;
    }
    @RequestMapping(value = "/dept/{deptno}",method = RequestMethod.GET)
    public Dept getDeptById(@PathVariable("deptno") Long deptno){
        return deptService.getDeptById(deptno) ;
    }
    @RequestMapping(value = "/dept",method = RequestMethod.POST)
    public String saveDept(Dept dept) {
        return deptService.saveDept(dept) ;
    }
}
