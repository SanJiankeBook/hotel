package com.yc.productInfo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.yc.Info.DBHelper;

public class YudingDao {
	public DBHelper db=new DBHelper();
	
	public List<Map<String, Object>> All(){
		String sall="select * from winehop_schedule where order_type='未入住'";
		List<Map<String, Object>> list=new ArrayList<Map<String, Object>>();
		list=db.find(sall, null);
		return list;
	}
	
	public int count(){
		String lc="select count(order_number) from winehop_schedule";
		//list=db.find(lc, null);
		return (int) db.getTotal(lc, null);
	}
//	给订单修改状态
	public int updateState1(String pid){
		String sql="update winehop_schedule set order_type='取消预约'  where order_number=?";
		int count=0;
		List<Object> list=new ArrayList<Object>();
		list.add(pid);
		count=db.update(sql, list);
		return count;

		
	}
	//给房间修改状态
	public int updateromm(String str){
		String sql="update wineshop_room set room_state='空'  where number_house=?";
		int count=0;
		List<Object> list=new ArrayList<Object>();
		list.add(str);
		count=db.update(sql, list);
		return count;

		
	}
}
