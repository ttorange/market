package com.shou.mapper;

import com.shou.bean.Bill;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

public interface BillMapper {
    String TABLE_NAME="goods,provider,bill";
    String SELECT_FIELDS="BilId,goodsName,proName,Amount,isPay";
    String ASSOC="bill.goodsId=goods.goodsId and goods.proId=provider.proId";
    //删除
    @Delete("delete from bill where bilId=#{bilId}")
    int DeleteBillById(@Param("bilId") Integer bilId);
    //新增
    @Insert({"INSERT INTO bill (goodsId,Amount,isPay) VALUES(#{goodsId},#{Amount},#{isPay})" })
    int addBill(@Param("goodsId")Integer goodsId, @Param("Amount")Integer Amount, @Param("isPay")Integer isPay);

//    //更新
//    @Update({"update bill set goodsId=#{goodsId},Amount=#{Amount},isPay=#{isPay}"})
//    int update(@Param("bilId"),@Param("goodsId")Integer goodsId, @Param("Amount")Integer Amount, @Param("isPay")Integer isPay);

    @Select({"select",SELECT_FIELDS,"from",TABLE_NAME,"where bilId=#{bilId} and",ASSOC})
    Bill selectBill(@Param("bilId")Integer bilId);

    @Select({"SELECT", SELECT_FIELDS, "FROM", TABLE_NAME,"where",ASSOC})
    List<Bill> selectBillList();

    @Select("select Amount*goodsPrice as payment from bill,goods where bilId=#{bilId} and bill.goodsId=goods.goodsId")
    Double getPayment(@Param("bilId")Integer bilId);

    @Select({"Select",SELECT_FIELDS,"from",TABLE_NAME,"where",ASSOC,"Limit #{offset},#{limit}"})
    List<Bill> selectBillByLimitAndOffset(@Param("offset") Integer offset,
                                             @Param("limit")Integer limit);
    @Select({"SELECT COUNT(*) FROM bill"})
    int getBillCount();
}
