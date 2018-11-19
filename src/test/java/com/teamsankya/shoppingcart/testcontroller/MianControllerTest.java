package com.teamsankya.shoppingcart.testcontroller;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.teamsankya.shoppingcart.dao.ShoppingCartDao;
import com.teamsankya.shoppingcart.dao.ShoppingCartDaoHiberImpl;
import com.teamsankya.shoppingcart.dto.ProductBean;
import com.teamsankya.shoppingcart.service.ShoppingCartService;

import junit.framework.TestCase;

public class MianControllerTest extends TestCase{
	
	@Test
	public void productSearchTest()
	{
		
		ApplicationContext applicationContext=new AnnotationConfigApplicationContext(DAOImpleConfig.class);
		String pname="pen";
		ShoppingCartService servimp=applicationContext.getBean(ShoppingCartService.class);
		List<ProductBean> actual= servimp.getDataFromServiceLayer(pname);
		// valid test data
		assertEquals(actual.get(0).getProduct_Name(),"pen");
		assertEquals(actual.get(0).getProduct_disc(),"good writing");
		assertEquals(actual.get(0).getProduct_Price(),15.0);
		assertEquals(actual.get(0).getProduct_Id(),1);
		// invalid test data
		
		/*assertEquals(actual.get(0).getpName(),"pen");
		assertEquals(actual.get(0).getPdisc(),"good ");
		assertEquals(actual.get(0).getpPrice(),1.0);
		assertEquals(actual.get(0).getpId(),1);*/
		
			
	}

}
