package com.xebia.service;

import java.util.List;

import com.xebia.bean.DetailedProduct;
import com.xebia.data.Product;
import com.xebia.data.ProductLoader;

public interface PrizyPricerUpdateService {
	public void updateData(String pbarcode, String desciprtion);

	public void savePrductLoader(String pbarcode, String pprice, String pstore,
			String pnotes);

	List<Product> getAllProductsforAdmin();
	public DetailedProduct getProductDeatils(String Barcode);
}
