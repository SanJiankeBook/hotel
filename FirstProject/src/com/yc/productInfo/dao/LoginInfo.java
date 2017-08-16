package com.yc.productInfo.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.yc.Info.DBHelper;

//import xxxxx.DBhelper;

public class LoginInfo {
	private  DBHelper db=new DBHelper();
	public Map<String,String> Info(){
		List<Map<String, Object>>  list= new ArrayList<Map<String,Object>>();
		String sql="select u.user_name,u.useri_password from userse u";
		list=db.find(sql, null);
		Map<String,String> map =new HashMap<String,String>();
		Set set=null;
		for(Map<String, Object> map1: list){
				set=map1.keySet();//得到集合map的键名
				Object [] object=set.toArray();//将set集合变成一个object的数组
				map.put(String.valueOf(map1.get(object[0])), String.valueOf(map1.get(object[1])));//通过键名获取到集合元素map的键
		}

		return map;
	}
//	public static void main(String[] args) {
//		LoginInfo lg=new LoginInfo();
//		System.out.println(lg.Info());
//	}

}

