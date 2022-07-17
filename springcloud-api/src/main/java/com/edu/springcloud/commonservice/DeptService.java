package com.edu.springcloud.commonservice;

import com.edu.springcloud.entries.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
@FeignClient(value = "SPRINGCLOUD-DEPT",fallbackFactory = DeptServiceFallBackMethod.class)
public interface DeptService {
    @RequestMapping(value = "/dept/list",method = RequestMethod.GET)
    public List<Dept> list() ;

    @RequestMapping(value = "/dept/{deptno}",method = RequestMethod.GET)
    public Dept getDeptById(@PathVariable("deptno") Long deptno) ;

    @RequestMapping(value = "/dept",method = RequestMethod.POST)
    public String saveDept(Dept dept) ;
}
