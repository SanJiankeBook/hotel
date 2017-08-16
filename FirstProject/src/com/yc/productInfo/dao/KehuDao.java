package com.yc.productInfo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.swt.widgets.TableItem;

import com.yc.Info.DBHelper;

public class KehuDao {
	public static DBHelper db=new DBHelper();
	private static String del;
	
	//获取客户个数
	public int count(){
		String lc="select count(customer_id) from wineshop_live";
		//list=db.find(lc, null);
		return (int) db.getTotal(lc, null);
	}
	
	//显示所有的顾客信息
	public List<Map<String, Object>> All(){
		String sall="select * from wineshop_live order by customer_id ";
		List<Map<String, Object>> list=new ArrayList<Map<String, Object>>();
		list=db.find(sall, null);
		//System.out.println(list);
		return list;
	}
	
	
	//按照身份证号查询所有顾客信息
	public static List<Map<String, Object>> find(String card_id){
		String sql="select customer_id,customer_name,card_id,sex,age,tel,mail,type_customer from wineshop_live where card_id=?";
		List<Map<String, Object>> list=new ArrayList<Map<String, Object>>();
		List<Object> params=new ArrayList<Object>();
		params.add(card_id);
		list=db.find(sql, params);
		return list;
	}

	//按照姓名查询所有顾客的信息
	public static List<Map<String, Object>> findName(String customer_name){
		String sql="select customer_id,customer_name,card_id,sex,age,tel,mail,type_customer from wineshop_live where customer_name=?";
		List<Map<String, Object>> list=new ArrayList<Map<String, Object>>();
		List<Object> params=new ArrayList<Object>();
		params.add(customer_name);
		list=db.find(sql, params);
		return list;
	}
	
		//修改
		public static List<Map<String, Object>> update(String tel,String mail,String type_customer,String customer_id){
			String sql="update wineshop_live set tel=?,mail=?,type_customer=? where customer_id=?";
			List<Object> params = new ArrayList<Object>();
			params.add(tel);
			params.add(mail);
			params.add(type_customer);
			params.add(customer_id);
			return db.find(sql, params); //顾客类型text_2 邮箱text_4 联系方式text_3
		}
		
		
		//隐藏表的属性（删除）
		public static  int del(String customer_id){
			String del="";
			List<Object> params = new ArrayList<Object>();
			if(customer_id.contains(",")&& !customer_id.contains(" or")){
				del="delete from wineshop_live  where customer_id in("+customer_id+")";
			}else{
				del="delete from wineshop_live  where customer_id=?";
				params.add(customer_id);
			}
			//System.out.println(del);
			return db.update(del, params);
		}
		
		//删除之后的显示数据
		/*public List<Map<String, Object>> delAll(){
			String sall="select * from wineshop_live where property=1";
			List<Map<String, Object>> list=new ArrayList<Map<String, Object>>();
			list=db.find(sall, null);
			return list;
		}*/
	
}


