package com.yecol.study.account.dao;

import java.util.List;

import com.yecol.study.account.domain.Admin;

public interface AdminDao {

	public Admin findByNameAndPwd(String name,String pwd);
	
	public List<Admin> findAll(String admin_name,String admin_role, int admin_state);
	
	/*
	 *	更改管理员的状态
	 */
	public void updateState(int id,int admin_state);
	
	public int insertAdmin(Admin admin);
	
	public Admin findById(int admin_id);
	
	public void updateAdmin(Admin admin);
	
	//条件分页查询
	public List<Admin> findByPage(String admin_name,String admin_role, int admin_state,int start,int pageSize);
	
	//查询总记录数
	public int findTotalCount(String admin_name,String admin_role, int admin_state);
	
}
