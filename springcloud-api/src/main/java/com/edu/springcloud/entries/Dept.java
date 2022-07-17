package com.edu.springcloud.entries;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Dept {
    private Long deptno ; // 部门的编号
    private String dname ; // 部门的名字
    private String db_source ; // 数据库

    public Dept(String dname) {
        this.dname = dname ;
    }
}
