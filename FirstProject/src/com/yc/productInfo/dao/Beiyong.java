package com.yc.productInfo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.yc.Info.DBHelper;

public class Beiyong {

		public DBHelper db=new DBHelper();
		
		
		public List<Map<String, Object>> find() {
			String sql="select customer_name from wineshop_live";
			return db.find(sql, null);
		}
		
		public List<Map<String, Object>> count(){
			String lc="select count(number_house) from wineshop_room where floor_1='一楼'";
			List<Map<String,Object>> list=new ArrayList<>();
			list=db.find(lc, null);
			return list;
		}
		
		public List<Map<String, Object>> count1(){
			String lc="select count(number_house) from wineshop_room where floor_1='二楼'";
			List<Map<String,Object>> list=new ArrayList<>();
			list=db.find(lc, null);
			return list;
		}
		
		public List<Map<String, Object>> count2(){
			String lc="select count(number_house) from wineshop_room where floor_1='三楼'";
			List<Map<String,Object>> list=new ArrayList<>();
			list=db.find(lc, null);
			return list;
		}
}
