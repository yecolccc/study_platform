package com.yecol.study.course.service;

import java.util.List;

import com.yecol.study.course.domain.Course;
import com.yecol.study.course.domain.CourseContent;
import com.yecol.study.course.domain.Node;

public interface CourseService {
	
	/**
	 * 查询所有课程
	 * @return
	 */
	List<Course> findAll();
	
	List<Node> findAllNode(int cid);
	
	/**
	 * 根据章节节点id查询具体的章节内容
	 * @param cnid
	 * @return
	 */
	public List<CourseContent> findContent(int cnid);
	
	public CourseContent findContentById(int list_id);

}
