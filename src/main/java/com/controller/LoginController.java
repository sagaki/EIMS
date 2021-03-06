package com.controller;

import com.domain.Emp;
import com.domain.Login;
import com.service.EmpService;
import com.service.LoginService;
import com.utils.SHAUtil;
import com.utils.SendEmailUtil;
import com.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * 未登录路由控制器
 */
@Controller
public class LoginController {

    @Autowired
    private EmpService empService;

    @Autowired
    private LoginService loginService;

    //  激活员工账号
    @RequestMapping("/activation")
    public String activation(String jwt, Model model) {
        try {
            String username = TokenUtil.parseJwt(jwt);
            Emp emp = this.empService.findEmpByUsername(username);
            this.loginService.updateActivation(emp.getUsername());
            model.addAttribute("msg", "账号激活成功");
            return "login";
        } catch (Exception e) {
            System.out.println(e);
            model.addAttribute("msg", "链接无效激活失败，请重新注册");
            return "register";
        }
    }

    // 返回首页
    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    // 返回登录页面
    @RequestMapping("/toLogin")
    public String login(Integer error, Model model) {
        if (error != null) {
            model.addAttribute("msg", "登陆后才能继续访问");
        }
        return "login";
    }

    // 返回注册页面
    @RequestMapping("/toRegister")
    public String register() {
        return "register";
    }

    // 返回员工登录密码修改页面
    @RequestMapping("/resetPassword")
    public String reset(String jwt, Model model) {
        try {
            String username = TokenUtil.parseJwt(jwt);
            model.addAttribute("username", username);
            return "resetPassword";
        } catch (Exception e) {
            System.out.println(e);
            model.addAttribute("msg", "链接无效，请重新发送");
            return "reset";
        }
    }

    // 员工登录密码修改
    @RequestMapping("/setPassword")
    public String setPassword(Login login, Model model) {
        String password = login.getPassword();
        login.setPassword(SHAUtil.SHA256(password));
        this.loginService.updatePassword(login);
        login.setPassword(password);
        model.addAttribute("login", login);
        model.addAttribute("msg", "重置密码成功");
        return "login";
    }

    // 返回首页
    @RequestMapping("/")
    public String toIndex() {
        return "index";
    }

    // 登录校验
    @RequestMapping("/login")
    public String toLogin(Login login, HttpSession session, Model model) {

        String password = login.getPassword();
        login.setPassword(SHAUtil.SHA256(password));
        Login user = loginService.findLogin(login);
        if (user == null) {
            login.setPassword(password);
            model.addAttribute("login", login);
            model.addAttribute("msg", "用户名或密码错误");
            return "login";
        } else {
            session.setAttribute("user", user);
            if (user.getPurview().equals("管理员")) {
                session.setAttribute("url", "main/admin/allEmp");
            } else {
                session.setAttribute("url", "main/emp/allEmp");
            }
            return "main";
        }
    }

    // 返回个人主页
    @RequestMapping("/main")
    public String toMian() {
        return "main";
    }

    // 注册信息校验 添加 成功后发送激活邮件
    @RequestMapping("/register")
    public String toRegister(Emp emp, Model model) {
        String password = emp.getPassword();
        emp.setPassword(SHAUtil.SHA256(password));
        try {
            this.empService.addEmp(emp);
        } catch (Exception e) {
            System.out.println(e);
            emp.setPassword(password);
            model.addAttribute("msg", "用户名已被使用，请使用其他用户名");
            model.addAttribute("emp", emp);
            return "register";
        }
        model.addAttribute("msg", "注册成功，请去邮箱查看邮件进行账号激活");
        emp.setPassword(password);
        model.addAttribute("emp", emp);
        String jwt = TokenUtil.createJwt(emp.getUsername());
        String url = "http://localhost:8080/activation?jwt=";
        String title = "激活账号";
        String content = emp.getUsername() + "请点击链接激活账号" + url + jwt;
        try {
            SendEmailUtil.send(emp.getEmail(), title, content);
        } catch (Exception e) {
            System.out.println(e);
            emp.setPassword(password);
            model.addAttribute("msg", "无效邮箱，请填写正确邮箱");
            model.addAttribute("emp", emp);
            return "register";
        }
        return "login";
    }

    // 返回员工密码重置页
    @RequestMapping("/reset")
    public String toReset() {
        return "reset";
    }

    // 校验员工密码重置需要的登录用户名 正确发送重置用邮件
    @RequestMapping("/toReset")
    public String toReset(String username, Model model) {
        try {
            Emp emp = this.empService.findEmpByUsername(username);
            String jwt = TokenUtil.createJwt(emp.getUsername());
            String url = "http://localhost:8080/resetPassword?jwt=";
            String title = "重置密码";
            String content = emp.getUsername() + "请点击链接来重置你的账号密码" + url + jwt;
            SendEmailUtil.send(emp.getEmail(), title, content);
            model.addAttribute("msg", "请查看邮箱点击链接进行密码重置");
            return "reset";
        } catch (Exception e) {
            model.addAttribute("msg", "该用户不存在，请填写正确的用户名");
            return "reset";
        }
    }

    // 员工退出
    @RequestMapping("/logout")
    public String userlogout(HttpSession session) {
        session.invalidate();
        return "login";
    }

}
