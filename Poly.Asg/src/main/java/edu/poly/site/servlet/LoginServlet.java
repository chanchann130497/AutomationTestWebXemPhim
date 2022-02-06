package edu.poly.site.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import edu.poly.common.CookieUtils;
import edu.poly.common.PageInfo;
import edu.poly.common.PageType;
import edu.poly.common.SessionUtils;
import edu.poly.dao.UserDao;
import edu.poly.domain.LoginForm;
import edu.poly.model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = CookieUtils.get("username", req);
		if (username == null) {
			PageInfo.prepareAndForwardSite(req, resp, PageType.SITE_LOGIN_PAGE);
			return;
		}
		SessionUtils.add(req, "username", username);
		req.getRequestDispatcher("/Homepage").forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			LoginForm form = new LoginForm();
			BeanUtils.populate(form, req.getParameterMap());
			UserDao dao = new UserDao();
			User user = dao.findById(form.getUsername());
			if (user != null && user.getPassword().equals(form.getPassword())) {
				SessionUtils.add(req, "username", user.getUsername());
				if (form.isRemember()) {
					CookieUtils.add("username", form.getUsername(), 24, resp);
				} else {
					CookieUtils.add("username", form.getUsername(), 0, resp);
				}
				req.setAttribute("isLogin", true);
				req.setAttribute("name", user.getFullname());
				if (user.getAdmin()) {
					req.getRequestDispatcher("/admin/layout.jsp").forward(req, resp);
					return;
				} else {
					req.getRequestDispatcher("/Homepage").forward(req, resp);
					return;
				}

			}
			req.setAttribute("error", "invalid username or password");

		} catch (Exception e) {
			req.setAttribute("error", e.getMessage());
		}
		PageInfo.prepareAndForwardSite(req, resp, PageType.SITE_LOGIN_PAGE);
	}

}
