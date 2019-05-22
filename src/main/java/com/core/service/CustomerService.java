package com.core.service;

import com.common.utils.Page;
import com.core.po.Customer;

/**
 * FileName: CustomerService
 * Author:   刘帅
 * Date:     2019-5-16 14:35
 */
public interface CustomerService {
    //查询用户列表
    Page<Customer> findCustomerList(Integer page,Integer rows,String custName,String custSource,String custIndustry,String vustLevel);

    int createCustomer(Customer customer);

    Customer getCustomerById(Integer id);

    int updateCustomer(Customer customer);

    int deleteCustomer(Integer id);
}
