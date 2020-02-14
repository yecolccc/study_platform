package com.yecol.study.account.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.log4j.Logger;

import com.yecol.study.account.dao.AccountDao;
import com.yecol.study.account.domain.Account;
import com.yecol.study.util.C3P0Uitls;

public class AccountDaoImpl implements AccountDao {

	//注册日志
	static Logger logger = Logger.getLogger(AccountDaoImpl.class);
	//创建qr
	private QueryRunner qr = new QueryRunner(C3P0Uitls.getDataSource());
	
	@Override
	public Account findByNameAndPwd(String acc_name, String acc_pwd) {
		String sql = "select * from tb_account where acc_name = ? and acc_pwd = ?";
		Account account = null;
		try {
			account = qr.query(sql, new BeanHandler<>(Account.class),acc_name,acc_pwd);
		} catch (Exception e) {
			logger.error("根据用户名和密码查询账户失败:" + e.getMessage());
		}
		return account;
	}

}
