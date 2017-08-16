package com.yc.productInfo.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.yc.Info.DBHelper;

public class DengluDao {
	private  DBHelper db=new DBHelper();
	public List<Map<String, Object>> Info(){
		List<Map<String, Object>>  list= new ArrayList<Map<String,Object>>();
		String sql="select u.user_name,u.useri_password from userse u";
		list=db.find(sql, null);
//		Map<String,String> map =new HashMap<String,String>();
//		Set set=null;
//		for(Map<String, Object> map1: list){
//				set=map1.keySet();//得到集合map的键名
//				Object [] object=set.toArray();//将set集合变成一个object的数组
//				map.put(String.valueOf(map1.get(object[1])), String.valueOf(map1.get(object[0])));//通过键名获取到集合元素map的键
//		}
		System.out.println(list);
		return list;
	}
//	public static void main(String[] args) {
//		LoginInfo lg=new LoginInfo();
//		System.out.println(lg.Info());
//	}
	//根据登入账号确定是否密码正确
	public List<Map<String, Object>> find(String name){
		List<Map<String, Object>>  list= new ArrayList<Map<String,Object>>();
		String sql="select u.useri_password from userse u where u.user_name=?";
		List<Object> list1=new ArrayList<Object>();
		list1.add(name);
		list=db.find(sql, list1);
		return list;
	}
//查询登入用户的权限
	public List<Map<String, Object>> quanXian(String name){
		List<Map<String, Object>>  list= new ArrayList<Map<String,Object>>();
		String sql="select roll_name from roll r inner join roll_user ru on r.roll_id=ru.roll_id inner join userse u on u.user_id=ru.user_id where u.user_name=?";
		List<Object> list1=new ArrayList<Object>();
		list1.add(name);
		list=db.find(sql, list1);
		return list;
	}
}
