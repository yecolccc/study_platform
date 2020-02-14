package com.yecol.study.course.domain;

/**
 * @author wenber
 *
 */
public class Node {
	
	private int course_node_id;
	private String course_node_name;
	private String course_node_desc;
	private int course_node__state;
	private int course_node_count;
	private String course_node_word;
	private String course_node_src;
	private Course course;
	
	public Node() {
	}
	
	public int getCourse_node_id() {
		return course_node_id;
	}
	public void setCourse_node_id(int course_node_id) {
		this.course_node_id = course_node_id;
	}
	
	public String getCourse_node_name() {
		return course_node_name;
	}

	public void setCourse_node_name(String course_node_name) {
		this.course_node_name = course_node_name;
	}

	public String getCourse_node_desc() {
		return course_node_desc;
	}
	public void setCourse_node_desc(String course_node_desc) {
		this.course_node_desc = course_node_desc;
	}
	public int getCourse_node__state() {
		return course_node__state;
	}
	public void setCourse_node__state(int course_node__state) {
		this.course_node__state = course_node__state;
	}
	public int getCourse_node_count() {
		return course_node_count;
	}
	public void setCourse_node_count(int course_node_count) {
		this.course_node_count = course_node_count;
	}
	public String getCourse_node_word() {
		return course_node_word;
	}
	public void setCourse_node_word(String course_node_word) {
		this.course_node_word = course_node_word;
	}
	public String getCourse_node_src() {
		return course_node_src;
	}
	public void setCourse_node_src(String course_node_src) {
		this.course_node_src = course_node_src;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Node [course_node_id=" + course_node_id + ", course_node_name=" + course_node_name
				+ ", course_node_desc=" + course_node_desc + ", course_node__state=" + course_node__state
				+ ", course_node_count=" + course_node_count + ", course_node_word=" + course_node_word
				+ ", course_node_src=" + course_node_src + ", course=" + course + "]";
	}

}
