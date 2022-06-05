package com.cjy.controller;

import com.cjy.domain.Emp;
import com.cjy.service.EmpService;
import com.cjy.utils.SHAUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/main/admin")
public class AdminController {

    @Autowired
    private EmpService empService;

    // 跳转到员工信息页面
    @RequestMapping("/addEmp")
    public String addEmp(Emp emp, Model model) {
        String password = emp.getPassword();
        emp.setPassword(SHAUtil.SHA256(password));
        try {
            this.empService.addEmp(emp);
        } catch (Exception e) {
            System.out.println(e);
            emp.setPassword(password);
            model.addAttribute("msg", "用户名已被使用，请使用其他用户名");
            model.addAttribute("emp", emp);
            return "addEmp";
        }
        return "redirect:/main/admin/allEmp";
    }

    // 删除员工信息
    @RequestMapping("/deleteEmp")
    public String deleteEmp(Integer id) {
        this.empService.deleteEmp(id);
        return "redirect:/main/admin/allEmp";
    }

    // 根据条件查询员工信息
    @RequestMapping("/empInfo")
    public String empInfo(String username, Integer id, Model model) {
        System.out.println(id);
        if (username.isEmpty() && id != null) {
            Emp emp = this.empService.findEmpById(id);  // 根据员工编号查询信息
            model.addAttribute("emp", emp);
            return "oneEmp";
        } else if (username.isEmpty() && id == null) {
            return "redirect:/main/admin/allEmp";
        } else {
            List<Emp> emps = this.empService.findEmpByName(username);   // 根据员工姓名模糊查询员工信息
            model.addAttribute("emps", emps);
            model.addAttribute("empName", username);
            return "AdminInfo";
        }
    }

    // 分页查询全部员工信息
    @RequestMapping("/allEmp")
    public String showEmp(Integer page, Model model, Integer error) {
        if (error != null) {
            model.addAttribute("msg", "<br>不能访问普通员页面");
        }
        Integer tmp = page;
        if (page != null) {
            page = (page - 1) * 5;
        } else {
            page = 0;
            tmp = 1;
        }
        List<Emp> emps = this.empService.allEmp(page);
        Integer pages = this.empService.CountEmp();
        pages = (int) Math.ceil(pages);
        model.addAttribute("emps", emps);
        model.addAttribute("pages", pages + 1);
        model.addAttribute("page", tmp);
        return "allAdmin";
    }

    // 添加员工信息
    @RequestMapping("/toAddEmp")
    public String toAddEmp() {
        return "addEmp";
    }

    // 更新员工信息
    @RequestMapping("/toUpdateEmp")
    public String toUpdateEmp(Integer id, Model model) {
        Emp emp = this.empService.findEmpById(id);
        model.addAttribute("emp", emp);
        return "updateEmp";
    }

    // 跳转到员工信息页面
    @RequestMapping("/updateEmp")
    public String updateEmp(Emp emp, Model model) {
        try {
            this.empService.updateEmp(emp);
        } catch (Exception e) {
            System.out.println(e);
            model.addAttribute("msg", "用户名已被使用，请使用其他用户名");
            model.addAttribute("emp", emp);
            return "updateEmp";
        }
        return "redirect:/main/admin/allEmp";
    }

}
