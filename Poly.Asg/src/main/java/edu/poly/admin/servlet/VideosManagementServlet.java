package edu.poly.admin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import edu.poly.common.PageInfo;
import edu.poly.common.PageType;
import edu.poly.common.UploadUtils;
import edu.poly.dao.VideoDao;
import edu.poly.model.Video;

/**
 * Servlet implementation class VideosManagementServlet
 */
@WebServlet({ "/Admin/VideosManagement", "/Admin/VideosManagement/create", "/Admin/VideosManagement/update",
		"/Admin/VideosManagement/delete", "/Admin/VideosManagement/reset", "/Admin/VideosManagement/edit" })
@MultipartConfig
public class VideosManagementServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String url = req.getRequestURL().toString();
		if (url.contains("edit")) {
			edit(req, resp);
			return;
		}
		if (url.contains("delete")) {
			delete(req, resp);
			return;
		}
		if (url.contains("reset")) {
			reset(req, resp);
			return;
		}

		Video video = new Video();
		video.setPoster("images/add.JPG");

		findAll(req, resp);
		req.setAttribute("video", video);
		PageInfo.prepareAndForward(req, resp, PageType.VIDEO_MANAGEMENT_PAGE);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String url = req.getRequestURL().toString();
		if (url.contains("create")) {
			create(req, resp);
			return;
		}
		if (url.contains("delete")) {
			delete(req, resp);
			return;
		}
		if (url.contains("update")) {
			update(req, resp);
			return;
		}
		if (url.contains("reset")) {
			reset(req, resp);
			return;
		}
	}

	private void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String id = req.getParameter("videoId");

		if (id == null) {
			req.setAttribute("error", "VideoId is required");
			PageInfo.prepareAndForward(req, resp, PageType.VIDEO_MANAGEMENT_PAGE);
			return;
		}
		try {
			VideoDao dao = new VideoDao();
			Video video = dao.findById(id);
			req.setAttribute("video", video);
			findAll(req, resp);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			req.setAttribute("error", "Error" + e.getMessage());
		}
		PageInfo.prepareAndForward(req, resp, PageType.VIDEO_MANAGEMENT_PAGE);

	}

	private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String id = req.getParameter("videoId");
		if (id == null) {
			req.setAttribute("error", "VideoId is required");
			PageInfo.prepareAndForward(req, resp, PageType.VIDEO_MANAGEMENT_PAGE);
			return;
		}
		try {
			VideoDao dao = new VideoDao();
			Video video = dao.findById(id);
			if (video == null) {
				req.setAttribute("error", "Video not found");
				PageInfo.prepareAndForward(req, resp, PageType.VIDEO_MANAGEMENT_PAGE);
				return;
			}

			dao.delete(id);
			req.setAttribute("message", "video is deleted");
			req.setAttribute("video", new Video());
			findAll(req, resp);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			req.setAttribute("error", "Error" + e.getMessage());
		}
		PageInfo.prepareAndForward(req, resp, PageType.VIDEO_MANAGEMENT_PAGE);

	}

	private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		Video video = new Video();
		try {
			BeanUtils.populate(video, req.getParameterMap());

			VideoDao dao = new VideoDao();
			Video oldVideo = dao.findById(video.getVideoId());
			if (req.getPart("cover").getSize() == 0) {
				video.setPoster(oldVideo.getPoster());
			} else {
				video.setPoster(
						"uploads/" + UploadUtils.processUploadField("cover", req, "/uploads", video.getVideoId()));
			}

			dao.update(video);

			req.setAttribute("video", video);
			req.setAttribute("message", "video updated");
			findAll(req, resp);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			req.setAttribute("error", "Error" + e.getMessage());
		}
		PageInfo.prepareAndForward(req, resp, PageType.VIDEO_MANAGEMENT_PAGE);

	}

	private void findAll(HttpServletRequest req, HttpServletResponse resp) {
		try {
			VideoDao dao = new VideoDao();
			List<Video> list = dao.findALL();
			req.setAttribute("videos", list);
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "error" + e.getMessage());
		}
	}

	public void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		Video video = new Video();
		try {
			BeanUtils.populate(video, req.getParameterMap());

			video.setPoster("uploads/" + UploadUtils.processUploadField("cover", req, "/uploads", video.getVideoId()));
			VideoDao dao = new VideoDao();
			dao.insert(video);

			req.setAttribute("video", video);
			req.setAttribute("message", "Video is inserted");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			req.setAttribute("error", "Error " + e.getMessage());
		}
		findAll(req, resp);
		PageInfo.prepareAndForward(req, resp, PageType.VIDEO_MANAGEMENT_PAGE);

	}

	private void reset(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		Video video = new Video();
		video.setPoster("/images/5cm_1.jpg");
		req.setAttribute("video", new Video());
		findAll(req, resp);
		PageInfo.prepareAndForward(req, resp, PageType.VIDEO_MANAGEMENT_PAGE);
	}

}
