package com.tw.web;

import javax.servlet.http.HttpServlet;

/**
 * Created by xim on 7/12/15.
 */
public class UserAddServlet extends HttpServlet {
//    private UserService service = new UserService();
//
//    @Override
//    public void doGet(HttpServletRequest req, HttpServletResponse res) {
//        String id = req.getParameter("userId");
//        User user = service.getUser(Integer.parseInt(id));
//
//        req.setAttribute("user", user);
//        try {
//            req.getRequestDispatcher("userUpdate.jsp").forward(req, res);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void doPost(HttpServletRequest req, HttpServletResponse res) {
//        String name = req.getParameter("name");
//        String sex = req.getParameter("sex");
//        String email = req.getParameter("email");
//        String age = req.getParameter("age");
//        System.out.println(name + sex + email + age);
//        service.addUser(new User(name, sex, email, Integer.parseInt(age)));
//        try {
//            res.sendRedirect("/web/");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
