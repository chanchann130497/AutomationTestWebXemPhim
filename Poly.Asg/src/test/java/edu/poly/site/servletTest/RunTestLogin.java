package edu.poly.site.servletTest;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;


public class RunTestLogin {
	public static void main(String[] args) {
		Result rs = JUnitCore.runClasses(ParaTest.class);
		for(Failure f : rs.getFailures()) {
			System.out.println(f.toString());
		}
		System.out.println("Result == " + rs.wasSuccessful());
	}
}
