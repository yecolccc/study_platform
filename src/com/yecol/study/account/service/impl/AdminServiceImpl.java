package com.yecol.study.account.service.impl;

import java.util.List;

import com.yecol.study.account.dao.AdminDao;
import com.yecol.study.account.dao.impl.AdminDaoImpl;
import com.yecol.study.account.domain.Admin;
import com.yecol.study.account.service.AdminService;
import com.yecol.study.util.MD5Utils;
import com.yecol.study.util.PageBean;

public class AdminServiceImpl implements AdminService {

	AdminDao adminDao = new AdminDaoImpl();
	
	public Admin findByNameAndPwd(String name,String pwd) {
		//进行MD5加密
		pwd = MD5Utils.stringToMD5(pwd);
		return adminDao.findByNameAndPwd(name, pwd);
	}

	@Override
	public List<Admin> findAll(String admin_name,String admin_role, int admin_state) {
		return adminDao.findAll(admin_name,admin_role,admin_state);
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

	@Override
	public PageBean<Admin> findPageBean(String admin_name, String admin_role, int admin_state, int currentPage,
			int pageSize) {
		PageBean<Admin> pageBean = new PageBean<Admin>();
		//添加当前页
		pageBean.setCurrentPage(currentPage);
		//添加每页最大数
		pageBean.setPageSize(pageSize);
		//添加总记录数
		int totalCount = adminDao.findTotalCount(admin_name, admin_role, admin_state);
		pageBean.setTotalCount(totalCount);
		//添加总页数
		int totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
		pageBean.setTotalPage(totalPage);
		//添加每页的记录数
		int start = (currentPage - 1)*pageSize;
		List<Admin> list = adminDao.findByPage(admin_name, admin_role, admin_state, start, pageSize);
		pageBean.setList(list);
		return pageBean;
	}
	
}
