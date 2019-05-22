package com.core.web.controller;

import com.core.po.Customer;
import com.core.po.User;
import com.core.service.CustomerService;
import com.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.Date;

/**
 * FileName: UserController
 * Author:   刘帅
 * Date:     2019-5-15 18:16
 */
//用户控制类
@Controller
public class UserController {
    //依赖注入
    @Autowired
    private UserService userService;
    @Autowired
    private CustomerService customerService;
    //用户登录
    @PostMapping(value = "/long.action")
    public String login(String user_code,String password, Model model, HttpSession session){
        //通过账户和密码查询用户
        User user=userService.findUser(user_code,password);
        if (user!=null){
            //将用户对象添加到Session
            session.setAttribute("SUSER_SESSION",user);
            //跳转到主页面
            return "customer";
        }
        //返回到登录页面
        return "Loge";
    }
    @RequestMapping(value = "/toCustomer.action")
    public String toCustomer(){
        return "customer";
    }

    @RequestMapping(value = "/logout.action")
    public String logout(HttpSession session){
        //清除session
        session.invalidate();
        //重定向到登录页面的跳转方法
        return "redirect:login.action";
    }
    @RequestMapping(value = "/login.action",method = RequestMethod.GET)
    public String toLogin(){
        return "Loge";
    }

    @RequestMapping(value = "/customer/create.action")
    @ResponseBody
    public String customerCreaate(Customer customer, HttpSession session){
        //获取session中的当前用户信息
        User user=(User) session.getAttribute("USER_SESSION");
        //将当前用户id存储到客户对象中
        customer.setCustCreateId(user.getUserId());
        //创建date对象
        Date date=new Date();
        //得到Timestamp格式的时间，存入mysql中的时间格式是“yyyy/MM/dd HH:mm:ss”
        Timestamp timestamp=new Timestamp(date.getTime());
        customer.setCust_createtime(timestamp);
        //执行service层中的创造方法，返回的是受影响的行数
        int rows=customerService.createCustomer(customer);
        if (rows>0)
            return "OK";
        else
            return "FALL";
    }
}
