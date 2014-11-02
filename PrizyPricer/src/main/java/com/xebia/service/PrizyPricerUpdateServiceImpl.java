package com.xebia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xebia.bean.DetailedProduct;
import com.xebia.dao.PrizyPricerDao;
import com.xebia.data.Product;
import com.xebia.data.ProductLoader;
import com.xebia.util.ObejctConvertion;

@Service
public class PrizyPricerUpdateServiceImpl implements PrizyPricerUpdateService {
	@Autowired
	public PrizyPricerDao prizyPricerDao;

	public void updateData(String pbarcode, 
			String desciprtion) {
		Product p1 = new Product();
		p1.setBarCode(pbarcode);
		p1.setDescription(desciprtion);
		
		prizyPricerDao.saveProduct(p1);
	}
	
	
	public void savePrductLoader(String pbarcode, String pprice, String pstore,
			String pnotes) {
		System.out.println("pbarcode"+pbarcode);
		Product p1 = prizyPricerDao.getProductBarCode(pbarcode);
		if(p1== null ){
			System.out.println("No product is avalibale with that name ");
			return;
		}
		ProductLoader pol = new ProductLoader();
		pol.setProduct(p1);
		pol.setNote(pnotes);
		pol.setStore(pstore);
		pol.setPrice(Float.parseFloat(pprice));
		prizyPricerDao.saveProductCost(pol);
		System.out.println("product stored sucessfully ");
	}
	
	public List<Product> getAllProductsforAdmin(){
		
		return prizyPricerDao.getProducts();
	}


	@Override
	public DetailedProduct getProductDeatils(String Barcode) {
		List<ProductLoader> pls= prizyPricerDao.getProductDeatils(Barcode);
		DetailedProduct dp = ObejctConvertion.getDetailedProduct(pls);
		System.out.println("Datiled Product"+dp.toString());
		return dp;
	}
}
