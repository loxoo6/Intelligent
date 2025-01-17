package com.example.controller;

import com.example.pojo.Clazz;
import com.example.pojo.PageResult;
import com.example.pojo.Result;
import com.example.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/clazzs")
public class ClassController {

    @Autowired
    private ClassService classService;

    @GetMapping
    public Result list(String name,
                       @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end,
                       @RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize){
        PageResult pageResult= classService.list(name,begin,end,page,pageSize);
        return Result.success(pageResult);

    }
    @PostMapping
    public Result addClass(@RequestBody Clazz clazz){

        classService.addClass(clazz);
        return Result.success();

    }
    @GetMapping("/{id}")
    public  Result searchById(@PathVariable Integer id){
        Clazz clazz=classService.searchById(id);
        return  Result.success(clazz);
    }


}
