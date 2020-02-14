package com.yecol.study.account.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yecol.study.account.domain.Account;
import com.yecol.study.account.service.AccountService;
import com.yecol.study.account.service.impl.AccountServiceImpl;
import com.yecol.study.course.domain.ResultInfo;
import com.yecol.study.course.web.servlet.BaseServlet;
import com.yecol.study.util.JWT;

/**
 * 账户的servlet
 * @author yecol
 *
 */
@WebServlet("/account/*")
public class AccountServlet extends BaseServlet {
	
	private static final long serialVersionUID = 1L;
	
	private AccountService accountService = new AccountServiceImpl();
	
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取请求参数
		String username = request.getParameter("acc_name");
		String password = request.getParameter("acc_pwd");
		Account account = accountService.findByNameAndPwd(username, password);
		if(account != null) {
			String token = JWT.sign(account, 1*24*3600*1000);
			account.setToken(token);
			String json = ResultInfo.success(account).toJson();
			sendJson(json, request, response);
		} else {
			String json = ResultInfo.fail("账号或密码错误").toJson();
			sendJson(json, request, response);
		}
	}

}
