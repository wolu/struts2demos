package com.gamiao.struts2.demo.firstdemo.action.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.gamiao.struts2.demo.firstdemo.action.FirstDemo;
import com.opensymphony.xwork2.ActionSupport;

public class FristDemoTest {

	@Test
	public void testSuccess() {
		FirstDemo fristDemo = new FirstDemo();
		fristDemo.setSecret("gamiao");
		String result = fristDemo.execute();

		assertTrue("Expected a success result!", ActionSupport.SUCCESS
				.equals(result));

		final String msg = "Hello, gamiao!";
		assertTrue("Expected the default message!", msg.equals(fristDemo
				.getSecret()));
	}

	@Test
	public void testError() {
		FirstDemo fristDemo = new FirstDemo();
		fristDemo.setSecret("bug");
		String result = fristDemo.execute();

		assertTrue("Expected a success result!", ActionSupport.ERROR
				.equals(result));

		final String msg = "Hello, bug!";
		assertTrue("Expected the default message!", msg.equals(fristDemo
				.getSecret()));
	}

}
