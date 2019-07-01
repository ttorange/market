package com.shou.test;

import com.shou.bean.Provider;
import com.shou.mapper.ProviderMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath:springmvc.xml"})
public class ProviderMapperTest {
    @Autowired
    private ProviderMapper providerMapper;

    @Test
    public void deleteProtTest(){
        int res = providerMapper.deleteProById(2);
        System.out.println(res);
    }

    @Test
    public void selbyIDtTest(){
        Provider provider=providerMapper.selectPorById(3);
        System.out.println(provider);
    }
    @Test
    public void selbyname(){
        Provider provider=providerMapper.selectProByName("Apple");
        System.out.println(provider);
    }
    @Test
    public void getList(){
        List<Provider> a=providerMapper.selectProList();
        for(Provider index:a){
            System.out.println(index);
        }
    }
    @Test
    public void getLimitList(){
        List<Provider> a=providerMapper.selectProByLimitAndOffset(2,3);
        System.out.println(a.size());
        for(Provider p:a){
            System.out.println(p);
        }
    }
    @Test
    public void updateTest(){
        Provider provider=new Provider(null,"Tesla","Ellon","548484");
        int res=providerMapper.updateProById(3,provider);
        System.out.println(res);
    }

        @Test
    public void insertTest(){
        Provider provider=new Provider(null,"Pessi","Trump","18221669666");
        System.out.println(provider);
        int res=providerMapper.insertPro(provider);
    }
    @Test
    public void countTest(){
        int res=providerMapper.getCount();
        System.out.println(res);
    }



}
