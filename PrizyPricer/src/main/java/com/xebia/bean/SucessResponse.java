package com.xebia.bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement(name="sucess")
public class SucessResponse {

	@XmlElement(name = "type")
	private String type;

	@XmlElement(name = "sucessCode")
	private int sucessCode;

	@XmlElement(name = "sucessMessage")
	private String sucessMessage;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getSucessCode() {
		return sucessCode;
	}

	public void setSucessCode(int sucessCode) {
		this.sucessCode = sucessCode;
	}

	public String getSucessMessage() {
		return sucessMessage;
	}

	public void setSucessMessage(String sucessMessage) {
		this.sucessMessage = sucessMessage;
	}

}
