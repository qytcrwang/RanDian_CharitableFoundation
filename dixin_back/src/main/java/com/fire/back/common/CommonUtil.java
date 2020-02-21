/**  
 * @Title: CommonUtil.java
 * @Description: TODO(描述)
 * @author Dragon
 * @date 2020-02-21 11:26:32 
 */
package com.fire.back.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.ibatis.io.Resources;

/**  
 * @Title: CommonUtil.java
 * @Description: TODO(描述)
 * @author Dragon
 * @date 2020-02-21 11:26:32 
 */
public class CommonUtil {

	/**
	 * 获取项目配置信息
	 * @param key
	 * @return
	 */
	public static String getValue(String key){
		String fileName ="application.properties";
		Properties properties = new Properties();
		try {
			File file = Resources.getResourceAsFile(fileName);
			FileInputStream fis = new FileInputStream(file);
			properties.load(fis);
			fis.close();
			return properties.getProperty(key);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "0";
	}
}
