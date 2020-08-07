package com.panicbuyinglk.springmvc.logger;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class PanicbuyingLKLogger {

	public StringBuffer writeLogRecord(StringBuffer buildLogRecord, String logRecordType, String userId,
			String userGender, String userType) {
			 
		String loggingTime= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));

		String loggerUniqueID = UUID.randomUUID().toString();

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

	
	public StringBuffer writeProductLogRecord(StringBuffer buildLogRecord, String logRecordType, String productId,
			String productName, String qty, String category,  String seller ) {
			 
		String loggingTime= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));

		String loggerUniqueID = UUID.randomUUID().toString();

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
}
