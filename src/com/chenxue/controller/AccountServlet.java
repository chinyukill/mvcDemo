package com.chenxue.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chenxue.service.Account_tblService;
import com.chenxue.service.Account_tblServiceImpl;

/**
 * Servlet implementation class AccountServlet
 */
@WebServlet("/account/transfer.do")
public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String aIdTo=request.getParameter("aIdTo");
		String aIdFrom=request.getParameter("aIdFrom");
		String money=request.getParameter("money");
		boolean flag=true;
		Account_tblService service = new Account_tblServiceImpl();
		flag=service.trasfer(Integer.valueOf(aIdFrom), Integer.valueOf(aIdTo), Integer.valueOf(money));
		response.setCharacterEncoding("utf-8");
		PrintWriter out =response.getWriter();
		String s="";
		if (flag) {
			s="转账成功";
		}else {
			s="转账失败";
		}
		
		out.write(s);
		//request.getRequestDispatcher("/index.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
