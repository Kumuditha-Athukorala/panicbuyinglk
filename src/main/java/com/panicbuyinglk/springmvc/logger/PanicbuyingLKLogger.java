package com.panicbuyinglk.springmvc.logger;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class PanicbuyingLKLogger {

	public StringBuffer writeLogRecord(StringBuffer buildLogRecord,String logRecordType,String userId, String userGender, String userType) {

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:MM:ss.SSS");

		String loggingTime = dateFormat.format(new Date());
		
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

}
