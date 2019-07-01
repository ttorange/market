package com.shou.bean;

import java.sql.Timestamp;

public class
Provider {
    private Integer proId;
    private String proName;
    private String proContacts;
    private String proPhone;

    public Provider(Integer proId, String proName, String proContacts, String proPhone) {
        this.proId = proId;
        this.proName = proName;
        this.proContacts = proContacts;
        this.proPhone = proPhone;
    }

    public Provider() {
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProContacts() {
        return proContacts;
    }

    public void setProContacts(String proContacts) {
        this.proContacts = proContacts;
    }

    public String getProPhone() {
        return proPhone;
    }

    public void setProPhone(String proPhone) {
        this.proPhone = proPhone;
    }

    @Override
    public String toString() {
        return "Provider{" +
                "proId=" + proId +
                ", proName='" + proName + '\'' +
                ", proContacts='" + proContacts + '\'' +
                ", proPhone='" + proPhone + '\'' +
                '}';
    }
}
