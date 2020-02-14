package com.yecol.study.course.dao;

import java.util.List;

import com.yecol.study.course.domain.Course;
import com.yecol.study.course.domain.CourseContent;
import com.yecol.study.course.domain.Node;

public interface CourseDao {

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
	List<CourseContent> findContent(int cnid);
	
	CourseContent findContentById(int list_id);
	
}
