package com.fire.back.util;

import java.util.Map;

/**
 * 
 * @author dragon
 * controller参数Map取值util
 * Feb 18, 2020
 */
public class ParamUtil {

	public static String processParam(Map<String, Object> paramMap, String paramKey) {
		if (paramMap.get(paramKey) == null) {
			return "";
		}
		return paramMap.get(paramKey).toString();
	}
	
	public static String getString(Map<String, Object> paramMap, String paramKey,String defaultvalue) {
		String value = processParam(paramMap, paramKey);
		if ("".equals(value)) 
			return defaultvalue;
		else  
			return value;
	}
	
	public static String getString(Map<String, Object> paramMap, String paramKey) {
		return  processParam(paramMap, paramKey);
	}
	
	public static Integer getInteger(Map<String, Object> paramMap, String paramKey, Integer defaultvalue) {
		String value = processParam(paramMap, paramKey);
		if ("".equals(value)) {
			return defaultvalue;
		} else {
			try {
				Integer integer = Integer.valueOf(value);
				return integer;
			} catch (Exception e) {
				return defaultvalue;
			}
		}
	}
	
	public static Integer getInteger(Map<String, Object> paramMap, String paramKey) {
		String value = processParam(paramMap, paramKey);
		if ("".equals(value)) {
			return null;
		} else {
			try {
				Integer integer = Integer.valueOf(value);
				return integer;
			} catch (Exception e) {
				return null;
			}
		}
	}
	
	public static Long getLong(Map<String, Object> paramMap, String paramKey, Long defaultvalue) {
		String value = processParam(paramMap, paramKey);
		if ("".equals(value)) {
			return defaultvalue;
		} else {
			try {
				Long lvalue = Long.valueOf(value);
				return lvalue;
			} catch (Exception e) {
				return defaultvalue;
			}
		}
	}
	
	public static Long getLong(Map<String, Object> paramMap, String paramKey) {
		String value = processParam(paramMap, paramKey);
		if ("".equals(value)) {
			return null;
		} else {
			try {
				Long lvalue = Long.valueOf(value);
				return lvalue;
			} catch (Exception e) {
				return null;
			}
		}
	}
	
	public static Double getDouble(Map<String, Object> paramMap, String paramKey, Double defaultvalue) {
		String value = processParam(paramMap, paramKey);
		if ("".equals(value)) {
			return defaultvalue;
		} else {
			try {
				Double lvalue = Double.valueOf(value);
				return lvalue;
			} catch (Exception e) {
				return defaultvalue;
			}
		}
	}
	
	public static Double getDouble(Map<String, Object> paramMap, String paramKey) {
		String value = processParam(paramMap, paramKey);
		if ("".equals(value)) {
			return null;
		} else {
			try {
				Double lvalue = Double.valueOf(value);
				return lvalue;
			} catch (Exception e) {
				return null;
			}
		}
	}
}
