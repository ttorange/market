package com.shou.bean;

import java.sql.Timestamp;

public class Bill {
    private Integer BillId;
    private String GoodsName;
    private Double Amount;
    private Integer isPay;
    private Timestamp createTime;

    public Bill(Integer billId, String goodsName, Double amount, Integer isPay, Timestamp createTime) {
        BillId = billId;
        GoodsName = goodsName;
        Amount = amount;
        this.isPay = isPay;
        this.createTime = createTime;
    }

    public Integer getBillId() {
        return BillId;
    }

    public void setBillId(Integer billId) {
        BillId = billId;
    }

    public String getGoodsName() {
        return GoodsName;
    }

    public void setGoodsName(String goodsName) {
        GoodsName = goodsName;
    }

    public Double getAmount() {
        return Amount;
    }

    public void setAmount(Double amount) {
        Amount = amount;
    }

    public Integer getIsPay() {
        return isPay;
    }

    public void setIsPay(Integer isPay) {
        this.isPay = isPay;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

}
