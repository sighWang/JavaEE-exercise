package com.tw.web;


import com.tw.core.Service;
import com.tw.core.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UserServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) {
        Service service = new Service();
        List<User> users = service.getUsers();
        req.setAttribute("users", users);
        try {
            req.getRequestDispatcher("test.jsp").forward(req, res);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
