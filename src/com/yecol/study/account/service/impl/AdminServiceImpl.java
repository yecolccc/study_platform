package com.yecol.study.account.service.impl;

import java.util.List;

import com.yecol.study.account.dao.AdminDao;
import com.yecol.study.account.dao.impl.AdminDaoImpl;
import com.yecol.study.account.domain.Admin;
import com.yecol.study.account.service.AdminService;
import com.yecol.study.util.MD5Utils;

public class AdminServiceImpl implements AdminService {

	AdminDao adminDao = new AdminDaoImpl();
	
	public Admin findByNameAndPwd(String name,String pwd) {
		//进行MD5加密
		pwd = MD5Utils.stringToMD5(pwd);
		return adminDao.findByNameAndPwd(name, pwd);
	}

	@Override
	public List<Admin> findAll() {
		return adminDao.findAll();
	}

	@Override
	public void updateState(int id, int admin_state) {
		adminDao.updateState(id, admin_state);
		
	}

	@Override
	public boolean insertAdmin(Admin admin) {
		return adminDao.insertAdmin(admin) == 1? true:false;
	}

	@Override
	public Admin findById(int admin_id) {
		return adminDao.findById(admin_id);
	}

	@Override
	public void updateAdmin(Admin admin) {
		//给密码加密
		admin.setAdmin_pwd(MD5Utils.stringToMD5(admin.getAdmin_pwd()));
		adminDao.updateAdmin(admin);
	}
	
}
