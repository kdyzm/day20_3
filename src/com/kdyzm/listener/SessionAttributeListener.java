package com.kdyzm.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class SessionAttributeListener implements HttpSessionAttributeListener {

	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		String attributename=event.getName();
		if(attributename.equals("user"))
		{
			System.out.println(event.getName()+"新属性被添加！"+event.getValue());
			String attributevalue=event.getValue().toString();
			ServletContext sc=event.getSession().getServletContext();
			Map<String,HttpSession>map=(Map<String, HttpSession>) sc.getAttribute("map");
			if(map==null)
			{
				map=new HashMap<String,HttpSession>();
				sc.setAttribute("map", map);
			}
			map.put(attributevalue, event.getSession());
		}
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		String name=event.getName();
		System.out.println("有属性被移除！"+name+":"+event.getValue());
		if(name.equals("user"))
		{
			ServletContext sc=event.getSession().getServletContext();
			String value=event.getValue().toString();
			Map<String,HttpSession> map=(Map<String, HttpSession>) sc.getAttribute("map");
			map.remove(value);
		}
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
	}
	
}
