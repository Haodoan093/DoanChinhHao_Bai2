package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.giangvienDao;
import com.model.giangvien;

@WebServlet("/")
public class giangvienServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private giangvienDao dao;// khoi tao doi tuong

	public giangvienServlet() {
		super();
		dao = new giangvienDao();

	}

	// lay het thong tin
	private void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<giangvien> ls = dao.getAll();// lay thong tin

		request.setAttribute("lsGV", ls);// key and values

		RequestDispatcher rd = request.getRequestDispatcher("views/index.jsp");
		rd.forward(request, response);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getServletPath();

		request.setCharacterEncoding("UTF-8");
		switch (action) {
		case "/new": {
			showFormInsert(request, response);
			break;
		}
		case "/edit": {
			showFormEdit(request, response);
			break;
		}
		case "/insert": {

			insertGV(request, response);
			break;
		}
		case "/update": {

			updateGV(request, response);
			break;
		}
		case "/search": {

			search(request, response);
			break;
		}
		case "/delete": {

			deleteGV(request, response);
			break;
		}
		case "/showall": {

			getAll(request, response);
			break;
		}
		default:
			getAll(request, response);
			break;
		}

	}

	private void updateGV(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// nhan tu form insert
		int id = Integer.parseInt(request.getParameter("id"));
		String hoten = request.getParameter("hoten");
		String ngaysinh = request.getParameter("ngaysinh");
		String tenbomon = request.getParameter("tenbomon");
		float hesoluong = Float.parseFloat(request.getParameter("hesoluong"));

		giangvien gv = new giangvien(hoten, ngaysinh, tenbomon, hesoluong, id);
		this.dao.updateGV(gv);
		response.sendRedirect("list");

	}

	// hien thi form edit
	private void showFormEdit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		giangvien gv = this.dao.getGV(id);
		request.setAttribute("gv", gv);
		RequestDispatcher rd = request.getRequestDispatcher("views/formsua.jsp");
		rd.forward(request, response);

	}

// hien thi form them
	private void showFormInsert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("views/formthem.jsp");
		rd.forward(request, response);

	}

	private void insertGV(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String hoten = request.getParameter("hoten");
		String ngaysinh = request.getParameter("ngaysinh");
		String tenbomon = request.getParameter("tenbomon");
		float hesoluong = Float.parseFloat(request.getParameter("hesoluong"));

		giangvien gv = new giangvien(hoten, ngaysinh, tenbomon, hesoluong);
		this.dao.insertGV(gv);
		response.sendRedirect("list");
	}
	// xoa

	private void deleteGV(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		this.dao.DeleteGV(id);

		response.sendRedirect("list");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	// tim kiem
	private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<giangvien> ls = new ArrayList<>();

		String hoten = request.getParameter("searchName");
		String maGV = request.getParameter("searchMa");
		if (!hoten.isEmpty()) {
			ls = dao.SearchAllStudent("name", hoten);
		}
		if (!maGV.isEmpty()) {
			ls = dao.SearchAllStudent("ma", maGV);
		}

		request.setAttribute("lsGV", ls);
		RequestDispatcher rd = request.getRequestDispatcher("views/index.jsp");
		rd.forward(request, response);

	}
	// sua

}
