package com.core.dao;

import com.core.po.BaseDict;

import java.util.List;

public interface BaseDictMapper {
    int deleteByPrimaryKey(String dictId);

    int insert(BaseDict record);

    int insertSelective(BaseDict record);

    BaseDict selectByPrimaryKey(String dictId);

    int updateByPrimaryKeySelective(BaseDict record);

    int updateByPrimaryKey(BaseDict record);
    //根据类别代码查询数据字典
    List<BaseDict> selectBaseDictByTypeCode(String typecode);

}