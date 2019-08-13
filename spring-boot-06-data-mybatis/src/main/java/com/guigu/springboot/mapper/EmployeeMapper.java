package com.guigu.springboot.mapper;

import com.guigu.springboot.bean.Employee;

public interface EmployeeMapper {

    public Employee getEmpById(Integer id);

    public void insertEmp(Employee employee);

}
