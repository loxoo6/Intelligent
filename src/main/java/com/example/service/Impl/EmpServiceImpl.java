package com.example.service.Impl;

import com.example.mapper.EmpMapper;
import com.example.pojo.Emp;
import com.example.pojo.EmpQueryParam;
import com.example.pojo.PageResult;
import com.example.service.EmpService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    @Override
    public PageResult page(EmpQueryParam empQueryParam) {
//        Long total=empMapper.count();
//        Integer start = (page - 1) * pageSize;
//        List<Emp> empList=empMapper.list(start,pageSize);
        PageHelper.startPage(empQueryParam.getPage(),empQueryParam.getPageSize());
        List<Emp> empList=empMapper.list(empQueryParam);
        Page<Emp> p= (Page<Emp>) empList;
        return new PageResult(p.getTotal(),p.getResult());
    }
}
