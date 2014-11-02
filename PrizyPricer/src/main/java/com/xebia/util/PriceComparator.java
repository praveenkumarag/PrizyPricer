package com.xebia.util;

import java.util.Comparator;

import com.xebia.data.ProductLoader;

public class PriceComparator implements Comparator<ProductLoader> {

		@Override
		public int compare(ProductLoader o1, ProductLoader o2) {
	        return Float.compare(o1.getPrice(), o2.getPrice());
	    }
}
