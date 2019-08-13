package com.guigu.springboot.controller;

import com.guigu.springboot.dao.DepartmentDao;
import com.guigu.springboot.dao.EmployeeDao;
import com.guigu.springboot.entities.Department;
import com.guigu.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    //查询所有员工,返回列表界面
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();

        //放在请求域中
        model.addAttribute("emps",employees);
        //thymeleaf默认进行拼串
        //classpath:/templates/xxx.html
        return "emp/list";
    }

    //来到员工添加页面
    @GetMapping("/emp")
    public String toAndPage(Model model){
        //来到添加页面,查出所有部门，在页面显示
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }

    //员工添加 redirect 重定向 forward 转发
    //SpringMvc自动将请求参数和入参对象的属性进行一一绑定
    //要求请求参数的名字和JavaBean入参的对象的属性名相同
    @PostMapping("/emp")//请求地址
    public String addEmp(Employee employee){
        //来到员工列表页面
        System.out.println("员工信息："+employee);
        //保存员工数据
        employeeDao.save(employee);
        return "redirect:/emps";//直接写/emps会被拼串
    }

    //来到修改页面，查出当前员工，在页面回显
    @GetMapping("/emp/{id}")
    //@PathVariable 获取路径变量 在页面回显要用Model的方式保存
    public String toEditPage(@PathVariable("id")Integer id,Model model){
        Employee employee = employeeDao.get(id);
        //保存一个emp
        model.addAttribute("emp",employee);
        //查出部门
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        //回到修改页面 add是一个修改添加二合一的页面
        return "emp/add";

    }

    //员工修改 需要提交员工id
    @PutMapping("/emp")
    public String updateEmployee(Employee employee){
        System.out.println("修改的员工数据："+employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //员工删除
    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }

}
