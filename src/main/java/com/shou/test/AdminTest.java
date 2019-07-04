package com.shou.test;

import com.shou.mapper.AdminMapper;
import com.shou.service.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath:springmvc.xml"})
public class AdminTest {
    @Autowired
    AdminMapper adminMapper;
    @Autowired
    AdminService adminService;
    @Test
    public void  testp(){
        String s=adminService.getPwd("admin");
        System.out.println(s);
    }
    @Test
    public void testpwd(){
        String user="Admin";
        String pwd=adminMapper.getPwd(user);
        System.out.println(pwd);

        int role=adminMapper.getRole(user);
        System.out.println(role);
    }

}
