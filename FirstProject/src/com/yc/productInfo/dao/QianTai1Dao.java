package com.yc.productInfo.dao;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;

import com.yc.productInfo.dao.DBhelper;

public class QianTai1Dao{
	private  DBhelper fz=new DBhelper();
	public List<Map<String, Object>> find(String str){//查询基本信息
		List<Map<String, Object>>  list= new ArrayList<Map<String,Object>>();
		List<Object> params=new ArrayList<Object>();
		params.add(str);
		String sql="select wr.number_house,wro.type_room,wro.room_state,"
				+ "wl.customer_name,wl.age,wro.price,wro.floor_1,wr.date_in,"
				+ "wr.date_out,wr.cash from wineshop_reserve  wr inner join "
				+ " wineshop_live wl on wr.customer_id=wl.customer_id inner join"
				+ " wineshop_room wro on wr.number_house=wro.number_house where wro.floor_1=? and wr.bill_state='没结账' order by number_house";
		list=fz.query(sql,params );
		return list;
	}
	//根据房号得到信息
	public List<Map<String, Object>> findRoom(String str){
		List<Map<String, Object>>  list= new ArrayList<Map<String,Object>>();
		List<Object> params=new ArrayList<Object>();
		params.add(str);
		String sql="select wr.number_house,wro.type_room,wro.room_state,"
				+ "wl.customer_name,wl.age,wro.price,wro.floor_1,wr.date_in,"
				+ "wr.date_out,wr.cash ,wl.tel ,wl.type_customer ,wr.evxx from wineshop_reserve  wr inner join "
				+ " wineshop_live wl on wr.customer_id=wl.customer_id inner join"
				+ " wineshop_room wro on wr.number_house=wro.number_house where wr.number_house=? and wr.bill_state='没结账' order by number_house";
		list=fz.query(sql,params );
		return list;
	}

	
	public List<Map<String, Object>> roomCount1(){//查询一楼的房间数
		int count=0;
		List<Map<String, Object>>  list= new ArrayList<Map<String,Object>>();
		String sql="select * from wineshop_room  where floor_1='一楼' order by number_house";
		list=fz.query(sql, null);
		return list;
	}
	public List<Map<String, Object>> roomCount2(){//查询二楼的房间数
		int count=0;
		List<Map<String, Object>>  list= new ArrayList<Map<String,Object>>();
		String sql="select * from wineshop_room where floor_1='二楼' order by number_house";
		list=fz.query(sql, null);

		return list;
	}
	public List<Map<String, Object>> roomCount3(){//查询三楼的房间数
		int count=0;
		List<Map<String, Object>>  list= new ArrayList<Map<String,Object>>();
		String sql="select * from wineshop_room where floor_1='三楼' order by number_house";
		list=fz.query(sql, null);

		return list;
	}
	//查询房间信息
	public List<Map<String, Object>> room(String str){//查询房间的基本信息
		List<Map<String, Object>>  list= new ArrayList<Map<String,Object>>();
		String sql="select * from wineshop_room  where number_house=?";
		List<Object> list1=new ArrayList<Object>();
		list1.add(str);
		list=fz.query(sql, list1);
		return list;
	}
	//根据房间类型查询房号
	public List<Map<String, Object>> roomType(String str){//查询房间的基本信息
		List<Map<String, Object>>  list= new ArrayList<Map<String,Object>>();
		String sql="select w.number_house from wineshop_room w where type_room=? and w.room_state='空' order by w.number_house";
		List<Object> list1=new ArrayList<Object>();
		list1.add(str);
		//System.out.println("这是测试"+list);
		list=fz.query(sql, list1);
		return list;
	}
	/**
	 * 修改房间状态
	 */
	public int updateState(String roomState,String number_houser){
		String sql="update wineshop_room set room_state=?  where number_house=?";
		int count=0;
		List<Object> list=new ArrayList<Object>();
		list.add(roomState);
		list.add(number_houser);
		count=fz.update(sql, list);
		return count;	
	}
	//修改账单状态
	public int updateBill(String bill){
		String sql="update wineshop_reserve wr set wr.bill_state='结账' where  wr.evxx = ?";
		int count=0;
		List<Object> list=new ArrayList<Object>();
		list.add(bill);
		//System.out.println(list+"这个还是账单的测试，看是否成功");
		count=fz.update(sql, list);
		//System.out.println(count+"这个还是账单的测试，看是否成功");
		return count ;	
	}
	//根据房号来查订单信息
		public List<Map<String, Object>> roomDing(String str){//查询房间的基本信息
			List<Map<String, Object>>  list= new ArrayList<Map<String,Object>>();
			String sql="select * from winehop_schedule  where order_room=? and order_type='未入住' order by order_date";
			List<Object> list1=new ArrayList<Object>();
			list1.add(str);
			list=fz.query(sql, list1);
			return list;
		}
		public int updateYuding(String bill){
			String sql="update winehop_schedule wr set wr.order_type='入住' where  wr.order_number = ?";
			int count=0;
			List<Object> list=new ArrayList<Object>();
			list.add(bill);
			//System.out.println(list+"这个还是账单的测试，看是否成功");
			count=fz.update(sql, list);
			//System.out.println(count+"这个还是账单的测试，看是否成功");
			return count ;	
		}
		//根据房号查询预订房间 信息
		public List<Map<String, Object>> roomYuDing(String str){//查询房间的基本信息
			List<Map<String, Object>>  list= new ArrayList<Map<String,Object>>();
			String sql="select * from winehop_schedule  where order_room=? and order_type='未入住' order by order_in";
			List<Object> list1=new ArrayList<Object>();
			list1.add(str);
			list=fz.query(sql, list1);
			//System.out.println(list+"这个是bug测试");
			return list;
		}
}
