package com.shou.controller;

import com.shou.bean.Bill;
import com.shou.bean.Goods;
import com.shou.service.BillService;
import com.shou.service.GoodsService;
import com.shou.service.ProviderService;
import com.shou.util.JsonMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "market/bill")
public class BillController {
    @Autowired
    BillService billService;
    @Autowired
    GoodsService goodsService;
    //删除
    @RequestMapping(value = "/deleteBill/{bilId}",method = RequestMethod.DELETE)
    @ResponseBody
    public JsonMsg deleteBill(@PathVariable("bilId") Integer BilId){
        int res=0;
        if(BilId>0){
            res=billService.DeleteBillById(BilId);
        }
        if(res!=1){
            return JsonMsg.fail().addInfo("bill_del_error","账单删除异常");
        }
        return JsonMsg.success();
    }
    //新增
    @RequestMapping(value = "/addBill",method = RequestMethod.POST)
    @ResponseBody
    public JsonMsg addBill(Bill bill){
        int res=billService.addBill(bill);
        if(res==1){
            return JsonMsg.success();
        }else {
            return JsonMsg.fail();
        }
    }
    @RequestMapping(value = "/seclectBill/{bilId}",method = RequestMethod.POST)
    @ResponseBody
    public JsonMsg selectBill(@PathVariable("bilId") Integer bilId){
        Bill bill=billService.selectBillById(bilId);
        if(bilId!=null){
            return JsonMsg.success().addInfo("bil",bill);
        }
        else {
            return JsonMsg.fail();
        }
    }

    //id查询
    @RequestMapping(value = "/getBillById/{bilId}",method = RequestMethod.GET)
    @ResponseBody
    public  JsonMsg getBillById(@PathVariable("bilId")Integer bilId){
        Bill bill=billService.selectBillById(bilId);
        if(bilId!=null){
            return JsonMsg.success().addInfo("bil",bill);
        }
        else {
            return JsonMsg.fail();
        }
    }
    //商品列表
    @RequestMapping(value = "/goodsList",method = RequestMethod.GET)
    @ResponseBody
    public JsonMsg getGoodsName(){
        List<Goods> goodsList=goodsService.selectGoodsList();
        if(goodsList!=null){
            return JsonMsg.success().addInfo("goodsList",goodsList);
        }
        return JsonMsg.fail();
    }
    //订单详情
    @RequestMapping(value = "/billView/{bilId}",method = RequestMethod.GET)
    @ResponseBody
    public JsonMsg getBillview(@PathVariable("bilId") Integer bilId){
        Bill bill=billService.selectBillById(bilId);
        Double payment=billService.getPayment(bilId);
        if(bilId!=null){
            return JsonMsg.success().addInfo("bill",bill).addInfo("payment",payment);
        }
        return JsonMsg.fail();
    }
    //list查询
    @RequestMapping(value = "/getBillList",method = RequestMethod.GET)
    public ModelAndView getBill(@RequestParam(value="pageNo",defaultValue = "1")Integer pageNo){
        ModelAndView mv=new ModelAndView("billPage");
        int limit=5;
        int offset=(pageNo-1)*limit;
        List<Bill> bill=billService.selectBillByLimitAndOffset(offset,limit);
        int totalItems=billService.getBillCount();
        int temp=totalItems/limit;
        int totalPages=(totalItems %limit==0)?temp:temp+1;
        int curPage=pageNo;

        mv.addObject("bill",bill)
                .addObject("totalItems",totalItems)
                .addObject("totalPages",totalPages)
                .addObject("curPage",curPage);
        return mv;
    }

}
