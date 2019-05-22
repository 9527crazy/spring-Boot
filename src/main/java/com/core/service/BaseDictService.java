package com.core.service;

import com.core.po.BaseDict;

import java.util.List;

/**
 * FileName: BaseDictService
 * Author:   刘帅
 * Date:     2019-5-16 14:32
 */
public interface BaseDictService {
    //根据类别代码查询数据字典
    List<BaseDict> findBaseDictByTypeCode(String typecode);
}
