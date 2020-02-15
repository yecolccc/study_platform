package com.yecol.study.account.service;

import java.util.List;

import com.yecol.study.account.domain.Admin;
import com.yecol.study.util.PageBean;

public interface AdminService {

	public Admin findByNameAndPwd(String name,String pwd);
	
	public List<Admin> findAll(String admin_name,String admin_role, int admin_state);
	
	/*
	 *	更改管理员的状态
	 */
	public void updateState(int id,int admin_state);
	
	public boolean insertAdmin(Admin admin);
	
	public Admin findById(int admin_id);
	
	public void updateAdmin(Admin admin);
	
	/**
	 * 查询我们的PageBean对象
	 * @param admin_name	用户名
	 * @param admin_role	角色
	 * @param admin_state	状态
	 * @param currentPage	当前页
	 * @param pageSize		每页的最大数量
	 * @return
	 */
	public PageBean<Admin> findPageBean(String admin_name,String admin_role, int admin_state,int currentPage,int pageSize);
	
}
