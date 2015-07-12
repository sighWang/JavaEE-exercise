package com.tw.web;

import com.tw.core.Service;
import com.tw.core.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by xim on 7/12/15.
 */
public class UserUpdateServlet extends HttpServlet {

    private Service service = new Service();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) {
        String id = req.getParameter("userId");
        User user = service.getUser(Integer.parseInt(id));

        req.setAttribute("user", user);
        try {
            req.getRequestDispatcher("update.jsp").forward(req, res);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String sex = req.getParameter("sex");
        String email = req.getParameter("email");
        String age = req.getParameter("age");
        System.out.println(id + name + sex + email + age);
        int result = service.updateUser(new User(Integer.parseInt(id), name, sex, email, Integer.parseInt(age)));
        if (result > 0) {
            try {
                res.sendRedirect("/web/");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
