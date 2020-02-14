package com.yecol.study.account.service.impl;

import com.yecol.study.account.dao.AccountDao;
import com.yecol.study.account.dao.impl.AccountDaoImpl;
import com.yecol.study.account.domain.Account;
import com.yecol.study.account.service.AccountService;
import com.yecol.study.util.MD5Utils;

/**
 * 账户业务层接口实现类
 * @author yecol
 *
 */
public class AccountServiceImpl implements AccountService {

	private AccountDao accountDao = new AccountDaoImpl();
	
	@Override
	public Account findByNameAndPwd(String acc_name, String acc_pwd) {
		// TODO Auto-generated method stub
		//用md5加密
		acc_pwd = MD5Utils.stringToMD5(acc_pwd);
		return accountDao.findByNameAndPwd(acc_name, acc_pwd);
	}
	

}
