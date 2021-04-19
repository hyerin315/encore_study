package com.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadConfig {
	FileInputStream fileInputStream;
	Properties property;
	private String path;
	
	public void getFilePath(String menuNameKey) {
		String propertyFilePath = "src/resources/program.properties";
		
		property = new Properties();
		try {
			fileInputStream = new FileInputStream(propertyFilePath);
			property.load(new BufferedInputStream(fileInputStream));
			
			//키 값으로 검색 
			this.path = property.getProperty(menuNameKey);
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
