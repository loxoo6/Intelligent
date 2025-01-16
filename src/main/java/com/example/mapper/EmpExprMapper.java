package com.example.mapper;

import com.example.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpExprMapper {
    public void insertExpr(List<EmpExpr> exprList);
    void deleteByEmpIds(List<Integer> empIds);
}
