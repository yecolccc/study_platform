package com.yecol.study.account.domain;

/**
 * ����Ա
 * @author wenber
 *
 */
public class Admin {
	
	//ΨһID
	private int admin_id;
	//�û���
	private String admin_name;
	//����
	private String admin_pwd;
	//״̬
	private int admin_state;
	//��֤�ַ�
	private String token;
	
	//��ɫ
	private String admin_role;
	//��������
	private String admin_date;
	
	public Admin() {
	}
	
	public Admin(String admin_name, int admin_state, String admin_role) {
		super();
		this.admin_name = admin_name;
		this.admin_state = admin_state;
		this.admin_role = admin_role;
	}



	public Admin(String admin_name, String admin_pwd, int admin_state) {
		super();
		this.admin_name = admin_name;
		this.admin_pwd = admin_pwd;
		this.admin_state = admin_state;
	}

	public Admin(int admin_id, String admin_name, String admin_pwd, int admin_state) {
		super();
		this.admin_id = admin_id;
		this.admin_name = admin_name;
		this.admin_pwd = admin_pwd;
		this.admin_state = admin_state;
	}
	
	

	public String getAdmin_role() {
		return admin_role;
	}

	public void setAdmin_role(String admin_role) {
		this.admin_role = admin_role;
	}

	public String getAdmin_date() {
		return admin_date;
	}

	public void setAdmin_date(String admin_date) {
		this.admin_date = admin_date;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public int getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}

	public String getAdmin_name() {
		return admin_name;
	}

	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}

	public String getAdmin_pwd() {
		return admin_pwd;
	}

	public void setAdmin_pwd(String admin_pwd) {
		this.admin_pwd = admin_pwd;
	}

	public int getAdmin_state() {
		return admin_state;
	}

	public void setAdmin_state(int admin_state) {
		this.admin_state = admin_state;
	}

	@Override
	public String toString() {
		return "Admin [admin_id=" + admin_id + ", admin_name=" + admin_name + ", admin_pwd=" + admin_pwd
				+ ", admin_state=" + admin_state + ", token=" + token + ", admin_role=" + admin_role + ", admin_date="
				+ admin_date + "]";
	}
	
	


}
