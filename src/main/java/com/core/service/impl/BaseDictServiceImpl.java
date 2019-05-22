package com.core.service.impl;

import com.core.dao.BaseDictMapper;
import com.core.po.BaseDict;
import com.core.service.BaseDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * FileName: BaseDictServiceImpl
 * Author:   刘帅
 * Date:     2019-5-16 14:38
 */
//数据字典service接口的实现类
@Service("baseDictService")
public class BaseDictServiceImpl implements BaseDictService {
    @Autowired
    private BaseDictMapper baseDictMapper;
    @Override
    public List<BaseDict> findBaseDictByTypeCode(String typecode) {
        return baseDictMapper.selectBaseDictByTypeCode(typecode);
    }
}
