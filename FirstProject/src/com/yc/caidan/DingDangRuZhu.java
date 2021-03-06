package com.yc.caidan;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

import com.yc.Info.DataInfo;
import com.yc.productInfo.dao.DingDangDao;
import com.yc.productInfo.dao.QianTai1Dao;

import org.eclipse.nebula.widgets.cdatetime.CDT;
import org.eclipse.nebula.widgets.cdatetime.CDateTime;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.nebula.widgets.cdatetime.*;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import java.awt.Frame;
import org.eclipse.swt.awt.SWT_AWT;
import java.awt.Panel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.awt.BorderLayout;
import javax.swing.JRootPane;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.nebula.widgets.cdatetime.CDT;
import org.eclipse.nebula.widgets.cdatetime.CDateTime;


public class DingDangRuZhu {

	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private QianTai1Dao qt=new QianTai1Dao();
	private int   DingDan_Number;
	Random rd=new Random();
	private Date date;
	private Label label_2;
	private SimpleDateFormat df;
	private Label lblNewLabel_11;
	private DingDangDao ding=new DingDangDao();
	private  Label lblNewLabel_3 ;
	private Text text_5;
	private QianTai1Dao qtinfo=new QianTai1Dao();
	private DataInfo datainfo=new DataInfo();
	private int money;
	

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			DingDangRuZhu window = new DingDangRuZhu();
			window.open(null, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open(String  str,String str1) {	
		Display display = Display.getDefault();
		createContents(str,str1);
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
	protected void createContents(String st,final String st1) {
		//System.out.println(st+" "+st1+"这个订单的测试");
		
		shell = new Shell();
		shell.setBackgroundImage(SWTResourceManager.getImage(DingDangRuZhu.class, "/Image/72.jpg"));
		shell.setBackgroundMode(SWT.INHERIT_DEFAULT);
		shell.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 16, SWT.NORMAL));
		shell.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		shell.setSize(681, 471);
		shell.setText("预定转入住信息");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(49, 26, 61, 15);
		lblNewLabel.setText("房间类型：");
		
		
		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setBounds(49, 67, 61, 15);
		lblNewLabel_1.setText("房间号：");
		
		Label label = new Label(shell, SWT.NONE);
		label.setText("订单单号：");
		label.setBounds(49, 104, 61, 15);
		
		final Label lblNewLabel_2 = new Label(shell, SWT.NONE);
		lblNewLabel_2.setBounds(133, 104, 107, 24);
		DingDan_Number=rd.nextInt(100000)+1586965;
		lblNewLabel_2.setText(String.valueOf(DingDan_Number));
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setBounds(49, 136, 61, 15);
		label_1.setText("打折比例：");
		
		 lblNewLabel_3 = new Label(shell, SWT.NONE);
		lblNewLabel_3.setBounds(133, 136, 107, 24);
		
		Label lblNewLabel_4 = new Label(shell, SWT.NONE);
		lblNewLabel_4.setBounds(49, 177, 61, 15);
		lblNewLabel_4.setText("宾客类型：");
		
		final Label lblNewLabel_5 = new Label(shell, SWT.NONE);
		lblNewLabel_5.setBounds(133, 177, 107, 24);
		
		Label lblNewLabel_6 = new Label(shell, SWT.NONE);
		lblNewLabel_6.setBounds(49, 222, 61, 15);
		lblNewLabel_6.setText("宾客年龄：");
		
		final Spinner spinner = new Spinner(shell, SWT.BORDER);
		spinner.setSelection(18);
		spinner.setBounds(133, 222, 107, 22);
		
		Label lblNewLabel_7 = new Label(shell, SWT.NONE);
		lblNewLabel_7.setBounds(49, 269, 61, 15);
		lblNewLabel_7.setText("宾客性别：");
		
		Label lblNewLabel_9 = new Label(shell, SWT.NONE);
		lblNewLabel_9.setBounds(49, 313, 61, 15);
		lblNewLabel_9.setText("邮箱地址：");
		
		final Combo combo_2 = new Combo(shell, SWT.READ_ONLY);
		combo_2.setBounds(133, 269, 107, 24);
		combo_2.add("男");
		combo_2.add("女");
		
		text = new Text(shell, SWT.BORDER);
		text.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 15, SWT.NORMAL));
		text.setBounds(133, 307, 418, 34);
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.setBounds(160, 352, 80, 25);
		btnNewButton.setText("取消");
		
		Button btnNewButton_1 = new Button(shell, SWT.NONE);
		btnNewButton_1.setBounds(326, 352, 80, 25);
		btnNewButton_1.setText("确认");
		
		Label lblNewLabel_8 = new Label(shell, SWT.NONE);
		lblNewLabel_8.setBounds(326, 26, 61, 15);
		lblNewLabel_8.setText("订单开始时间：");
		
		final Label lblNewLabel_10 = new Label(shell, SWT.NONE);
		lblNewLabel_10.setBounds(414, 26, 129, 23);
		/**
		 * 获取系统时间
		 */
		 df= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		date=new Date();
		String str=df.format(date);
		lblNewLabel_10.setText(str);
		
		 lblNewLabel_11 = new Label(shell, SWT.NONE);
		lblNewLabel_11.setBounds(326, 67, 61, 15);
		lblNewLabel_11.setText("预住天数：");
		
		Label lblNewLabel_12 = new Label(shell, SWT.NONE);
		lblNewLabel_12.setBounds(326, 104, 61, 15);
		lblNewLabel_12.setText("订单结束时间：");
		
		 label_2 = new Label(shell, SWT.NONE);
		label_2.setBounds(414, 104, 124, 23);
		
		Label lblNewLabel_13 = new Label(shell, SWT.NONE);
		lblNewLabel_13.setBounds(326, 136, 61, 15);
		lblNewLabel_13.setText("实收押金：");
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(414, 136, 137, 24);
		
		Label lblNewLabel_14 = new Label(shell, SWT.NONE);
		lblNewLabel_14.setBounds(326, 177, 61, 15);
		lblNewLabel_14.setText("宾客姓名：");
		
		text_2 = new Text(shell, SWT.BORDER | SWT.READ_ONLY);
		text_2.setBounds(409, 174, 137, 23);
		
		Label lblNewLabel_15 = new Label(shell, SWT.NONE);
		lblNewLabel_15.setBounds(326, 222, 61, 15);
		lblNewLabel_15.setText("证件编号：");
		
		text_3 = new Text(shell, SWT.BORDER | SWT.READ_ONLY);
		text_3.setBounds(414, 222, 137, 21);
		
		Label lblNewLabel_16 = new Label(shell, SWT.NONE);
		lblNewLabel_16.setBounds(326, 269, 61, 15);
		lblNewLabel_16.setText("联系电话：");
		
		text_4 = new Text(shell, SWT.BORDER | SWT.READ_ONLY);
		text_4.setBounds(414, 263, 137, 21);
		
		Label lblNewLabel_17 = new Label(shell, SWT.NONE);
		lblNewLabel_17.setBounds(431, 362, 61, 15);
		lblNewLabel_17.setText("营业员：");
		
		final Label lblNewLabel_18 = new Label(shell, SWT.NONE);
		lblNewLabel_18.setBounds(514, 362, 114, 15);
		lblNewLabel_18.setText(Denglu.chuangzhi());
		
		Label label_3 = new Label(shell, SWT.NONE);
		label_3.setBounds(133, 26, 107, 23);
		//System.out.println(st+"房间类型");
		label_3.setText(st);//房间类型
		
		final Label label_4 = new Label(shell, SWT.NONE);
		label_4.setBounds(133, 67, 107, 24);
		//System.out.println(st1+"房间号");
		label_4.setText(st1);//房间号
		
		text_5 = new Text(shell, SWT.BORDER | SWT.READ_ONLY);
		text_5.setBounds(414, 67, 129, 21);
		text_5.setText(st1);
		List<Map<String,Object>> list33=new ArrayList<Map<String,Object>>();
		list33=qtinfo.roomDing(st1);
		if(label_2.getText()==null || label_2.getText().length()<=0 || label_2.getText().equals("")){
			ChangDate(Integer.parseInt(text_5.getText().trim()));
		}//获取预离时间
		text_2.setText(String.valueOf(list33.get(0).get("CUSTOMER_NAME")));//顾客姓名
		text_3.setText(String.valueOf(list33.get(0).get("CARD_ID")));//身份号
		List<Map<String, Object>>  list= new ArrayList<Map<String,Object>>();
		list =ding.FindId(text_3.getText().trim());
		if(list !=null && list.size()>0){
			lblNewLabel_5.setText(String.valueOf(list.get(0).get("TYPE_CUSTOMER")));
			ChangType(lblNewLabel_5.getText().trim());
		}else{//说明这位顾客还不是会员
			lblNewLabel_5.setText("普通");
			lblNewLabel_3.setText("无折扣");
		}
		text_4.setText(String.valueOf(list33.get(0).get("TEL")));//电话号码
		combo_2.setText(String.valueOf(list33.get(0).get("SEX")));//性别
		
		final Label lblNewLabel_19 = new Label(shell, SWT.NONE);
		lblNewLabel_19.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 9, SWT.BOLD));
		lblNewLabel_19.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblNewLabel_19.setBounds(557, 143, 61, 17);
		//text_3.setText(String.valueOf(list33.get(0).get("CARD_ID")));//身份证号
		
		//点击确认
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int count=1;//存储当前数据填写完整度情况
				List<Map<String, Object>>  list= new ArrayList<Map<String,Object>>();
				try {
					String s=text_2.getText().trim();//姓名
					String s1=text_3.getText().trim();//证件编号
					String s2=combo_2.getText().trim();//性别
					String s3=spinner.getText().trim();//年龄
					String s4=text_4.getText().trim();//联系电话
					String s5=text.getText().trim();//邮箱地址
					String s6=lblNewLabel_5.getText().trim();//宾客类型
					if((s!=null&&!s.equals("")) && (s1!=null&&!s1.equals("")) && (s2!=null&&!s2.equals("")) && (s3!=null&&!s3.equals("")) && (s4!=null&&!s4.equals("")) &&(s5!=null&&!s5.equals("")) && (s6!=null&&!s6.equals(""))){
						ding.InsertCustomer(s, s1, s2, s3, s4, s5, s6);
						//.out.println("这个是预定转入住的测试111111111111111111111111111111111");
					}else{
						count=0;
						MessageDialog.openError(shell, "温馨提示", "信息填写有问题，请从新填写");
					}
					String str=null;
					if(text_3.getText().trim()!=null && !text_3.getText().trim().equals("")){
						try {
							list =ding.Find(text_3.getText().trim());
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						 str=String.valueOf(list.get(0).get("CUSTOMER_ID"));//获取顾客编号
					}
					
						
						String str1=label_4.getText().trim();//获取房号
						String str2=text_1.getText().trim();//押金
						String str3=lblNewLabel_10.getText().trim();//入住时间
						String  str4=text_5.getText().trim();//入住天数
						String str5=label_2.getText().trim();//预计离开时间
						String str7=lblNewLabel_2.getText().trim();//获取订单单号
						List<Map<String, Object>>  list2= new ArrayList<Map<String,Object>>();
						list2=ding.FindPrice(st1);
						money=Integer.parseInt(String.valueOf(list2.get(0).get("PRICE")));
							if((str!=null&&!str.equals("")) && (str1!=null&&!str1.equals("")) && (str2!=null&&!str2.equals("")) && (str3!=null&&!str3.equals("")) && (str4!=null&&!str4.equals("")) &&(str5!=null&&!str5.equals("")) && (str7!=null&&!str7.equals(""))&& (lblNewLabel_18.getText().trim()!=null&&!lblNewLabel_18.getText().trim().equals("")) && count>0){	
										if(Integer.parseInt(text_1.getText().trim())>(money/2)){
										//	System.out.println(money/2+"这个是价格的测速");
											lblNewLabel_19.setText("");
											ding.Insert(str, str1, str2, str3, str4, str5,"没结账",str7,lblNewLabel_18.getText().trim());//把数据插入订单
									}else{
										count =0;
										MessageDialog.openError(shell, "温馨提示", "押金不够，押金至少为房价的一半");
										int mon=money/2+1;
										lblNewLabel_19.setText("$"+mon);
									}
							}else{
								if(count==1){
									MessageDialog.openError(shell, "温馨提示", "信息填写有问题，请从新填写");
									count =0;
								}
								
							}
						
						if(count==1){
						//ystem.out.println("成功插入个各种数据,这是个测试");
							List<Map<String,Object>> list44=new ArrayList<Map<String,Object>>();
							list44=qtinfo.roomDing(st1);
							qtinfo.updateYuding(String.valueOf(list44.get(0).get("ORDER_NUMBER")));
							datainfo.isNumber=1;
							//System.out.println("成功插入个各种数据");
							shell.dispose();
						
						}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					
				
			}
		});
		//点击取消
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.dispose();
				datainfo.isNumber=0;

			}
		});
		
	}
	//折扣
	public void ChangType(String str){
		switch (str){
		case "贵宾":  lblNewLabel_3.setText("七折");break;
		case "普通": lblNewLabel_3.setText("无折扣");break;
		}
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
			public void ChangDate(int day){
				/**
				 * 订单预计结束时间
				 */
				Calendar now= Calendar.getInstance();
				now.setTime(date);
				now.set(Calendar.DATE,now.get(Calendar.DATE)+day);
				label_2.setText(String.valueOf(df.format(now.getTime())));
				
			}
}
