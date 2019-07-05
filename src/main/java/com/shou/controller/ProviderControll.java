package com.shou.controller;

import com.shou.bean.Provider;
import com.shou.service.AdminService;
import com.shou.service.ProviderService;
import com.shou.util.JsonMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "market/provider")
public class ProviderControll {
    @Autowired
    ProviderService providerService;
    @Autowired
    AdminService adminService;

    //删除
    @RequestMapping(value = "/delPro/{proId}",method = RequestMethod.DELETE)
    @ResponseBody
    public JsonMsg deletePro(@PathVariable("proId") Integer proId){
        int res=0;
        if(proId>0){
            res=providerService.deleteProById(proId);
        }
        if(res!=1){
            return JsonMsg.fail().addInfo("del_pro_error","删除异常");
        }
        return JsonMsg.success();
    }
    //修改
    @RequestMapping(value = "/updatePro/{proId}" ,method = RequestMethod.PUT)
    @ResponseBody
    public  JsonMsg updateProById(@PathVariable("proId")Integer proId, Provider provider){
        int res=0;
        if(proId>0){
            res=providerService.updateProById(proId,provider);
        }
        if(res!=1){
            return JsonMsg.fail().addInfo("update_pro_error","更新失败");
        }
        return JsonMsg.success();
    }
    //add
    @RequestMapping(value = "addPro",method = RequestMethod.PUT)
    @ResponseBody
    public JsonMsg addPro(Provider provider){
        int res=providerService.addPro(provider);
        if(res!=1){
            return JsonMsg.fail().addInfo("add_pro_error","新增失败");
        }
        return JsonMsg.success();
    }

    //列表页码数
    @RequestMapping(value = "/getTotalPages",method = RequestMethod.GET)
    @ResponseBody
    public JsonMsg getTotalPages(){
        int limit=3;
        int totalItems=providerService.getProCount();
        int temp=totalItems/limit;
        int totoPages=(totalItems % limit ==0)?temp:temp+1;
        return JsonMsg.success().addInfo("totoalPages",totoPages);
    }
    @RequestMapping(value = "/getProById/{proId}",method = RequestMethod.GET)
    @ResponseBody
    public JsonMsg getProById(@PathVariable("proId") Integer proId){
        Provider provider=null;
        if(proId>0){
            provider=providerService.getProById(proId);
        }
        if(provider!=null){
            return JsonMsg.success().addInfo("provider",provider);
        }
        return JsonMsg.fail().addInfo("get_pro_erro","无供应商信息");
    }
    //分页查询
    @RequestMapping(value = "/getProList",method = RequestMethod.GET)
    public ModelAndView getProList(@RequestParam(value = "pageNo",defaultValue = "1")Integer pageNo){
        ModelAndView mv=new ModelAndView("providerPage");
        //每页记录的行数
        int limit=5;
        //记录总数
        int totalItems=providerService.getProCount();
        int temp=totalItems/limit;
        int totalPages=(totalItems%limit==0)?temp:temp+1;

        int offset=(pageNo-1)*limit;
        List<Provider> providers=providerService.getProList(offset,limit);
        mv.addObject("provider",providers)
                .addObject("totalItems",totalItems)
                .addObject("totalPages",totalPages)
                .addObject("curPageNo",pageNo);
        return mv;
    }
    //查询所有供应商名称
    @RequestMapping(value = "/getProName",method=RequestMethod.GET)
    @ResponseBody
    public JsonMsg getProName(){
        List<Provider> providerList=providerService.getProName();
        if(providerList!=null){
            return JsonMsg.success().addInfo("providerList",providerList);
        }
        return JsonMsg.fail();
    }
    @RequestMapping(value = "/getProByName/{proName}",method = RequestMethod.GET)
    @ResponseBody
    public JsonMsg getProByName(@PathVariable("proName") String proName){
        Provider provider=providerService.getProByName(proName);
        if(provider!=null){
            return JsonMsg.success().addInfo("provider",provider);
        }
        return JsonMsg.fail().addInfo("get_pro_erro","无供应商信息");
    }
}
