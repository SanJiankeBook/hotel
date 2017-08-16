package com.yc.productInfo.dao;

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
import java.util.List;
import java.util.Map;

import org.eclipse.ui.internal.dnd.DragBorder;

public class DBhelper {
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	Connection con = null;
	ResultSetMetaData rsd = null;
	List<Map<String, Object>> parms = null;

	/**
	 * ������
	 */
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			//LogUtil.log.error(e.toString());

		}
	}

	/**
	 * ��������
	 * 
	 * @return
	 */
	public Connection getConnection() {
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "scott", "a");
		} catch (SQLException e) {
			e.printStackTrace();
			//LogUtil.log.error(e.toString());

		}
		return con;
	}

	public void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try {
			if (con != null) {
				con.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (rs != null) {
				rs.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
			//LogUtil.log.error(e.toString());

		}
	}

	/**
	 * ��ռλ��ֵ
	 * 
	 * @param pstmt
	 * @param list
	 */
	public void setValue(PreparedStatement pstmt, List<Object> list) {
		if (pstmt != null && list != null && list.size() > 0) {
			Object obj = null;
			String typeName;
			for (int i = 0, count = list.size(); i < count; i++) {
				obj = list.get(i);
				try {
					if (obj != null) {
						typeName = obj.getClass().getName();// ��ȡ��ǰ��ݵ�����
						if ("String".equals(typeName)) {
							pstmt.setString(i + 1, String.valueOf(list.get(i)));
						} else if ("byte[]".equals(typeName)) {
							pstmt.setBytes(i + 1, (byte[]) obj);// ʹ���ֽڸ��õĺ�����ʹ���ַ�ĺ���
						} else {
							pstmt.setString(i + 1, String.valueOf(list.get(i)));// ��û�����ƣ���ʱĬ����Ϊ�ַ�

						}
					}

				} catch (SQLException e) {
					e.printStackTrace();
					//LogUtil.log.error(e.toString());

				}
			}
		}
	}

	/**
	 * �޸����
	 * 
	 * @param sql
	 *            �޸����
	 * @param list
	 *            �޸����ȱʡ��ֵ������Ӧ��ֵ
	 * @return
	 */
	public int update(String sql, List<Object> list) {
		int count = 0;
		try {

			con = getConnection();
			pstmt = con.prepareStatement(sql);
			this.setValue(pstmt, list);
			count = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			//LogUtil.log.error(e.toString());

		}
		this.close(con, pstmt, null);
		return count;
	}

	/**
	 * ��ѯ���
	 * 
	 * @param sql
	 * @param list
	 */
	@SuppressWarnings("null")
	public List<Map<String, Object>> query(String sql, List<Object> list) {
		try {
			parms = new ArrayList<Map<String, Object>>();
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			this.setValue(pstmt, list);// ������ݣ�ռλ��
			rs = pstmt.executeQuery();
			// if(rs.next()){
			// System.out.println("�ɹ���ѯ���");//��������д������ᵼ��rs��ָ��Ϊ��һ�������������rs��ָ��ڶ���
			// }
			rsd = rs.getMetaData();
			int count = rsd.getColumnCount();// ȡ���ֶεĸ���

			String[] str = new String[count];// new
			for (int i = 0; i < count; i++) {
				str[i] = rsd.getColumnName(i + 1);// ȡ���ֶε�����
			}

			Object obj = null;
			String typeName = null;
			Map<String, Object> map = null;
			System.out.println(rs.toString());
			while (rs.next()) {
				map = new HashMap<String, Object>();// ����Ҫ����newһ���ռ�
				for (int i = 0; i < count; i++) {
					typeName = null;
					obj = rs.getObject(str[i]);
					if( obj!=null  && !"".equals(obj)){
						typeName = obj.getClass().getSimpleName();
					}
					// if (obj != null && !"".equals(obj) ) {
					// typeName = str[i].getClass().getSimpleName();
					// System.out.println(i + "\t typeName:" +
					// rsd.getColumnClassName(i+1));
					// System.out.println(
					// "BLOB".equals(rsd.getColumnClassName(i+1)) );
					if ("String".equals(typeName)) {
						map.put(str[i], rs.getString(str[i]));
					} else if ("BLOB".equals(typeName)) {
						Blob blob = rs.getBlob(str[i]);
						byte[] bt = null;
						BufferedInputStream bis = null;

						try {

							bis = new BufferedInputStream(blob.getBinaryStream());
							bt = new byte[(int) blob.length()];
							bis.read(bt);
							map.put(str[i], bt);

						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} finally {
							if (bis != null) {
								try {
									bis.close();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						}
						map.put(str[i], rs.getString(str[i]));
						// }
					} else {
						map.put(str[i], rs.getString(str[i]));

					}

					// System.out.println(map);
				}
				parms.add(map);
				// System.out.println(parms);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			//LogUtil.log.error(e.toString());

		}
		// System.out.println(parms);
		// for(Map<String,Object> ss: parms){
		// System.out.println(ss);
		// }
		System.out.println(parms.toString());
		return parms;
	}

	/**
	 * ��ȡ���е��ֶ�
	 * 
	 * @param sql
	 * @param list
	 * @return
	 */
	public double getTal(String sql, List<Object> list) {
		Double count = 0d;
		try {

			parms = new ArrayList<Map<String, Object>>();
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			this.setValue(pstmt, list);// ������ݣ�ռλ��
			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getDouble(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			//LogUtil.log.error(e.toString());
		}
		close(con, pstmt, rs);
		return count;
	}

	/**
	 * ���ж���
	 * 
	 * @param sql
	 * @param list
	 * @return
	 */
	public List<Object> getManyTal(String sql, List<Object> list) {
		List<Object> parm = new ArrayList<Object>();
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			this.setValue(pstmt, list);// ������ݣ�ռλ��
			rs = pstmt.executeQuery();
			rsd = rs.getMetaData();
			int count = rsd.getColumnCount();
			while (rs.next()) {
				for (int i = 0; i < count; i++)
					parm.add(rs.getInt(i + 1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			//LogUtil.log.error(e.toString());
		}
		return parm;
	}
//	public static void main(String[] args) {
//		DBhelper db=new DBhelper();
//		String sql="update wineshop_room set room_state='住人'  where number_house= 3";
//		int count=0;
//		List<Object> list=new ArrayList<Object>();
//		list.add("住人");
//		list.add("3");
//		count=db.update(sql, null);
//		System.out.println(count);
//	}
	/**
	 * �޸İ�Ķ��ж���
	 * 
	 * @param args
	 */
	// public int updatefo(List<String> sql,List<List<Object>> list){
	// try {
	// int rrs=0;
	// con=getConnection();
	// if(sql!=null && list!=null && list.size()>0){
	// for(int i=0,len=list.size();i<len;i++){
	// pstmt=con.prepareStatement(sql.get(i));
	// this.setValue(pstmt, list.get(i));//������ݣ�ռλ��
	// rrs=pstmt.executeUpdate();
	// }
	//
	// }
	// con.commit();
	// } catch (SQLException e) {
	// rrs=0;
	//
	// e.printStackTrace();
	// }
	// return rrs;
	// }
	// public static void main(String[] args){
	// /**
	// * �������
	// */
	// FenZhuang fz=new FenZhuang();
	// String sql="update emp set sal=? where empno=?";
	// List<Object > list=new ArrayList<Object>();
	// list.add(6666);
	// list.add(7369);
	// fz.update(sql, list);
	//
	// FenZhuang fz=new FenZhuang();
	// String sql="select * from dept where deptno=?";
	// List<Object> list=new ArrayList<Object>();
	// list.add(40);
	// List<Map<String, Object>> parms=fz.query(sql, list);
	// for(Map<String,Object> ss: parms){
	// System.out.println(ss);
	// }
	//
	// FenZhuang fz=new FenZhuang();
	// String sql="insert into dept values(?,?,?)";
	// List<Object> list=new ArrayList<Object>();
	// list.add(55);
	// list.add("���ް�");
	// list.add("ɵ��");
	// fz.update(sql, list);
	//
	// FenZhuang fz=new FenZhuang();
	// String sql="insert into sal values(33,to_date(?,'YYYY-mm-dd'),?,?)";
	// List<Object> list=new ArrayList<Object>();
	// list.add("2016-05-03");
	// list.add(1001);
	// list.add(10);
	// if(fz.update(sql, list)!=null){
	// String sql1="update ProductInfo set sore=sore-? where pid=?";
	// list=new ArrayList<Object>();
	// list.add(10);
	// list.add(1001);
	// fz.update(sql1, list);
	// }
	// }

}
