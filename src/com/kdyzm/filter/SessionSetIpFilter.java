package com.kdyzm.filter;
//拦截请求并从请求信息中获取ip信息将信息保存到session中
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionSetIpFilter implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest) req;
		if(request.getSession().getAttribute("ip")==null)
		{
			String ip=request.getRemoteAddr();
			System.out.println("有新用户访问！ip="+ip);
			HttpSession session=request.getSession();
			session.setAttribute("ip", ip);
		}
		chain.doFilter(request, response);
	}
	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
