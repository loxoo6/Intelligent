package com.example.service.Impl;

import com.example.mapper.EmpExprMapper;
import com.example.mapper.EmpMapper;
import com.example.pojo.Emp;
import com.example.pojo.EmpExpr;
import com.example.pojo.EmpQueryParam;
import com.example.pojo.PageResult;
import com.example.service.EmpService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private EmpExprMapper empExprMapper;

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

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void save(Emp emp){
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.insert(emp);

        int i=1/0;

        Integer empId = emp.getId();
        List<EmpExpr> exprList=emp.getExprList();
        if(!CollectionUtils.isEmpty(exprList)){
            exprList.forEach(empExpr -> empExpr.setEmpId(empId));
            empExprMapper.insertExpr(exprList);
        }
    }
}
