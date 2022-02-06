package edu.poly.site.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.poly.common.EmailUtils;
import edu.poly.common.PageInfo;
import edu.poly.common.PageType;
import edu.poly.common.SessionUtils;
import edu.poly.dao.ShareDao;
import edu.poly.dao.UserDao;
import edu.poly.domain.Email;
import edu.poly.model.Share;
import edu.poly.model.User;
import edu.poly.model.Video;

/**
 * Servlet implementation class ShareVideoServlet
 */
@WebServlet("/ShareVideo")
public class ShareVideoServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (!SessionUtils.isLogin(req)) {
			resp.sendRedirect("Login");
			return;
		}
		String videoId = req.getParameter("videoId");
		
		if (videoId == null) {
			resp.sendRedirect("/Homepage");
			return;
		}
		
		req.setAttribute("videoId", videoId);
		PageInfo.prepareAndForwardSite(req, resp, PageType.SITE_SHARE_PAGE);
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String emailAddress = req.getParameter("email");
			String videoId = req.getParameter("videoId");
			
			if (videoId==null) {
				req.setAttribute("error", "VideoID is Null");
			}else {
				Email email = new Email();
				email.setFrom("halala1102@gmail.com");
				email.setFromPassword("123456");
				email.setTo(emailAddress);
				email.setSubject("Share Favorite Video");
				StringBuilder sb = new StringBuilder();
				sb.append("Dear Mr/Mrs </br>");
				sb.append("The video is more interesting and I want to share with you <br>");
				sb.append("Link video : <a href='http://localhost:8080/Poly.Asg/Homepage'>View Video</a><br>");
				sb.append("</br>From administrator");
				
				email.setContent(sb.toString());
				EmailUtils.send(email);
				
				ShareDao dao = new ShareDao();
				Share share = new Share();
				share.setEmails(emailAddress);
				share.setSharedDate(new Date());
				
				String username = SessionUtils.getLoginedUsername(req);
				User user =new User();
				user.setUsername(username);
				
				share.setUser(user);
				Video video =new Video();
				video.setVideoId(videoId);
				share.setVideo(video);
				
				dao.insert(share);	
				req.setAttribute("message", "Video link has been sent");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Error"+e.getMessage());
		}
		PageInfo.prepareAndForwardSite(req, resp, PageType.SITE_SHARE_PAGE);
	}
	

}
