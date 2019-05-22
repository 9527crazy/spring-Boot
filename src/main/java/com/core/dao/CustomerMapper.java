package com.core.dao;

import com.core.po.Customer;

import java.util.List;

public interface CustomerMapper {
    int deleteByPrimaryKey(Integer custId);

    int insertSelective(Customer record);

    Customer selectByPrimaryKey(Integer custId);

    int updateByPrimaryKey(Customer record);
    //客户列表
    List<Customer> selectCustomerList(Customer customer);
    //客户数
    Integer selectCustomerListCount(Customer customer);

    int createCustomer(Customer customer);

    Customer getCustomerById(Integer id);

    int updateCustomer(Customer customer);
}