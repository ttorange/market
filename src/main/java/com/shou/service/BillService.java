package com.shou.service;

import com.shou.bean.Bill;
import com.shou.mapper.BillMapper;
import com.shou.mapper.GoodsMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class BillService {
    @Autowired
    BillMapper billMapper;
    @Autowired
    GoodsMapper goodsMapper;

    public int DeleteBillById(Integer BillId){
        return billMapper.DeleteBillById(BillId);
    }

    public List<Bill> selectBillList(){
        return billMapper.selectBillList();
    }
    public List<Bill> selectBillByLimitAndOffset(Integer offset,Integer limit){
        return billMapper.selectBillByLimitAndOffset(offset,limit);
    }

    public Bill selectBillById(Integer BillId){
        return billMapper.selectBill(BillId);
    }
    //账单价格
    public Double getPayment(Integer bilId){
        return billMapper.getPayment(bilId);
    }
    //添加账单
    public int addBill(Bill bill){
        Integer goodsId=goodsMapper.getgoodsId(bill.getGoodsName());
        Integer amount=bill.getAmount();
        Integer isPay=bill.getIsPay();
        return billMapper.addBill(goodsId,amount,isPay);
    }
    public int getBillCount(){
        return billMapper.getBillCount();
    }
//    //更新账单
//    public int updateBill(Bill bill){
//        Integer BiId=goodsMapper.getgoodsId(bill.getGoodsName());
//        int ses=billMapper.update(bill.g)
//
//    }

}
