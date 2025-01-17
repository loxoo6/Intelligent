package com.example.service;

import com.example.pojo.Clazz;
import com.example.pojo.PageResult;

import java.time.LocalDate;

public interface ClassService {
    PageResult list(String name, LocalDate begin, LocalDate end, Integer page, Integer pageSize);

    void addClass(Clazz clazz);

    Clazz searchById(Integer clazz);
}
