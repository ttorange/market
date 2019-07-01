package com.shou.mapper;

import com.shou.bean.Provider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProviderMapper {
    String TABLE_NAME="provider";
    String INSERT_FIELDS="proName,proContacts,proPhone";
    String SELECT_FIELDS="proId,proName,proContacts,proPhone";

    /**
     * =================================删除============================================
     */
    @Delete({"DELETE FROM", TABLE_NAME, "WHERE proId=#{proId}"})
    int deleteProById(@Param("proId") Integer proId);

    /**
     * =================================更改============================================
     */

    int updateProById(@Param("proId") Integer proId,
                      @Param("provider")Provider provider);

    /**
     * =================================新增============================================
     */
    @Insert({"INSERT INTO",TABLE_NAME, "(", INSERT_FIELDS ,") " +
            "VALUES(#{provider.proName}, #{provider.proContacts},#{provider.proPhone})" })
    int insertPro(@Param("provider") Provider provider);
    /**
     * =================================查询============================================
     */
    @Select({"SELECT", SELECT_FIELDS, "FROM", TABLE_NAME, "WHERE proId=#{proId}" })
    Provider selectPorById(@Param("proId") Integer deptId);
    @Select({"SELECT", SELECT_FIELDS, "FROM", TABLE_NAME, "WHERE proName=#{proName}" })
    Provider selectProByName(@Param("proName") String proName);
    @Select({"SELECT", SELECT_FIELDS, "FROM", TABLE_NAME})
    List<Provider> selectProList();

    List<Provider> selectProByLimitAndOffset(@Param("offset") Integer offset,
                                             @Param("limit")Integer limit);
    @Select({"SELECT COUNT(*) FROM", TABLE_NAME})
    int getCount();

}
