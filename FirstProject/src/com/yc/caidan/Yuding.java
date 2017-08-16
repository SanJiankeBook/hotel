package com.yc.caidan;

import org.eclipse.swt.widgets.Composite;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;

import com.yc.productInfo.dao.DingDangDao;
import com.yc.productInfo.dao.YudingDao;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;


public class Yuding extends Composite {
	private Table table;
	private YudingDao yu=new YudingDao();
	private TableItem tm;
	private Map map;
	Denglu deng=new Denglu();

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public Yuding(Composite parent, int style) {
		super(parent, style);
		setLayout(new FillLayout(SWT.HORIZONTAL));
		
		SashForm sashForm = new SashForm(this, SWT.NONE);
		sashForm.setOrientation(SWT.VERTICAL);
		
		Composite composite = new Composite(sashForm, SWT.NONE);
		composite.setBackgroundImage(SWTResourceManager.getImage(Yuding.class, "/Image/96g58PICMPs_1024.jpg"));
		
		Button btnNewButton = new Button(composite, SWT.NONE);
		btnNewButton.setBounds(0, 10, 80, 27);
		btnNewButton.setText("新增预定");
		
		Button btnNewButton_1 = new Button(composite, SWT.NONE);
		btnNewButton_1.setBounds(86, 10, 80, 27);
		btnNewButton_1.setText("刷新");
		
		Composite composite_1 = new Composite(sashForm, SWT.NONE);
		composite_1.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		SashForm sashForm_1 = new SashForm(composite_1, SWT.NONE);
		sashForm_1.setOrientation(SWT.VERTICAL);
		
		Composite composite_3 = new Composite(sashForm_1, SWT.NONE);
		composite_3.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		table = new Table(composite_3, SWT.BORDER | SWT.FULL_SELECTION);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(73);
		tblclmnNewColumn.setText("预约订单号");
		
		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_1.setWidth(62);
		tblclmnNewColumn_1.setText("顾客姓名");
		
		TableColumn tblclmnNewColumn_2 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_2.setWidth(46);
		tblclmnNewColumn_2.setText("性别");
		
		TableColumn tblclmnNewColumn_3 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_3.setText("身份证号");
		tblclmnNewColumn_3.setWidth(103);
		
		TableColumn tblclmnNewColumn_5 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_5.setWidth(85);
		tblclmnNewColumn_5.setText("联系方式");
		
		TableColumn tblclmnNewColumn_4 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_4.setWidth(67);
		tblclmnNewColumn_4.setText("预约房号");
		
		TableColumn tblclmnNewColumn_6 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_6.setWidth(61);
		tblclmnNewColumn_6.setText("房间价格");
		
		
		TableColumn tblclmnNewColumn_8 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_8.setWidth(139);
		tblclmnNewColumn_8.setText("预住时间");
		
		TableColumn tableColumn = new TableColumn(table, SWT.NONE);
		tableColumn.setWidth(118);
		tableColumn.setText("预定时间");
		
		TableColumn tableColumn_1 = new TableColumn(table, SWT.NONE);
		tableColumn_1.setWidth(118);
		tableColumn_1.setText("预离时间");
		
		TableColumn tblclmnNewColumn_7 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_7.setWidth(60);
		tblclmnNewColumn_7.setText("居住天数");
		
		TableColumn tblclmnNewColumn_10 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_10.setWidth(44);
		tblclmnNewColumn_10.setText("状态");
		
		tm= new TableItem(table, SWT.NONE);
		
		TableColumn tblclmnNewColumn_9 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_9.setWidth(61);
		tblclmnNewColumn_9.setText("操作员工");
		
		Menu menu = new Menu(table);
		table.setMenu(menu);
		
		MenuItem menuItem = new MenuItem(menu, SWT.NONE);
		menuItem.setText("取消预约");
		
		Composite composite_2 = new Composite(sashForm_1, SWT.NONE);
		composite_2.setBackgroundImage(SWTResourceManager.getImage(Yuding.class, "/Image/96g58PICMPs_1024.jpg"));
		sashForm_1.setWeights(new int[] {332, 79});
		//sashForm_1.setWeights(new int[] {358, 358});
		sashForm.setWeights(new int[] {24, 273});
		ShowAll();
		//取消预约
		menuItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
						TableItem[] tis =table.getSelection();
						if(tis!=null&&tis.length>0){
							String str7=tis[0].getText(0);
							String str1=tis[0].getText(5);
							// DingDangDao ding1=new DingDangDao();
							 yu.updateState1(str7);
							 yu.updateromm(str1);
							
						}
					}
		
				
			
		});
		
		//新增订单
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				Yuyue_1 yu=new Yuyue_1();
				yu.open();
			}
		});
		
		//刷新
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				ShowAll();
			}
		});
		
		//一旦表格的宽度发生改变
				table.addControlListener(new ControlAdapter() {
					@Override
					public void controlResized(ControlEvent e) {
						ChangeColumnWidth();
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
		
		//显示 全部数据
		public void ShowAll(){
			table.removeAll();
			List<Map<String, Object>> list=yu.All();
			int len=list.size();
			if(list!=null && list.size()>0){
				for(int i=0;i<len;i++){
					tm=new TableItem(table,SWT.NONE);
					tm.setText(new String[]{String.valueOf(list.get(i).get("ORDER_NUMBER")),String.valueOf(list.get(i).get("CUSTOMER_NAME")),
							String.valueOf(list.get(i).get("SEX")),String.valueOf(list.get(i).get("CARD_ID")),
							String.valueOf(list.get(i).get("TEL")),String.valueOf(list.get(i).get("ORDER_ROOM")),String.valueOf(list.get(i).get("NUNN")),
							String.valueOf(list.get(i).get("ORDER_DATE")),String.valueOf(list.get(i).get("ORDER_IN")),String.valueOf(list.get(i).get("ORDER_OUT")),
							String.valueOf(list.get(i).get("ORDER_STATE")),String.valueOf(list.get(i).get("ORDER_TYPE")),String.valueOf(list.get(i).get("LPQ"))});
				}
				
			}
		}
		
}
