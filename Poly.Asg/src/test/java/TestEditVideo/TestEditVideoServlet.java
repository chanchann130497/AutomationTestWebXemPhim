package TestEditVideo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.poly.dao.VideoDao;
import edu.poly.model.Video;

public class TestEditVideoServlet {
	Video video = new Video();
	VideoDao videoDao = new VideoDao();
	@Before
	public void everyBefore() {
		video = new Video();
		videoDao = new VideoDao();
	}
	@After
	public void everyAfter() {
		video = null;
		videoDao = null;
	}
	@Test
	public void EV_01_ThemVideo_Success() {	
		String videoId = "OP";
		String tittle = "Anime";
		int count = 10;
		String poster = "videoposter.jpg";
		boolean isActive = true;
		String description = "One Piece";
		
		video.setVideoId(videoId);
		video.setTitle(tittle);
		video.setPoster(poster);
		video.setViews(count);
		video.setActive(isActive);
		video.setDescription(description);
		
		boolean expected = true;
		boolean actual = false;
		try {
			videoDao.insert(video);
			videoDao.delete(videoId);
			actual = true;
		}catch(Exception e) {
			
		}
		assertEquals(expected, actual);
	}
		
	@Test
	public void EV_02_ThemVideo_Fail() {
		String videoId = "V01";
		String tittle = "Anime";
		int count = 10;
		String poster = "videoposter.jpg";
		boolean isActive = true;
		String description = "One Piece";
		
		video.setVideoId(videoId);
		video.setTitle(tittle);
		video.setPoster(poster);
		video.setViews(count);
		video.setActive(isActive);
		video.setDescription(description);
		
		boolean expected = false;
		boolean actual = false;
		try {
			videoDao.insert(video);
			actual = true;
		}catch(Exception e) {
			
		}
		
		assertEquals(expected, actual);
	}
	
	
	@Test
	public void EV_03_ThemVideo_Fail() {
		String videoId = "OP";
		String tittle = null;
		int count = 10;
		String poster = null;
		boolean isActive = true;
		String description = "One Piece";
		
		video.setVideoId(videoId);
		video.setTitle(tittle);
		video.setPoster(poster);
		video.setViews(count);
		video.setActive(isActive);
		video.setDescription(description);
		
		boolean expected = false;
		boolean actual = false;
		try {
			videoDao.insert(video);
//			videoDao.delete(videoId);
			actual = true;
		}catch(Exception e) {
			
		}
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void EV_04_CapNhatVideo_Success() {
		String videoId = "OP";
		String tittle = "Anime";
		int count = 10;
		String poster = "videoposter.jpg";
		boolean isActive = true;
		String description = "One Piece";
		
		video.setVideoId(videoId);
		video.setTitle(tittle);
		video.setPoster(poster);
		video.setViews(count);
		video.setActive(isActive);
		video.setDescription(description);
		
		boolean expected = true;
		boolean actual = false;
		try {
			videoDao.insert(video);
			
			video = videoDao.findById(videoId);
			
			count = 100;
			poster = "videoposter123.jpg";
			description = "One Piece Update";
			
			video.setPoster(poster);
			video.setViews(count);
			video.setDescription(description);
			
			videoDao.update(video);
			
			videoDao.delete(videoId);
			actual = true;
		}catch(Exception e) {
			
		}
		
		assertEquals(expected, actual);
	}
	
	
	@Test
	public void EV_05_CapNhatVideo_Fail() {
		String videoId = "OP";
		String tittle = "Anime";
		int count = 10;
		String poster = "videoposter.jpg";
		boolean isActive = true;
		String description = "One Piece";
		
		video.setVideoId(videoId);
		video.setTitle(tittle);
		video.setPoster(poster);
		video.setViews(count);
		video.setActive(isActive);
		video.setDescription(description);
		
		boolean expected = false;
		boolean actual = false;
		try {
			videoDao.insert(video);
			
			video = videoDao.findById(videoId);
			
			tittle = null;
			poster = null;
			
			video.setPoster(poster);
			video.setTitle(tittle);
			
			videoDao.update(video);
		
			actual = true;
		}catch(Exception e) {
			
		}finally {
			videoDao.delete(videoId);
		}
		assertEquals(expected, actual);
	}
	
	@Test
	public void EV_06_CapNhatVideo_Fail() {
		String videoId = "OP123";
		
		String tittle = "Anime";
		int count = 10;
		String poster = "videoposter.jpg";
		boolean isActive = true;
		String description = "One Piece";
		
		boolean expected = false;
		boolean actual = false;
		try {	
			videoDao.update(video = videoDao.findById(videoId));
			actual = true;
		}catch(Exception e) {
			
		}
		assertEquals(expected, actual);
	}
	
	
	@Test
	public void EV_07_XoaVideo_Success() {
		String videoId = "OP";
		String tittle = "Anime";
		int count = 10;
		String poster = "videoposter.jpg";
		boolean isActive = true;
		String description = "One Piece";
		
		video.setVideoId(videoId);
		video.setTitle(tittle);
		video.setPoster(poster);
		video.setViews(count);
		video.setActive(isActive);
		video.setDescription(description);
		
		boolean expected = true;
		boolean actual = false;
		try {
			videoDao.insert(video);
			videoDao.delete(videoId);
			actual = true;
		}catch(Exception e) {
			
		}
		assertEquals(expected, actual);
	}
	
	
	@Test
	public void EV_08_XoaVideo_Fail() {
		String videoId = null;
		
		boolean expected = false;
		boolean actual = false;
		try {
			videoDao.delete(videoId);
			actual = true;
		}catch(Exception e) {
			
		}
		assertEquals(expected, actual);
	}
}
