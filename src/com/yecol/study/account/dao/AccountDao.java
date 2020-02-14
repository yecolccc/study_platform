package com.yecol.study.account.dao;

import com.yecol.study.account.domain.Account;

/**
 * 账户dao层接口
 * @author yecol
 *
 */
public interface AccountDao {

	/**
	 * 根据用户名密码查询用户
	 * @param acc_name
	 * @param acc_pwd
	 * @return
	 */
	Account findByNameAndPwd(String acc_name,String acc_pwd);
	
}
