package com.yecol.study.course.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yecol.study.course.domain.Course;
import com.yecol.study.course.domain.CourseContent;
import com.yecol.study.course.domain.Node;
import com.yecol.study.course.domain.ResultInfo;
import com.yecol.study.course.service.CourseService;
import com.yecol.study.course.service.impl.CourseServiceImpl;

@WebServlet("/course/*")
public class CourseServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;
	
	private CourseService service = new CourseServiceImpl();
	
	/**
	 * 查询所有课程
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Course> courses = service.findAll();
		if(courses != null) {
			String json = ResultInfo.success(courses).toJson();
			sendJson(json, request, response);
		}
	}
	
	public void findAllNode(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cid = request.getParameter("cid");
		List<Node> nodes = service.findAllNode(Integer.parseInt(cid));
		if(nodes != null) {
			String json = ResultInfo.success(nodes).toJson();
			sendJson(json, request, response);
		}
	}
	
	public void findContent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cnid = request.getParameter("cnid");
		List<CourseContent> contents = service.findContent(Integer.parseInt(cnid));
		if(contents != null) {
			String json = ResultInfo.success(contents).toJson();
			sendJson(json, request, response);
		} else {
			String json = ResultInfo.fail().toJson();
			sendJson(json, request, response);
		}
	}
	
	public void findContentById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String list_id = request.getParameter("list_id");
		CourseContent content = service.findContentById(Integer.parseInt(list_id));
		if(content != null) {
			String json = ResultInfo.success(content).toJson();
			sendJson(json, request, response);
		} else {
			String json = ResultInfo.fail().toJson();
			sendJson(json, request, response);
		}
	}
	
}
