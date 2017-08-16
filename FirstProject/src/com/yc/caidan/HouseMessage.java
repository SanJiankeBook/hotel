package com.yc.caidan;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.TableItem;

import com.yc.productInfo.dao.HouseMessageDao;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.wb.swt.SWTResourceManager;

public class HouseMessage extends Composite {

	private Composite sashForm;
	private Table table;
	private TableItem tm;
	HouseMessageDao house=new HouseMessageDao();
	private Text text_2;
	private Text text_1;
	private Combo combo,combo_1,combo_2,combo_3 ; 
	private Text text_3;
	private Spinner spinner_1;
	private Label lblNewLabel_2;
	private Label lblNewLabel_1;
	private Label lblNewLabel_3;
	private Label lblNewLabel_4;
	HouseMessageDao message=new HouseMessageDao();
	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public HouseMessage(Composite parent, int style) {
		super(parent, style);
		setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_DARK_SHADOW));
		setLayout(new FillLayout(SWT.HORIZONTAL));
		
		SashForm sashForm_1 = new SashForm(this, SWT.NONE);
		
		Composite composite = new Composite(sashForm_1, SWT.NONE);
		composite.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		SashForm sashForm_2 = new SashForm(composite, SWT.NONE);
		sashForm_2.setOrientation(SWT.VERTICAL);
		
		Composite composite_2 = new Composite(sashForm_2, SWT.NONE);
		composite_2.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		table = new Table(composite_2, SWT.BORDER | SWT.FULL_SELECTION);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(100);
		tblclmnNewColumn.setText("房间号");
		
		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_1.setWidth(100);
		tblclmnNewColumn_1.setText("房间类型");
		
		TableColumn tblclmnNewColumn_2 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_2.setWidth(100);
		tblclmnNewColumn_2.setText("房间状态");
		
		TableColumn tblclmnNewColumn_3 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_3.setWidth(100);
		tblclmnNewColumn_3.setText("所在楼层");
		
		TableColumn tblclmnNewColumn_4 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_4.setWidth(100);
		tblclmnNewColumn_4.setText("房间单价");
		
		tm = new TableItem(table, SWT.NONE);
		
		
		//一旦表格的宽度发生改变
		table.addControlListener(new ControlAdapter() {
				@Override
			public void controlResized(ControlEvent e) {
					ChangeColumnWidth();
			}
		});
		
		Composite composite_3 = new Composite(sashForm_2, SWT.NONE);
		composite_3.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		SashForm sashForm_3 = new SashForm(composite_3, SWT.NONE);
		sashForm_3.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_DARK_SHADOW));
		
		Composite composite_1 = new Composite(sashForm_3, SWT.NONE);
		composite_1.setBackgroundMode(SWT.INHERIT_DEFAULT);
		composite_1.setTouchEnabled(true);
		composite_1.setBackgroundImage(SWTResourceManager.getImage(HouseMessage.class, "/Image/96g58PICMPs_1024.jpg"));
		
		 lblNewLabel_1 = new Label(composite_1, SWT.NONE);
		 lblNewLabel_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 9, SWT.BOLD));
		lblNewLabel_1.setAlignment(SWT.CENTER);
		lblNewLabel_1.setBounds(218, 13, 61, 17);
		lblNewLabel_1.setText("房间类型：");
		
		 lblNewLabel_3 = new Label(composite_1, SWT.NONE);
		 lblNewLabel_3.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 9, SWT.BOLD));
		lblNewLabel_3.setBounds(218, 63, 61, 17);
		lblNewLabel_3.setText("所在楼层：");
		
		lblNewLabel_4 = new Label(composite_1, SWT.NONE);
		lblNewLabel_4.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 9, SWT.BOLD));
		lblNewLabel_4.setBounds(20, 13, 36, 17);
		lblNewLabel_4.setText("单价：");
		
		text_2 = new Text(composite_1, SWT.BORDER);
		text_2.setText("");
		text_2.setBounds(64, 10, 86, 23);
		
		combo = new Combo(composite_1, SWT.READ_ONLY);
		combo.setBounds(283, 13, 88, 25);
		combo.add("单人间");
		combo.add("双人间");
		combo.add("总统房");
		
		Button btnNewButton_1 = new Button(composite_1, SWT.NONE);
		btnNewButton_1.setBounds(40, 142, 80, 27);
		btnNewButton_1.setText("修改");
		
		Button btnNewButton_2 = new Button(composite_1, SWT.NONE);
		btnNewButton_2.setBounds(257, 142, 80, 27);
		btnNewButton_2.setText("删除");
		
		Button btnNewButton_3 = new Button(composite_1, SWT.NONE);
		btnNewButton_3.setBounds(40, 208, 80, 27);
		btnNewButton_3.setText("刷新");
		
		Label lblNewLabel_5 = new Label(composite_1, SWT.NONE);
		lblNewLabel_5.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 9, SWT.BOLD));
		lblNewLabel_5.setBounds(218, 213, 61, 17);
		lblNewLabel_5.setText("房间筛选：");
		
		combo_1 = new Combo(composite_1, SWT.READ_ONLY);
		combo_1.setBounds(283, 210, 113, 25);
		combo_1.add("预定");
		combo_1.add("空");
		combo_1.add("住人");
		combo_1.add("脏房");
		combo_1.add("维护");
		
		Label label = new Label(composite_1, SWT.NONE);
		label.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 9, SWT.BOLD));
		label.setBounds(10, 63, 48, 17);
		label.setText("房间号：");
		
		text_3 = new Text(composite_1, SWT.BORDER | SWT.READ_ONLY);
		text_3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
			}
		});
		text_3.setBounds(64, 60, 86, 23);
		
		combo_3 = new Combo(composite_1, SWT.READ_ONLY);
		combo_3.setBounds(283, 60, 88, 25);
		combo_3.add("一楼");
		combo_3.add("二楼");
		combo_3.add("三楼");
		
		Composite composite_4 = new Composite(sashForm_3, SWT.NONE);
		composite_4.setBackgroundMode(SWT.INHERIT_DEFAULT);
		composite_4.setBackgroundImage(SWTResourceManager.getImage(HouseMessage.class, "/Image/96g58PICMPs_1024.jpg"));
		
		Button btnNewButton = new Button(composite_4, SWT.NONE);
		btnNewButton.setBounds(182, 206, 80, 27);
		btnNewButton.setText("增加房间");
		
		combo_2 = new Combo(composite_4, SWT.READ_ONLY);
		combo_2.setBounds(232, 23, 88, 25);
		combo_2.add("单人间");
		combo_2.add("双人间");
		combo_2.add("总统房");
	
		
		text_1 = new Text(composite_4, SWT.BORDER);
		text_1.setBounds(232, 71, 88, 23);
		
		spinner_1 = new Spinner(composite_4, SWT.BORDER | SWT.READ_ONLY);
		spinner_1.setBounds(232, 123, 88, 23);
		
		Label lblNewLabel_6 = new Label(composite_4, SWT.NONE);
		lblNewLabel_6.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 9, SWT.BOLD));
		lblNewLabel_6.setBounds(152, 26, 60, 17);
		lblNewLabel_6.setText("房间类型：");
		
		Label lblNewLabel_7 = new Label(composite_4, SWT.NONE);
		lblNewLabel_7.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 9, SWT.BOLD));
		lblNewLabel_7.setBounds(164, 74, 48, 17);
		lblNewLabel_7.setText("房间号：");
		
		Label lblNewLabel_8 = new Label(composite_4, SWT.NONE);
		lblNewLabel_8.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 9, SWT.BOLD));
		lblNewLabel_8.setBounds(176, 126, 36, 17);
		lblNewLabel_8.setText("楼层：");
		
		Label lblNewLabel = new Label(composite_4, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 9, SWT.BOLD));
		lblNewLabel.setBounds(176, 173, 36, 17);
		lblNewLabel.setText("价格：");
		
		lblNewLabel_2 = new Label(composite_4, SWT.NONE);
		lblNewLabel_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		lblNewLabel_2.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 10, SWT.BOLD));
		lblNewLabel_2.setBounds(232, 173, 88, 17);
		sashForm_3.setWeights(new int[] {224, 223});
		sashForm_2.setWeights(new int[] {223, 222});
		sashForm_1.setWeights(new int[] {553});
		
		housefind();
		
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				TableItem[] tab=table.getSelection();
	    		if(tab!=null && tab.length>0){
	    			text_3.setText(tab[0].getText(0));//房号
	    			combo.setText(tab[0].getText(1));//房间类型
	    			combo_3.setText(tab[0].getText(3)); //所在楼层
	    			text_2.setText(tab[0].getText(4));//价格
	    			
	    			
	    		}
			}
		});
		
		//修改
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {//房间类型,价格，房间状态，所在楼层，房号
				String d1=combo.getText().trim();
				//System.out.println("房间类型"+d1);
				String d2=text_2.getText().trim();
				//System.out.println("房间状态"+d3);
				String d4=combo_3.getText().trim();
				//System.out.println("所在楼层"+d4);
				TableItem[] tab=table.getSelection();
				String sta=tab[0].getText(2);
				if(sta.equals("空")){
					try {
						tm=table.getSelection()[0];
						String st=tm.getText(0).trim();
						//System.out.println("st="+st);
						int list=house.update(d1,d2,d4,st);
						house.update1(d1,d2);
						showdate(st);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else{
					MessageDialog.openError(getShell(), "警告","此房间不能修改，只有空状态的房间才能被修改");
				}

			}
		});
		
		
		//房间判断
		text_3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				List<Map<String,Object>> list=new ArrayList<Map<String, Object>>();
				list=message.All();
				tm=table.getSelection()[0];
				String st=tm.getText(0).trim();
				for(Map<String,Object> map:list){
					String h=(String) map.get("NUMBER_HOUSE");
					if(st.equals(h)){
						MessageDialog.openError(getShell(), "警告","不能修改房间号");
					}
				}
				
			}
		});
		
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				housefind();
			}
		});
		
		//房间筛选
		combo_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(combo_1.getText().equals("预定")){
					findType(combo_1.getText().trim());
				}
				if(combo_1.getText().equals("空")){
					findType(combo_1.getText().trim());
				}
				if(combo_1.getText().equals("住人")){
					findType(combo_1.getText().trim());
				}
				if(combo_1.getText().equals("维护")){
					findType(combo_1.getText().trim());
				}
				if(combo_1.getText().equals("脏房")){
					findType(combo_1.getText().trim());
				}
				
			}
		});
		
		//显示房间价格
		combo_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(combo_2.getText().equals("单人间")){
					int i=200;
					String p1=String.valueOf(i);
					lblNewLabel_2.setText(p1);
				}
				if(combo_2.getText().equals("双人间")){
					int i=300;
					String p1=String.valueOf(i);
					lblNewLabel_2.setText(p1);
				}
				if(combo_2.getText().equals("总统房")){
					int i=500;
					String p1=String.valueOf(i);
					lblNewLabel_2.setText(p1);
				}
			}
		});
		
		
		
		//房间增加
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				List<Map<String,Object>> list=new ArrayList<Map<String, Object>>();
				list=message.All();
				for(Map<String,Object> map:list){
					//text_1.getText().trim();
					String sq1=(String) map.get("NUMBER_HOUSE");
					if(text_1.getText().trim().equals(sq1) || text_1.getText().trim()==sq1){
						MessageDialog.openError(getShell(), "警告","这个房间号与数据库的房间号相同不能增加");
					}
				}
				String q1=combo_2.getText().trim();//房间类型
				String q2=text_1.getText().trim();//房号
				String q4=lblNewLabel_2.getText().trim();//价格
				int num=Integer.parseInt(spinner_1.getText().trim());//楼层
				switch(num){
					case 1:String q3=("一楼");
					if(message.add(q2,q3,q1,q4)>0){
						MessageDialog.openInformation(getShell(), "提示","添加成功");
					}else{
						MessageDialog.openError(getShell(), "温馨提示","房间添加失败");
					}
					
					break;
					case 2:String q6=("二楼");
					if(message.add(q2,q6,q1,q4)>0){
						MessageDialog.openInformation(getShell(), "提示","添加成功");
					}else{
						MessageDialog.openError(getShell(), "温馨提示","房间添加失败");
					}
					
					break;
					case 3:	String q5=("三楼");
					if(message.add(q2,q5,q1,q4)>0){
						MessageDialog.openInformation(getShell(), "提示","添加成功");
					}else{
						MessageDialog.openError(getShell(), "温馨提示","房间添加失败");
					}
					
					break;	
				}
				
			}
			
		});
		
		//删除房间
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				TableItem[] tab=table.getSelection();
				String sta=tab[0].getText(2);
				String num=tab[0].getText(0);
				if(sta.equals("空")){
					message.del(num);
					housefind();
				}else{
					MessageDialog.openError(getShell(), "警告","此房间不能删除，只有空状态的房间才能被删除");
				}
			}
		});
		
	}
	
	//修改表格的宽度
		public void ChangeColumnWidth(){
			TableColumn[] cols=table.getColumns();//获取表格的字段数
			int width=(table.getSize().x)/(cols.length);//用剩余的长度除以减去1的列数（字段数）
			for(int i=0;i<cols.length;i++){
				cols[i].setWidth(width);
			}
		}	
	
	//显示所有数据
	public void housefind(){
		table.removeAll();
		List<Map<String, Object>> list=house.All();
		int len=house.count();
		if(list!=null && list.size()>0){
			for(int i=0;i<len;i++){
				tm=new TableItem(table,SWT.NONE);//房间号、房间类型、房间状态、所在楼层、房间单价
				tm.setText(new String[]{String.valueOf(list.get(i).get("NUMBER_HOUSE")),String.valueOf(list.get(i).get("TYPE_ROOM")),
						String.valueOf(list.get(i).get("ROOM_STATE")),String.valueOf(list.get(i).get("FLOOR_1")),
						String.valueOf(list.get(i).get("PRICE"))});
			}
		}
	}
	
	//条件选择
	public void showdate(String s){
		table.removeAll();
		List<Map<String, Object>> list=house.findNum(s);
		//System.out.println(list+"list的输出");
		if(list!=null && list.size()>0){
				tm=new TableItem(table,SWT.NONE);//房间号、房间类型、房间状态、所在楼层、房间单价
				tm.setText(new String[]{String.valueOf(list.get(0).get("NUMBER_HOUSE")),String.valueOf(list.get(0).get("TYPE_ROOM")),
						String.valueOf(list.get(0).get("ROOM_STATE")),String.valueOf(list.get(0).get("FLOOR_1")),
						String.valueOf(list.get(0).get("PRICE"))});	
			}
		}
	//条件选择房间状态
	public void findType(String type){
		table.removeAll();
		List<Map<String, Object>> list=house.findType(type);
		//System.out.println(list+"list的输出");
		int len=list.size();
		if(list!=null && list.size()>0){
			for(int i=0;i<len;i++){
				tm=new TableItem(table,SWT.NONE);//房间号、房间类型、房间状态、所在楼层、房间单价
				tm.setText(new String[]{String.valueOf(list.get(i).get("NUMBER_HOUSE")),String.valueOf(list.get(i).get("TYPE_ROOM")),
						String.valueOf(list.get(i).get("ROOM_STATE")),String.valueOf(list.get(i).get("FLOOR_1")),
						String.valueOf(list.get(i).get("PRICE"))});	
			}
		}
	}


	
}
