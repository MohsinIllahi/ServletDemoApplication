package com.millahi;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

//@WebServlet("/add")
public class AddServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int i = Integer.parseInt(req.getParameter("num1"));
		int j = Integer.parseInt(req.getParameter("num2"));
		
		int k = i + j;
		
		//session management can also be used to pass parameter to a servlet
//		HttpSession session = req.getSession();
//		session.setAttribute("k", k);
		
		//
		Cookie cookie = new Cookie("k", k+"");
		res.addCookie(cookie);
		
		PrintWriter out = res.getWriter();
		
//		out.println("result is " + k);
		// we can send data from one servlet to another by using setAttribute where there will be key and vaue like a map 
//		req.setAttribute("k", k);
//		RequestDispatcher rDispatcher = req.getRequestDispatcher("sq");
//		rDispatcher.forward(req, res);
		
		//sendRedirect example
		res.sendRedirect("sq");
	}
}
