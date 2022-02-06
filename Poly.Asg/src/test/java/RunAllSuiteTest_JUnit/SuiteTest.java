package RunAllSuiteTest_JUnit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import TestDoiMatKhau.TestDoiMatKhauServlet;
import TestEditUser.TestEditUserServlet;
import TestEditVideo.TestEditVideoServlet;
import TestRegister.RegisterTest;
import edu.poly.site.servletTest.LoginServletTest;

@RunWith(Suite.class)
@Suite.SuiteClasses(
		{
			LoginServletTest.class,
			TestDoiMatKhauServlet.class,
			TestEditUserServlet.class,
			TestEditVideoServlet.class,
			RegisterTest.class
		}
)

public class SuiteTest {

}
