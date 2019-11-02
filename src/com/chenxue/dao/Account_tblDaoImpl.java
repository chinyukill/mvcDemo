package com.chenxue.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sun.org.apache.regexp.internal.recompile;
import com.sun.org.glassfish.external.statistics.annotations.Reset;

public class Account_tblDaoImpl implements Account_tblDao {

	@Override
	public int checkAccount(int Aid) {
		String sql="select count(1) from Account_tbl where Aid=?";
		Connection connection=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		int flag=0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/chenxue","root","root");
			ps=connection.prepareStatement(sql);
			ps.setInt(1, Aid);
			rs=ps.executeQuery();
			rs.next();
			flag=rs.getInt(1);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return flag;
	}

	@Override
	public int checkBalance(int Aid) {
		String sql="select Abalance from Account_tbl where Aid=?";
		Connection connection=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		int flag=0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/chenxue","root","root");
			ps=connection.prepareStatement(sql);
			ps.setInt(1, Aid);
			rs=ps.executeQuery();
			rs.next();
			flag=rs.getInt(1);			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag;
	}

	@Override
	public int updateBalance(int Aid, int money) {
		String sql="update Account_tbl set Abalance=? where Aid=?";
		Connection connection=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		int flag=0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/chenxue","root","root");
			ps=connection.prepareStatement(sql);
			ps.setInt(1, money);
			ps.setInt(2, Aid);
			flag=ps.executeUpdate();
						
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag;
	}

}
