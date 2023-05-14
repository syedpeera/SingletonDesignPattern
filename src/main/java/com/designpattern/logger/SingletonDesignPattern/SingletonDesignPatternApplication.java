package com.designpattern.logger.SingletonDesignPattern;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SingletonDesignPatternApplication {

	public static void main(String[] args) {
		SpringApplication.run(SingletonDesignPatternApplication.class, args);
		Logger logger1 = Logger.getLoggerInstance();
		logger1.logInfo("Logger1: Logger Information");
		
		Logger logger2 = Logger.getLoggerInstance();
		logger2.logError("Logger2: Logger Error");
		
		System.out.println("Total Instances: "+Logger.getLoggerInstanceCount());
		
		Thread thread1 = new Thread(()->{
			Logger logger3 = Logger.getLoggerInstance();
			logger3.logWarning("Thread1 - Logger3: Logger Warning");
		});
		
		Thread thread2 = new Thread(()->{
			Logger logger4 = Logger.getLoggerInstance();
			logger4.logInfo("Thread2 - Logger4: Logger Information");
		});
		
		Thread thread3 = new Thread(()->{
			Logger logger5 = Logger.getLoggerInstance();
			logger5.logError("Thread3 - Logger5: Logger Error");
		});
		
		thread1.start();
		thread2.start();
		thread3.start();
		
		int instanceCount = Logger.getLoggerInstanceCount();
		System.out.println("Total Instances: "+instanceCount);
	}

}
