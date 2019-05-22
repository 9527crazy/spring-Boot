package com.core.web.controller;

import com.common.utils.Page;
import com.core.po.BaseDict;
import com.core.po.Customer;
import com.core.service.BaseDictService;
import com.core.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * FileName: CustomerController
 * Author:   刘帅
 * Date:     2019-5-16 15:08
 */
//客户管理控制器类
@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private BaseDictService baseDictService;
    //客户来源
    @Value("${customer.form.type}")
    private String FROM_TYPE;
    //客户所属行业
    @Value("${customer.industry.type}")
    private String INDUSTRY_TYPE;
    //客户等级
    @Value("${customer.level.type}")
    private String LEVEL_TYPE;
    //客户列表
    @RequestMapping(value = "/customer/list.action")
    public String list(@RequestParam(defaultValue = "1")Integer page, @RequestParam(defaultValue = "10")Integer rows, String custName, String custSource, String custIndustry, String vustLevel, Model model){
        //条件查询说有用户
        Page<Customer> customers=customerService.findCustomerList(page,rows,custName,custSource,custIndustry,vustLevel);
        model.addAttribute("page",customers);
        //客户来源
        List<BaseDict> fromType=baseDictService.findBaseDictByTypeCode(FROM_TYPE);
        //客户所属行业
        List<BaseDict> industrType=baseDictService.findBaseDictByTypeCode(LEVEL_TYPE);
        //客户等级
        List<BaseDict> levelType=baseDictService.findBaseDictByTypeCode(LEVEL_TYPE);
        //添加参数
        model.addAttribute("fromType",fromType);
        model.addAttribute("industryType",industrType);
        model.addAttribute("levelType",levelType);
        model.addAttribute("custName",custName);
        model.addAttribute("custSource",custSource);
        model.addAttribute("custIndustry",custIndustry);
        model.addAttribute("vustLevel",vustLevel);
        return "custom";
    }
    //通过Id获取客户信息
    @ResponseBody
    @RequestMapping(value = "/customer/getCustomerById.action")
    public Customer getCustomerById(Integer id){
        Customer customer=customerService.getCustomerById(id);
        return customer;
    }
    //更新客户
    @RequestMapping(value = "/customer/update.action")
    @ResponseBody
    public String customerUpdate(Customer customer){
        int rows=customerService.updateCustomer(customer);
        if (rows>0)
            return "OK";
        else
            return "FALL";
    }
    //删除客户
    @ResponseBody
    @RequestMapping(value = "/customer/delete.action")
    public String customerDelete(Integer id){
        int rows=customerService.deleteCustomer(id);
        if (rows>0)
            return "OK";
        else
            return "FALL";
    }

















}
