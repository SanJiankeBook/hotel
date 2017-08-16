package com.yc.caidan;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.custom.SashForm;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.eclipse.core.commands.ParameterTypeEvent;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.wb.swt.SWTResourceManager;

import com.yc.Info.DataInfo;
import com.yc.productInfo.dao.*;

import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.custom.TableCursor;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;

public class QianTai1 extends Composite {
	private QianTai1Dao qtinfo=new QianTai1Dao();
	private int heigth;
	private int width;
	private int sum=0;
	private Label lblNewLabel_21 ;
	private int count1;
	private String str=null;
	private int acount=0;
	private List<Map<String, Object>> params=new ArrayList<Map<String, Object>>();
	private Label lblNewLabel_17;//顾客类型
	private Label lblL;//顾客姓名
	private Label lblNewLabel_30;//年龄
	private Label lblNewLabel_22;//房间价格
	private Label lblNewLabel_23;//房间楼层
	private Label lblNewLabel_24 ;//入住开始时间
	private Label lblNewLabel_25;//预计退房时间
	private Label lblNewLabel_26;//押金
	private Label lblNewLabel_28;//联系方式
	private String str1=null;//房号
	private Label label;//订单单号

	private MenuItem item;
	private MenuItem item1;
	private MenuItem item2;
	private MenuItem item3;
	private MenuItem item4;
	private MenuItem item5;
	private MenuItem item6;
	
