package com.study.springboot.jdbc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class MyUserDTO {

    private int deptno;
    private String dname;
    private String loc;
}
