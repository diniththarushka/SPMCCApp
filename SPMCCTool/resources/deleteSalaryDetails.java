package com.java.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.model.salaryCalc;
import com.java.service.SalaryImpl;

/**
 * Servlet implementation class deleteSalaryDetails
 */
@WebServlet("/deleteSalaryDetails")
public class deleteSalaryDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteSalaryDetails() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		salaryCalc s = new salaryCalc();
		
		s.setEid(request.getParameter("eid"));
		s.setEname(request.getParameter("eName"));
		s.setHours(request.getParameter("hours"));
		s.setRate(request.getParameter("rate"));
		s.setDeduc(request.getParameter("deduc"));
		s.setBonus(request.getParameter("bonus"));
		s.setBasic(request.getParameter("basic"));
		s.setNet(request.getParameter("net"));
		
		SalaryImpl sl = new SalaryImpl();
		sl.deleteSalaryDetails();
		doGet(request, response);
	}

}
