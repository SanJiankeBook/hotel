package com.yc.productInfo.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadPro extends Properties{//继承Properties
	public static ReadPro pro=new ReadPro();
	
	/**
	 * 读取并解析配置文件db.properties
	 */
	private ReadPro(){
		//以流的方式读取配置文件db.properties
		InputStream is=this.getClass().getClassLoader().getResourceAsStream("db.properties");
		//getClass()是返回Class对象，getClassLoader()返回该类的类加载器，getResourceAsStream("db.properties");
		//  getResourceAsStream(String name) 查找具有给定名称的资源。 返回InputStream
		try {
			this.load(is);
		} catch (IOException e) {//将流里面的字节码文件加载到ReadPro对象中
			e.printStackTrace();
			//LogUtil.log.error(e.toString());
		}
	}
}
