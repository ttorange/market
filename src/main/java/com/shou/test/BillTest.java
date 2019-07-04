package com.shou.test;

import com.shou.bean.Bill;
import com.shou.bean.Goods;
import com.shou.mapper.BillMapper;
import com.shou.mapper.GoodsMapper;
import com.shou.service.BillService;
import com.shou.service.GoodsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath:springmvc.xml"})
public class BillTest {
    @Autowired
    BillMapper billMapper;
    @Autowired
    BillService billService;

    @Autowired
    GoodsMapper goodsMapper;
    @Test
    public void testGoods(){
        String s=goodsMapper.getGoodsProName(4);
        System.out.println(s);
    }
    @Test
    public void testDelte(){
        int res= billMapper.DeleteBillById(15);
        int r=billService.DeleteBillById(15);
        System.out.println(res);
    }
    @Test
    public void testlist(){
        List<Bill> b=billMapper.selectBillList();
        for(Bill bill:b){
            System.out.println(bill);
        }
    }
    @Test
    public void testgoodslist(){
        List<Goods> b=goodsMapper.selectGoodsList();
        for(Goods g:b){
            System.out.println(g);
        }
    }
    @Test
    public void testSelect(){
        Bill bill=billMapper.selectBill(1);
        System.out.println(bill);

    }
    @Test
    public void testPayment(){
        double pay=billMapper.getPayment(3);
        System.out.println(pay);
    }

    @Test
    public void testAdd(){
        Timestamp createtime=new Timestamp(System.currentTimeMillis());
        System.out.println(createtime);
        Bill bill=new Bill(null,"Mi9","Xiaomi",3,1);
        int res=billService.addBill(bill);
        System.out.println(bill);
    }
    @Test
    public void limit(){
        List<Bill> bills=billMapper.selectBillByLimitAndOffset(3,5);
        for(Bill bill:bills){
            System.out.println(bill);
        }
    }
}
