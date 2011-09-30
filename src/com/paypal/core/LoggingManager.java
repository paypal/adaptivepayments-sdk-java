package com.paypal.core;

import java.util.HashMap;
import java.util.Map;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * LoggingManager Class uses java.util.logging
 * 
 */
public final class LoggingManager {
	private static Map<Class<?>, Logger> loggerMap = new HashMap<Class<?>, Logger>();

	private static Logger getLogger(Class<?> thisClass) {
		if (loggerMap.get(thisClass) == null) {
			synchronized (loggerMap) {
				if (loggerMap.get(thisClass) == null) {
					loggerMap.put(thisClass,
							Logger.getLogger(thisClass.toString()));
				}
			}
		}
		Logger logger = loggerMap.get(thisClass);
		return logger;
	}

	public static void log(Level priority, Class<?> thisClass, Object message) {
		Logger logger = getLogger(thisClass);
		synchronized (logger) {
			if (logger.isLoggable(priority)) {
				logger.log(priority, (String) message);
			}
		}
	}

	public static void log(Level priority, Class<?> thisClass, Object message,
			Throwable t) {
		Logger logger = getLogger(thisClass);
		synchronized (logger) {
			if (logger.isLoggable(priority)) {
				logger.log(priority, (String) message, t);
			}
		}
	}

	public static void debug(Class<?> thisClass, Object message) {
		log(Level.FINEST, thisClass, message);
	}

	public static void debug(Class<?> thisClass, Object message, Throwable t) {
		log(Level.FINEST, thisClass, message, t);
	}

	public static void info(Class<?> thisClass, Object message) {
		log(Level.INFO, thisClass, message);
	}

	public static void info(Class<?> thisClass, Object message, Throwable t) {
		log(Level.INFO, thisClass, message, t);
	}

	public static void warn(Class<?> thisClass, Object message) {
		log(Level.WARNING, thisClass, message);
	}

	public static void warn(Class<?> thisClass, Object message, Throwable t) {
		log(Level.WARNING, thisClass, message, t);
	}

	public static void severe(Class<?> thisClass, Object message) {
		log(Level.SEVERE, thisClass, message);
	}

	public static void severe(Class<?> thisClass, Object message, Throwable t) {
		log(Level.SEVERE, thisClass, message);
	}

}
