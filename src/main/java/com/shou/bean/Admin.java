package com.shou.bean;

public class Admin {
    private Integer adminId;
    private String adminName;
    private String pwd;
    private Integer adminRole;

    public Integer getAdminId() {
        return adminId;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId=" + adminId +
                ", adminName='" + adminName + '\'' +
                ", pwd='" + pwd + '\'' +
                ", adminRole=" + adminRole +
                '}';
    }

    public Admin() {
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Integer getAdminRole() {
        return adminRole;
    }

    public void setAdminRole(Integer adminRole) {
        this.adminRole = adminRole;
    }

    public Admin(Integer adminId, String adminName, String pwd, Integer adminRole) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.pwd = pwd;
        this.adminRole = adminRole;
    }
}
