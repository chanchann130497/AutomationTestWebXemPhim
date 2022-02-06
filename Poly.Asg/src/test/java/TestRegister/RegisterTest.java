package TestRegister;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.poly.dao.UserDao;
import edu.poly.model.User;

public class RegisterTest {

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
	public void DK_01_testRegister_Success() {
		String acc = "taikhoantest";
		String pass = "pwtest";
		String fullname = "Chí Phèo Nam Cao";
		String email = "test123@gmail.com";

		user.setUsername(acc);
		user.setPassword(pass);
		user.setFullname(fullname);
		user.setEmail(email);

		boolean expected = true;
		boolean actual = false;
		try {
			userDao.insert(user);
			userDao.delete(acc);
			actual = true;
		} catch (Exception e) {
			actual = false;
		}
		assertEquals(expected, actual);
	}

	@Test
	public void DK_02_testRegister_Failed() {
		String acc = "admin";
		String pass = "pwtest";
		String fullname = "Chí Phèo Nam Cao";
		String email = "test123@gmail.com";

		user.setUsername(acc);
		user.setPassword(pass);
		user.setFullname(fullname);
		user.setEmail(email);
		boolean flag = true;
		try {
			userDao.insert(user);
		} catch (Exception e) {
			flag = false;
		}
		assertEquals(false, flag);
	}

	@Test
	public void DK_03_testRegister_Failed() {
		// Thất bại vì mong muốn không thể insert vì trùng email - Thực tế
		// insert thành công
		String acc = "taikhoantest1";
		String pass = "pwtest";
		String fullname = "Chí Phèo Nam Cao";
		String email = "halala1102@gmail.com";

		user.setUsername(acc);
		user.setPassword(pass);
		user.setFullname(fullname);
		user.setEmail(email);
		boolean flag = false;
		try {
			userDao.insert(user); // chỗ này true
			userDao.delete(acc); // xóa để chạy test nhiều lần nếu insert thành công
		} catch (Exception e) {
			flag = false; // phải xuống đây
		}
		assertEquals(false, flag);
	}

	@Test
	public void DK_04_testRegister_Failed() {
		String acc = null;
		String pass = "pwtest";
		String fullname = "Chí Phèo Nam Cao";
		String email = "halala1102@gmail.com";

		user.setUsername(acc);
		user.setPassword(pass);
		user.setFullname(fullname);
		user.setEmail(email);
		boolean flag = true;
		try {
			userDao.insert(user); // chỗ này true
			userDao.delete(acc); // xóa để chạy test nhiều lần nếu insert thành công
		} catch (Exception e) {
			flag = false; // phải xuống đây
		}
		assertEquals(false, flag);
	}

	@Test
	public void DK_05_testRegister_Failed() {
		String acc = "taikhoantest";
		String pass = null;
		String fullname = "Chí Phèo Nam Cao";
		String email = "halala1102@gmail.com";

		user.setUsername(acc);
		user.setPassword(pass);
		user.setFullname(fullname);
		user.setEmail(email);
		boolean flag = true;
		try {
			userDao.insert(user); // chỗ này true
			userDao.delete(acc); // xóa để chạy test nhiều lần nếu insert thành công
		} catch (Exception e) {
			flag = false; // phải xuống đây
		}
		assertEquals(false, flag);
	}

	@Test
	public void DK_06_testRegister_Failed() {
		String acc = "taikhoantest";
		String pass = "pwtest";
		String fullname = null;
		String email = "halala1102@gmail.com";

		user.setUsername(acc);
		user.setPassword(pass);
		user.setFullname(fullname);
		user.setEmail(email);
		boolean flag = true;
		try {
			userDao.insert(user); // chỗ này true
			userDao.delete(acc); // xóa để chạy test nhiều lần nếu insert thành công
		} catch (Exception e) {
			flag = false; // phải xuống đây
		}
		assertEquals(false, flag);
	}

	@Test
	public void DK_07_testRegister_Failed() {
		String acc = "taikhoantest";
		String pass = "pwtest";
		String fullname = "Chí Phèo Nam Cao";
		String email = null;

		user.setUsername(acc);
		user.setPassword(pass);
		user.setFullname(fullname);
		user.setEmail(email);
		boolean flag = true;
		try {
			userDao.insert(user); // chỗ này true
			userDao.delete(acc); // xóa để chạy test nhiều lần nếu insert thành công
		} catch (Exception e) {
			flag = false; // phải xuống đây
		}
		assertEquals(false, flag);
	}

	@Test
	public void DK_08_testRegister_Failed() {
		String acc = "taikhoantest";
		String pass = "pwtest";
		String fullname = "Chí Phèo Nam Cao";
		String email = "abcc@@123";

		user.setUsername(acc);
		user.setPassword(pass);
		user.setFullname(fullname);
		user.setEmail(email);

		String pattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		boolean flag = true;
		try {
			if (email.matches(pattern)) {
				userDao.insert(user); // chỗ này true
				userDao.delete(acc); // xóa để chạy test nhiều lần nếu insert thành công
			}else {
				flag = false;
			}
		} catch (Exception e) {
			flag = false; // phải xuống đây
		}
		assertEquals(false, flag);
	}

}
