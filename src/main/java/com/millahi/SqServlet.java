package com.millahi;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class SqServlet extends HttpServlet 
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int k =0;
		// We can retrieve attributes passed from another servlet using request.getAttribute("key").
		//
		// When working within the same application, RequestDispatcher.forward() is preferred
		// because it forwards the request internally without changing the URL and
		// preserves the same request and response objects.
		//
		// If redirection is required, response.sendRedirect() is used.
		// It changes the URL and creates a new request, so request attributes are not preserved.
		// This is commonly used for external systems like payment gateways or CAPTCHA services.

//		 k = (int) req.getAttribute("k");
		PrintWriter out= resp.getWriter();
//		out.println("square of addition is "+k*k);
		
		//sendRedirect example
		//session management
//		HttpSession session = req.getSession();
//		 k = (int) session.getAttribute("k");
		
		//cookie 
		Cookie[] cookies = req.getCookies();
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("k")) {
				k= Integer.parseInt(cookie.getValue());
			}
		}
//		 k = Integer.parseInt(req.getParameter("k"));
		k=k*k;
		out.print("Result is " +k);
	}
}
