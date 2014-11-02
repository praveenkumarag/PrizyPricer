package com.xebia.util;
import java.io.IOException;
import java.io.Writer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//
//import org.apache.commons.httpclient.HttpStatus;
//import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.google.gson.Gson;
import com.xebia.bean.SucessResponse;
import com.xebia.controller.PrizyPricerController;


public class PrizyPricerUtil {
	private static final Logger logger = LoggerFactory.getLogger(PrizyPricerUtil.class);
	public static String generateResponse(HttpServletRequest request,
			Object obj, HttpServletResponse response) {
		String accept = request.getHeader("Accept");
		String responseMessage = "";

		// if("text/javascript".equals(accept)) {
		Gson gson = new Gson();
		// logger.info("Json response "+gson.toJson(obj) );
		response.setContentType("application/json");
		responseMessage = gson.toJson(obj);
		String jsCallback = request.getParameter("callback");
//		if (!StringUtils.isBlank(jsCallback)) {
//			responseMessage = jsCallback + "(" + responseMessage + ")";
//		}
		/*
		 * } else { StringWriter xml = new StringWriter();
		 * jaxbMarshallerNoSchema.marshal(obj, new StreamResult(xml));
		 * logger.info("XmL response :"+xml.toString());
		 * response.setContentType("application/xml;charset=ISO-8859-1");
		 * response.setHeader("Accept", "application/xml"); responseMessage =
		 * xml.toString(); }
		 */

		// logger.info("Accept :"+accept);
		// logger.info(responseMessage);
		System.out.println(responseMessage);
		try {
			Writer out = response.getWriter();
			out.write(responseMessage);
		} catch (IOException ex1) {
			// logger.fatal(ex1);
			// logger.info("Unable to return Responsemessage:"+responseMessage);
		}
		return null;
	}

	@ExceptionHandler
	public void handleException(HttpServletRequest request,
			HttpServletResponse response, Exception ex) {

		logger.info("Exception:" + ex.getMessage());
		ex.printStackTrace();
		com.xebia.bean.ErrorResponse err = new com.xebia.bean.ErrorResponse();

		if (ex instanceof PrizyPricerException) {
			if (ex.getMessage().equals("UNSUPPORTED_SERVICE")) {
				err.setType("Exception");
				err.setErrorCode(302);
				err.setErrorMessage("Requested service is not supported");
			//	response.setStatus(HttpStatus.SC_NOT_FOUND);
			} else {
				err.setType("Exception");
				err.setErrorCode(300);
				err.setErrorMessage(ex.getMessage());
			//	response.setStatus(HttpStatus.SC_BAD_REQUEST);
			}
		} else if (ex instanceof HttpRequestMethodNotSupportedException) {
			err.setErrorCode(301);
			err.setType("Exception");
			err.setErrorMessage("Invalid Method not Supported");
		//	response.setStatus(HttpStatus.SC_METHOD_NOT_ALLOWED);
		} else {
			err.setErrorCode(204);
			err.setType("InternalException");
			err.setErrorMessage("Something went wrong at server");
			//response.setStatus(HttpStatus.SC_INTERNAL_SERVER_ERROR);
		}

		String errMessage = generateResponse(request, err, response);
		logger.info(errMessage);
	}

	public static SucessResponse createSucessObject(String sucessMessage) {
		com.xebia.bean.SucessResponse sucess = new SucessResponse();
		sucess.setSucessCode(0);
		sucess.setSucessMessage(sucessMessage);
		sucess.setType("sucess");
		return sucess;

	}

}
