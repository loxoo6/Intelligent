package com.example.service.Impl;

import com.example.mapper.ClassMapper;
import com.example.pojo.Clazz;
import com.example.pojo.ClazzVO;
import com.example.pojo.PageResult;
import com.example.service.ClassService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClassServiceImpl implements ClassService {

    @Autowired
    private ClassMapper classMapper;

    @Override
    public PageResult list(String name, LocalDate begin, LocalDate end,
                           Integer page, Integer pageSize){
        PageHelper.startPage(page,pageSize);
        List<Clazz> classList=classMapper.list(name,begin,end);
        Page<Clazz> p= (Page<Clazz>) classList;
        // 计算并设置每个班级的状态
        LocalDate now = LocalDate.now();
        for(Clazz clazz : p) {
            if(now.isAfter(clazz.getEndDate())) {
                clazz.setStatus("已结课");
            } else if(now.isBefore(clazz.getBeginDate())) {
                clazz.setStatus("未开班");
            } else {
                clazz.setStatus("在读中");
            }
        }
        return new PageResult(p.getTotal(), p);
    }

    @Override
    public void addClass(Clazz clazz){

        classMapper.addClass(clazz);

    }

    @Override
    public Clazz searchById(Integer id){
        return classMapper.searchById(id);
    }

}
