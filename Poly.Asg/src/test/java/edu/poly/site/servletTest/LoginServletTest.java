package edu.poly.site.servletTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import edu.poly.dao.UserDao;
import edu.poly.model.User;

public class LoginServletTest {
	UserDao userDao = new UserDao();
	User user = new User();
	@Before
	public void everyBefore() {
		userDao = new UserDao();
		user = new User();
	}
	@After
	public void everyAfter() {
		userDao = null;
		user = null;
	}
	
	@Test
	public void DN_01_testLogin_User_Success() {
		String account = "user02";
		String pass = "123";
		boolean expected = true;
		boolean result = false;
		boolean tonTaiAccount = userDao.findById(account) != null ? true : false;
		if (tonTaiAccount) {
			user = userDao.findById(account);
			if (!user.getAdmin() && pass.equals(user.getPassword())) {result = true;}
		}
		assertEquals(expected, result);
	}
	@Test
	public void DN_02_testLogin_Admin_Success() {
		String account = "admin";
		String pass = "admin01";
		boolean expected = true;
		boolean result = false;
		boolean tonTaiAccount = userDao.findById(account) != null ? true : false;
		if (tonTaiAccount) {
			user = userDao.findById(account);
			if (user.getAdmin() && pass.equals(user.getPassword())) {result = true;}
		}
		assertEquals(expected, result);
	}
	
	@Test
	public void DN_03_testLogin_User_Fail() {
		String account = "user01";
		String pass = "124";
		boolean expected = false;
		boolean result = false;
		boolean tonTaiAccount = userDao.findById(account) != null ? true : false;
		if (tonTaiAccount) {
			user = userDao.findById(account);
			if (pass.equals(user.getPassword())) {result = true;}
		}
		assertEquals(expected, result);
	}
}
