package com.teamsankya.shoppingcart.dao;

import java.util.List;

import com.teamsankya.shoppingcart.dto.ProductBean;

public interface ShoppingCartDao {
	
	public ProductBean getDataFromDaoLayer(int id);
	public List<ProductBean> getDataFromDaoLayerr(String name);

}
