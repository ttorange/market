package com.shou.mapper;

import com.shou.bean.Goods;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface GoodsMapper {
    @Select("select proName from goods,provider where goodsId=#{goodsId} and goods.proId=provider.proId")
    String getGoodsProName (@Param("goodsId")Integer goodsId);
    @Select("select goodsId from goods where goodsName=#{goodsName}")
    Integer getgoodsId(@Param("goodsName")String goodsName);
    @Select("select goodsId,goodsName,proName,goodsPrice from goods,provider where goods.proId=provider.proId")
    List<Goods>selectGoodsList();
}
