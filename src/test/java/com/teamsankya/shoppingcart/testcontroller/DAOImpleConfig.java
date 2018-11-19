package com.teamsankya.shoppingcart.testcontroller;

import org.apache.commons.pool.impl.GenericKeyedObjectPool.Config;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.teamsankya.shoppingcart.dao.ShoppingCartDao;
import com.teamsankya.shoppingcart.dao.ShoppingCartDaoHiberImpl;
import com.teamsankya.shoppingcart.service.ShoppingCartService;

@Configuration
public class DAOImpleConfig {
	public static void main(String[] args) {
		ApplicationContext applicationContext=new AnnotationConfigApplicationContext(MianControllerTest.class);
		ShoppingCartService implTest=applicationContext.getBean(ShoppingCartService.class);
		ShoppingCartDao dao = applicationContext.getBean(ShoppingCartDao.class);
		System.out.println(implTest);
		System.out.println(dao);
		System.out.println(implTest.getDataFromServiceLayer("pen"));
	}
	@Bean(name="dao")
	public ShoppingCartDaoHiberImpl getDAO() {
		return new ShoppingCartDaoHiberImpl();
	}
	@Bean(name="service")
	public ShoppingCartService getService() {
		return new ShoppingCartService();
	}
	@Bean
	public SessionFactory getSessionFactory() {
		return new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
	}
}
