package com.yc.Info;

import java.util.List;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.yc.productInfo.dao.ReadPro;

public class DBHelper {
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs  = null;
	
	static{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			//LogUtil.log.error(e.toString());
		}
	}
	
	public Connection getConnection(){
		try {
			con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "scott", "a");
		} catch (SQLException e) {
			e.printStackTrace();
			//LogUtil.log.error(e.toString());
		}
		
		return con;
	}
	
	
	public void closeAll(Connection con,PreparedStatement pstmt,ResultSet set){
		if(rs!=null){
			try {
				rs.close();
				rs=null;
			} catch (SQLException e) {
				e.printStackTrace();
				//LogUtil.log.error(e.toString());
			}
		}
		if(pstmt!=null){
			try {
				pstmt.close();
				pstmt=null;
			} catch (SQLException e) {
				e.printStackTrace();
				//LogUtil.log.error(e.toString());
			}
		}
		
		if(con!=null){
			try {
				con.close();
				con=null;
			} catch (SQLException e) {
				e.printStackTrace();
				//LogUtil.log.error(e.toString());
			}
		}
	}
	
	
	
	
	public int update(String sql,List<Object> params){
		int result=0;
		try {
			con=this.getConnection();
			pstmt=con.prepareStatement(sql);
			this.setValue(pstmt, params);
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			//LogUtil.log.error(e.toString());
		}finally{
			this.closeAll(con, pstmt, null);
		}
		return result;
		
	}
	
	
	
	
	public int update(List<String> sqls,List<List<Object>> params){
		int result=0;
		
		try {
			con=this.getConnection();
			con.setAutoCommit(false);
			if(sqls!=null && sqls.size()>0){
				for(int i=0,len=sqls.size();i<len;i++){
					pstmt=con.prepareStatement(sqls.get(i));
					this.setValue(pstmt, params.get(i));
					result=pstmt.executeUpdate();
				}
			}
			con.commit();
		} catch (SQLException e) {
			result=0;
			e.printStackTrace();
			//LogUtil.log.error(e.toString());
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
				//LogUtil.log.error(e.toString());
			}
		}finally {
			try {
				con.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
				//LogUtil.log.error(e.toString());
			}
			this.closeAll(con, pstmt,null);
		}
		return result;
	}
	
	
	
	public void setValue(PreparedStatement pstmt,List<Object> params){
		if(pstmt!=null && params!=null && params.size()>0){
			Object obj=null;
			String typeName;
			for(int i=0,len=params.size();i<len;i++){
				obj=params.get(i);
				try {
					if(obj!=null){
						typeName=obj.getClass().getSimpleName();
						if("String".equals(typeName)){
							pstmt.setString(i+1, String.valueOf(params.get(i)));
						}else if("byte[]".equals(typeName)){
							pstmt.setBytes(i+1,(byte[])obj);
						}else{
							pstmt.setString(i+1,String.valueOf(params.get(i)));
						}
					}else{
						pstmt.setString(i+1,String.valueOf(params.get(i)));
					}
					
				} catch (Exception e) {
					e.printStackTrace();
					//LogUtil.log.error(e.toString());
				}
			}
		}
	}
	
	
	public List<Map<String,Object>> find(String sql,List<Object> params){
		List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
		
		try {
			con=this.getConnection();
			
			pstmt=con.prepareStatement(sql);
			
			this.setValue(pstmt, params);
			
			rs=pstmt.executeQuery();
			
			
			ResultSetMetaData rsmd=rs.getMetaData();
			int colLen=rsmd.getColumnCount();
			String[] colNames=new String[colLen];
			
			for(int i=0;i<colLen;i++){
				colNames[i]=rsmd.getColumnName(i+1);
			}
			
			
			Map<String, Object> map=null;
			String typeName;
			Object obj;
			while(rs.next()){ 
				map=new HashMap<String,Object>();
				
				for(int i=0;i<colLen;i++){                        // ֵ
					obj=rs.getObject(colNames[i]);
					if(obj!=null){
						typeName=obj.getClass().getSimpleName();
						if("String".equals(typeName)){
							map.put(colNames[i],rs.getString(colNames[i]));
						}else if("BLOB".equals(typeName)){
							Blob blob=rs.getBlob(colNames[i]);
							byte[] bt=null;
							BufferedInputStream bis=null;
							try{
								bis=new BufferedInputStream(blob.getBinaryStream());
								bt=new byte[(int) blob.length()];
								bis.read(bt);
								map.put(colNames[i],bt);
							}catch(IOException e){
								e.printStackTrace();
							}finally{
								if(bis!=null){
									try{
										bis.close();
									}catch(IOException e){
										e.printStackTrace();
									}
								}
							}
						}else{
							map.put(colNames[i],rs.getString(colNames[i]));
						}
					}else{
						map.put(colNames[i],rs.getString(colNames[i]));
					}
				}
				list.add(map);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			//LogUtil.log.error(e.toString());
		}finally{
			this.closeAll(con, pstmt, rs);
		}
		
		return list;
	}
	
	/**
	 * ��ȡ�ܼ�¼����
	 * @param sql
	 * @param params
	 * @return
	 */
	public double getTotal(String sql,List<Object> params){
		double result=0;
		try {
			con=this.getConnection();
			pstmt=con.prepareStatement(sql);
			this.setValue(pstmt, params);
			
			rs=pstmt.executeQuery();
			if(rs.next()){
				result=rs.getDouble(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			//LogUtil.log.error(e.toString());
		} finally {
			this.closeAll(con, pstmt, rs);
		}
		
		
		return result;
	}

	
	public List<Double> getNumber(String sql,List<Object> params){
		List<Double> list=new ArrayList<Double>();
		
		try {
			con=this.getConnection();
			pstmt=con.prepareStatement(sql);
			this.setValue(pstmt, params);
			rs=pstmt.executeQuery();
			ResultSetMetaData rsmd=rs.getMetaData();
			int colLen=rsmd.getColumnCount();//��ȡ��������е�����
			if(rs.next()){
				for(int i=0;i<colLen;i++){
					list.add(rs.getDouble(i+1));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			//LogUtil.log.error(e.toString());
		} finally {
			this.closeAll(con, pstmt, rs);
		}
		
		return list;
	}
	
	public List<List<Double>> getNumbers(String sql,List<Object> params){
		List<List<Double>> list=new ArrayList<List<Double>>();
		
		try {
			con=this.getConnection();
			pstmt=con.prepareStatement(sql);
			this.setValue(pstmt, params);
			rs=pstmt.executeQuery();
			ResultSetMetaData rsmd=rs.getMetaData();
			int colLen=rsmd.getColumnCount();//��ȡ��������е�����
			
			List<Double> data=null;
			while(rs.next()){
				data=new ArrayList<Double>();
				for(int i=0;i<colLen;i++){
					data.add(rs.getDouble(i+1));
				}
				list.add(data);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			//LogUtil.log.error(e.toString());
		} finally {
			this.closeAll(con, pstmt, rs);
		}
		
		return list;
	}

	public int louceng(String sql, Object object) {
		// TODO Auto-generated method stub
		return 0;
	}

}
