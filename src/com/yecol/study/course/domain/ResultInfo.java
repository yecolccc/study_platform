package com.yecol.study.course.domain;

import com.google.gson.Gson;

public class ResultInfo {
	
	private int code;	//0表示成功
	
	private Object data;
	
	private String msg;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	/**
	 * 将当前对象转换为json格式
	 * @return
	 */
	public String toJson() {
		Gson gson = new Gson();
		String json = gson.toJson(this);
		return json;
	}
	
	/**
	 * 成功 带对象
	 * @param object
	 * @return
	 */
	public static ResultInfo success(Object object) {
		ResultInfo resultInfo = new ResultInfo();
		resultInfo.setCode(0);
		resultInfo.setData(object);
		resultInfo.setMsg("成功");
		return resultInfo;
	}
	
	/**
	 * 成功 不带对象
	 * @param object
	 * @return
	 */
	public static ResultInfo success() {
		ResultInfo resultInfo = new ResultInfo();
		resultInfo.setCode(0);
		resultInfo.setMsg("成功");
		return resultInfo;
	}
	
	/**
	 * 失败 不带对象
	 * @param object
	 * @return
	 */
	public static ResultInfo fail() {
		ResultInfo resultInfo = new ResultInfo();
		resultInfo.setCode(1);
		resultInfo.setMsg("失败");
		return resultInfo;
	}
	
	/**
	 * 失败 带消息
	 * @param object
	 * @return
	 */
	public static ResultInfo fail(String msg) {
		ResultInfo resultInfo = new ResultInfo();
		resultInfo.setCode(1);
		resultInfo.setMsg(msg);
		return resultInfo;
	}
	
	/**
	 * 失败 带消息 带状态码	2表示未登录
	 * @param object
	 * @return
	 */
	public static ResultInfo fail(String msg,int code) {
		ResultInfo resultInfo = new ResultInfo();
		resultInfo.setCode(code);
		resultInfo.setMsg(msg);
		return resultInfo;
	}

}
