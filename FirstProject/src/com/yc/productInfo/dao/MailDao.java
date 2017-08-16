package com.yc.productInfo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.yc.Info.DBHelper;

public class MailDao {
	DBHelper db=new DBHelper();
	
	
	//查询所有数据
		public List<Map<String, Object>> All(){
			String sall="select * from wineshop_live";
			List<Map<String, Object>> list=new ArrayList<Map<String, Object>>();
			list=db.find(sall, null);
			return list;
		}
		
		//显示个数
		public int count(){
			String lc="select count(customer_id) from wineshop_live";
			//list=db.find(lc, null);
			return (int) db.getTotal(lc, null);
		}	
	
}
