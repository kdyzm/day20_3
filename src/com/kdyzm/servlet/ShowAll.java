package com.kdyzm.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kdyzm.utils.BaseServlet;

public class ShowAll extends BaseServlet {

	@Override
	public void defaultMethod(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ServletContext sc=getServletContext();
		Map<String,HttpSession>map=(Map<String, HttpSession>) sc.getAttribute("map");
		List<Map<String,String>>list=new ArrayList<Map<String,String>>();
		if(map!=null)
		{
			Set<Map.Entry<String, HttpSession>>set=map.entrySet();
			Iterator <Map.Entry<String, HttpSession>> it=set.iterator();
			while(it.hasNext())
			{
				Map.Entry<String, HttpSession>entry=it.next();
				Map<String,String>hashMap=new HashMap<String,String>();
				hashMap.put("name",entry.getValue().getAttribute("user").toString());
				hashMap.put("ip",entry.getValue().getAttribute("ip").toString());
				hashMap.put("createtime",new Date(entry.getValue().getCreationTime()).toString());
				hashMap.put("lastaccesstime",new Date(entry.getValue().getLastAccessedTime()).toString());
				list.add(hashMap);
			}
		}
		request.setAttribute("userlist", list);
		request.getRequestDispatcher("/showAll.jsp").forward(request, response);
	}

}
