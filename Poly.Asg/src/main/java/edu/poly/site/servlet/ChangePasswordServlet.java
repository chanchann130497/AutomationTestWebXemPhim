package edu.poly.site.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import edu.poly.common.PageInfo;
import edu.poly.common.PageType;
import edu.poly.common.SessionUtils;
import edu.poly.dao.UserDao;
import edu.poly.domain.ChangePasswordForm;
import edu.poly.model.User;

/**
 * Servlet implementation class ChangePasswordServlet
 */
@WebServlet("/ChangePassword")
public class ChangePasswordServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = SessionUtils.getLoginedUsername(request);
		if (username == null) {
			request.getRequestDispatcher("/Login").forward(request, response);
			return;
		}

		request.setAttribute("username", username);

		PageInfo.prepareAndForwardSite(request, response, PageType.SITE_CHANGE_PASSWORD_PAGE);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String newPassword = request.getParameter("currentPassword");
			String confirmPassword = request.getParameter("confirmPassword");

//			String username = SessionUtils.getLoginedUsername(request);
//			ChangePasswordForm form = new ChangePasswordForm();
//			BeanUtils.populate(form, request.getParameterMap());
//			request.setAttribute("username", username);

			if (!newPassword.equals(confirmPassword)) {
				request.setAttribute("error", "new password and new comfirm password are not in identical");
			} else {
				UserDao dao = new UserDao();
				User user = dao.findById(username);
				if (user.getPassword().equals(password)) {
					user.setPassword(confirmPassword);
					dao.update(user);
					request.setAttribute("message", "Password has been changed");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		PageInfo.prepareAndForwardSite(request, response, PageType.SITE_CHANGE_PASSWORD_PAGE);
	}

}





















