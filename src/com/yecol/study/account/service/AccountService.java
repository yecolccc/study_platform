package com.yecol.study.account.service;

import com.yecol.study.account.domain.Account;

/**
 * 用户的业务层接口
 * @author yecol
 *
 */
public interface AccountService {

	/**
	 * 根据用户名和密码查询账户
	 * @param acc_name
	 * @param acc_pwd
	 * @return
	 */
	public Account findByNameAndPwd(String acc_name, String acc_pwd);
	
}
