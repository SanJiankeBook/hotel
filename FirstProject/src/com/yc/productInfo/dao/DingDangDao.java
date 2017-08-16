package com.yc.productInfo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.yc.productInfo.dao.DBhelper;

public class DingDangDao {
	private  DBhelper fz=new DBhelper();
	public List<Map<String, Object>>  FindId(String str){//根据证件编号查询顾客类型
		List<Map<String, Object>>  list= new ArrayList<Map<String,Object>>();
		List< Object>  parmas= new ArrayList<Object>();
		parmas.add(str);
		String sql="select * from wineshop_live wl where wl.card_id=?";
		list=fz.query(sql, parmas);
		return list;
	}
	//显示价格
	public List<Map<String, Object>>  FindPrice(String str){//根据房号查询顾客类型
		List<Map<String, Object>>  list= new ArrayList<Map<String,Object>>();
		List< Object>  parmas= new ArrayList<Object>();
		parmas.add(str);
		String sql="select * from wineshop_room  where number_house=?";
		list=fz.query(sql, parmas);
		return list;
	}
	//根据顾客身份号查询顾客编号
	public List<Map<String, Object>>  Find(String str){//根据证件编号查询顾客编号
		List<Map<String, Object>>  list= new ArrayList<Map<String,Object>>();
		List< Object>  parmas= new ArrayList<Object>();
		parmas.add(str);
		String sql="select wl.customer_id from wineshop_live wl where wl.card_id=?";
		list=fz.query(sql, parmas);
		return list;
	}
	public int Insert(String str,String str1,String str2,String str3,String str4,String str5,String str6,String str7,String str8){
		//给订单数据库插入数据
		int count;
		List< Object>  parmas= new ArrayList<Object>();
		parmas.add(str);
		parmas.add(str1);
		parmas.add(str2);
		parmas.add(str3);
		parmas.add(str4);
		parmas.add(str5);
		parmas.add(str6);
		parmas.add(str7);
		parmas.add(str8);
		String sql="insert into wineshop_reserve values(?,?,?,to_date(?,'yyyy_MM_dd HH24:MI:ss'),?,to_date(?,'yyyy_MM_dd HH24:MI:ss'),?,1,?,?)";//结账为1，没结账为0
//		System.out.println("11111111111111111111111111");
//		System.out.println(parmas+"这是测试");
		count=fz.update(sql, parmas);
		return count;
	}
	public int InsertCustomer(String str,String str1,String str2,String str3,String str4,String str5,String str6){
		//给顾客数据库插入数据
		int count;
		List< Object>  parmas= new ArrayList<Object>();
		parmas.add(str);
		parmas.add(str1);
		parmas.add(str2);
		parmas.add(str3);
		parmas.add(str4);
		parmas.add(str5);
		parmas.add(str6);
		String sql="insert into wineshop_live values(seq_sta.nextval,?,?,?,?,?,?,?,1,1,1,1)";
		count=fz.update(sql, parmas);
		return count;

	}
	//给房间修改状态
	public int updateState(String roomState,String number_houser){
		String sql="update wineshop_room set room_state=?  where number_house=?";
		int count=0;
		List<Object> list=new ArrayList<Object>();
		list.add(roomState);
		list.add(number_houser);
		count=fz.update(sql, list);
		return count;

		
	}
	//获取相应房号的酒店预订信息
		public List<Map<String, Object>> findd(String str){
			List <Object> params=new ArrayList<Object>();
			params.add(str);
			String houes="select * from winehop_schedule where order_room=? and order_type='未入住'";
			List<Map<String, Object>> list=new ArrayList<Map<String, Object>>();
			list=fz.query(houes,params );
			return list;
		}
	//判定当 前顾客编号是否已经在开房了
				public List<Map<String, Object>> findShen(String str){
					List <Object> params=new ArrayList<Object>();
					params.add(str);
					String houes="select * from wineshop_reserve  wr where customer_id=? and  wr.bill_state='没结账' ";
					List<Map<String, Object>> list=new ArrayList<Map<String, Object>>();
					list=fz.query(houes,params );
					return list;
				}
}
