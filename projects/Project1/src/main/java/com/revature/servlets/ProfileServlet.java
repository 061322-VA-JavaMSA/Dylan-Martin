package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;
import com.revature.services.UserService;
import com.revature.util.CorsFix;

public class ProfileServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private UserService us = new UserService();
	private ObjectMapper om = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        CorsFix.addCorsHeader(req.getRequestURI(), res);
        res.addHeader("Content-Type", "application/json");

        String pathInfo = req.getPathInfo();

        HttpSession session = req.getSession();

        if (pathInfo == null) {
            User user = (User) session.getAttribute("user");
            res.getWriter().write(om.writeValueAsString(user));
        } else {
            int id = Integer.parseInt(pathInfo.substring(1));
            User user = null;
			try {
				user = us.getUserById(id);
			} catch (UserNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            res.getWriter().write(om.writeValueAsString(user));
        }
    }
}
