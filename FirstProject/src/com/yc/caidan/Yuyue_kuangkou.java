package com.yc.caidan;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.xml.crypto.Data;

import org.eclipse.nebula.widgets.cdatetime.CDateTime;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.nebula.widgets.cdatetime.CDT;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

import com.yc.Info.DataInfo;
import com.yc.productInfo.dao.Yuding_kuangkouDao;

import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseTrackAdapter;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TouchListener;
import org.eclipse.swt.events.TouchEvent;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.MouseWheelListener;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.nebula.widgets.calendarcombo.CalendarCombo;

public class Yuyue_kuangkou {
	//public Yuding yu=new Yuding();
	private Spinner spinner;
	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Yuding_kuangkouDao yuding=new Yuding_kuangkouDao();
	private Label lblNewLabel_11,lblNewLabel_13,lblNewLabel_12,lblNewLabel_15,lblNewLabel_14;
	private DateTime dateTime,dateTime_1;
	boolean isRn;
	private Combo combo;
	//private Map map;
	//Map<String,Object> map=new HashMap<String,Object>();
	Date data=new Date();

	
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss EEE");
	private Label label;
	

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Yuyue_kuangkou window = new Yuyue_kuangkou();
			window.open(null, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open(String st,String st1) {
		Display display = Display.getDefault();
		createContents(st,st1);
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents(String st,String st1) {
		shell = new Shell();
		shell.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				lblNewLabel_14.setText(Denglu.chuangzhi());
			}
		});
		shell.setSize(560, 393);
		shell.setText("新增预订");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(69, 63, 61, 17);
		lblNewLabel.setText("姓      名：");
		
		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setBounds(69, 100, 61, 17);
		lblNewLabel_1.setText("联系方式：");
		
		Label lblNewLabel_2 = new Label(shell, SWT.NONE);
		lblNewLabel_2.setBounds(69, 167, 61, 17);
		lblNewLabel_2.setText("房间类型：");
		
		Label lblNewLabel_3 = new Label(shell, SWT.NONE);
		lblNewLabel_3.setBounds(304, 63, 47, 17);
		lblNewLabel_3.setText("身份证：");
		
		Label lblNewLabel_4 = new Label(shell, SWT.NONE);
		lblNewLabel_4.setText("房    号：");
		lblNewLabel_4.setBounds(69, 132, 47, 17);
		
		Label lblNewLabel_5 = new Label(shell, SWT.NONE);
		lblNewLabel_5.setBounds(304, 221, 61, 17);
		lblNewLabel_5.setText("居住天数：");
		
		Label lblNewLabel_6 = new Label(shell, SWT.NONE);
		lblNewLabel_6.setBounds(69, 221, 61, 17);
		lblNewLabel_6.setText("预住时间：");
		
		Label lblNewLabel_7 = new Label(shell, SWT.NONE);
		lblNewLabel_7.setBounds(182, 20, 61, 17);
		lblNewLabel_7.setText("员工号：");
		
		Label lblNewLabel_8 = new Label(shell, SWT.NONE);
		lblNewLabel_8.setBounds(69, 278, 61, 17);
		lblNewLabel_8.setText("预离时间：");
		
		Label lblNewLabel_9 = new Label(shell, SWT.NONE);
		lblNewLabel_9.setBounds(304, 278, 61, 17);
		lblNewLabel_9.setText("预定时间：");
		
		Label lblNewLabel_10 = new Label(shell, SWT.NONE);
		lblNewLabel_10.setBounds(304, 167, 47, 17);
		lblNewLabel_10.setText("房    价：");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(136, 60, 128, 23);
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(357, 60, 128, 23);
		
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setBounds(136, 97, 128, 23);
		
		lblNewLabel_11 = new Label(shell, SWT.NONE);
		lblNewLabel_11.setBounds(363, 167, 122, 17);
		
		spinner = new Spinner(shell, SWT.BORDER | SWT.READ_ONLY);
		spinner.setSelection(1);
		spinner.setBounds(371, 218, 47, 23);
		
		lblNewLabel_12 = new Label(shell, SWT.NONE);
		lblNewLabel_12.setBounds(136, 278, 128, 17);
		
		lblNewLabel_14= new Label(shell, SWT.NONE);
		lblNewLabel_14.setBounds(249, 20, 61, 17);
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.setBounds(69, 317, 80, 27);
		btnNewButton.setText("完成");
		
		Button btnNewButton_1 = new Button(shell, SWT.NONE);
		btnNewButton_1.setBounds(304, 317, 80, 27);
		btnNewButton_1.setText("取消");
		
		dateTime= new DateTime(shell, SWT.NONE);
		dateTime.setLayoutDeferred(true);
		dateTime.setBounds(136, 203, 128, 23);
		
		lblNewLabel_13 = new Label(shell, SWT.NONE);
		lblNewLabel_13.setBounds(136, 167, 128, 17);
		lblNewLabel_13.setText(st);
		
		dateTime_1 = new DateTime(shell, SWT.BORDER | SWT.TIME);
		dateTime_1.setBounds(136, 232, 70, 24);
		
