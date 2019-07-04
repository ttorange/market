package com.shou.service;

import com.shou.bean.Goods;
import com.shou.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService {
    @Autowired
    GoodsMapper goodsMapper;

    public String getGoodsProName(Integer goodsId){
        return goodsMapper.getGoodsProName(goodsId);
    }

    public Integer getGoodsId(String goodsName){
        return goodsMapper.getgoodsId(goodsName);
    }
    public List<Goods> selectGoodsList(){return goodsMapper.selectGoodsList();}
}
