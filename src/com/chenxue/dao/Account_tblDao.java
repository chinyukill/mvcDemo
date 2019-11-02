package com.chenxue.dao;

public interface Account_tblDao {
	public int checkAccount(int Aid);
	public int checkBalance(int Aid);
	public int updateBalance(int Aid,int money);
}
