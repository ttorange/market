package com.shou.controller;

import com.shou.service.AdminService;
import com.shou.util.JsonMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value="/market")
public class LoginController {
    @Autowired
    AdminService adminService;
    //跳转到登录页面
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(){return "login";}

    //登录页面密码验证
    @RequestMapping(value = "/dologin",method = RequestMethod.POST)
    @ResponseBody
    public JsonMsg dologin(HttpServletRequest request){
        String adminName=request.getParameter("username");
        String pwd=request.getParameter("password");
        System.out.println(adminName+pwd);

        String pssword=adminService.getPwd(adminName);
        if(!pssword.equals(pwd)){
            return JsonMsg.fail().addInfo("login_error","密码错误");
        }
        return JsonMsg.success();
    }
    //去主界面
    @RequestMapping(value = "/main",method = RequestMethod.GET)
    public String main(){return "main";}
    //退出
    @RequestMapping(value = "logout",method = RequestMethod.GET)
    public String logout(){return "login";}

}
