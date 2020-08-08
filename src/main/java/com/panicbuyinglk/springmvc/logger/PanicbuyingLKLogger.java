package com.panicbuyinglk.springmvc.logger;


import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import com.panicbuyinglk.springmvc.entity.Product;
import com.panicbuyinglk.springmvc.entity.User;
import com.panicbuyinglk.springmvc.pojo.ProductData;

public class PanicbuyingLKLogger {

	public StringBuffer writeUserLogRecord(User savedUser) {
		
		String loggingTime= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
		String loggerUniqueID = UUID.randomUUID().toString();
		String logRecordType = "user_registration_request";

		String userId = "<userid>" + savedUser.getUserId() + "</userid>";
		String userFirstName = "<userfirstname>" + savedUser.getFirstName() + "</userfirstname>";
		String userLastName = "<userlastname>" + savedUser.getLastName() + "</userlastname>";
		String userGender = "<usergender>" + savedUser.getGender() + "</usergender>";
		String userType = "<usertype>" + savedUser.getUserType().getType() + "</usertype>";
		String userPhone = "<userphone>" + savedUser.getPhone() + "</userphone>";
		String userAddress = "<useraddress>" + savedUser.getAddress() + "</useraddress>";
		String userEmail = "<useremail>" + savedUser.getEmail() + "</useremail>";

		StringBuffer buildLogRecord = new StringBuffer();
		buildLogRecord.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		buildLogRecord.append("<userregistrationrequest status=\"N\">");
		buildLogRecord.append(userId);
		buildLogRecord.append(userFirstName);
		buildLogRecord.append(userLastName);
		buildLogRecord.append(userGender);
		buildLogRecord.append(userType);
		buildLogRecord.append(userPhone);
		buildLogRecord.append(userAddress);
		buildLogRecord.append(userEmail);
		buildLogRecord.append("</userregistrationrequest>");		 


		StringBuffer LoggingBuffer = new StringBuffer();

		LoggingBuffer.append(loggingTime);
		LoggingBuffer.append("::");
		LoggingBuffer.append(logRecordType);
		LoggingBuffer.append("::");
		LoggingBuffer.append(loggerUniqueID);
		LoggingBuffer.append("::");
		LoggingBuffer.append(userId);
		LoggingBuffer.append("::");
		LoggingBuffer.append(userGender);
		LoggingBuffer.append("::");
		LoggingBuffer.append(userType);
		LoggingBuffer.append("::");
		LoggingBuffer.append(buildLogRecord);

		return LoggingBuffer;
	}

	
	public StringBuffer writeProductLogRecord(Product savedProduct, ProductData productData) {		

		 
		String loggingTime= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
		String loggerUniqueID = UUID.randomUUID().toString();		
		String logRecordType = "product_registration_request";

		String productId = "<productid>" + savedProduct.getProductId() + "</productid>";
		String productName = "<productname>" + productData.getProductName() + "</productname>";
		String qty = "<quantity>" + productData.getQyt() + "</quantity>";
		String category = "<category>" + productData.getCategory() + "</category>";
		String seller = "<seller>" + productData.getRegisteredUser().getEmail() + "</seller>";
		

		StringBuffer buildLogRecord = new StringBuffer();
		buildLogRecord.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		buildLogRecord.append("<productregistrationrequest status=\"N\">");
		buildLogRecord.append(productId);
		buildLogRecord.append(productName);
		buildLogRecord.append(qty);
		buildLogRecord.append(category);
		buildLogRecord.append(seller);
		
		buildLogRecord.append("</productregistrationrequest>");	
		

		StringBuffer LoggingBuffer = new StringBuffer();

		LoggingBuffer.append(loggingTime);
		LoggingBuffer.append("::");
		LoggingBuffer.append(logRecordType);
		LoggingBuffer.append("::");
		LoggingBuffer.append(loggerUniqueID);
		LoggingBuffer.append("::");
		LoggingBuffer.append(productId);
		LoggingBuffer.append("::");
		LoggingBuffer.append(productName);
		LoggingBuffer.append("::");
		LoggingBuffer.append(qty);
		LoggingBuffer.append("::");
		LoggingBuffer.append(category);
		LoggingBuffer.append("::");
		LoggingBuffer.append(seller);
		LoggingBuffer.append("::");
		LoggingBuffer.append(buildLogRecord);

		return LoggingBuffer;
	}
	
	
	
	public StringBuffer writeErrorLogRecord(Exception ex) {	
		
		String logRecordType = "panicbuyinglk_error";
		
		String errorInShortForm = trimStackTrace(ex,3);
		String errorClass = ex.getClass().toString();
		String errormessage = ex.getMessage();
		
		String exceptionClass = "<exceptionclass>" + errorClass+ "</exceptionclass>";
		String message = "<message>" + errormessage + "</message>";
		String location = "<location>" + errorInShortForm + "</location>";

		StringBuffer buildLogRecord = new StringBuffer();
		buildLogRecord.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		buildLogRecord.append("<panicbuyinglkerror status=\"N\">");
		buildLogRecord.append(exceptionClass);
		buildLogRecord.append(message);
		buildLogRecord.append(location);
		buildLogRecord.append("</panicbuyinglkerror>");
		
		
		String loggingTime= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));

		String loggerUniqueID = UUID.randomUUID().toString();

		StringBuffer LoggingBuffer = new StringBuffer();

		LoggingBuffer.append(loggingTime);
		LoggingBuffer.append("::");
		LoggingBuffer.append(logRecordType);
		LoggingBuffer.append("::");
		LoggingBuffer.append(loggerUniqueID);
		LoggingBuffer.append("::");
		LoggingBuffer.append(exceptionClass);
		LoggingBuffer.append("::");
		LoggingBuffer.append(message);
		LoggingBuffer.append("::");
		LoggingBuffer.append(location);
		LoggingBuffer.append("::");
		LoggingBuffer.append(buildLogRecord);

		return LoggingBuffer;
		
	}
	
	
	public String trimStackTrace(Exception e, int maxLines) {
	    StringWriter writer = new StringWriter();
	    e.printStackTrace(new PrintWriter(writer));
	    String[] lines = writer.toString().split("\n");
	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < Math.min(lines.length, maxLines); i++) {
	        sb.append(lines[i]).append("\n");
	    }
	    return sb.toString();
	}
}




