package com.yc.productInfo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import com.yc.productInfo.dao.DBhelper;

public class UserManagerDao {
	private DBhelper db=new DBhelper();
	public List<Map<String, Object>>  Find(){//查询用户名和密码等信息
		List<Map<String, Object>>  list= new ArrayList<Map<String,Object>>();
		String sql="select u.user_id,u.user_name,u.useri_password,r.roll_name "
				+ "from roll_user  ru inner join userse u on ru.user_id=u.user_id inner "
				+ "join roll r on r.roll_id=ru.roll_id";
		list=db.query(sql, null);
		return list;
	}
	/**
	 * 删除数据
	 * @param ids
	 * @return
	 */
	public int del(String ids){
		String sql ="";
		Vector<Object> params =new Vector<Object>();
		if(ids.contains(",")&&!ids.contains("or")){//说明要同时删除多条记录
		  	sql ="delete  from userse where user_id in ("+ids+")";
			
		}else {
			sql ="delete from userse where user_id=? ";
			params.add(ids);
		}
		delzi(ids);
		return db.update(sql, params);
		
	}
	 //删除用户的子表
	 private int delzi(String ids){
			String sql ="";
			Vector<Object> params =new Vector<Object>();
			if(ids.contains(",")&&!ids.contains("or")){//说明要同时删除多条记录
			  	sql ="delete  from roll_user where user_id in ("+ids+")";
				
			}else {
				sql ="delete from roll_user where user_id=? ";
				params.add(ids);
			}
			return db.update(sql, params);
			
		}
	 //修改用户信息
		public int update(String pname,String price,String pid){
			
			List<Object>params =new ArrayList<Object>();
			String sql ="update userse set user_name=?,useri_password=? where user_id=?";
			params.add(pname);
			params.add(price);
			params.add(pid);
			return db.update(sql, params);
			
		}
		//添加用户的信息
		
		public int add(String pname,String price){
			int  count =0;
			String sql ="insert into userse values(seq_userse.nextval,?,?,1,1,1)";
			List<Object> params =new ArrayList<Object>();
			params.add(pname);
			params.add(price);
			count=db.update(sql, params);
			
			List<Map<String, Object>>  list= new ArrayList<Map<String,Object>>();
			list=FindUser(pname);
			String str=(String) list.get(0).get("USER_ID");
			//System.out.println(str+"这个是添加用户的测试");
	
			List< Object>  list1= new ArrayList<Object>();
			list1.add(str);
			String sql1 ="insert into roll_user values(1001,?,1,1)";
			db.update(sql1, list1);
			return count;
		}
		//查询用户的编号
		public List<Map<String, Object>>  FindUser(String name){//查询用户名和密码等信息
			List<Map<String, Object>>  list= new ArrayList<Map<String,Object>>();
			String sql="select u.user_id from userse u where u.user_name=?";
			List<Object> list1=new ArrayList<Object>();
			list1.add(name);
			list=db.query(sql, list1);
			return list;
		}

}
