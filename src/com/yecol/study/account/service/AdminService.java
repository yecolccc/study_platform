package com.yecol.study.account.service;

import java.util.List;

import com.yecol.study.account.domain.Admin;

public interface AdminService {

	public Admin findByNameAndPwd(String name,String pwd);
	
	public List<Admin> findAll();
	
	/*
	 *	更改管理员的状态
	 */
	public void updateState(int id,int admin_state);
	
	public boolean insertAdmin(Admin admin);
	
	public Admin findById(int admin_id);
	
	public void updateAdmin(Admin admin);
	
}
