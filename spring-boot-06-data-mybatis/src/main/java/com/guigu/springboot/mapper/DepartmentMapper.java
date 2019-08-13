package com.guigu.springboot.mapper;

import com.guigu.springboot.bean.Department;
import org.apache.ibatis.annotations.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

//辅助mybatis极简单表开发的组件
//指定这是一个操作数据库的mapper
//@Mapper
public interface DepartmentMapper {


    //sql语句
    @Select("select * from department where id=#{id}")
    public Department getDeptById(Integer id);

    @Delete("delete from department where id=#{id}")
    public int deleteDeptById(Integer id);

    @Options(useGeneratedKeys = true,keyProperty = "id")//设置自增id，使用id封装组件
    @Insert("insert into department(department_name) values(#{departmentName})")
    public int insertDept(Department department);

    @Update("update department set department_name=#{departmentName} where id=#{id}")
    public int updateDept(Department department);

}
