package com.yecol.study.account.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.log4j.Logger;

import com.yecol.study.account.dao.AdminDao;
import com.yecol.study.account.domain.Admin;
import com.yecol.study.util.C3P0Uitls;
import com.yecol.study.util.MD5Utils;

/**
 * 管理员持久层实现类
 * @author yecol
 *
 */
public class AdminDaoImpl implements AdminDao {

	Logger logger = Logger.getLogger(AdminDaoImpl.class);
	
	QueryRunner qr = new QueryRunner(C3P0Uitls.getDataSource());
	
	public Admin findByNameAndPwd(String name,String pwd) {
		String sql = "select * from tb_admin where admin_name = ? and admin_pwd = ?";
		Admin admin = null;
		try {
			admin = qr.query(sql, new BeanHandler<Admin>(Admin.class),name,pwd);
		} catch (SQLException e) {
			logger.error("查询管理员错误：" + e.getMessage());
		}
		return admin;
	}

	@Override
	public List<Admin> findAll() {
		String sql = "select * from tb_admin";
		List<Admin> admins = null;
		try {
			admins = qr.query(sql, new BeanListHandler<Admin>(Admin.class));
		} catch (SQLException e) {
			logger.error("查询所有管理员错误：" + e.getMessage());
		}
		return admins;
	}

	@Override
	public void updateState(int id, int admin_state) {
		String sql = "update tb_admin set admin_state = ? where admin_id = ?";
		try {
			qr.update(sql,admin_state,id);
		} catch (SQLException e) {
			logger.error("根据id更改管理员状态错误：" + e.getMessage());
		}
		
	}

	@Override
	public int insertAdmin(Admin admin) {
		String sql = "insert into tb_admin(admin_name,admin_pwd,admin_state,admin_date,admin_role) " + 
				" values (?,?,?,NOW(),?)";
		try {
			return qr.update(sql,admin.getAdmin_name(),MD5Utils.stringToMD5("123456"),admin.getAdmin_state(),admin.getAdmin_role());
		} catch (Exception e) {
			logger.error("增加管理员异常：" + e.getMessage());
		}
		return 0;
	}

	@Override
	public Admin findById(int admin_id) {
		String sql = "select * from tb_admin where admin_id = ?";
		Admin admin = null;
		try {
			admin = qr.query(sql, new BeanHandler<Admin>(Admin.class),admin_id);
		} catch (Exception e) {
			logger.error("根据id查询管理员异常：" + e.getMessage());
		}
		return admin;
	}

	@Override
	public void updateAdmin(Admin admin) {
		String sql = "update tb_admin set admin_name = ?,admin_role = ?,admin_pwd = ? where admin_id = ?";
		try {
			qr.update(sql,admin.getAdmin_name(),admin.getAdmin_role(),admin.getAdmin_pwd(),admin.getAdmin_id());
		} catch (Exception e) {
			logger.error("修改管理员异常：" + e.getMessage());
		}
	}
	
}
