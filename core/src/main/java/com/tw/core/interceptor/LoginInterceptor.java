package com.tw.core.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by xim on 7/15/15.
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handle) {
//        if (request.getServletPath().startsWith("/login")) {
//            return true;
//        }
//
//        if (request.getSession().getAttribute("loginUser") != null) {
//            return true;
//        }
//        try {
//            String previousPage = request.getQueryString();
//            if(previousPage.equals("")) {
//                previousPage = request.getServletPath() + "?" + previousPage;
//            }else {
//                previousPage = request.getServletPath();
//            }
//            System.out.println(request.getQueryString());
//            Cookie cookie = new Cookie("previousPage", previousPage);
//            response.addCookie(cookie);
//            response.sendRedirect(request.getContextPath() + "/login");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return false;
//    }
}
