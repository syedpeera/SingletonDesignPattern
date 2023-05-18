package com.designpattern.logger.SingletonDesignPattern;

public class Logger {
	private static volatile Logger loggerInstance = null;
	private static int instanceCount=0;
	
	private Logger() {
		System.out.println("Logger Initialized");
		instanceCount++;
	}
	
	public static Logger getLoggerInstance() {
		if(loggerInstance==null) {
			synchronized(Logger.class) {
				if(loggerInstance==null) {
					loggerInstance = new Logger();
				}
			}
		}
		return loggerInstance;
	}
	
	public static int getLoggerInstanceCount() {
		return instanceCount;
	}
	
	public void logInfo(String message) {
		System.out.println("[INFO]: "+message);
	}
	
	public void logWarning(String message) {
		System.out.println("[WARNING]: "+message);
	}
	
	public void logError(String message) {
		System.out.println("[ERROR]: "+message);
	}
}
