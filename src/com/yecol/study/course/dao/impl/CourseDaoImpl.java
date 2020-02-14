package com.yecol.study.course.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.log4j.Logger;

import com.yecol.study.course.dao.CourseDao;
import com.yecol.study.course.domain.Course;
import com.yecol.study.course.domain.CourseContent;
import com.yecol.study.course.domain.Node;
import com.yecol.study.util.C3P0Uitls;

public class CourseDaoImpl implements CourseDao {

	//创建qr
	private QueryRunner qr = new QueryRunner(C3P0Uitls.getDataSource());
	
	static Logger logger = Logger.getLogger(CourseDaoImpl.class);
	
	@Override
	public List<Course> findAll() {
		String sql = "select * from tb_course";
		try {
			return qr.query(sql, new BeanListHandler<Course>(Course.class));
		} catch (SQLException e) {
			logger.error("查询所有课程发生了异常：" + e.getMessage());
			return null;
		}
	}

	@Override
	public List<Node> findAllNode(int cid) {
		String sql = "select * from tb_course_node where course_id = ?";
		try {
			return qr.query(sql, new BeanListHandler<Node>(Node.class),cid);
		} catch (SQLException e) {
			logger.error("查询所有节点发生了异常：" + e.getMessage());
			return null;
		}
	}
	
	/**
	 * 根据章节节点id查询具体的章节内容
	 * @param cnid
	 * @return
	 */
	public List<CourseContent> findContent(int cnid) {
		String sql = "select * from tb_course_list where course_node_id = ?";
		try {
			return qr.query(sql, new BeanListHandler<CourseContent>(CourseContent.class),cnid);
		} catch (SQLException e) {
			logger.error("查询所有节点内容发生了异常：" + e.getMessage());
			return null;
		}
	}

	/**
	 * 根据list_id查询内容
	 */
	@Override
	public CourseContent findContentById(int list_id) {
		String sql = "SELECT * FROM tb_course_list WHERE list_id = ?";
		try {
			return qr.query(sql, new BeanHandler<CourseContent>(CourseContent.class),list_id);
		} catch (SQLException e) {
			logger.error("查询单个节点内容发生了异常：" + e.getMessage());
			return null;
		}
	}

}
