package com.yecol.study.course.web.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * 所有servlet的父类 利用反射执行方法
 * @author yecol
 *
 */
public class BaseServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	static Logger logger = Logger.getLogger(BaseServlet.class);
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取请求的uri
		String uri = request.getRequestURI();
		//获取方法名
		String methodName = uri.substring(uri.lastIndexOf("/") + 1);
		try {
			//根据类的类类型通过方法名和参数类型的方法，来找到我们具体要执行的方法
			Method method = this.getClass().getMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			method.invoke(this, request, response);
		} catch (Exception e) {
			logger.error("执行的方法未找到:" + e.getMessage());
		} 
	}
	
	protected void sendJson(String json,HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("application/json;charset=utf-8");
		try {
			response.getWriter().write(json);
		} catch (IOException e) {
			logger.error("发送json数据错误:" + e.getMessage());
		}
	}

}
