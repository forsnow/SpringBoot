package com.xuesong.springbootrestfulcrud.controller;

import com.xuesong.springbootrestfulcrud.dao.DepartmentDao;
import com.xuesong.springbootrestfulcrud.dao.EmployeeDao;
import com.xuesong.springbootrestfulcrud.entities.Department;
import com.xuesong.springbootrestfulcrud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @author: Snow
 * @create: 2020-07-17 17:31
 **/
@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;
    //查询所有员工返回列表页面
    @GetMapping(value = "emps")
    public String list(Model model){
        Collection<Employee> all = employeeDao.getAll();
        //结果放在请求域中
        model.addAttribute("emps",all);
        return "emp/list";
    }

    //来到员工添加页面
    @GetMapping(value = "emp")
    public String toAddPage(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }

    //员工添加
    //SpringMVC自动将请求参数和入参对象的属性进行绑定，请求参数的名字和javabean的对象里面的属性名字是一样的
    @PostMapping(value = "emp")
    public String addEmp(Employee employee){

        System.out.println("保存的员工信息"+employee);
        employeeDao.save(employee);
        //添加完成后来到员工列表页面
        //redirect:表示重定向到一个地址
        //forward:表示转发到一个地址
        return "redirect:/emps";
    }

    //来到编辑页面,查出当前员工，在页面回显
    @GetMapping(value = "/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);

        //页面要显示所有的部门列表
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        //回到修改页面（add页面是修改和添加页面二合一的）
        return "emp/add";
    }

    //员工修改功能 需要把员工的id也提交过来
    @PutMapping(value = "/emp")
    public String updateEmp(Employee employee){
        System.out.println("修改的员工数据"+employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //员工删除功能
    @DeleteMapping(value = "/emp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
