package TestDoiMatKhau;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import edu.poly.dao.UserDao;
import edu.poly.model.User;

public class TestDoiMatKhauServlet {

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
	public void DMK_01_DoiMatKhau_Success() {
		String taikhoan = "user02";
		String matkhau = "123";
		String matkhaumoi = "12345";
		String xacnhanmatkhau = "12345";

		boolean expected = true;
		boolean actual = false;
		try {
			user = userDao.findById(taikhoan);
			user.setPassword(xacnhanmatkhau);
			userDao.update(user);
			actual = true;
		} catch (Exception e) {

		}

		assertEquals(expected, actual);
	}

	@Test
	public void DMK_02_DoiMatKhau_Failed() {
		String taikhoan = "user02";
		String matkhau = "1";
		String matkhaumoi = "12345";
		String xacnhanmatkhau = "12345";

		boolean expected = false;
		boolean actual = true;
		user = userDao.findById(taikhoan);
		if (!user.getPassword().equals(matkhau)) {
			actual = false;
		}
		assertEquals(expected, actual);
	}
	
	@Test
	public void DMK_03_DoiMatKhau_Failed() {
		String taikhoan = "user02";
		String matkhau = "123";
		String matkhaumoi = "12345";
		String xacnhanmatkhau = "1";

		boolean expected = false;
		boolean actual = true;
		
		if(!matkhaumoi.equals(xacnhanmatkhau)) actual = false;
		
		assertEquals(expected, actual);
	}

	
	@Test
	public void DMK_04_DoiMatKhau_Failed() {
		String taikhoan = "user02";
		String matkhau = null;
		String matkhaumoi = "12345";
		String xacnhanmatkhau = "1";

		boolean expected = false;
		boolean actual = true;
		
		user = userDao.findById(taikhoan);
		if (!user.getPassword().equals(matkhau)) {
			actual = false;
		}
		
		assertEquals(expected, actual);
	}

	@Test
	public void DMK_05_DoiMatKhau_Failed() {
		String taikhoan = "user02";
		String matkhau = "123";
		String matkhaumoi = null;
		String xacnhanmatkhau = "12345";

		boolean expected = false;
		boolean actual = true;
		
		if(matkhaumoi == null) actual = false;
		
		assertEquals(expected, actual);
	}
	
	
	@Test
	public void DMK_06_DoiMatKhau_Failed() {
		String taikhoan = "user02";
		String matkhau = "123";
		String matkhaumoi = "12345";
		String xacnhanmatkhau = null;

		boolean expected = false;
		boolean actual = true;
		
		if(xacnhanmatkhau == null) actual = false;
		
		assertEquals(expected, actual);
	}
	
}
