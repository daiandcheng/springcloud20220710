package com.edu.springcloud.controller;

import com.edu.springcloud.entries.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/consumer")
public class DeptController {
    private String PREFIX = "http://SPRINGCLOUD-DEPT";
    @Autowired
    private RestTemplate restTemplate ;
    @RequestMapping(value = "/dept/list",method = RequestMethod.GET)
    public List<Dept> list() {
        return restTemplate.getForObject(PREFIX + "/dept/list", List.class);
    }
    @RequestMapping(value = "/dept/{deptno}",method = RequestMethod.GET)
    public Dept getDeptById(@PathVariable("deptno") Long deptno){
        return restTemplate.getForObject(PREFIX + "/dept/"+deptno, Dept.class);
    }
    @RequestMapping(value = "/dept",method = RequestMethod.POST)
    public String saveDept(Dept dept) {
        return restTemplate.postForObject(PREFIX +"/dept",dept,String.class) ;
    }
}
