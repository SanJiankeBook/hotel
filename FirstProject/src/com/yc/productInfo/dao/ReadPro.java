package com.yc.productInfo.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadPro extends Properties{//�̳�Properties
	public static ReadPro pro=new ReadPro();
	
	/**
	 * ��ȡ�����������ļ�db.properties
	 */
	private ReadPro(){
		//�����ķ�ʽ��ȡ�����ļ�db.properties
		InputStream is=this.getClass().getClassLoader().getResourceAsStream("db.properties");
		//getClass()�Ƿ���Class����getClassLoader()���ظ�������������getResourceAsStream("db.properties");
		//  getResourceAsStream(String name) ���Ҿ��и������Ƶ���Դ�� ����InputStream
		try {
			this.load(is);
		} catch (IOException e) {//����������ֽ����ļ����ص�ReadPro������
			e.printStackTrace();
			//LogUtil.log.error(e.toString());
		}
	}
}
