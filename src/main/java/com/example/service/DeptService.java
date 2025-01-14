package com.example.service;

import com.example.pojo.Dept;

import java.util.List;

public interface DeptService {
    public List<Dept> findAll();
    void deleteById(Integer id);
//    void save(Dept dept);
    void save(Dept dept);

    Dept getById(Integer id);

    void update(Dept dept);
}
