package com.kdyzm.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest) req;
		HttpServletResponse respose=(HttpServletResponse) resp;
		if(request.getSession().getAttribute("user")==null)
		{
			System.out.println("用户还没有登录！");
			respose.sendRedirect(request.getContextPath()+"/index.jsp");
		}
		else
		{
			chain.doFilter(request, resp);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
