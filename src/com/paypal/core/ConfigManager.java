package com.paypal.core;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

/**
 * 
 * Loads the configuration file and hands out appropriate params to all other
 * classes
 * 
 */
public final class ConfigManager {
	private static ConfigManager conf;
	private Enumeration<Object> em;
	private Properties properties;
	private boolean propertyLoaded = false;

	private ConfigManager() {

	}

	/**
	 * create singleton object for ConfigManager
	 * 
	 * @return ConfigManager object
	 */
	public static ConfigManager getInstance() {
		if (conf == null) {
			conf = new ConfigManager();
		}
		return conf;
	}

	/**
	 * overloaded method to load the configuration file.
	 * 
	 * @param is
	 * 
	 * @throws IOException
	 */
	public void load(InputStream is) throws IOException {
		properties = new Properties();
		properties.load(is);
		setPropertyLoaded(true);

	}

	/**
	 * load the keys from properties
	 * 
	 * @return Enumeration of keys from configuration property file.
	 */
	private Enumeration<Object> loadKeys() {
		return properties.keys();
	}

	/**
	 * Used to get the corresponding value for the configuration key
	 * 
	 * @param key
	 * @return String value
	 */
	public String getValue(String key) {
		return properties.getProperty(key);
	}

	/**
	 * Used to get all the values in the particular category in configuration
	 * (eg: acct)
	 * 
	 * @param category
	 * @return HashMap
	 */
	public HashMap<String, String> getValuesByCategory(String category) {
		loadKeys();
		String key = Constants.EMPTY_STRING;
		HashMap<String, String> map = new HashMap<String, String>();
		while (em.hasMoreElements()) {
			key = (String) em.nextElement();
			if (key.contains(category)) {
				map.put(key, properties.getProperty(key));
			}
		}
		return map;
	}

	/**
	 * return acct value corresponding to the API userId passed in
	 * 
	 * @param userName
	 * @return String
	 */
	public String getPrefix(String userName) {
		String acct = Constants.EMPTY_STRING;
		String key = Constants.EMPTY_STRING;
		loadKeys();
		while (em.hasMoreElements()) {
			key = (String) em.nextElement();
			if (userName.equalsIgnoreCase(properties.getProperty(key))) {
				int pos = key.indexOf('.');
				acct = key.substring(0, pos);
			}
		}
		return acct;
	}

	/**
	 * returns the key prefixes for all configured accounts
	 * 
	 * @return Set
	 */

	public Set<String> getNumOfAcct() {
		loadKeys();
		String key = Constants.EMPTY_STRING;
		Set<String> set = new HashSet<String>();
		while (em.hasMoreElements()) {
			key = (String) em.nextElement();
			if (key.contains("acct")) {
				int pos = key.indexOf('.');
				String acct = key.substring(0, pos);
				set.add(acct);
			}
		}
		return set;

	}

	public boolean isPropertyLoaded() {
		return propertyLoaded;
	}

	public void setPropertyLoaded(boolean propertyLoaded) {
		this.propertyLoaded = propertyLoaded;
	}

}
