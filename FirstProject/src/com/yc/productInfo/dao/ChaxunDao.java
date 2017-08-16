package com.yc.productInfo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.yc.Info.DBHelper;

public class ChaxunDao {
	private DBHelper db=new DBHelper();
	
	/*public int add(String pname,String price,String tid,byte[] pics){
		String sql="insert into productInfo values(seq_info.nextval,?,?,?,?)";
		List<Object> params=new ArrayList<Object>();
		params.add(pname);
		params.add(price);
		params.add(pics);
		params.add(tid);
		return db.update(sql, params);
	}*/

	//查询基本信息
	public List<Map<String, Object>> Info(){
		List<Map<String, Object>>  list= new ArrayList<Map<String,Object>>();
		String sql="select wl.customer_name,w.number_house,w.cash,w.date_in,w.live_num,w.date_out,w.bill_state from"
				+ " wineshop_reserve w inner join wineshop_live wl on w.customer_id=wl.customer_id order by date_in DESC";
		list=db.find(sql, null);
		return list;
	}
	
	//查询名字
	public List<Map<String, Object>> findName(String s){
		List<Map<String, Object>>  list= new ArrayList<Map<String,Object>>();
		List<Object> params=new ArrayList<Object>();
		params.add(s);
		String sql="select * from (select wl.customer_name,w.number_house,w.cash,"
				+ "w.date_in,w.live_num,w.date_out,w.bill_state from wineshop_reserve w "
				+ "inner join wineshop_live wl on w.customer_id=wl.customer_id) where customer_name=? order by date_in DESC";
		return list=db.find(sql, params);
	}
	
	//查询房间号
	public List<Map<String, Object>> findRoom(String s){
		List<Map<String, Object>>  list= new ArrayList<Map<String,Object>>();
		List<Object> params=new ArrayList<Object>();
		params.add(s);
		String sql="select * from (select wl.customer_name,w.number_house,"
				+ "w.cash,w.date_in,w.live_num,w.date_out,w.bill_state from wineshop_reserve"
				+ " w inner join wineshop_live wl on w.customer_id=wl.customer_id) where number_house=? order by date_in DESC";
		
		return list=db.find(sql, params);
	}
	//通过查询账单状态
	public List<Map<String, Object>> findState(){
		List<Map<String, Object>>  list= new ArrayList<Map<String,Object>>();
		List<Object> params=new ArrayList<Object>();
		
		String sql="select * from (select wl.customer_name,w.number_house,"
				+ "w.cash,w.date_in,w.live_num,w.date_out,w.bill_state from wineshop_reserve"
				+ " w inner join wineshop_live wl on w.customer_id=wl.customer_id) where bill_state='没结账' order by date_in DESC";
		
		return list=db.find(sql, null);
	}		

	
}
