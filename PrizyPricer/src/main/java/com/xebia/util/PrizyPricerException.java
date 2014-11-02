package com.xebia.util;

public class PrizyPricerException extends Exception {
	public PrizyPricerException(){
		super();
	}
	public PrizyPricerException(String message){
		super(message);
	}
//	public VPPException(String message, Throwable cause){
//		super(message);
//	}
	
	public PrizyPricerException(Throwable cause){
		super(cause);
	}

}
