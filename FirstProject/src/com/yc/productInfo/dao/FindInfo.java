package com.yc.productInfo.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.yc.Info.DBHelper;

//import xxxxx.DBhelper;

public class FindInfo {
	private  DBHelper db=new DBHelper();
	public List<Map<String, Object>> Info(){
		List<Map<String, Object>>  list= new ArrayList<Map<String,Object>>();
		String sql="select wl.customer_name,w.number_house,w.cash,w.date_in,w.live_num,w.date_out,"
				+ "w.bill_state from wineshop_reserve w inner join wineshop_live wl on w.customer_id=wl.customer_id";
		list=db.find(sql, null);
		return list;
	}
	
	public List<Map<String, Object>> findName(String s){
		List<Map<String, Object>>  list= new ArrayList<Map<String,Object>>();
		List<Object> params=new ArrayList<Object>();
		params.add(s);
		String sql="select * from (select wl.customer_name,w.number_house,w.cash,"
				+ "w.date_in,w.live_num,w.date_out,w.bill_state from wineshop_reserve w "
				+ "inner join wineshop_live wl on w.customer_id=wl.customer_id) where customer_name=? ";
		return list=db.find(sql, params);
	}
	
	public List<Map<String, Object>> findRoom(String s){
		List<Map<String, Object>>  list= new ArrayList<Map<String,Object>>();
		List<Object> params=new ArrayList<Object>();
		params.add(s);
		String sql="select * from (select wl.customer_name,w.number_house,"
				+ "w.cash,w.date_in,w.live_num,w.date_out,w.bill_state from wineshop_reserve"
				+ " w inner join wineshop_live wl on w.customer_id=wl.customer_id) where number_house=? ";
		
		return list=db.find(sql, params);
	}		
}