		lblNewLabel_15 = new Label(shell, SWT.NONE);
		lblNewLabel_15.setBounds(367, 278, 167, 17);
		lblNewLabel_15.setText(sdf.format(data));
		
		Label lblNewLabel_16 = new Label(shell, SWT.NONE);
		lblNewLabel_16.setBounds(304, 100, 47, 17);
		lblNewLabel_16.setText("性别:");
		
		label = new Label(shell, SWT.NONE);
		label.setBounds(136, 132, 128, 23);
		label.setText(st1);
		
		combo = new Combo(shell, SWT.READ_ONLY);
		combo.setBounds(357, 97, 128, 25);
		ShowPrice(st1);
		combo.add("男");
		combo.add("女");
		
		//读取日历的时间
		dateTime.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				dateTime.getDay();
				dateTime.getMonth();
				dateTime.getYear();
				addDay();
			}
		});
		
		//读取分钟和秒钟
		dateTime_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				dateTime_1.getHours();
				dateTime_1.getMinutes();
				dateTime_1.getSeconds();
				addDay();
			}
		});
		
		
		//当选择居住天数(获取预离时间和判断)
		spinner.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				List<Map<String,Object>> lmap= new ArrayList<Map<String, Object>>();
				String strs=addDay();//获取预住时间
					
		}
	});
		
		
		//按下确定键
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override//姓名 ，房间号，房间类型，身份证号，性别，联系方式，预抵时间，预离时间，居住天数
			public void mouseDown(MouseEvent e) {
				if(lblNewLabel_12.getText().trim()!=null && !lblNewLabel_12.getText().trim().equals("")){
					addDay();
				}
				int count=1;
				List<Map<String,Object>> lmap= new ArrayList<Map<String, Object>>();
				String str11=label.getText().trim();//获取房号
				String strs=addDay();//获取预住时间
				//System.out.println(strs+"这是预住时间的测试");
				lmap=yuding.findd(str11);//预定订单
				String str22=lblNewLabel_12.getText().trim();//获取预离时间
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");//获取系统的当前时间
				String sysdate=sdf.format(new Date());				
				for(Map<String,Object> map:lmap){
					//System.out.println(map+"这是测试");
					String out=(String) map.get("ORDER_OUT");//获取预离时间
					//System.out.println(out+"这个是测试");
					String in=String.valueOf(map.get("ORDER_DATE"));//获取预住时间
					//System.out.println(in+"这个是测试");
					if(compare_date(strs,sysdate)>0){
						if(compare_date(strs,out)>0){
						
						}else if(compare_date(in,str22)>0){
						
						}else{
							count=0;
						}
					}else{
						count=0;
					}

				}
				
				List<Map<String, Object>> list= new ArrayList<Map<String, Object>>();
						list=yuding.find2(str11);
				for(Map<String,Object> map:list){
					String out=(String) map.get("DATE_OUT");//获取预离时间
					String in=String.valueOf(map.get("DATE_IN"));//获取预住时间
					if(compare_date(strs,sysdate)>0){
						if(compare_date(strs,out)>0){
						
						}else{
							count=0;
						}
					}else{
						count=0;
					}
				}

				String xingming=text.getText().trim();
				String shenfen=text_1.getText().trim();
				String liangxi=text_2.getText().trim();
				String sex=combo.getText().trim();
				String fj=label.getText();
				String type=lblNewLabel_13.getText();
				String price=lblNewLabel_11.getText();
				
				String day=String.valueOf(dateTime.getDay());
				String mon=String.valueOf(dateTime.getMonth()+1);
				String year=String.valueOf(dateTime.getYear());
				String hou=String.valueOf(dateTime_1.getHours());
				String minu=String.valueOf(dateTime_1.getMinutes());
				String sec=String.valueOf(dateTime_1.getSeconds());
				String yudi=(year+"-"+mon+"-"+day+" "+hou+":"+minu+":"+sec);
				String yuli=lblNewLabel_12.getText().trim();
				String num=String.valueOf(spinner.getText().trim());//天数
				if(count==1 && Integer.parseInt(num)>0){
					//System.out.println();
					if((!fj.equals("")&& fj!=null)&&(!type.equals("")&& type!=null)&&(!xingming.equals("")&& xingming!=null)&&(!sex.equals("")&& sex!=null)&&(!liangxi.equals("")&&liangxi!=null)&&(!shenfen.equals("")&& shenfen!=null)&&(!yudi.equals("")&& yudi!=null)&&(!yuli.equals("")&& yuli!=null)&&(!num.equals("")&& num!=null)&&(!price.equals("")&& price!=null)&&(!Denglu.chuangzhi().equals("")&& Denglu.chuangzhi()!=null)){
						Insert(fj,type,xingming,sex,liangxi,shenfen,yudi,yuli,num,price,Denglu.chuangzhi());
						//房号 房间类型 顾客姓名 性别 联系方式 身份证号 预抵时间  预离时间 居住天数  1 1 1
						DataInfo.isNumber=1;
						//System.out.println("你怎么进来的");
						shell.close();
					}else{
						MessageDialog.openError(getShell(),"温馨提示","请完善您的信息，否则无法完成此预定");
					}
				}else{
					MessageDialog.openError(getShell(),"温馨提示","你选的时间和别的客户相冲突,请选择别的时间段");
					DataInfo.isNumber=0;
				}
				
			}
		});
		
		
		//点击取消
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				DataInfo.isNumber=0;
				shell.close();
			}
		});
		
	}
	
	
	protected Shell getShell() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	//添加日期的天数
	public String  addDay(){
		String str=null;
		int panduan=0;
		spinner.getText().trim();
		//System.out.println("得到"+spinner.getText().trim());
		int date=Integer.parseInt(spinner.getText().trim());
		//int date1=date+dateTime.getDay();
		int date2=dateTime.getDay();
		int mo=dateTime.getMonth()+1;
		int h=dateTime_1.getHours();
		int m=dateTime_1.getMinutes();
		int s=dateTime_1.getSeconds();
		//System.out.println(mo+"月份");
		int ye=dateTime.getYear();
		//System.out.println(ye+"年份");
		year(ye);
		String dayss=String .valueOf(date2);
		String month=String.valueOf(mo);
		String years=String.valueOf(ye);
		String hour=String.valueOf(h);
		String minutes=String.valueOf(m);
		String seconds=String.valueOf(s);
		//
		str=years+"-"+month+"-"+dayss+" "+hour+":"+minutes+":"+seconds;//预定离开日期
		//String str=years+"/"+month+"/"+dayss+" "+hour+":"+minutes+":"+seconds;//预定入住日期
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");     
		try {
			Date date11 = sdf.parse(str);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date11);
			calendar.add(Calendar.DATE,date );
			//System.out.println(calendar.toString()+"这个是他妈炒蛋的测试");
			Date da= new Date(calendar.getTimeInMillis());
			String dateStr=sdf.format(da);
			lblNewLabel_12.setText(dateStr);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return str;
	}
	//显示房号
