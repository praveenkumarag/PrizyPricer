package com.xebia.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "type",
    "errorCode",
    "errorMessage"
})

public class ErrorResponse {

	@XmlElement(name="type")
	private String type;

	@XmlElement(name="errorCode")
	private int errorCode;

	@XmlElement(name="errorMessage")
	private String errorMessage;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
}
