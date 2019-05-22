package com.core.service.impl;

import com.common.utils.Page;
import com.core.dao.CustomerMapper;
import com.core.po.Customer;
import com.core.service.CustomerService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * FileName: CustomerServicelmpl
 * Author:   刘帅
 * Date:     2019-5-16 14:42
 */
//客户管理
@Service("customerService")
@Transactional
public class CustomerServicelmpl implements CustomerService{
    @Autowired
    private CustomerMapper customerMapper;
    //客户列表
    @Override
    public Page<Customer> findCustomerList(Integer page, Integer rows, String custName, String custSource, String custIndustry, String vustLevel) {
        //创建客户对象
        Customer customer=new Customer();
        //判断客户名字 判断某字符串是否不为空且长度不为0且不由空白符(whitespace)构成，等于!isBlank(String str)
        if (StringUtils.isNotBlank(custName)){
            customer.setCustName(custName);
        }
        //判读用户信息来源
        if (StringUtils.isNotBlank(custSource))
            customer.setCustSource(custSource);
        //判断所属行业
        if (StringUtils.isNotBlank(custIndustry))
            customer.setCustIndustry(custIndustry);
        //判断用户等级
        if (StringUtils.isNotBlank(vustLevel))
            customer.setVustLevel(vustLevel);
        //当前页
        customer.setStart((page-1)*rows);
        //每页数
        customer.setRows(rows);
        //查询客户列表
        List<Customer> customers=customerMapper.selectCustomerList(customer);
        //查询客户列表总记录数
        Integer count=customerMapper.selectCustomerListCount(customer);
        //创建page返回对象
        Page<Customer> result=new Page<>();
        result.setPage(page);
        result.setRows(customers);
        result.setSize(rows);
        result.setTotal(count);
        return result;
    }

    @Override
    public int createCustomer(Customer customer) {
        return customerMapper.createCustomer(customer);
    }

    @Override
    public Customer getCustomerById(Integer id) {
        Customer customer=customerMapper.getCustomerById(id);
        return null;
    }

    @Override
    public int updateCustomer(Customer customer) {
        return customerMapper.updateCustomer(customer);
    }

    @Override
    public int deleteCustomer(Integer id) {
        return customerMapper.deleteByPrimaryKey(id);
    }
}
