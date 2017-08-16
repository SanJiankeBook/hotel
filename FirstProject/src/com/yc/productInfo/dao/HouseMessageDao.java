package com.yc.productInfo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.yc.Info.DBHelper;

public class HouseMessageDao {
	public static DBHelper db=new DBHelper();
	
	//查询所有数据
	public List<Map<String, Object>> All(){
		String sall="select * from wineshop_room order by number_house";
		List<Map<String, Object>> list=new ArrayList<Map<String, Object>>();
		list=db.find(sall, null);
		return list;
	}
	
	//显示个数
	public int count(){
		String lc="select count(number_house) from wineshop_room";
		//list=db.find(lc, null);
		return (int) db.getTotal(lc, null);
	}
	
	//修改
			public static int update(String type_room,String price,String floor_1,String number_house ){
				String sql="update wineshop_room set type_room=?,price=?,floor_1=? where number_house=?";
				List<Object> params = new ArrayList<Object>();
				params.add(type_room);
				params.add(price);
				params.add(floor_1);
				params.add(number_house);
				//System.out.println(params+"得到的值");
				return db.update(sql, params); //顾客类型text_2 邮箱text_4 联系方式text_3
			}
		//修改每种类型房间的价格 
			public static int update1(String type_room,String price ){
			//	System.out.println("131333333333333333333333333333333333333333");
				String sql="update wineshop_room set price=? where type_room=?";
				List<Object> params = new ArrayList<Object>();
				
				params.add(price);
				params.add(type_room);
				//System.out.println(params+"得到的值");
				return db.update(sql, params); //顾客类型text_2 邮箱text_4 联系方式text_3
			}
	//条件选择
	public static List<Map<String, Object>> findNum(String number_house){//房间类型、房间状态、所在楼层、房间单价
		String sql="select * from wineshop_room where number_house=?";
		List<Map<String, Object>> list=new ArrayList<Map<String, Object>>();
		List<Object> params=new ArrayList<Object>();
		params.add(number_house);
		list=db.find(sql, params);
			return list;
	}
	
	//条件选择房间状态
	public static List<Map<String, Object>> findType(String room_state){
		String sql="select * from wineshop_room where room_state=?";
		List<Map<String, Object>> list=new ArrayList<Map<String, Object>>();
		List<Object> params=new ArrayList<Object>();
		params.add(room_state);
		list=db.find(sql, params);
			return list;
	}
	
	//房间增肌
	public int add(String number_house,String floor_1,String type_room,String price){//房号，楼层，房间类型，价格
		String sql="insert into wineshop_room values(?,?,'空',?,?,1,1,1)";
		List<Object> params=new ArrayList<Object>();
		params.add(number_house);
		params.add(floor_1);
		params.add(type_room);
		params.add(price);
		System.out.println(params+"得到");
		return db.update(sql, params);
	}
	
	//删除
	public static int del(String number_house){
		String sql="delete wineshop_room where number_house=?";
		List<Object> params = new ArrayList<Object>();
		params.add(number_house);
		return db.update(sql, params); 
	}
	
}
