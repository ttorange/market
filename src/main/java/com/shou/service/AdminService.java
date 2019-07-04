package com.shou.service;

import com.shou.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    AdminMapper adminMapper;
    public String getPwd(String adminName){
        return adminMapper.getPwd(adminName);
    }
    public int getAminRoleByName(String adminName){
        return adminMapper.getRole(adminName);
    }

}
