package edu.poly.site.servletTest;


import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class ParaTest {
	private String acc;
	private String pass;
	private boolean expectedRs;
	private LoginTest lg;
	
	public ParaTest(String acc, String pass, boolean expectedRs) {
		super();
		this.acc = acc;
		this.pass = pass;
		this.expectedRs = expectedRs;
	}
	
	@Before
	public void initialize() {
		lg = new LoginTest();
	}
	
	@Parameterized.Parameters
	public static Collection input() {
		return Arrays.asList(new Object[][] {
			{"user01", "124", false},
			{"user0199", "125", false},
			{"user999", "123", false},
			{"", "", false},
			{"", "123", false},
			{"user02", "", false},
			{"", "pppp", false},
			{"taikhoanchuatontai", "", false},
		});
	}
	
	@Test
	public void testParaLogin() {
		assertEquals(expectedRs, lg.ans(acc, pass));
	}
}








