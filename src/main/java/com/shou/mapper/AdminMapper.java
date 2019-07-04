package com.shou.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface AdminMapper {
    @Select("select pwd from admin where adminName=#{adminName}")
    String getPwd(@Param("adminName")String adminName);
    @Select("select adminRole from admin where adminName=#{adminName}")
    int getRole(@Param("adminName")String adminName);

}
