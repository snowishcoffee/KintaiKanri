package com.management.kintaikanri.model;

public class LoginModel {

	private int loginId;
	private String password;

	public LoginModel(int loginId, String password) {
		this.loginId = loginId;
		this.password = password;
	}

	public int getLoginId() {
		return loginId;
	}

	public String getPassword() {
		return password;
	}
}
