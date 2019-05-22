package com.core.interceptor;

import com.core.po.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * FileName: LoginInterceptor
 * Author:   刘帅
 * Date:     2019-5-15 20:39
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //获取请求的URL
        String url=httpServletRequest.getRequestURI();
        //URL：除了登录请求外，其他URL都进行URL拦截控制
        if (url.indexOf("/long.action")>=0){
            return true;
        }
        //获取session
        HttpSession httpSession=httpServletRequest.getSession();
        User user=(User) httpSession.getAttribute("USER_SESSION");
        //判断session中是否有用户数据
        if (user!=null){
            return true;
        }
        httpServletRequest.setAttribute("msg","没登录");
        httpServletRequest.getRequestDispatcher("/WEB-INF/jsp/Loge.jsp").forward(httpServletRequest,httpServletResponse);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
