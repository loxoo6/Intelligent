package com.example.service;

import com.example.pojo.EmpQueryParam;
import com.example.pojo.PageResult;

import java.time.LocalDate;

public interface EmpService {
    PageResult page(EmpQueryParam empQueryParam);}
