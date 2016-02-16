package com.pear.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class TUser {
    private String id;

    private String userName;

    private String passWord;
    
    private Double money;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord == null ? null : passWord.trim();
    }
    
    

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}
    
}