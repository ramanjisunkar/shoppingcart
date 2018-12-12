package com.teamsankya.shoppingcart.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.teamsankya.shoppingcart.dao.ShoppingCartDao;
import com.teamsankya.shoppingcart.dao.ShoppingCartDaoHiberImpl;
import com.teamsankya.shoppingcart.dto.ProductBean;

@Service
public class ShoppingCartService {
	final static Logger LOGGER = Logger.getLogger(ShoppingCartDaoHiberImpl.class);
	@Autowired
	private ShoppingCartDao shopcartdao;
	
	public List<ProductBean> getDataFromServiceLayer(String name)
	{
		LOGGER.info("inside"+this.getClass().getSimpleName());
		LOGGER.info("calling getDataFromDaoLayerr() from getDataFromServiceLayer () of"+this.getClass().getSimpleName());
		List<ProductBean> res=shopcartdao.getDataFromDaoLayerr(name);
		LOGGER.info(" returning db results form getDataFromServiceLayer of"+this.getClass().getSimpleName());
		return res;
	}
	

}
