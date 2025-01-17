package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

// VO类
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClazzVO {
    private Integer id;          //ID
    private String name;         //班级名称
    private String room;         //班级教室
    private LocalDate beginDate; //开课时间
    private LocalDate endDate;   //结课时间
    private Integer masterId;    //班主任ID
    private String masterName;   //班主任姓名
    private Integer subject;     //学科
    private String status;       //班级状态
    private LocalDateTime createTime; //创建时间
    private LocalDateTime updateTime; //修改时间
}