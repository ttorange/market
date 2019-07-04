package com.shou.bean;

public class Goods {
    private Integer goodsId;
    private String goodsName;
    private String proName;
    private Double goodsPrice;

    @Override
    public String toString() {
        return "Goods{" +
                "goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", proName='" + proName + '\'' +
                ", goodsPrice=" + goodsPrice +
                '}';
    }

    public Goods() {
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public Double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Goods(Integer goodsId, String goodsName, String proName, Double goodsPrice) {
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.proName = proName;
        this.goodsPrice = goodsPrice;
    }
}
