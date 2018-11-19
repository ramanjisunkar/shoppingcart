package com.teamsankya.shoppingcart.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.teamsankya.shoppingcart.dao.ShoppingCartDao;
import com.teamsankya.shoppingcart.dto.ProductBean;
import com.teamsankya.shoppingcart.service.ShoppingCartService;

import javassist.tools.reflect.Sample;

@Controller
public class MainController {
	
	final static Logger LOGGER = Logger.getLogger(MainController.class);
	@Autowired
	private ShoppingCartService cartservice;
	@RequestMapping(value="getdata",method =RequestMethod.GET)
	public ModelAndView productSearch(String name,ModelAndView view,@RequestParam(required = false)Integer page)
	{
		
		LOGGER.info("inside"+this.getClass().getSimpleName());
		LOGGER.info("inside productSearch() method");
		LOGGER.info("calling getDataFromServiceLayer() method");
		List<ProductBean> res=cartservice.getDataFromServiceLayer(name);
		PagedListHolder<ProductBean> pagedListHolder = new PagedListHolder<ProductBean>(res);
		pagedListHolder.setPageSize(6);
		int pag=pagedListHolder.getPageCount();
		System.out.println("page count="+pag);
		String pname=null;
		for (ProductBean product : res) {
			pname=product.getProduct_Name();
			System.out.println(product.getProduct_Name());
		}
		//below code for pagination Next and Previous
		if(pname!=null && pname.equals(name))
		{	
			view.setViewName("response.jsp");
			view.addObject("maxPages", pagedListHolder.getPageCount());
			if(page==null || page < 1 || page > pagedListHolder.getPageCount())
				page=1;
			view.addObject("page", page);
			if(page == null || page < 1 || page > pagedListHolder.getPageCount())
			{
	            pagedListHolder.setPage(0);
	            view.addObject("product", pagedListHolder.getPageList());
	            }
	            else if(page <= pagedListHolder.getPageCount())
	            {
	                pagedListHolder.setPage(page-1);
	                view.addObject("product", pagedListHolder.getPageList());
	            }
	        view.addObject("page", page);
			view.addObject("response",res);
			view.addObject("pname", pname);
			LOGGER.info("view returning from productSearch() method");
			return view;
		}
		else
		{
			view.setViewName("searchbar.jsp");
			view.addObject("response",res);
			view.addObject("pname", pname);
			view.addObject("msg","You are Search item..(" +name+ ")Not Found..Please Try Another!..");
			LOGGER.info("view returning from productSearch() method");
			return view;
		}
		
		}
	}
