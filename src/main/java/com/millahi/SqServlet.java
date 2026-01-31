package com.millahi;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SqServlet extends HttpServlet 
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// we can get the attribute which is passed from other servlet in request by using .getAttribute(nameOfKey) method
		int k = (int) req.getAttribute("k");
		PrintWriter out= resp.getWriter();
		out.println(k*k);
	}
}
