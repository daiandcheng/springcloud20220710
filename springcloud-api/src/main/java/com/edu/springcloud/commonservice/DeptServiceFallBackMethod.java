package com.edu.springcloud.commonservice;

import com.edu.springcloud.entries.Dept;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class DeptServiceFallBackMethod implements FallbackFactory<DeptService> {
    @Override
    public DeptService create(Throwable cause) {
        return new DeptService() {
            @Override
            public List<Dept> list() {
                return null;
            }

            @Override
            public Dept getDeptById(Long deptno) {
                return new Dept().setDeptno(deptno)
                        .setDname("当前deptno:"+deptno+",没有找到dept,customer提供的降级服务，此时provider已经关闭......")
                        .setDb_source("no this database in mysql");
            }

            @Override
            public String saveDept(Dept dept) {
                return null;
            }
        };
    }
}
