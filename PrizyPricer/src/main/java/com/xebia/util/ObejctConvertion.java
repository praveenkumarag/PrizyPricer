package com.xebia.util;

import java.util.Collections;
import java.util.List;

import com.xebia.bean.DetailedProduct;
import com.xebia.data.ProductLoader;

public class ObejctConvertion {
   static float  avgP=0.0f;
	public static DetailedProduct getDetailedProduct(List<ProductLoader> pls) {
		DetailedProduct dp = new DetailedProduct();
		PriceComparator pricecomparator = new PriceComparator();
		if (pls == null && pls.size() <= 0) {
			return null;
		} else if (pls.size() == 1) {
			dp.setBarCode(pls.get(0).getProduct().getBarCode());
			dp.setDescription(pls.get(0).getProduct().getDescription());
			dp.setAvgprice(pls.get(0).getPrice());
			dp.setLowprice(pls.get(0).getPrice());
			dp.setHighprice(pls.get(0).getPrice());
			dp.setIdealprice(pls.get(0).getPrice());
		} else if (pls.size() == 5) {
			Collections.sort(pls, pricecomparator);

			for (ProductLoader pl : pls) {
				System.out.println("--->" + pl.getPrice());
				avgP =avgP+pl.getPrice();
			}
			dp.setBarCode(pls.get(0).getProduct().getBarCode());
			dp.setDescription(pls.get(0).getProduct().getDescription());
			dp.setAvgprice(avgP/pls.size());
			dp.setLowprice(pls.get(0).getPrice());
			dp.setHighprice(pls.get(pls.size()-1).getPrice());
			
			dp.setIdealprice(pls.get(0).getPrice());


		}else if(pls.size() >5){
			Collections.sort(pls, pricecomparator);
			for (int i = 2; i < pls.size()-2; i++) 				
		  {
				System.out.println("--->" + pls.get(i).getPrice());
				avgP =avgP+pls.get(i).getPrice();
			}
			dp.setBarCode(pls.get(0).getProduct().getBarCode());
			dp.setDescription(pls.get(0).getProduct().getDescription());
			dp.setAvgprice(avgP/pls.size());
			dp.setLowprice(pls.get(0).getPrice());
			dp.setHighprice(pls.get(pls.size()-1).getPrice());
			
			dp.setIdealprice(avgP/pls.size()-4);
		}

		return dp;

	}

}
