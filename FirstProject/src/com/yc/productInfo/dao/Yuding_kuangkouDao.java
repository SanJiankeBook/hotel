package com.yc.productInfo.dao;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.yc.Info.DBHelper;
public class Yuding_kuangkouDao {
	public DBHelper db=new DBHelper();
	
	//添加数据
	public int add(String order_room,String houes_type,String customer_name,String sex,String tel,String card_id,
		String order_date,String order_out,String order_state,String nunn,String lpq){//姓名，身份证，性别，联系方式，预抵时间，预住时间，居住天数，预离时间,顾客状态
		String sql="insert into winehop_schedule values(seq_sta1.nextval,?,?,?,?,?,?,?,sysdate,?,?,'未入住',1,?,?)";		//房号，房间类型，房价
		List<Object> params=new ArrayList<Object>();
		params.add(order_room);
		params.add(houes_type);
		params.add(customer_name);
		params.add(sex);
		params.add(tel);
		params.add(card_id);
		params.add(order_date);
		params.add(order_out);
		params.add(order_state);
		params.add(nunn);
		params.add(lpq);
//		System.out.println(sql);
//		System.out.println(params+"这个是预定的测试");
//		System.out.println("得到"+db.update(sql, params));
		return db.update(sql, params);
		//房号 房间类型 顾客姓名 性别 联系方式 身份证号 预抵时间 预定时间 预离时间 居住天数  1 1 1
	}
	
	
	//显示房号
	public List<Map<String, Object>> find(){
		String houes="select * from wineshop_room";
		List<Map<String, Object>> list=new ArrayList<Map<String, Object>>();
		list=db.find(houes, null);
		return list;
	}	
	
	//房间数量
	public int count(){
		String lc="select count(number_house) from wineshop_room";
		//list=db.find(lc, null);
		return (int) db.getTotal(lc, null);
	}
	
	//房间类型数量
	public int count1(){
		String lc="select count(type_room) from wineshop_room";
		//list=db.find(lc, null);
		return (int) db.getTotal(lc, null);
	}
	
	//得到房间价格
	public List<Map<String, Object>> findprice(String number_house){
		String houes="select price,type_room from wineshop_room where number_house=?";
		List<Map<String, Object>> list=new ArrayList<Map<String, Object>>();
		List<Object> params=new ArrayList<Object>();
		params.add(number_house);
		list=db.find(houes, params);
		return list;
	}
	
	//获取相应房号的酒店预订信息
	public List<Map<String, Object>> findd(String str){
		List <Object> params=new ArrayList<Object>();
		params.add(str);
		String houes="select * from winehop_schedule where order_room=? and order_type='未入住'";
		List<Map<String, Object>> list=new ArrayList<Map<String, Object>>();
		list=db.find(houes,params );
		return list;
	}
	
	//获取 酒店订房信息
	public List<Map<String, Object>> find1(){
		String houes="select * from wineshop_reserve ";
		List<Map<String, Object>> list=new ArrayList<Map<String, Object>>();
		list=db.find(houes, null);
		return list;
	}
	//获取酒店房号相应的信息
	public List<Map<String, Object>> find2(String str){
		List <Object> params=new ArrayList<Object>();
		params.add(str);
		String houes="select * from wineshop_reserve where number_house=? and bill_state='没结账'";
		List<Map<String, Object>> list=new ArrayList<Map<String, Object>>();
		list=db.find(houes, params);
		return list;
	}
	
	
}
