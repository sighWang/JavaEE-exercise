package com.tw.web;

import com.tw.core.UserService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserDeleteServlet extends HttpServlet {

//    @Override
//    public void doGet(HttpServletRequest req, HttpServletResponse res) {
//        UserService service = new UserService();
//        String id = req.getParameter("userId");
//        System.out.println(id);
//        int result = service.deleteUser(Integer.parseInt(id));
//        if (result > 0) {
//            try {
//                res.sendRedirect("/web/");
////                req.getRequestDispatcher("test.jsp").forward(req, res);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    public void doPost(HttpServletRequest req, HttpServletResponse res) {
//        doGet(req, res);
//    }
}
