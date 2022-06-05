package com.cjy.controller;

import com.cjy.domain.Emp;
import com.cjy.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 普通用户路由控制器
 */
@Controller
@RequestMapping("/main/emp")
public class EmpController {

    @Autowired
    private EmpService empService;

    // 根据条件查询员工信息
    @RequestMapping("/empInfo")
    public String empInfo(String username, Model model) {
        if (username.isEmpty()) {
            return "redirect:/main/emp/allEmp";
        } else {
            List<Emp> emps = this.empService.findEmpByName(username);
            model.addAttribute("emps", emps);
            model.addAttribute("empName", username);
            return "EmpInfo";
        }
    }

    // 分页查询全部员工信息
    @RequestMapping("/allEmp")
    public String showEmp(Integer page, Model model, Integer error) {
        if (error != null) {
            model.addAttribute("msg", "<br>不能访问管理员页面");
        }
        Integer tmp = page;
        if (page != null) {
            page = (page - 1) * 5;
        } else {
            page = 0;
            tmp = 1;
        }
        List<Emp> emps = this.empService.allEmp(page);
        Integer pages = this.empService.countEmp();
        if (pages % 5 != 0) {
            pages = pages / 5 + 1;
        } else {
            pages = pages / 5;
        }
        model.addAttribute("emps", emps);
        model.addAttribute("pages", pages);
        model.addAttribute("page", tmp);
        return "allEmp";
    }

}
