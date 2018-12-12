package com.teamsankya.shoppingcart.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.criteria.internal.compile.CriteriaQueryTypeQueryAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.teamsankya.shoppingcart.controller.MainController;
import com.teamsankya.shoppingcart.dto.ProductBean;

@Repository
public class ShoppingCartDaoHiberImpl implements ShoppingCartDao {
	
	
	final static Logger LOGGER = Logger.getLogger(ShoppingCartDaoHiberImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public ProductBean getDataFromDaoLayer(int id) {
		return null;
	}
	
	@Override
	public List<ProductBean> getDataFromDaoLayerr(String name) {
		LOGGER.info("inside getDataFromDaoLayerr() of"+this.getClass().getSimpleName());
		String hql="from ProductBean where product_Name='"+name+"'";
		org.hibernate.query.Query<ProductBean>q=sessionFactory.openSession().createQuery(hql);
		List<ProductBean> res=q.list();
		LOGGER.info("db results returning from getDataFromDaoLayerr() of"+this.getClass().getSimpleName());
	
		return res;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
