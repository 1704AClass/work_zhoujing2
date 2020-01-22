package com.zuoye.mapper;

import com.zuoye.pojo.TSetmeal;
import com.zuoye.pojo.TSetmealExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface TSetmealMapper {
    int countByExample(TSetmealExample example);

    int deleteByExample(TSetmealExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TSetmeal record);

    int insertSelective(TSetmeal record);

    List<TSetmeal> selectByExample(TSetmealExample example);

    TSetmeal selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TSetmeal record, @Param("example") TSetmealExample example);

    int updateByExample(@Param("record") TSetmeal record, @Param("example") TSetmealExample example);

    int updateByPrimaryKeySelective(TSetmeal record);

    int updateByPrimaryKey(TSetmeal record);

    @Select("select * from t_setmeal where id=#{id}")
	TSetmeal findById(@Param("id")int id);
}