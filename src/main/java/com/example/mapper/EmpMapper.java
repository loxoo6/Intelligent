package com.example.mapper;

import com.example.pojo.Emp;
import com.example.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
    @Select("select e.*, d.name as deptName from emp e left join dept d on e.dept_id = d.id")
    public List<Emp> list(EmpQueryParam empQueryParam);

}
