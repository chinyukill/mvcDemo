package com.chenxue.service;

import com.chenxue.dao.Account_tblDao;
import com.chenxue.dao.Account_tblDaoImpl;

public class Account_tblServiceImpl implements Account_tblService {

	@Override
	public boolean trasfer(int aIdFrom, int aIdTo, int money) {
		Account_tblDao dao = new Account_tblDaoImpl();
		int flag=0,from_Balance=0,to_Balance=0;
		//转账的用户
		flag=dao.checkAccount(aIdFrom);
		if (flag==0) {
			return false;
		}
		//接受转账的用户
		flag=dao.checkAccount(aIdTo);
		if (flag==0) {
			return false;
		}
		//转账用户余额
		from_Balance=dao.checkBalance(aIdFrom);
		if (from_Balance<money) {
			return false;
		}
		//接受转账用户余额
		to_Balance=dao.checkBalance(aIdTo);
		//转账用户余额更新
		flag=dao.updateBalance(aIdFrom, from_Balance-money);
		if (flag==0) {
			return false;
		}
		//接受转账用户余额更新
		flag=dao.updateBalance(aIdTo, to_Balance+money);
		if (flag==0) {
			return false;
		}
		return true;
	}

}
