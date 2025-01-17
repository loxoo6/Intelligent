package com.example.mapper;

import com.example.pojo.Clazz;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface ClassMapper {

    @Select("SELECT c.*, e.name as masterName \n" +
            "        FROM clazz c \n" +
            "        LEFT JOIN emp e ON c.master_id = e.id")
    public List<Clazz> list(String name, LocalDate begin, LocalDate end);
    @Insert("""
        INSERT INTO clazz(name, room, begin_date, end_date, master_id, subject, 
                         create_time, update_time)
        VALUES(#{name}, #{room}, #{beginDate}, #{endDate}, #{masterId}, #{subject},
               #{createTime}, #{updateTime})
        """)
    void addClass(Clazz clazz);
    @Select("""
        SELECT c.*, e.name as masterName 
        FROM clazz c 
        LEFT JOIN emp e ON c.master_id = e.id 
        WHERE c.id = #{id}
        """)
    Clazz searchById(Integer id);
}


