package com.amaker.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amaker.bean.Stu;
import com.amaker.dao.StuDao;
import com.amaker.dao.impl.StuDaoImpl;

public class StuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public StuServlet() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
	}

	public void destroy() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		int age = new Integer(request.getParameter("age"));
		
		StuDao dao = new StuDaoImpl();
		
		Stu s = new Stu();
		s.setAge(age);
		s.setName(name);
		dao.save(s);
		
		List list = dao.list();
		
		request.setAttribute("StuList", list);
		
		request.getRequestDispatcher("/Stu.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