	String temp="";

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public QianTai1(Composite parent, int style) {
		super(parent, style);
		setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_DARK_SHADOW));
		setLayout(new FillLayout(SWT.HORIZONTAL));
		SashForm sashForm = new SashForm(this, SWT.NONE);
		sashForm.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_DARK_SHADOW));

		Composite composite = new Composite(sashForm, SWT.NONE);
		composite.setBackgroundImage(SWTResourceManager.getImage(QianTai1.class, "/Image/235045-12100Z2254697.jpg"));
		composite.setBackgroundMode(SWT.INHERIT_DEFAULT);
		composite.setBackground(SWTResourceManager.getColor(SWT.COLOR_CYAN));

		Composite composite_1 = new Composite(sashForm, SWT.NONE);
		composite_1.setLayout(new FillLayout(SWT.HORIZONTAL));

		SashForm sashForm_1 = new SashForm(composite_1, SWT.VERTICAL);
		sashForm_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_DARK_SHADOW));

		Composite composite_2 = new Composite(sashForm_1, SWT.NONE);//房间
		composite_2.setBackgroundImage(SWTResourceManager.getImage(QianTai1.class, "/Image/96g58PICMPs_1024.jpg"));

		composite_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		composite_2.setBackgroundMode(SWT.INHERIT_DEFAULT);

		Composite composite_3 = new Composite(sashForm_1, SWT.NONE);
		composite_3.setBackgroundImage(SWTResourceManager.getImage(QianTai1.class, "/Image/07p58PIC4da_看图王.jpg"));

		Composite composite_4 = new Composite(composite_3, SWT.NONE);
		composite_4.setBackgroundMode(SWT.INHERIT_DEFAULT);
		composite_4.setBackground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
		composite_4.setBounds(27, 10, 64, 64);

		Label lblNewLabel = new Label(composite_4, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("黑体", 10, SWT.BOLD));
		lblNewLabel.setBounds(0, 0, 61, 15);
		lblNewLabel.setText("  全部");

		Label lblNewLabel_1 = new Label(composite_4, SWT.NONE);
		lblNewLabel_1.setBounds(0, 21, 61, 15);

		Composite composite_5 = new Composite(composite_3, SWT.NONE);
		composite_5.setBackgroundMode(SWT.INHERIT_DEFAULT);
		composite_5.setBackground(SWTResourceManager.getColor(SWT.COLOR_YELLOW));
		composite_5.setBounds(132, 10, 64, 64);

		Label lblNewLabel_2 = new Label(composite_5, SWT.NONE);
		lblNewLabel_2.setFont(SWTResourceManager.getFont("黑体", 10, SWT.BOLD));
		lblNewLabel_2.setText("  空");
		lblNewLabel_2.setBounds(0, 0, 61, 15);

		Composite composite_6 = new Composite(composite_3, SWT.NONE);
		composite_6.setBackgroundMode(SWT.INHERIT_DEFAULT);
		composite_6.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		composite_6.setBounds(243, 10, 64, 64);

		Label lblNewLabel_3 = new Label(composite_6, SWT.NONE);
		lblNewLabel_3.setFont(SWTResourceManager.getFont("黑体", 10, SWT.BOLD));
		lblNewLabel_3.setBounds(0, 0, 61, 15);
		lblNewLabel_3.setText("  脏房");

		Composite composite_7 = new Composite(composite_3, SWT.NONE);
		composite_7.setBackground(SWTResourceManager.getColor(SWT.COLOR_CYAN));
		composite_7.setBackgroundMode(SWT.INHERIT_DEFAULT);
		composite_7.setBounds(353, 10, 64, 64);

		Label lblNewLabel_4 = new Label(composite_7, SWT.NONE);
		lblNewLabel_4.setFont(SWTResourceManager.getFont("黑体", 10, SWT.BOLD));
		lblNewLabel_4.setBounds(0, 0, 61, 15);
		lblNewLabel_4.setText("  预定");

		Composite composite_8 = new Composite(composite_3, SWT.NONE);
		composite_8.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_GREEN));
		composite_8.setBackgroundMode(SWT.INHERIT_DEFAULT);
		composite_8.setBounds(451, 10, 64, 64);

		Label lblNewLabel_14 = new Label(composite_8, SWT.NONE);
		lblNewLabel_14.setFont(SWTResourceManager.getFont("黑体", 10, SWT.BOLD));
		lblNewLabel_14.setBounds(0, 0, 61, 15);
		lblNewLabel_14.setText("  住人");

		Composite composite_9 = new Composite(composite_3, SWT.NONE);
		composite_9.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_YELLOW));
		composite_9.setBackgroundMode(SWT.INHERIT_DEFAULT);
		composite_9.setBounds(543, 10, 64, 64);

		Label lblNewLabel_15 = new Label(composite_9, SWT.NONE);
		lblNewLabel_15.setFont(SWTResourceManager.getFont("黑体", 10, SWT.BOLD));
		lblNewLabel_15.setBounds(0, 0, 61, 15);
		lblNewLabel_15.setText("  维护");
		
		sashForm.setWeights(new int[] {212, 587});
		Label lblNewLabel_5 = new Label(composite , SWT.NONE);
		lblNewLabel_5.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		lblNewLabel_5.setFont(SWTResourceManager.getFont("方正兰亭超细黑简体", 9, SWT.BOLD));
		lblNewLabel_5.setText("顾客姓名：");
		lblNewLabel_5.setBounds(10, 10, 61, 17);

		Label lblNewLabel_6 = new Label(composite, SWT.NONE);
		lblNewLabel_6.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		lblNewLabel_6.setFont(SWTResourceManager.getFont("方正兰亭超细黑简体", 9, SWT.BOLD));
		lblNewLabel_6.setBounds(10, 33, 36, 17);
		lblNewLabel_6.setText("年龄：");

		Label lblNewLabel_7 = new Label(composite, SWT.NONE);
		lblNewLabel_7.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		lblNewLabel_7.setFont(SWTResourceManager.getFont("方正兰亭超细黑简体", 9, SWT.BOLD));
		lblNewLabel_7.setBounds(10, 56, 61, 17);
		lblNewLabel_7.setText("房间价格：");

		Label lblNewLabel_8 = new Label(composite, SWT.NONE);
		lblNewLabel_8.setFont(SWTResourceManager.getFont("方正兰亭超细黑简体", 9, SWT.BOLD));
		lblNewLabel_8.setBounds(10, 83, 61, 17);
		lblNewLabel_8.setText("房间楼层：");

		Label lblNewLabel_9 = new Label(composite, SWT.NONE);
		lblNewLabel_9.setFont(SWTResourceManager.getFont("方正兰亭超细黑简体", 9, SWT.BOLD));
		lblNewLabel_9.setText("入住开始时间：");
		lblNewLabel_9.setBounds(10, 106, 80, 17);

		Label lblNewLabel_10 = new Label(composite, SWT.NONE);
		lblNewLabel_10.setFont(SWTResourceManager.getFont("方正兰亭超细黑简体", 9, SWT.BOLD));
		lblNewLabel_10.setText("退房时间：");
		lblNewLabel_10.setBounds(10, 175, 61, 17);

		Label lblNewLabel_11 = new Label(composite, SWT.NONE);
		lblNewLabel_11.setFont(SWTResourceManager.getFont("方正兰亭超细黑简体", 9, SWT.BOLD));
		lblNewLabel_11.setBounds(10, 243, 61, 17);
		lblNewLabel_11.setText("已收押金：");

		Label lblNewLabel_13 = new Label(composite, SWT.NONE);
		lblNewLabel_13.setFont(SWTResourceManager.getFont("方正兰亭超细黑简体", 9, SWT.BOLD));
		lblNewLabel_13.setBounds(10, 276, 61, 17);
		lblNewLabel_13.setText("联系方式：");
		final Label lblNewLabel_21 = new Label(composite_2, SWT.NONE);
		sashForm_1.setWeights(new int[] {445, 82});

		lblNewLabel_22 = new Label(composite, SWT.NONE);
		lblNewLabel_22.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 9, SWT.BOLD));
		lblNewLabel_22.setBounds(77, 60, 61, 17);

		lblNewLabel_23 = new Label(composite, SWT.NONE);
		lblNewLabel_23.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 9, SWT.BOLD));
		lblNewLabel_23.setBounds(77, 83, 61, 17);

		lblNewLabel_24 = new Label(composite, SWT.NONE);
		lblNewLabel_24.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 9, SWT.BOLD));
		lblNewLabel_24.setBounds(10, 129, 170, 40);

		lblNewLabel_25 = new Label(composite, SWT.NONE);
		lblNewLabel_25.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 9, SWT.BOLD));
		lblNewLabel_25.setBounds(10, 198, 170, 39);

		lblNewLabel_26 = new Label(composite, SWT.NONE);
		lblNewLabel_26.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 9, SWT.BOLD));
		lblNewLabel_26.setBounds(77, 243, 61, 17);

		lblNewLabel_28 = new Label(composite, SWT.NONE);
		lblNewLabel_28.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 9, SWT.BOLD));
		lblNewLabel_28.setBounds(77, 276, 61, 17);

		lblNewLabel_30 = new Label(composite, SWT.NONE);
		lblNewLabel_30.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 9, SWT.BOLD));
		lblNewLabel_30.setBounds(74, 33, 49, 17);

		lblL = new Label(composite, SWT.NONE);
		lblL.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 9, SWT.BOLD));
		lblL.setBounds(88, 12, 61, 15);

		Label lblNewLabel_16 = new Label(composite, SWT.NONE);
		lblNewLabel_16.setFont(SWTResourceManager.getFont("方正兰亭超细黑简体", 9, SWT.BOLD));
		lblNewLabel_16.setBounds(10, 299, 61, 15);
		lblNewLabel_16.setText("顾客类型：");

		lblNewLabel_17 = new Label(composite, SWT.NONE);
		lblNewLabel_17.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 9, SWT.BOLD));
		lblNewLabel_17.setBounds(77, 299, 61, 15);
		
		Label lblNewLabel_12 = new Label(composite, SWT.NONE);
		lblNewLabel_12.setFont(SWTResourceManager.getFont("方正兰亭超细黑简体", 9, SWT.BOLD));
		lblNewLabel_12.setBounds(10, 330, 61, 15);
		lblNewLabel_12.setText("订单号：");
		
	 label = new Label(composite, SWT.NONE);//订单号
	 label.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 9, SWT.BOLD));
		label.setBounds(77, 330, 103, 15);

		show(composite_2);
	}
	
	public void show(Composite composite_2){
		List<Map<String, Object>>  list= new ArrayList<Map<String,Object>>();//开始存储返回的值
		params=qtinfo.roomCount1();
		count1=0;
		for(Map<String, Object> map : params){
			count1++;//通过循环来确定有几条数据，从而得到有几个房间

		}
		showRoom1(composite_2,count1);

		count1=0;//在第二次用的时候应该要将它初始化
		params=qtinfo.roomCount2();
		for(Map<String, Object> map : params){
			count1++;
		}
		//System.out.println(count1);
		showRoom2(composite_2,count1);

		count1=0;
		params=qtinfo.roomCount3();
		for(Map<String, Object> map : params){
			count1++;
		}
		//System.out.println(count1);
		showRoom3(composite_2,count1);

	}
	
	public void showRoom1(final Composite composite_2,int count1){
		lblNewLabel_21=new Label(composite_2, SWT.NONE);
		lblNewLabel_21.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		lblNewLabel_21.setAlignment(SWT.CENTER);
		lblNewLabel_21.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 16, SWT.NORMAL));
		lblNewLabel_21.setText("一楼");//创建一楼的表
		lblNewLabel_21.setBounds(10, 10, 69, 64);

		List<Map<String, Object>> list=new ArrayList<Map<String, Object>>();
		list=qtinfo.find("一楼");

		for(int i=0;i<count1;i++){
			int count= 185;
			if(i<5){
				acount=i;
				//每循环一次，new一个面板
				sum=0;//sum在这里表示当前行数
				heigth=69*sum;

				final Composite composite_14 = new Composite(composite_2, SWT.NONE);
				composite_14.setBounds(80+i*count, 10+heigth*sum, 180, 64);

				final Label text = new Label(composite_14, SWT.BORDER);//房号
				text.setBounds(10, 10, 70, 21);

				final Label text_1 = new Label(composite_14, SWT.BORDER);//房间类型
				text_1.setBounds(90, 10, 70, 21);

				final Label text_2 = new Label(composite_14, SWT.BORDER);//状态
				text_2.setBounds(10, 37, 70, 21);

				final Label  text_3 = new Label(composite_14, SWT.BORDER);//顾客姓名
				text_3.setBounds(90, 37, 70, 21);

				try {
					text.setText(String.valueOf(params.get(acount).get("NUMBER_HOUSE"))); //房号
					text_1.setText(String.valueOf(params.get(acount).get("TYPE_ROOM")));//房间类型
					text_2.setText(String.valueOf(params.get(acount).get("ROOM_STATE")));//房间状态
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				String str2=text_2.getText().trim();
				color(composite_14,str2);
				
				composite_14.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseUp(MouseEvent e) {
						//System.out.println(Denglu.chuangzhi());
						List<Map<String, Object>> list1=new ArrayList<Map<String, Object>>();
						List<Map<String,Object>> list2=new ArrayList<Map<String, Object>>();
						List<Map<String,Object>> list3=new ArrayList<Map<String, Object>>();
						try {
							clear();
							list1=qtinfo.findRoom(text.getText().trim());
							list2=qtinfo.room(text.getText().trim());
							list3=qtinfo.roomYuDing(text.getText().trim());
							text_3.setText("");
								lblNewLabel_22.setText(String.valueOf(list2.get(0).get("PRICE")));//房间价格
								lblNewLabel_23.setText(String.valueOf(list2.get(0).get("FLOOR_1")));//楼层
								if(String.valueOf(list2.get(0).get("ROOM_STATE")).equals("住人") ){
									
								text_3.setText(String.valueOf(list1.get(0).get("CUSTOMER_NAME")));//顾客姓名
								lblL.setText(String.valueOf(list1.get(0).get("CUSTOMER_NAME")));//顾客姓名
								lblNewLabel_30.setText(String.valueOf(list1.get(0).get("AGE")));//年龄
								
								lblNewLabel_24.setText(String.valueOf(list1.get(0).get("DATE_IN")));//入住开始时间
								lblNewLabel_25.setText(String.valueOf(list1.get(0).get("DATE_OUT")));//预计退房时间
								lblNewLabel_26.setText(String.valueOf(list1.get(0).get("CASH")));//押金
								lblNewLabel_28.setText(String.valueOf(list1.get(0).get("TEL")));//联系方式
								lblNewLabel_17.setText(String.valueOf(list1.get(0).get("TYPE_CUSTOMER")));//顾客类型
								label.setText("");
								label.setText(String.valueOf(list1.get(0).get("EVXX")));
							}else if(String.valueOf(list2.get(0).get("ROOM_STATE")).equals("预定")){
								lblNewLabel_28.setText(String.valueOf(list3.get(0).get("TEL")));//联系方式
								lblL.setText(String.valueOf(list3.get(0).get("CUSTOMER_NAME")));//顾客姓名
								lblNewLabel_24.setText(String.valueOf(list3.get(0).get("ORDER_IN")));//入住开始时间
								lblNewLabel_25.setText(String.valueOf(list3.get(0).get("ORDER_OUT")));//预计退房时间
							}
							
						} catch (Exception e1) {
							e1.printStackTrace();
						}

						if (e.button == 3) {
							str1=text.getText().trim();
							Menu menu = new Menu(composite_14.getShell(),SWT.POP_UP);
							menu(composite_2,composite_14,menu,text,text_1,text_2,text_3);	
							menu.setVisible(true);
						}
					}
				});

			}else if(i>=5){
				acount=i;
				sum=1;
				heigth=69*sum;
				final Composite	 composite_14 = new Composite(composite_2, SWT.NONE);
				composite_14.setBounds(80+(i-5)*count,10+heigth, 180, 64);

				final Label text = new Label(composite_14, SWT.BORDER);//房号
				text.setBounds(10, 10, 70, 21);

				final Label  text_1 = new Label(composite_14, SWT.BORDER);//房间类型
				text_1.setBounds(90, 10, 70, 21);

				final Label text_2 = new Label(composite_14, SWT.BORDER);//状态
				text_2.setBounds(10, 37, 70, 21);

				final Label  text_3 = new Label(composite_14, SWT.BORDER);//顾客姓名
				text_3.setBounds(90, 37, 70, 21);

				try {
					text.setText(String.valueOf(params.get(acount).get("NUMBER_HOUSE")));
					text_1.setText(String.valueOf(params.get(acount).get("TYPE_ROOM")));
					text_2.setText(String.valueOf(params.get(acount).get("ROOM_STATE")));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				String str2=text_2.getText().trim();
				color(composite_14,str2);
				composite_14.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseUp(MouseEvent e) {
						List<Map<String, Object>> list1=new ArrayList<Map<String, Object>>();
						List<Map<String,Object>> list2=new ArrayList<Map<String, Object>>();
						try {
							clear();
							text_3.setText("");
							list1=qtinfo.findRoom(text.getText().trim());
							list2=qtinfo.room(text.getText().trim());
								lblNewLabel_22.setText(String.valueOf(list2.get(0).get("PRICE")));//房间价格
								lblNewLabel_23.setText(String.valueOf(list2.get(0).get("FLOOR_1")));//楼层
								if(String.valueOf(list2.get(0).get("ROOM_STATE")).equals("住人") || String.valueOf(list2.get(0).get("ROOM_STATE")).equals("预定")){
									text_3.setText(String.valueOf(list1.get(0).get("CUSTOMER_NAME")));//顾客姓名
								lblL.setText(String.valueOf(list1.get(0).get("CUSTOMER_NAME")));//顾客姓名
								lblNewLabel_30.setText(String.valueOf(list1.get(0).get("AGE")));//年龄
								
								lblNewLabel_24.setText(String.valueOf(list1.get(0).get("DATE_IN")));//入住开始时间
								lblNewLabel_25.setText(String.valueOf(list1.get(0).get("DATE_OUT")));//预计退房时间
								lblNewLabel_26.setText(String.valueOf(list1.get(0).get("CASH")));//押金
								lblNewLabel_28.setText(String.valueOf(list1.get(0).get("TEL")));//联系方式
								label.setText("");
								label.setText(String.valueOf(list1.get(0).get("EVXX")));
								lblNewLabel_17.setText(String.valueOf(list1.get(0).get("TYPE_CUSTOMER")));//顾客类型
							}
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						if (e.button == 3) {
							str1=text.getText().trim();
							Menu menu = new Menu(composite_14.getShell(),SWT.POP_UP);
							menu(composite_2,composite_14,menu,text,text_1,text_2,text_3);
							menu.setVisible(true);
						}

					}
				});
			}else if(i>=10){
				MessageDialog.openError(composite_2.getShell(), "错误信息","不能再往里面添加房间，一楼上限为10间房");
			}
		}

	}
	public void showRoom2(final Composite composite_2,int count1){
		lblNewLabel_21=new Label(composite_2, SWT.NONE);
		lblNewLabel_21.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		lblNewLabel_21.setAlignment(SWT.CENTER);
		lblNewLabel_21.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 16, SWT.NORMAL));
		lblNewLabel_21.setText("二楼");
		lblNewLabel_21.setBounds(10, 10+(69*(sum+1)), 69, 64);
		//System.out.println(10+(69*(sum+1)));
		List<Map<String, Object>> list=new ArrayList<Map<String, Object>>();
		list=qtinfo.find("二楼");
		for(int i=0;i<count1;i++){
			int count= 185;
			acount=i;
			if(i<5){
				//每循环一次，new一个面板
				if(i==0){
					if(sum==0){//如果到达这一步，应该将sum在它原有的基础上加上
						sum=1;
					}else{
						sum=2;
					}
					//System.out.println("二楼"+sum);
				}

				heigth=69*sum;
				final Composite composite_14 = new Composite(composite_2, SWT.NONE);
				composite_14.setBounds(80+i*count, 10+heigth, 180, 64);

				final Label text = new Label(composite_14, SWT.BORDER);//房号
				text.setBounds(10, 10, 70, 21);

				final Label  text_1 = new Label(composite_14, SWT.BORDER);//房间类型
				text_1.setBounds(90, 10, 70, 21);

				final Label  text_2 = new Label(composite_14, SWT.BORDER);//状态
				text_2.setBounds(10, 37, 70, 21);

				final Label text_3 = new Label(composite_14, SWT.BORDER);//顾客姓名
				text_3.setBounds(90, 37, 70, 21);

				try {
					text.setText(String.valueOf(params.get(acount).get("NUMBER_HOUSE")));
					text_1.setText(String.valueOf(params.get(acount).get("TYPE_ROOM")));
					text_2.setText(String.valueOf(params.get(acount).get("ROOM_STATE")));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				String str2=text_2.getText().trim();
				color(composite_14,str2);
				composite_14.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseUp(MouseEvent e) {
						List<Map<String, Object>> list1=new ArrayList<Map<String, Object>>();
						List<Map<String,Object>> list2=new ArrayList<Map<String, Object>>();
						try {
							clear();	
							text_3.setText("");
							list1=qtinfo.findRoom(text.getText().trim());
							list2=qtinfo.room(text.getText().trim());
								lblNewLabel_22.setText(String.valueOf(list2.get(0).get("PRICE")));//房间价格
								lblNewLabel_23.setText(String.valueOf(list2.get(0).get("FLOOR_1")));//楼层
								if(String.valueOf(list2.get(0).get("ROOM_STATE")).equals("住人") || String.valueOf(list2.get(0).get("ROOM_STATE")).equals("预定")){
									text_3.setText(String.valueOf(list1.get(0).get("CUSTOMER_NAME")));//顾客姓名
								lblL.setText(String.valueOf(list1.get(0).get("CUSTOMER_NAME")));//顾客姓名
								lblNewLabel_30.setText(String.valueOf(list1.get(0).get("AGE")));//年龄
								label.setText("");
								label.setText(String.valueOf(list1.get(0).get("EVXX")));//订单单号
								lblNewLabel_24.setText(String.valueOf(list1.get(0).get("DATE_IN")));//入住开始时间
								lblNewLabel_25.setText(String.valueOf(list1.get(0).get("DATE_OUT")));//预计退房时间
								lblNewLabel_26.setText(String.valueOf(list1.get(0).get("CASH")));//押金
								lblNewLabel_28.setText(String.valueOf(list1.get(0).get("TEL")));//联系方式
								lblNewLabel_17.setText(String.valueOf(list1.get(0).get("TYPE_CUSTOMER")));//顾客类型
							}
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						if (e.button == 3) {
							str1=text.getText().trim();
							Menu menu = new Menu(composite_14.getShell(),SWT.POP_UP);
							menu(composite_2,composite_14,menu,text,text_1,text_2,text_3);
							menu.setVisible(true);
						}

					}
				});
			}else if(i>=5){
				//每循环一次，new一个面板
				if(i==5){
					if(sum==1){
						sum=2;
					}else{
						sum=3;
					}
					//System.out.println("二楼"+sum);
				}
				acount=i;
				heigth=69*sum;
				final Composite composite_14 = new Composite(composite_2, SWT.NONE);
				composite_14.setBounds(80+(i-5)*count,10+heigth, 180, 64);

				final Label text = new Label(composite_14, SWT.BORDER);//房号
				text.setBounds(10, 10, 70, 21);

				final Label  text_1 = new Label(composite_14, SWT.BORDER);//房间类型
				text_1.setBounds(90, 10, 70, 21);

				final Label  text_2 = new Label(composite_14, SWT.BORDER);//状态
				text_2.setBounds(10, 37, 70, 21);

				final Label  text_3 = new Label(composite_14, SWT.BORDER);//顾客姓名
				text_3.setBounds(90, 37, 70, 21);

				try {
					text.setText(String.valueOf(params.get(acount).get("NUMBER_HOUSE")));
					text_1.setText(String.valueOf(params.get(acount).get("TYPE_ROOM")));
					text_2.setText(String.valueOf(params.get(acount).get("ROOM_STATE")));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				String str2=text_2.getText().trim();
				color(composite_14,str2);
				composite_14.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseUp(MouseEvent e) {
						List<Map<String, Object>> list1=new ArrayList<Map<String, Object>>();
						List<Map<String,Object>> list2=new ArrayList<Map<String, Object>>();
						try {
							clear();		
							text_3.setText("");
							list1=qtinfo.findRoom(text.getText().trim());
							list2=qtinfo.room(text.getText().trim());
								lblNewLabel_22.setText(String.valueOf(list2.get(0).get("PRICE")));//房间价格
								lblNewLabel_23.setText(String.valueOf(list2.get(0).get("FLOOR_1")));//楼层
								if(String.valueOf(list2.get(0).get("ROOM_STATE")).equals("住人") || String.valueOf(list2.get(0).get("ROOM_STATE")).equals("预定")){
									text_3.setText(String.valueOf(list1.get(0).get("CUSTOMER_NAME")));//顾客姓名
								lblL.setText(String.valueOf(list1.get(0).get("CUSTOMER_NAME")));//顾客姓名
								lblNewLabel_30.setText(String.valueOf(list1.get(0).get("AGE")));//年龄
								label.setText("");
								label.setText(String.valueOf(list1.get(0).get("EVXX")));
								lblNewLabel_24.setText(String.valueOf(list1.get(0).get("DATE_IN")));//入住开始时间
								lblNewLabel_25.setText(String.valueOf(list1.get(0).get("DATE_OUT")));//预计退房时间
								lblNewLabel_26.setText(String.valueOf(list1.get(0).get("CASH")));//押金
								lblNewLabel_28.setText(String.valueOf(list1.get(0).get("TEL")));//联系方式
								lblNewLabel_17.setText(String.valueOf(list1.get(0).get("TYPE_CUSTOMER")));//顾客类型
							}
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						if (e.button == 3) {
							str1=text.getText().trim();
							Menu menu = new Menu(composite_14.getShell(),SWT.POP_UP);
							menu(composite_2,composite_14,menu,text,text_1,text_2,text_3);
							menu.setVisible(true);
						}

					}
				});
			}else if(i>=10){
				MessageDialog.openError(composite_2.getShell(), "错误信息","不能再往里面添加房间，一楼上限为10间房");
			}
		}

	}
	public void showRoom3(final Composite composite_2,int count1){
		lblNewLabel_21=new Label(composite_2, SWT.NONE);
		lblNewLabel_21.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		lblNewLabel_21.setAlignment(SWT.CENTER);
		lblNewLabel_21.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 16, SWT.NORMAL));
		lblNewLabel_21.setText("三楼");
		lblNewLabel_21.setBounds(10, 10+(69*(sum+1)), 69, 64);

		List<Map<String, Object>> list=new ArrayList<Map<String, Object>>();
		list=qtinfo.find("三楼");
		for(int i=0;i<count1;i++){
			acount=i;
			int count= 185;
			if(i<5){
				//每循环一次，new一个面板
				if(i==0){
					if(sum==2){
						sum=3;
					}else if(sum==1){
						sum=2;
					}else{
						sum=4;
					}
					//System.out.println("三楼"+sum);
				}

				heigth=69*sum;
				final Composite composite_14 = new Composite(composite_2, SWT.NONE);
				composite_14.setBounds(80+i*count, 10+heigth, 180, 64);

				final Label text = new Label(composite_14, SWT.BORDER);//房号
				text.setBounds(10, 10, 70, 21);

				final Label  text_1 = new Label(composite_14, SWT.BORDER);//房间类型
				text_1.setBounds(90, 10, 70, 21);

				final Label  text_2 = new Label(composite_14, SWT.BORDER);//状态
				text_2.setBounds(10, 37, 70, 21);

				final Label  text_3 = new Label(composite_14, SWT.BORDER);//顾客姓名
				text_3.setBounds(90, 37, 70, 21);	

				try {
					text.setText(String.valueOf(params.get(acount).get("NUMBER_HOUSE")));
					text_1.setText(String.valueOf(params.get(acount).get("TYPE_ROOM")));
					text_2.setText(String.valueOf(params.get(acount).get("ROOM_STATE")));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				String str2=text_2.getText().trim();
				color(composite_14,str2);
				composite_14.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseUp(MouseEvent e) {
						List<Map<String, Object>> list1=new ArrayList<Map<String, Object>>();
						List<Map<String,Object>> list2=new ArrayList<Map<String, Object>>();
						try {
							clear();	
							text_3.setText("");
							list1=qtinfo.findRoom(text.getText().trim());
							list2=qtinfo.room(text.getText().trim());
								lblNewLabel_22.setText(String.valueOf(list2.get(0).get("PRICE")));//房间价格
								lblNewLabel_23.setText(String.valueOf(list2.get(0).get("FLOOR_1")));//楼层
								if(String.valueOf(list2.get(0).get("ROOM_STATE")).equals("住人") || String.valueOf(list2.get(0).get("ROOM_STATE")).equals("预定")){
									text_3.setText(String.valueOf(list1.get(0).get("CUSTOMER_NAME")));//顾客姓名
								lblL.setText(String.valueOf(list1.get(0).get("CUSTOMER_NAME")));//顾客姓名
								lblNewLabel_30.setText(String.valueOf(list1.get(0).get("AGE")));//年龄
								label.setText("");
								label.setText(String.valueOf(list1.get(0).get("EVXX")));
								lblNewLabel_24.setText(String.valueOf(list1.get(0).get("DATE_IN")));//入住开始时间
								lblNewLabel_25.setText(String.valueOf(list1.get(0).get("DATE_OUT")));//预计退房时间
								lblNewLabel_26.setText(String.valueOf(list1.get(0).get("CASH")));//押金
								lblNewLabel_28.setText(String.valueOf(list1.get(0).get("TEL")));//联系方式
								lblNewLabel_17.setText(String.valueOf(list1.get(0).get("TYPE_CUSTOMER")));//顾客类型
							}
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						if (e.button == 3) {
							str1=text.getText().trim();
							Menu menu = new Menu(composite_14.getShell(),SWT.POP_UP);
							menu(composite_2,composite_14,menu,text,text_1,text_2,text_3);
							menu.setVisible(true);
						}
					}
				});
			}else if(i>=5){
				//每循环一次，new一个面板
				if(i==5){
					if(sum==3){
						sum=4;
					}else if(sum==2){
						sum=3;
					}else{
						sum=5;
					}
				}
				acount=i;
				heigth=69*sum;
				final Composite composite_14 = new Composite(composite_2, SWT.NONE);
				composite_14.setBounds(80+(i-5)*count,10+heigth, 180, 64);

				final Label text = new Label(composite_14, SWT.BORDER);//房号
				text.setBounds(10, 10, 70, 21);

				final Label  text_1 = new Label(composite_14, SWT.BORDER);//房间类型
				text_1.setBounds(90, 10,70, 21);

				final Label  text_2 = new Label(composite_14, SWT.BORDER);//状态
				text_2.setBounds(10, 37,70, 21);

				final Label  text_3 = new Label(composite_14, SWT.BORDER);//顾客姓名
				text_3.setBounds(90, 37, 70, 21);
				try {
					text.setText(String.valueOf(params.get(acount).get("NUMBER_HOUSE")));
					text_1.setText(String.valueOf(params.get(acount).get("TYPE_ROOM")));
					text_2.setText(String.valueOf(params.get(acount).get("ROOM_STATE")));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String str2=text_2.getText().trim();
				color(composite_14,str2);
				composite_14.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseUp(MouseEvent e) {
						List<Map<String, Object>> list1=new ArrayList<Map<String, Object>>();
						List<Map<String,Object>> list2=new ArrayList<Map<String, Object>>();
						try {
							clear();	
							text_3.setText("");
							list1=qtinfo.findRoom(text.getText().trim());
							list2=qtinfo.room(text.getText().trim());
								lblNewLabel_22.setText(String.valueOf(list2.get(0).get("PRICE")));//房间价格
								lblNewLabel_23.setText(String.valueOf(list2.get(0).get("FLOOR_1")));//楼层
								if(String.valueOf(list2.get(0).get("ROOM_STATE")).equals("住人") || String.valueOf(list2.get(0).get("ROOM_STATE")).equals("预定")){
									text_3.setText(String.valueOf(list1.get(0).get("CUSTOMER_NAME")));//顾客姓名
								lblL.setText(String.valueOf(list1.get(0).get("CUSTOMER_NAME")));//顾客姓名
								lblNewLabel_30.setText(String.valueOf(list1.get(0).get("AGE")));//年龄
								label.setText("");
								label.setText(String.valueOf(list1.get(0).get("EVXX")));
								lblNewLabel_24.setText(String.valueOf(list1.get(0).get("DATE_IN")));//入住开始时间
								lblNewLabel_25.setText(String.valueOf(list1.get(0).get("DATE_OUT")));//预计退房时间
								lblNewLabel_26.setText(String.valueOf(list1.get(0).get("CASH")));//押金
								lblNewLabel_28.setText(String.valueOf(list1.get(0).get("TEL")));//联系方式
								lblNewLabel_17.setText(String.valueOf(list1.get(0).get("TYPE_CUSTOMER")));//顾客类型
							}
						} catch (Exception e1) {
							e1.printStackTrace();
						}
						if (e.button == 3) {
							str1=text.getText().trim();
							Menu menu = new Menu(composite_14.getShell(),SWT.POP_UP);
							menu(composite_2,composite_14,menu,text,text_1,text_2,text_3);
							menu.setVisible(true);
						}
					}
				});

			}else if(i>=10){
				MessageDialog.openError(composite_2.getShell(), "温馨提示","不能再往里面添加房间，三楼上限为10个间房");
			}
		}

	}
	//清零
	public void clear(){
		lblL.setText("");//顾客姓名
		lblNewLabel_30.setText("");//年龄
		lblNewLabel_22.setText("");//房间价格
		lblNewLabel_23.setText("");//楼层
		lblNewLabel_24.setText("");//入住开始时间
		lblNewLabel_25.setText("");//预计退房时间
		lblNewLabel_26.setText("");//押金
		lblNewLabel_28.setText("");//联系方式
		lblNewLabel_17.setText("");//顾客类型
		
	}
	//表格清零
	//	public void clear1(Label text_1,Label text_2,Label text_3){
	////		System.out.println("这是清零！！！！！！！！！！！！！！！！！！！！！！！！！");		 
	//		 text_1.setText("");
	////		 System.out.println("清零"+text_1.getText());
	//		 text_2.setText("");
	//		 text_3.setText("");
	//
	//	}
	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	
	//实现菜单
		public void menu(final Composite composite_2,final Composite composite_14,Menu menu,final Label text,final Label text_1,final Label text_2,final Label text_3){
			item = new MenuItem(menu, SWT.PUSH);
			item.setText("散客开房");
			
			item1 = new MenuItem(menu, SWT.PUSH);
			item1.setText("预定转入住");
			
			item2 = new MenuItem(menu, SWT.PUSH);
			item2.setText("宾客结账");
			
			item3 = new MenuItem(menu, SWT.PUSH);
			item3.setText("预定房间");
			
			//维护房子菜单
			item4 = new MenuItem(menu, SWT.PUSH);
			item4.setText("维护");
			
			//清理菜单
			item5 = new MenuItem(menu, SWT.PUSH);
			item5.setText("清理");
			
			item6 = new MenuItem(menu, SWT.PUSH);
			item6.setText("维护转空");
			
			changeMenu(text_2.getText().trim());
			
			//散客开房
			item.addSelectionListener(new SelectionListener() {
				public void widgetDefaultSelected(SelectionEvent arg0) {
				}
				@Override
				public void widgetSelected(SelectionEvent arg0) {

					//System.out.println(text.getText()+" "+text_1.getText()+" "+text_2.getText()+" 这个是测试菜单的bug！！！！！！！！！！！");
					
						//System.out.println("8888888888888888888888888888888888888");
						DingDang dingdan=new DingDang();
						dingdan.open(text_1.getText().trim(),text.getText().trim());
						List<Map<String ,Object>> list1=new ArrayList<Map<String ,Object>>();
						String s=text.getText().trim();
						if(s!=null || !s.equals("")){
								list1=qtinfo.findRoom(text.getText().trim());
						}
						try {
							//clear();
							//clear1( text_1,text_2, text_3);

							List<Map<String,Object>> list11=new ArrayList<Map<String,Object>>();
							if(s!=null || !s.equals("")){
								list11=qtinfo.room(s);
							}
							text.setText(String.valueOf(list11.get(0).get("NUMBER_HOUSE")));
							text_1.setText(String.valueOf(list11.get(0).get("TYPE_ROOM")));
							text_2.setText(String.valueOf(list11.get(0).get("ROOM_STATE")));
							text_3.setText(String.valueOf(list1.get(0).get("CUSTOMER_NAME")));
							//System.out.println(list11.get(0).get("ROOM_STATE")+"这是宾客开房菜单测试");
							lblL.setText(String.valueOf(list1.get(0).get("CUSTOMER_NAME")));//顾客姓名
							lblNewLabel_30.setText(String.valueOf(list1.get(0).get("AGE")));//年龄
							lblNewLabel_22.setText(String.valueOf(list1.get(0).get("PRICE")));//房间价格
							lblNewLabel_23.setText(String.valueOf(list1.get(0).get("FLOOR_1")));//楼层
							lblNewLabel_24.setText(String.valueOf(list1.get(0).get("DATE_IN")));//入住开始时间
							lblNewLabel_25.setText(String.valueOf(list1.get(0).get("DATE_OUT")));//预计退房时间
							lblNewLabel_26.setText(String.valueOf(list1.get(0).get("CASH")));//押金
							lblNewLabel_28.setText(String.valueOf(list1.get(0).get("TEL")));//联系方式
							lblNewLabel_17.setText(String.valueOf(list1.get(0).get("TYPE_CUSTOMER")));//顾客类型
							//System.out.println(String.valueOf(list1.get(0).get("EVXX"))+"这是在测试");
							label.setText("");
							label.setText(String.valueOf(list1.get(0).get("EVXX")));
						} catch (Exception e) {
							e.printStackTrace();
						}
						String str2=text_2.getText().trim();
						color(composite_14,str2);
						


				}
			});
			//预定转入住
			item1.addSelectionListener(new SelectionListener() {
				public void widgetDefaultSelected(SelectionEvent arg0) {
				}
				@Override
				public void widgetSelected(SelectionEvent arg0) {
						DingDangRuZhu ddrz=new DingDangRuZhu();
						ddrz.open(text_1.getText().trim(),text.getText().trim());
						if(DataInfo.isNumber>0){
							DataInfo.isNumber=0;
							if(qtinfo.updateState("住人",str1)>0){
								List<Map<String ,Object>> list1=new ArrayList<Map<String ,Object>>();
								String s=text.getText().trim();
								list1=qtinfo.findRoom(text.getText().trim());
								try {
									//clear();
									//clear1( text_1,text_2, text_3);
			
									List<Map<String,Object>> list11=new ArrayList<Map<String,Object>>();
									list11=qtinfo.room(s);				
									text.setText(String.valueOf(list11.get(0).get("NUMBER_HOUSE")));
									text_1.setText(String.valueOf(list11.get(0).get("TYPE_ROOM")));
									text_2.setText(String.valueOf(list11.get(0).get("ROOM_STATE")));
									text_3.setText(String.valueOf(list1.get(0).get("CUSTOMER_NAME")));
			
									lblL.setText(String.valueOf(list1.get(0).get("CUSTOMER_NAME")));//顾客姓名
									lblNewLabel_30.setText(String.valueOf(list1.get(0).get("AGE")));//年龄
									lblNewLabel_22.setText(String.valueOf(list1.get(0).get("PRICE")));//房间价格
									lblNewLabel_23.setText(String.valueOf(list1.get(0).get("FLOOR_1")));//楼层
									lblNewLabel_24.setText(String.valueOf(list1.get(0).get("DATE_IN")));//入住开始时间
									lblNewLabel_25.setText(String.valueOf(list1.get(0).get("DATE_OUT")));//预计退房时间
									lblNewLabel_26.setText(String.valueOf(list1.get(0).get("CASH")));//押金
									lblNewLabel_28.setText(String.valueOf(list1.get(0).get("TEL")));//联系方式
									lblNewLabel_17.setText(String.valueOf(list1.get(0).get("TYPE_CUSTOMER")));//顾客类型
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								String str2=text_2.getText().trim();
								color(composite_14,str2);
								
							}else{
								MessageDialog.openError(getShell(), "错误","错误信息，修改失败");
							}
						}
					}
				
			});
			//宾客结账
			item2.addSelectionListener(new SelectionListener() {
				public void widgetDefaultSelected(SelectionEvent arg0) {
					// TODO Auto-generated method stub
				}
				@Override
				public void widgetSelected(SelectionEvent arg0) {
					List<Object> list=new ArrayList<Object>();
					list.add(label.getText().trim());//单号
					list.add(text.getText().trim());//房号
					list.add(lblNewLabel_22.getText().trim());//房间价格
					list.add(lblL.getText().trim());//顾客姓名
					list.add(lblNewLabel_17.getText().trim());//顾客类型
					list.add(lblNewLabel_26.getText().trim());//押金
					JieZhang jz=new JieZhang();
					jz.open(list);
					if(JieZhang.getNumber()>0){
							if(qtinfo.updateState("脏房",str1)>0){
							List<Map<String ,Object>> list1=new ArrayList<Map<String ,Object>>();
							String s=text.getText().trim();
							list1=qtinfo.findRoom(text.getText().trim());
							try {
							
		
								List<Map<String,Object>> list11=new ArrayList<Map<String,Object>>();
								list11=qtinfo.room(s);				
								text.setText(String.valueOf(list11.get(0).get("NUMBER_HOUSE")));
								text_1.setText(String.valueOf(list11.get(0).get("TYPE_ROOM")));
								text_2.setText(String.valueOf(list11.get(0).get("ROOM_STATE")));
								String bill=label.getText().trim();
								System.out.println(bill+"这个是账单的测试");
								if(qtinfo.updateBill(bill)>0){
									//System.out.println("成功修改信息");
								}
								label.setText("");
		
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							String str2=text_2.getText().trim();
							color(composite_14,str2);
							
						}else{
							MessageDialog.openError(getShell(), "错误","错误信息，修改失败");
						}
					}


				}
			});
			//预定菜单
			item3.addSelectionListener(new SelectionListener() {
				public void widgetDefaultSelected(SelectionEvent arg0) {
					// TODO Auto-generated method stub
				}
		
				public void widgetSelected(SelectionEvent arg0) {
					Yuyue_kuangkou yukk=new Yuyue_kuangkou();
					yukk.open(text_1.getText().trim(),text.getText().trim());
					if(DataInfo.isNumber==1){//如果是成功的才进入下面{
						if(!text_2.getText().trim().equals("住人")){
							qtinfo.updateState("预定",str1);
						}
						DataInfo.isNumber=0;
							List<Map<String ,Object>> list1=new ArrayList<Map<String ,Object>>();
							String s=text.getText().trim();
							list1=qtinfo.findRoom(text.getText().trim());
							try {
								//clear();
								//clear1( text_1,text_2, text_3);
		
								List<Map<String,Object>> list11=new ArrayList<Map<String,Object>>();
								list11=qtinfo.room(s);				
								text.setText(String.valueOf(list11.get(0).get("NUMBER_HOUSE")));
								text_1.setText(String.valueOf(list11.get(0).get("TYPE_ROOM")));
								text_2.setText(String.valueOf(list11.get(0).get("ROOM_STATE")));
								text_3.setText(String.valueOf(list1.get(0).get("CUSTOMER_NAME")));
		
								lblL.setText(String.valueOf(list1.get(0).get("CUSTOMER_NAME")));//顾客姓名
								lblNewLabel_30.setText(String.valueOf(list1.get(0).get("AGE")));//年龄
								lblNewLabel_22.setText(String.valueOf(list1.get(0).get("PRICE")));//房间价格
								lblNewLabel_23.setText(String.valueOf(list1.get(0).get("FLOOR_1")));//楼层
								lblNewLabel_24.setText(String.valueOf(list1.get(0).get("DATE_IN")));//入住开始时间
								lblNewLabel_25.setText(String.valueOf(list1.get(0).get("DATE_OUT")));//预计退房时间
								lblNewLabel_26.setText(String.valueOf(list1.get(0).get("CASH")));//押金
								lblNewLabel_28.setText(String.valueOf(list1.get(0).get("TEL")));//联系方式
								lblNewLabel_17.setText(String.valueOf(list1.get(0).get("TYPE_CUSTOMER")));//顾客类型
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							String str2=text_2.getText().trim();
							color(composite_14,str2);
		
					}
				}
			});
			//维护房子菜单
			item4.addSelectionListener(new SelectionListener() {
				public void widgetDefaultSelected(SelectionEvent arg0) {
					// TODO Auto-generated method stub
				}
				@Override
				public void widgetSelected(SelectionEvent arg0) {
					if(qtinfo.updateState("维护",str1)>0){
						List<Map<String ,Object>> list1=new ArrayList<Map<String ,Object>>();
						String s=text.getText().trim();
						list1=qtinfo.findRoom(text.getText().trim());
						try {
							//clear();
							//clear1( text_1,text_2, text_3);

							List<Map<String,Object>> list11=new ArrayList<Map<String,Object>>();
							list11=qtinfo.room(s);				
							text.setText(String.valueOf(list11.get(0).get("NUMBER_HOUSE")));
							text_1.setText(String.valueOf(list11.get(0).get("TYPE_ROOM")));
							text_2.setText(String.valueOf(list11.get(0).get("ROOM_STATE")));

						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						String str2=text_2.getText().trim();
						color(composite_14,str2);
						
					}else{
						MessageDialog.openError(getShell(), "错误","错误信息，修改失败");
					}

				}
			});
			//清理
			item5.addSelectionListener(new SelectionListener() {
				public void widgetDefaultSelected(SelectionEvent arg0) {
					// TODO Auto-generated method stub
				}
				@Override
				public void widgetSelected(SelectionEvent arg0) {
						List<Map<String ,Object>> li=new ArrayList<Map<String ,Object>>();
						try {
							li=qtinfo.roomDing(text.getText().trim());
							if(li!=null && !li.equals("") && li.size()>0){
								qtinfo.updateState("预定",str1);
							}else{
								qtinfo.updateState("空",str1);
							}
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						List<Map<String ,Object>> list1=new ArrayList<Map<String ,Object>>();
						String s=text.getText().trim();
						list1=qtinfo.findRoom(text.getText().trim());
						try {
							//clear();
							//clear1( text_1,text_2, text_3);

							List<Map<String,Object>> list11=new ArrayList<Map<String,Object>>();
							list11=qtinfo.room(s);				
							text.setText(String.valueOf(list11.get(0).get("NUMBER_HOUSE")));
							text_1.setText(String.valueOf(list11.get(0).get("TYPE_ROOM")));
							text_2.setText(String.valueOf(list11.get(0).get("ROOM_STATE")));
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						String str2=text_2.getText().trim();
						color(composite_14,str2);
				}
			});

			item6.addSelectionListener(new SelectionListener() {
				public void widgetDefaultSelected(SelectionEvent arg0) {
					// TODO Auto-generated method stub
				}
				@Override
				public void widgetSelected(SelectionEvent arg0) {
					if(qtinfo.updateState("空",str1)>0){
						List<Map<String ,Object>> list1=new ArrayList<Map<String ,Object>>();
						String s=text.getText().trim();
						list1=qtinfo.findRoom(text.getText().trim());
						try {
							//clear();
							//clear1( text_1,text_2, text_3);

							List<Map<String,Object>> list11=new ArrayList<Map<String,Object>>();
							list11=qtinfo.room(s);				
							text.setText(String.valueOf(list11.get(0).get("NUMBER_HOUSE")));
							text_1.setText(String.valueOf(list11.get(0).get("TYPE_ROOM")));
							text_2.setText(String.valueOf(list11.get(0).get("ROOM_STATE")));
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						String str2=text_2.getText().trim();
						color(composite_14,str2);
						
					}else{
						MessageDialog.openError(getShell(), "错误","错误信息，修改失败");
					}

				}
			});
		}

		public void changeMenu(String status){
			item.setEnabled(true);
			item1.setEnabled(true);
			item3.setEnabled(true);
			item4.setEnabled(true);
			item2.setEnabled(true);
			item5.setEnabled(true);
			item6.setEnabled(true);

			switch(status){
			case "空" : 
				item2.setEnabled(false);
				item1.setEnabled(false);
			break;//预定、入住、维护、清理、全部、空
			case "住人" : item.setEnabled(false);//设置它们不可操作
			item1.setEnabled(false);
			item3.setEnabled(true);
			item4.setEnabled(false);
			item5.setEnabled(false);
			item6.setEnabled(false);
			break;
			case "维护" : item.setEnabled(false);
			item1.setEnabled(false);
			item3.setEnabled(false);
			item4.setEnabled(false);
			item5.setEnabled(false);
			item2.setEnabled(false);
			break;
			case "脏房" :item.setEnabled(false);
			item1.setEnabled(false);
			item3.setEnabled(false);
			item4.setEnabled(false);
			item2.setEnabled(false);
			item6.setEnabled(false);
			break;

			case "预定" :
			item4.setEnabled(false);
			item2.setEnabled(false);
			item5.setEnabled(false);
			item6.setEnabled(false);
			break;
			}
		}

		public void color(Composite composite_14, String str){//显示房间的状态
			try {
				switch (str){
				case "空": composite_14.setBackground(SWTResourceManager.getColor(SWT.COLOR_YELLOW)); break;
				case "住人":composite_14.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_GREEN)); break;
				case "预定":composite_14.setBackground(SWTResourceManager.getColor(SWT.COLOR_CYAN)); break;
				case "脏房":composite_14.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLUE)); break;
				case "维护":composite_14.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_YELLOW)); break;
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
