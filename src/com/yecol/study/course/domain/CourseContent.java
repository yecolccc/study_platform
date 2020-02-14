package com.yecol.study.course.domain;

/**
 * 课程具体内容的实体类
 * 
 * @author wenber
 *
 */
public class CourseContent {

	private int list_id;
	
	private String list_name;
	
	private String list_desc;
	
	private String list_video_url;
	
	private String list_video_state;
	
	private int list_video_count;

	public int getList_id() {
		return list_id;
	}

	public void setList_id(int list_id) {
		this.list_id = list_id;
	}

	public String getList_name() {
		return list_name;
	}

	public void setList_name(String list_name) {
		this.list_name = list_name;
	}

	public String getList_desc() {
		return list_desc;
	}

	public void setList_desc(String list_desc) {
		this.list_desc = list_desc;
	}

	public String getList_video_url() {
		return list_video_url;
	}

	public void setList_video_url(String list_video_url) {
		this.list_video_url = list_video_url;
	}

	public String getList_video_state() {
		return list_video_state;
	}

	public void setList_video_state(String list_video_state) {
		this.list_video_state = list_video_state;
	}

	public int getList_video_count() {
		return list_video_count;
	}

	public void setList_video_count(int list_video_count) {
		this.list_video_count = list_video_count;
	}

}
