package com.example.MVC.Servlet;

import com.example.MVC.Bean.School;
import com.example.MVC.Bean.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/user")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        School school = new School("No.1 Middle School", "101 South Street");
        User user = new User("123456", "Bob", school);

        req.setAttribute("user", user);

        req.getRequestDispatcher("/WEB-INF/user.jsp").forward(req, resp);
    }
}
