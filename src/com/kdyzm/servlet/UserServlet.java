package com.kdyzm.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kdyzm.utils.BaseServlet;

public class UserServlet extends BaseServlet {
	//默认是登陆
	@Override
	public void defaultMethod(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		//暂时不验证
		HttpSession session=request.getSession();
		session.setAttribute("user", name);
		response.sendRedirect(request.getContextPath()+"/index.jsp");
	}
	public void remove(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		String name=request.getParameter("name");
		name=new String(name.getBytes("iso-8859-1"),"utf-8");
		ServletContext sc=getServletContext();
		Map<String,HttpSession>map=(Map<String, HttpSession>) sc.getAttribute("map");
		HttpSession session=map.get(name);
		session.removeAttribute("user");
		response.sendRedirect(request.getContextPath()+"/showAll");
	}
}
