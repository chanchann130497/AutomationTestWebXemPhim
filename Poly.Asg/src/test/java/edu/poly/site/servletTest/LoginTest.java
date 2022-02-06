package edu.poly.site.servletTest;

import edu.poly.dao.UserDao;
import edu.poly.model.User;

public class LoginTest {
	public boolean ans(String account, String pass) {
		UserDao uDao = new UserDao();
		User u = new User();
		boolean tonTaiAccount = uDao.findById(account) != null ? true : false;
		if (tonTaiAccount) {
			u = uDao.findById(account);
			if (pass.equals(u.getPassword())) {
				return true;
			}
		}
		return false;
	}
}
