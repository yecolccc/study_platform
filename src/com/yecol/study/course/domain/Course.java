package com.yecol.study.course.domain;

/**
 *	课程实体类
 */
public class Course {
	
	private int course_id;
	private String course_name;
	private String course_desc;
	private String course_image;
	private int course_state;
	//排放的顺序
	private int course_index;
	
	public Course() {
	}

	public Course(int course_id, String course_name, String course_desc, String course_image, int course_state,
			int course_index) {
		super();
		this.course_id = course_id;
		this.course_name = course_name;
		this.course_desc = course_desc;
		this.course_image = course_image;
		this.course_state = course_state;
		this.course_index = course_index;
	}

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public String getCourse_desc() {
		return course_desc;
	}

	public void setCourse_desc(String course_desc) {
		this.course_desc = course_desc;
	}

	public String getCourse_image() {
		return course_image;
	}

	public void setCourse_image(String course_image) {
		this.course_image = course_image;
	}

	public int getCourse_state() {
		return course_state;
	}

	public void setCourse_state(int course_state) {
		this.course_state = course_state;
	}

	public int getCourse_index() {
		return course_index;
	}

	public void setCourse_index(int course_index) {
		this.course_index = course_index;
	}

	@Override
	public String toString() {
		return "Course [course_id=" + course_id + ", course_name=" + course_name + ", course_desc=" + course_desc
				+ ", course_image=" + course_image + ", course_state=" + course_state + ", course_index=" + course_index
				+ "]";
	}
	
}
