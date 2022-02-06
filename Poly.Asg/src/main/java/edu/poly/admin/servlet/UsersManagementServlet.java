package edu.poly.admin.servlet;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import edu.poly.common.PageInfo;
import edu.poly.common.PageType;
import edu.poly.dao.JpaUtils;
import edu.poly.dao.UserDao;
import edu.poly.model.User;

/**
 * Servlet implementation class UserManagementSevlet
 */
//@WebServlet("/UserManagement")
@WebServlet({ "/Admin/UsersManagement", "/Admin/UsersManagement/create", "/Admin/UsersManagement/update",
		"/Admin/UsersManagement/delete", "/Admin/UsersManagement/reset", "/Admin/UsersManagement/edit" })
public class UsersManagementServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		UserDao dao = new UserDao();
		String url = req.getRequestURL().toString();
		if (url.contains("edit")) {
			String username = req.getParameter("username");
			User user = dao.findById(username);
			req.setAttribute("form", user);
		}
		if (url.contains("reset")) {

		}

		List<User> listU = dao.findALL();

		req.setAttribute("listUser", listU);
		PageInfo.prepareAndForward(req, resp, PageType.USER_MANAGEMENT_PAGE);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		UserDao dao = new UserDao();
		String url = req.getRequestURL().toString();
		if (url.contains("create")) {
			insert(req, resp);
		}
		if (url.contains("delete")) {
			delete(req, resp);
		}
		if (url.contains("update")) {
			update(req, resp);
		}
		if (url.contains("reset")) {
		}

		List<User> listU = dao.findALL();

		req.setAttribute("listUser", listU);
		PageInfo.prepareAndForward(req, resp, PageType.USER_MANAGEMENT_PAGE);
	}

	public void insert(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		try {
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			String fullname = req.getParameter("fullname");
			String email = req.getParameter("email");
			boolean isadmin = Boolean.parseBoolean(req.getParameter("admin"));

			User user = new User();
			BeanUtils.populate(user, req.getParameterMap());
			UserDao dao = new UserDao();
			dao.insert(user);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		EntityManager em = JpaUtils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			UserDao dao = new UserDao();
			String username = req.getParameter("username");
			User u = em.find(User.class, username);
			em.remove(u);
			trans.commit();

		} catch (Exception e) {
		
			trans.rollback();
		}
	}

	public void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		try {
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			String fullname = req.getParameter("fullname");
			String email = req.getParameter("email");
			boolean isadmin = Boolean.parseBoolean(req.getParameter("admin"));

			User user = new User();
			BeanUtils.populate(user, req.getParameterMap());
			UserDao dao = new UserDao();
			dao.update(user);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
