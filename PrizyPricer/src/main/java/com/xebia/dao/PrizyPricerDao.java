package com.xebia.dao;

import java.util.List;



import com.xebia.data.Product;
import com.xebia.data.ProductLoader;

public interface PrizyPricerDao {

	public void saveProduct(Product pro);

	public void saveProductCost(ProductLoader pl);

	public Product getProductBarCode(String Barcode);

	public List<Product> getProducts();
	
	public List<ProductLoader> getProductDeatils(String Barcode);

}