//	public void ShowHoues(){
//		label.set
//		List<Map<String, Object>> list=yuding.find();
//		int len=yuding.count();
//		if(list!=null&& list.size()>0){
//			int i=0;
//			for(i=0;i<len;i++){
//				String str=String.valueOf(list.get(i).get("NUMBER_HOUSE"));
//				combo.add(str);
//			}		
//		}
//	}
	
	//显示房间价格
	public void ShowPrice(String s){
		List<Map<String, Object>> list=yuding.findprice(s);
		if(list!=null && list.size()>0){
			for(Map<String,Object> map:list){
				lblNewLabel_11.setText(String.valueOf(list.get(0).get("PRICE")));
				lblNewLabel_13.setText((String) list.get(0).get("TYPE_ROOM"));
			}
		}
	}
	
	//判断年份是闰年还平年
	public void year(int years){
		if(years%4==0&&years%100!=0 || years%400==0){ //说明是润年
			isRn=true;
		}else{
			isRn=false;
		}
	}
	
	//添加预定客户信息进数据库
	public void Insert(String order_room,String houes_type,String customer_name,String sex,String tel,String card_id,String order_date,String order_out,String order_state,String nunn,String lpq){
		//System.out.println(order_room+" "+houes_type+" "+customer_name+"这个是测试");
		int list=yuding.add(order_room, houes_type,customer_name, sex, tel,card_id,order_date, order_out, order_state,nunn,lpq);
		//System.out.println(list+"这个数数不呢输出");
		//房号 房间类型 顾客姓名 性别 联系方式 身份证号 预抵时间  预离时间 居住天数  1 1 1
	}
	
	//时间比较
	 public static int compare_date(String DATE1, String  DATE2) {
	       
	       
	        DateFormat df = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
	        try {
	            Date dt1 = df.parse(DATE1); //预住时间
	            Date dt2 = df.parse(DATE2); //入住时间(离开时间)
	           // Date dt3 = df.parse(DATE3); //入住时间（住进去时间）
	            if (dt1.getTime() >=dt2.getTime()) { //肯定能住
	               // System.out.println("dt1 在dt2后");
	                return 1;
	            } else  { //如果入住时间(离开时间)大于预住时间判断能不能住
	            		return -1;
	            	
	            }
	        } catch (Exception exception) {
	            exception.printStackTrace();
	        }
	        return 0;
	    }
	 
	 
	 //时间上进行比较是否合理
	 public static int compare_date1(String DATE1, Date DATE2) {
	       
	       
	        DateFormat df = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
	        try {
	            Date dt1 = df.parse(DATE1); //预离时间
	           // Date dt2 = df.parse(DATE2); //入住时间(住房时间)
	            if (dt1.getTime() > DATE2.getTime()) {  
	              //  System.out.println("预离时间在入住时间(住房时间)后");
	                return 1;
	            } else {
	            	
	                return -1;
	            }
	        } catch (Exception exception) {
	            exception.printStackTrace();
	        }
	        return 0;
	    }
}
