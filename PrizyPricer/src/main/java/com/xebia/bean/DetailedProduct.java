package com.xebia.bean;

public class DetailedProduct {

	

	private String barCode;
	private String description;
	private float avgprice;
	private float lowprice;
	private float highprice;
	private float idealprice;

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getAvgprice() {
		return avgprice;
	}

	public void setAvgprice(float avgprice) {
		this.avgprice = avgprice;
	}

	public float getLowprice() {
		return lowprice;
	}

	public void setLowprice(float lowprice) {
		this.lowprice = lowprice;
	}

	public float getHighprice() {
		return highprice;
	}

	public void setHighprice(float highprice) {
		this.highprice = highprice;
	}

	public float getIdealprice() {
		return idealprice;
	}

	public void setIdealprice(float idealprice) {
		this.idealprice = idealprice;
	}
	
	
	@Override
	public String toString() {
		return "DetailedProduct [barCode=" + barCode + ", description="
				+ description + ", avgprice=" + avgprice + ", lowprice="
				+ lowprice + ", highprice=" + highprice + ", idealprice="
				+ idealprice + "]";
	}

}
