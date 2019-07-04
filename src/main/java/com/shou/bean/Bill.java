package com.shou.bean;

import java.sql.Date;
import java.sql.Timestamp;

public class Bill {
    private Integer BilId;
    private String GoodsName;
    private String proName;
    private Integer Amount;
    private Integer isPay;

    @Override
    public String toString() {
        return "Bill{" +
                "BilId=" + BilId +
                ", GoodsName='" + GoodsName + '\'' +
                ", proName='" + proName + '\'' +
                ", Amount=" + Amount +
                ", isPay=" + isPay +
                '}';
    }

    public Integer getBilId() {
        return BilId;
    }

    public void setBilId(Integer bilId) {
        BilId = bilId;
    }

    public String getGoodsName() {
        return GoodsName;
    }

    public void setGoodsName(String goodsName) {
        GoodsName = goodsName;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public Integer getAmount() {
        return Amount;
    }

    public void setAmount(Integer amount) {
        Amount = amount;
    }

    public Integer getIsPay() {
        return isPay;
    }

    public void setIsPay(Integer isPay) {
        this.isPay = isPay;
    }

    public Bill() {
    }

    public Bill(Integer bilId, String goodsName, String proName, Integer amount, Integer isPay) {
        BilId = bilId;
        GoodsName = goodsName;
        this.proName = proName;
        Amount = amount;
        this.isPay = isPay;
    }
}
