package com.teamsankya.shoppingcart.jwebunittest;

import org.junit.Test;

import junit.framework.TestCase;
import net.sourceforge.jwebunit.WebTester;

public class SearchBarTest extends TestCase {
	private WebTester tester=new WebTester();
	private static final String BASE_URL="http://localhost:8080/shoppingcart/";
	@Override
	protected void setUp() throws Exception {
		tester.getTestContext().setBaseUrl(BASE_URL);
	
	}
	@Test
	public void testCase1() {
		tester.beginAt("searchbar.jsp");
		tester.assertFormPresent();
		tester.setFormElement("name", "bbok");
		tester.submit();
		tester.assertTitleEquals("sucess page");
		
		
		
		
		
	}

}
