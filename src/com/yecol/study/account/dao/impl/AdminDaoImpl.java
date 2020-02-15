package com.yecol.study.account.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
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

	//根据条件完成分页查询
	@Override
	public List<Admin> findAll(String admin_name,String admin_role, int admin_state) {
		String sql = "select * from tb_admin where 1 = 1 ";
		//绑定动态sql
		StringBuilder sb = new StringBuilder(sql);
		List<Object> params = new ArrayList<>();
		//添加用户名
		if(null != admin_name && admin_name.length() > 0) {
			sb.append(" and admin_name like ? ");
			params.add("%" + admin_name + "%");
		}
		//添加角色
		if(null != admin_role && admin_role.length() > 0) {
			sb.append(" and admin_role = ? ");
			params.add(admin_role);
		}
		//添加状态
		if(admin_state != -1) {
			sb.append(" and admin_state = ? ");
			params.add(admin_state);
		}
		sql = sb.toString();
		List<Admin> admins = null;
		try {
			admins = qr.query(sql, new BeanListHandler<Admin>(Admin.class),params.toArray());
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

	@Override
	public List<Admin> findByPage(String admin_name, String admin_role, int admin_state, int start, int pageSize) {
		String sql = "select * from tb_admin where 1 = 1 ";
		//绑定动态sql
		StringBuilder sb = new StringBuilder(sql);
		List<Object> params = new ArrayList<>();
		//添加用户名
		if(null != admin_name && admin_name.length() > 0) {
			sb.append(" and admin_name like ? ");
			params.add("%" + admin_name + "%");
		}
		//添加角色
		if(null != admin_role && admin_role.length() > 0) {
			sb.append(" and admin_role = ? ");
			params.add(admin_role);
		}
		//添加状态
		if(admin_state != -1) {
			sb.append(" and admin_state = ? ");
			params.add(admin_state);
		}
		//添加分页
		sb.append(" limit ? , ? ");
		params.add(start);
		params.add(pageSize);
		sql = sb.toString();
		System.out.println("=======" + sql + "==========");
		List<Admin> admins = null;
		try {
			admins = qr.query(sql, new BeanListHandler<Admin>(Admin.class),params.toArray());
		} catch (SQLException e) {
			logger.error("查询所有管理员错误：" + e.getMessage());
		}
		return admins;
	}

	@Override
	public int findTotalCount(String admin_name,String admin_role, int admin_state) {
		String sql = "select count(*) from tb_admin where 1=1 ";
		//绑定动态sql
		StringBuilder sb = new StringBuilder(sql);
		List<Object> params = new ArrayList<>();
		//添加用户名
		if(null != admin_name && admin_name.length() > 0) {
			sb.append(" and admin_name like ? ");
			params.add("%" + admin_name + "%");
		}
		//添加角色
		if(null != admin_role && admin_role.length() > 0) {
			sb.append(" and admin_role = ? ");
			params.add(admin_role);
		}
		//添加状态
		if(admin_state != -1) {
			sb.append(" and admin_state = ? ");
			params.add(admin_state);
		}
		//sql更新
		sql = sb.toString();
		try {
			return qr.query(sql,new ResultSetHandler<Integer>() {

				@Override
				public Integer handle(ResultSet rs) throws SQLException {
					if(rs.next()) {
						return rs.getInt(1);
					}
					return 0;
				}
				
			}, params.toArray());
		} catch (SQLException e) {
			logger.error("查询所有管理员条数：" + e.getMessage());
		}
		return 0;
	}
	
	public static void main(String[] args) {
		AdminDaoImpl dao = new AdminDaoImpl();
		/*List<Admin> list = dao.findByPage("", "编辑人员", -1, 6, 5);
		for (Admin admin : list) {
			System.out.println(admin);
		}*/
		int count = dao.findTotalCount("", "超级管理员", -1);
		System.out.println(count);
	}
	
}
