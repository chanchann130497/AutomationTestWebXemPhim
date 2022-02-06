package TestEditUser;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.poly.dao.UserDao;
import edu.poly.dao.VideoDao;
import edu.poly.model.User;
import edu.poly.model.Video;

public class TestEditUserServlet {
	
	User user = new User();
	UserDao userDao = new UserDao();
	
	@Before
	public void everyBefore() {
		user = new User();
		userDao = new UserDao();
	}
	
	@After
	public void everyAfter() {
		user = null;
		userDao = null;
	}
	
	@Test
	public void EU_01_ThemUser_Success() {	
		String username = "concobebe";
		String password = "bebanghotme";
		String fullname = "Bé Xuân Mai";
		String email = "bexuanmai@gmail.com";
		boolean role = false;
		
		user.setUsername(username);
		user.setPassword(password);
		user.setFullname(fullname);
		user.setEmail(email);
		user.setAdmin(role);
		
		boolean expected = true;
		boolean actual = false;
		try {
			userDao.insert(user);
			userDao.delete(username);
			actual = true;
		}catch(Exception e) {
			
		}
		assertEquals(expected, actual);
	}
		
	@Test
	public void EU_02_ThemUser_Fail() {
		String username = "admin";
		String password = "admin01";
		String fullname = "Doan Hoai Nam";
		String email = "nam@fpt.edu.vn";
		boolean role = true;
		
		user.setUsername(username);
		user.setPassword(password);
		user.setFullname(fullname);
		user.setEmail(email);
		user.setAdmin(role);
		
		boolean expected = false;
		boolean actual = false;
		try {
			userDao.insert(user);
			actual = true;
		}catch(Exception e) {
			
		}
		
		assertEquals(expected, actual);
	}
	
	
	@Test
	public void EU_03_ThemUser_Fail() {
		String username = "concobebe";
		String password = "bebanghotme";
		String fullname = null;
		String email = "bexuanmai@gmail.com";
		boolean role = false;
		
		user.setUsername(username);
		user.setPassword(password);
		user.setFullname(fullname);
		user.setEmail(email);
		user.setAdmin(role);
		
		boolean expected = false;
		boolean actual = false;
		try {
			userDao.insert(user);
			actual = true;
		}catch(Exception e) {
			
		}
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void EU_04_CapNhatUser_Success() {
		String username = "concobebe";
		String password = "bebanghotme2222";
		String fullname = "Bé Xuân Mai 3 Con 2k3";
		String email = "bexuanmai@gmail.com";
		boolean role = false;
		
		user.setUsername(username);
		user.setPassword(password);
		user.setFullname(fullname);
		user.setEmail(email);
		user.setAdmin(role);
		
		boolean expected = true;
		boolean actual = false;
		try {
			userDao.insert(user);
			
			user = userDao.findByUsernameAndEmail(username, email);
			
			user.setPassword("MatKhaumoi");
			user.setFullname("Hotenmoi");
			
			userDao.update(user);
			
			userDao.delete(username);
			actual = true;
		}catch(Exception e) {
			
		}
		
		assertEquals(expected, actual);
	}
	
	
	@Test
	public void EU_05_CapNhatUser_Fail() {
		String username = "concobebe";
		String password = "bebanghotme2222";
		String fullname = "Bé Xuân Mai 2k3";
		String email = "bexuanmai@gmail.com";
		boolean role = false;
		
		user.setUsername(username);
		user.setPassword(password);
		user.setFullname(fullname);
		user.setEmail(email);
		user.setAdmin(role);
		
		boolean expected = false;
		boolean actual = false;
		try {
			userDao.insert(user);
			
			user = userDao.findByUsernameAndEmail(username, email);
			
			fullname = null;
			user.setFullname(fullname);
			
			userDao.update(user);
			userDao.delete(username);
			actual = true;
		}catch(Exception e) {
			
		}finally {
			userDao.delete(username);
		}
		assertEquals(expected, actual);
	}
	
	@Test
	public void EU_06_CapNhatUser_Fail() {
		String username = "concobebe";
		String email = "bexuanmai@gmail.com";
		
		boolean expected = false;
		boolean actual = false;
		try {	
			userDao.update(user = userDao.findByUsernameAndEmail(username, email));
			actual = true;
		}catch(Exception e) {
			
		}
		assertEquals(expected, actual);
	}
	
	
	@Test
	public void EU_07_XoaUser_Success() {
		String username = "concobebe";
		String password = "bebanghotme";
		String fullname = "Bé Xuân Mai";
		String email = "bexuanmai@gmail.com";
		boolean role = false;
		
		user.setUsername(username);
		user.setPassword(password);
		user.setFullname(fullname);
		user.setEmail(email);
		user.setAdmin(role);
		
		boolean expected = true;
		boolean actual = false;
		try {
			userDao.insert(user);
			userDao.delete(username);
			actual = true;
		}catch(Exception e) {
			
		}
		assertEquals(expected, actual);
	}
	
	
	@Test
	public void EU_08_XoaUser_Fail() {
		String username = "";
		
		boolean expected = false;
		boolean actual = false;
		try {
			userDao.delete(username);
			actual = true;
		}catch(Exception e) {
			
		}
		assertEquals(expected, actual);
	}
}
