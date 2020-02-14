package com.yecol.study.course.service.impl;

import java.util.List;


import com.yecol.study.course.dao.CourseDao;
import com.yecol.study.course.dao.impl.CourseDaoImpl;
import com.yecol.study.course.domain.Course;
import com.yecol.study.course.domain.CourseContent;
import com.yecol.study.course.domain.Node;
import com.yecol.study.course.service.CourseService;

/**
 * 课程业务层
 * @author yecol
 *
 */
public class CourseServiceImpl implements CourseService {

	private CourseDao courseDao = new CourseDaoImpl();
	
	/**
	 * 查询所有课程
	 */
	@Override
	public List<Course> findAll() {
		return courseDao.findAll();
	}

	@Override
	public List<Node> findAllNode(int cid) {
		return courseDao.findAllNode(cid);
	}
	
	/**
	 * 根据章节节点id查询具体的章节内容
	 * @param cnid
	 * @return
	 */
	public List<CourseContent> findContent(int cnid) {
		return courseDao.findContent(cnid);
	}

	@Override
	public CourseContent findContentById(int list_id) {
		return courseDao.findContentById(list_id);
	}
	
}
