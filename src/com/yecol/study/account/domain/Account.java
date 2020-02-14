package com.yecol.study.account.domain;

/**
 * 账户
 * @author wenber
 *
 */
public class Account {
	
	private int aid;
	private String acc_name;
	private String acc_pwd;
	private int acc_state;
	//密钥
	String token;
	
	public Account() {
	}

	public Account(String acc_name, String acc_pwd) {
		super();
		this.acc_name = acc_name;
		this.acc_pwd = acc_pwd;
	}

	public Account(int aid, String acc_name, String acc_pwd, int acc_state) {
		super();
		this.aid = aid;
		this.acc_name = acc_name;
		this.acc_pwd = acc_pwd;
		this.acc_state = acc_state;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getAcc_name() {
		return acc_name;
	}

	public void setAcc_name(String acc_name) {
		this.acc_name = acc_name;
	}

	public String getAcc_pwd() {
		return acc_pwd;
	}

	public void setAcc_pwd(String acc_pwd) {
		this.acc_pwd = acc_pwd;
	}

	public int getAcc_state() {
		return acc_state;
	}

	public void setAcc_state(int acc_state) {
		this.acc_state = acc_state;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "Account [aid=" + aid + ", acc_name=" + acc_name + ", acc_pwd=" + acc_pwd + ", acc_state=" + acc_state
				+ "]";
	}
	
	

}
