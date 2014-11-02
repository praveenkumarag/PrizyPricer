package com.xebia.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.xebia.data.Product;
import com.xebia.data.ProductLoader;

@Repository("prizyPricerDao")
@Component
public class PrizyPricerDaoImpl implements PrizyPricerDao{
	
	@PersistenceContext
	protected EntityManager em;
	
	@Autowired
	private DataSource dataSource;

	@Override
	@Transactional
	public void saveProduct(Product pro) {
		em.persist(pro);
		
	}

	@Override
	@Transactional
	public void saveProductCost(ProductLoader pl) {
		em.persist(pl);
		
	}

	@Override
	@Transactional
	public Product getProductBarCode(String Barcode) {
	//	String QUERY="SELECT p FROM Product p WHERE p.barCode like \" "+Barcode +"\"";
	     String QUERY="SELECT p FROM Product p WHERE p.barCode = "+Barcode ;
		System.out.println("q="+QUERY);
		Query query = this.em.createQuery(QUERY);
		System.out.println("Barcode"+Barcode);
		//query.setParameter("bcode", Barcode);
		List resultList= query.getResultList();
		if(resultList ==null || resultList.size() <=0){
			System.out.println("no recodd ");
			return null;
		}else{
			Product ptemp =(Product) resultList.get(0);
			System.out.println("bode >>>>>>>>>>."+ptemp.getBarCode());
			return ptemp;
		}
		//return CollectionUtils.isEmpty(resultList) ? null : ();
		
		
		
	} 
	
	public List<Product> getProducts(){
		String QUERY="SELECT p FROM Product p";
		Query query = this.em.createQuery(QUERY);
		List<Product> pds = query.getResultList();
		return pds;
		
	}

	@Override
	public List<ProductLoader> getProductDeatils(String Barcode) {
		String QUERY="SELECT pl FROM ProductLoader pl where pl.product.barCode = "+Barcode;
		
		System.out.println("q="+QUERY);
		Query query = this.em.createQuery(QUERY);
		System.out.println("Barcode"+Barcode);
		//query.setParameter("bcode", Barcode);
		List resultList= query.getResultList();
		if(resultList ==null || resultList.size() <=0){
			System.out.println("no recodd ");
			return null;
		}else{
			ProductLoader ptemp =(ProductLoader) resultList.get(0);
			System.out.println("bode >>>>>>>>>>."+ptemp.getProduct().getBarCode());
			return resultList;
		}
	}
	

}
