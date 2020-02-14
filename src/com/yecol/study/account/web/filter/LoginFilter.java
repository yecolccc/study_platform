package com.yecol.study.account.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.yecol.study.account.domain.Account;
import com.yecol.study.course.domain.ResultInfo;
import com.yecol.study.util.JWT;

/**
 * 拦截未登录的用户
 * jwt能够解开就能登进去 不能解开发送失败的json
 */
@WebFilter("/*")
public class LoginFilter implements Filter {
	
	Logger logger = Logger.getLogger(LoginFilter.class);

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		//获取请求的uri(uri不会带请求的参数)
		String uri = req.getRequestURI();
//		System.out.println(uri.endsWith("Admin"));
		if(uri.endsWith("login") || uri.endsWith("Admin")) {
			chain.doFilter(request, response);
			return;
		}
		//获取传来的token
		String token = req.getParameter("token");
		if(JWT.unsign(token, Account.class) == null) {
			String json = ResultInfo.fail("用户尚未登录", 2).toJson();
			response.setContentType("application/json;charset=utf-8");
			try {
				response.getWriter().write(json);
			} catch (IOException e) {
				logger.error("发送json数据错误:" + e.getMessage());
			}
		} else {
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
