package com.cjy.controller;

import com.cjy.domain.Emp;
import com.cjy.domain.Login;
import com.cjy.service.EmpService;
import com.cjy.service.LoginService;
import com.cjy.utils.SHAUtil;
import com.cjy.utils.SendEmailUtil;
import com.cjy.utils.TokenUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private EmpService empService;

    @Autowired
    private LoginService loginService;

    @RequestMapping("/activation")
    public String activation(String jwt, Model model) {
        try {
            Claims claims = TokenUtil.parseJwt(jwt);
            Emp emp = this.empService.findEmpByUsername(claims.getId());
            this.loginService.updateActivation(emp.getUsername());
            model.addAttribute("msg", "账号激活成功");
            return "login";
        } catch (Exception e) {
            System.out.println(e);
            model.addAttribute("msg", "链接无效激活失败，请重新注册");
            return "register";
        }
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/toLogin")
    public String login(Integer error, Model model) {
        if (error != null) {
            model.addAttribute("msg", "登陆后才能继续访问");
        }
        return "login";
    }

    @RequestMapping("/toRegister")
    public String register() {
        return "register";
    }

    @RequestMapping("/resetPassword")
    public String reset(String jwt, Model model) {
        try {
            Claims claims = TokenUtil.parseJwt(jwt);
            model.addAttribute("username", claims.getId());
            return "resetPassword";
        } catch (Exception e) {
            System.out.println(e);
            model.addAttribute("msg", "链接无效，请重新发送");
            return "reset";
        }
    }

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

    @RequestMapping("/")
    public String toIndex() {
        return "index";
    }

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

    @RequestMapping("/main")
    public String toMian() {
        return "main";
    }

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
        String url = "http://localhost:8080/ssm/activation?jwt=";
        String title = "激活账号";
        String content = "请点击链接激活账号" + url + jwt;
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

    @RequestMapping("/reset")
    public String toReset() {
        return "reset";
    }

    @RequestMapping("/toReset")
    public String toReset(String username, Model model) {
        try {
            Emp emp = this.empService.findEmpByUsername(username);
            String jwt = TokenUtil.createJwt(emp.getUsername());
            String url = "http://localhost:8080/ssm/resetPassword?jwt=";
            String title = "重置密码";
            String content = "请点击链接来重置你的账号密码" + url + jwt;
            SendEmailUtil.send(emp.getEmail(), title, content);
            model.addAttribute("msg", "请查看邮箱点击链接进行密码重置");
            return "reset";
        } catch (Exception e) {
            model.addAttribute("msg", "该用户不存在，请填写正确的用户名");
            return "reset";
        }
    }

    @RequestMapping("/logout")
    public String userlogout(HttpSession session) {
        session.invalidate();
        return "login";
    }

}
