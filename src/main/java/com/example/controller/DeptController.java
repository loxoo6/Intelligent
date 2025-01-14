package com.example.controller;

import com.example.pojo.Dept;
import com.example.pojo.Result;
import com.example.service.DeptService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/depts")
@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

    @GetMapping
    public Result list(){
        log.info("查询部门列表");
        List<Dept> deptList=deptService.findAll();
        return Result.success(deptList);
    }

    @DeleteMapping
    public Result delete(Integer id){
//        String idStr=request.getParameter("id");
//        int id=Integer.parseInt(idStr);
        log.info("根据id删除部门，id:{}",id);
        System.out.println("根据ID删除部门："+ id);
        deptService.deleteById(id);
        return Result.success();
    }
    @PostMapping
    public Result save(@RequestBody Dept dept){
        log.info("新增部门，dept:{}",dept);
        System.out.println("添加部门： "+ dept);
        deptService.save(dept);
        return Result.success();
    }
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        log.info("根据id查询部门,id:{}",id);
        System.out.println("根据ID查询，id="+id);
        Dept dept=deptService.getById(id);
        return Result.success(dept);
    }
    @PutMapping
    public Result update(@RequestBody Dept dept){
        log.info("修改部门,dept:{}",dept);
        System.out.println("修改部门 dept="+dept);
        deptService.update(dept);
        return Result.success();
    }

}
