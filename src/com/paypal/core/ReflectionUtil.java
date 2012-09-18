package com.paypal.core;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReflectionUtil {

	public static Map<String, String> decodeResponseObject(Object responseType, String prefix) {
		Map<String, String> returnMap = new HashMap<String, String>();
		Map<String, Object> rMap = ReflectionUtil.generateMapFromResponse(responseType, "");
		if(rMap != null && rMap.size() > 0) {
			for (String key : rMap.keySet()) {
				returnMap.put(key, rMap.get(key).toString());
			}
		}
		return returnMap;
	}

	public static Map<String, Object> generateMapFromResponse(Object responseType,
			String prefix) {

		if (responseType == null) {
			return null;
		}

		Map<String, Object> responseMap = new HashMap<String, Object>();

		// To check return types
		Map<String, Object> returnMap;
		Object returnObject;

		try {
			Class klazz = responseType.getClass();
			Method[] methods = klazz.getMethods();
			Package packageName;
			String propertyName;
			AccessibleObject.setAccessible(methods, true);
			for (Method m : methods) {
				if (m.getName().startsWith("get")
						&& !m.getName().equalsIgnoreCase("getClass")) {
					packageName = m.getReturnType().getPackage();
					try {
						if (!prefix.isEmpty()) {
							propertyName = prefix + "."
									+ m.getName().substring(3, 4).toLowerCase()
									+ m.getName().substring(4);
						} else {
							propertyName = m.getName().substring(3, 4)
									.toLowerCase()
									+ m.getName().substring(4);

						}
						if (packageName != null) {
							if (!packageName.getName().contains("com.paypal")) {
								returnObject = m.invoke(responseType, null);
								if (returnObject != null
										&& List.class.isAssignableFrom(m
												.getReturnType())) {
									List listObj = (List) returnObject;
									int i = 0;
									for (Object o : listObj) {
										if (o.getClass().getPackage().getName().contains("com.paypal")) {
											responseMap
											.putAll(generateMapFromResponse(
													o, propertyName + "(" + i
															+ ")"));
										} else {
											responseMap.put(propertyName + "(" + i
													+ ")", o);
										}
										i++;
									}

								} else if (returnObject != null) {
									if(responseType.getClass().getSimpleName().equalsIgnoreCase("ErrorParameter") &&
											propertyName.endsWith("value")) {
										propertyName = propertyName.substring(0, propertyName.lastIndexOf("."));
									}
									responseMap.put(propertyName, returnObject);
								}
							} else {
								returnObject = m.invoke(responseType, null);
								if (returnObject != null
										&& m.getReturnType().isEnum()) {
									responseMap
											.put(propertyName,
													returnObject
															.getClass()
															.getMethod(
																	"getValue",
																	null)
															.invoke(returnObject,
																	null));
								} else if (returnObject != null) {
									returnMap = generateMapFromResponse(
											returnObject, propertyName);
									if (returnMap != null
											&& returnMap.size() > 0) {
										responseMap.putAll(returnMap);
									}
								}
							}

						} else {
							responseMap.put(propertyName,
									m.invoke(klazz.newInstance(), null));
						}
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					} catch (InstantiationException e) {
						e.printStackTrace();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return responseMap;
	}

}
