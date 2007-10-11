package com.gamiao.struts2.demo.firstdemo.action;

import com.opensymphony.xwork2.ActionSupport;

public class FirstDemo extends ActionSupport {

	private String secret;

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public String execute() {
		if (secret.equals("gamiao")) {
			secret = "Hello, " + secret + "!";
			return SUCCESS;
		} else {
			secret = "Hello, " + secret + "!";
			return ERROR;
		}
	}
}
