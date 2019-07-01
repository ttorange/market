package com.shou.service;

import com.shou.bean.Provider;
import com.shou.mapper.ProviderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderService {
    @Autowired
    ProviderMapper providerMapper;

    public int deleteProById(Integer proId){
        return providerMapper.deleteProById(proId);
    }
    public int updateProById(Integer proId, Provider provider){
        return providerMapper.updateProById(proId,provider);
    }
    public int addPro(Provider provider){
        return providerMapper.insertPro(provider);
    }

    public List<Provider> getProList(Integer offset,Integer limit){
        return providerMapper.selectProByLimitAndOffset(offset,limit);
    }
    public List<Provider> getProList(){
        return providerMapper.selectProList();
    }
    public Provider getProById(Integer proId){
        return providerMapper.selectPorById(proId);
    }
    public Provider getProByName(String proName){
        return providerMapper.selectProByName(proName);
    }
    public List<Provider> getProName(){
        return providerMapper.selectProList();
    }
    public int getProCount(){
        return providerMapper.getCount();
    }

}
