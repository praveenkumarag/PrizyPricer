/**
 * @author praveen
 * 
 */
package com.xebia.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.xebia.bean.DetailedProduct;
import com.xebia.data.Product;
import com.xebia.service.PrizyPricerUpdateService;
import com.xebia.util.PrizyPricerUtil;

@Controller
public class PrizyPricerController {
	@Autowired
	public PrizyPricerUpdateService prizypricerupdateservice;

	private static final Logger logger = LoggerFactory.getLogger(PrizyPricerController.class);

	/*
	 * this is Extra  API for adding products to the database. 
	 * 
	 */
	
	@RequestMapping(value ="/addproduct" , method = RequestMethod.POST)
	public void addUser(
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(required = false, defaultValue = "") String pbarcode,
			@RequestParam(required = false, defaultValue = "Help ful product ") String pnotes
			){
		//logger.info("BarCode="+pbarcode+"Description="+Store="+pstore+");
		
		//public void updateData(pbarcode,pprice,pstore, pnotes);
		prizypricerupdateservice.updateData(pbarcode, pnotes);
		PrizyPricerUtil.generateResponse(request, PrizyPricerUtil.createSucessObject("Inserted Sucessfully"), response);
		
	}
	/*
	 * this 
	 * 
	 */
	@RequestMapping(value ="/addproductcost" , method = RequestMethod.POST)
	public void addproductCost(
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(required = false, defaultValue = "") String pbarcode,
			@RequestParam(required = false, defaultValue = "100") String pprice,
			@RequestParam(required = false, defaultValue = "apple") String pstore,
			@RequestParam(required = false, defaultValue = "Help ful product ") String pnotes
			){
		logger.info("BarCode="+pbarcode+"Description ="+pprice+"Store="+pstore+"Notes="+pnotes);
		
		//public void updateData(pbarcode,pprice,pstore, pnotes);
		prizypricerupdateservice.savePrductLoader( pbarcode, pprice,  pstore, pnotes);
		PrizyPricerUtil.generateResponse(request, PrizyPricerUtil.createSucessObject("Inserted Sucessfully"), response);
		
		
	}
	
	@RequestMapping(value = "/listproducts", method = RequestMethod.GET)
	public void listProductForAdmin(
			HttpServletRequest request,
			HttpServletResponse response
			) {

		logger.debug("welcome() - name {}" );

		ModelAndView model = new ModelAndView();
		model.setViewName("index");
	//	model.addObject("name", name);
	List<Product> pds=	prizypricerupdateservice.getAllProductsforAdmin();
	System.out.println("Number of products "+pds.size());
	
	PrizyPricerUtil.generateResponse(request, pds, response);
	}
	
	@RequestMapping(value = "/productview/{pbarcode:.+}", method = RequestMethod.GET)
	public void productView(
			HttpServletRequest request,
			HttpServletResponse response,
			@PathVariable("pbarcode") String pbarcode) {

		logger.debug("welcome() - name {}", pbarcode);
		DetailedProduct 	dp =	prizypricerupdateservice.getProductDeatils(pbarcode);
		PrizyPricerUtil.generateResponse(request,dp, response);

	}
	
	
	/*
	 * dummy API 
	 */
	
	@RequestMapping(value = "/hello/{name:.+}", method = RequestMethod.GET)
	public ModelAndView welcome(@PathVariable("name") String name) {

		logger.debug("welcome() - name {}", name);

		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		model.addObject("name", name);

		return model;

	}

}
