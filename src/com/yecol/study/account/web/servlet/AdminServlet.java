package com.yecol.study.account.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.yecol.study.account.domain.Admin;
import com.yecol.study.account.service.AdminService;
import com.yecol.study.account.service.impl.AdminServiceImpl;
import com.yecol.study.course.domain.ResultInfo;
import com.yecol.study.course.web.servlet.BaseServlet;
import com.yecol.study.util.JWT;

@WebServlet("/admin/*")
public class AdminServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;

	private AdminService adminService = new AdminServiceImpl();
	
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取请求参数
		String username = request.getParameter("admin_name");
		String password = request.getParameter("admin_pwd");
		Admin admin = adminService.findByNameAndPwd(username, password);
		if(admin != null) {
			String token = JWT.sign(admin, 1*24*3600*1000);
			admin.setToken(token);
			String json = ResultInfo.success(admin).toJson();
			sendJson(json, request, response);
		} else {
			String json = ResultInfo.fail("账号或密码错误").toJson();
			sendJson(json, request, response);
		}
	}
	
	public void findAllAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Admin> admins = adminService.findAll();
		String json = ResultInfo.success(admins).toJson();
		sendJson(json, request, response);
		
	}
	
	public void updateAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String admin_state = request.getParameter("admin_state");
		adminService.updateState(Integer.parseInt(id), Integer.parseInt(admin_state));
	}
	
	public void insertAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Map<String, String[]> map = request.getParameterMap();
		String name = request.getParameter("admin_name");
		String state = request.getParameter("admin_state");
		String role = request.getParameter("admin_role");
		Admin admin = new Admin(name,Integer.parseInt(state),role);
		System.out.println(admin);
		
		/*try {
			BeanUtils.populate(admin, map);
		} catch (IllegalAccessException | InvocationTargetException e) {
			Logger logger = Logger.getLogger(AdminServlet.class);
			logger.error("利用BeanUtils封装数据产生异常:" + e.getMessage());
		}*/
		boolean result = adminService.insertAdmin(admin);
		if(result) {
			String json = ResultInfo.success().toJson();
			sendJson(json, request, response);
		} else {
			String json = ResultInfo.fail("添加管理员失败").toJson();
			sendJson(json, request, response);
		}
	}
	
	public void findByIdAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String admin_id = request.getParameter("admin_id");
		Admin admin = adminService.findById(Integer.parseInt(admin_id));
		String json = ResultInfo.success(admin).toJson();
		sendJson(json, request, response);
	}
	
	public void updateAllAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String[]> map = request.getParameterMap();
		Admin admin = new Admin();
		try {
			BeanUtils.populate(admin, map);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println(admin);
		adminService.updateAdmin(admin);
		
	}
	
}
