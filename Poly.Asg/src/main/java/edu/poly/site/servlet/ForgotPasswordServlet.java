package edu.poly.site.servlet;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.poly.common.PageInfo;
import edu.poly.common.PageType;
import edu.poly.dao.UserDao;
import edu.poly.model.User;

/**
 * Servlet implementation class ForgotPasswordServlet
 */
@WebServlet("/ForgotPassword")
public class ForgotPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PageInfo.prepareAndForwardSite(request, response, PageType.SITE_FORGOT_PASSWORD_PAGE);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com"); // mail server cửa google là smtp
		props.put("mail.smtp.port", "587");

		// get session
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication("halala1102@gmail.com", "thang123456");
			}

		});

		try {
			String emailAddress = request.getParameter("email");
			String username = request.getParameter("username");

			UserDao dao = new UserDao();
			User user = dao.findByUsernameAndEmail(username, emailAddress);

			if (user == null) {
				request.setAttribute("error", "Username or email are incorrect");
			} else {

				MimeMessage message = new MimeMessage(session);
				// từ mail nào
				message.setRecipients(Message.RecipientType.TO, emailAddress);
				// đến mail nào
				message.setSubject("Your password");
				// nội dung thư
				message.setText("Password    :" + user.getPassword());
				// gửi thư đi
				Transport.send(message);
				// báo thành công
				System.out.println("Message sent successfully");
				request.setAttribute("message", "Your mail sent...OK");
			}

		} catch (Exception e) {
			e.printStackTrace();

			request.setAttribute("error", e.getMessage());
		}
		PageInfo.prepareAndForwardSite(request, response, PageType.SITE_FORGOT_PASSWORD_PAGE);
	}

}
