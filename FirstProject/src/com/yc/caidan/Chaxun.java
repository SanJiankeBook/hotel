package com.yc.caidan;

import org.eclipse.swt.widgets.Composite;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Text;

import com.yc.productInfo.dao.*;

import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.wb.swt.SWTResourceManager;

public class Chaxun extends Composite {
	private Table table;
	private ChaxunDao WineshopDao=new ChaxunDao() ;
	private Combo combo;
	private Text text;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public Chaxun(final Composite parent, int style) {
		super(parent, style);
		setLayout(new FillLayout(SWT.HORIZONTAL));
		
		SashForm sashForm = new SashForm(this, SWT.NONE);
		sashForm.setOrientation(SWT.VERTICAL);
		sashForm.setBackgroundMode(SWT.INHERIT_DEFAULT);
		
		Composite composite = new Composite(sashForm, SWT.V_SCROLL);
		composite.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		table = new Table(composite, SWT.BORDER | SWT.FULL_SELECTION);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tableColumn = new TableColumn(table, SWT.NONE);
		tableColumn.setText("顾客");
		tableColumn.setWidth(100);
		
		TableColumn tblclmnNewColumn_4 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_4.setWidth(100);
		tblclmnNewColumn_4.setText("房号");
		
		TableColumn tableColumn_1 = new TableColumn(table, SWT.NONE);
		tableColumn_1.setText("押金");
		tableColumn_1.setToolTipText("");
		tableColumn_1.setWidth(100);
		
		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setText("入住时间");
		tblclmnNewColumn.setWidth(100);
		
		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_1.setWidth(100);
		tblclmnNewColumn_1.setText("居住天数");
		
		TableColumn tblclmnNewColumn_2 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_2.setWidth(100);
		tblclmnNewColumn_2.setText("退房时间");
		
		TableColumn tblclmnNewColumn_3 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_3.setWidth(141);
		tblclmnNewColumn_3.setText("结账状态(结账、没结)");
		
		Composite composite_1 = new Composite(sashForm, SWT.NONE);
		composite_1.setBackgroundImage(SWTResourceManager.getImage(Chaxun.class, "/Image/96g58PICMPs_1024.jpg"));
		
		combo = new Combo(composite_1, SWT.NONE);
		combo.setBounds(77, 31, 88, 23);
		
		Label lblNewLabel = new Label(composite_1, SWT.NONE);
		lblNewLabel.setBounds(10, 34, 61, 15);
		lblNewLabel.setText("查询方式");
		
		Button btnNewButton = new Button(composite_1, SWT.NONE);
		btnNewButton.setBounds(505, 29, 80, 25);
		btnNewButton.setText("查询");
		
		Label lblNewLabel_1 = new Label(composite_1, SWT.NONE);
		lblNewLabel_1.setBounds(281, 39, 88, 15);
		lblNewLabel_1.setText("查询的索引信息");
		
		text = new Text(composite_1, SWT.BORDER);
		text.setBounds(376, 33, 106, 21);
		
		Button btnNewButton_1 = new Button(composite_1, SWT.NONE);
		btnNewButton_1.setBounds(661, 29, 80, 25);
		btnNewButton_1.setText("返回");
		sashForm.setWeights(new int[] {241, 56});
		changType();
		showDate();
		//返回键
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				showDate();
			}
		});
		
		//一旦表格的宽度发生改变
		table.addControlListener(new ControlAdapter() {
			@Override
			public void controlResized(ControlEvent e) {
				ChangeColumnWidth();
			}
		});
		
		//查询按钮
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String txt=combo.getText().trim();
				System.out.println(txt);
				if(txt.equals("顾客姓名")){
					System.out.println(text.getText().trim());
					List<Map<String, Object>> list=WineshopDao.findName(text.getText().trim());
					if(!list.isEmpty()){
						showDateInfo(list);
					}else{
						MessageDialog.openError(parent.getShell(), "错误信息","顾客信息查询失败");
					}
					
				}else if(txt.equals("房号")){
					List<Map<String, Object>> list=WineshopDao.findRoom(text.getText().trim());
					if(!list.isEmpty()){
						showDateInfo(list);
					}else{
						MessageDialog.openError(parent.getShell(), "错误信息","顾客信息查询失败");
					}
				}else if(txt.equals("结账状态")){
					List<Map<String, Object>> list=WineshopDao.findState();
					if(!list.isEmpty()){
						showDateInfo(list);
					}else{
						MessageDialog.openError(parent.getShell(), "错误信息","顾客信息查询失败");
					}
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

	//添加查询的类型
	public void changType(){
		combo.removeAll();
		List<Object> map= new ArrayList<Object>();
		map.add("顾客姓名");
		map.add("房号");
		map.add("结账状态");
		if(map!=null && map.size()>0){
			for(Object m:map){
				//System.out.println(m);
				combo.add(String .valueOf(m));
			}
		}
	}
	//一开始的查询信息界面
	public  void showDate(){
		table.removeAll();//移除所有数据
		List<Map<String ,Object>> types=WineshopDao.Info();
		if(types!=null){
			TableItem tm;
			for(Map<String ,Object> map:types){
				tm=new TableItem(table, SWT.NONE);
				tm.setText(new String[]{String.valueOf(map.get("CUSTOMER_NAME")),String.valueOf(map.get("NUMBER_HOUSE")),String.valueOf(map.get("CASH")),String.valueOf(map.get("DATE_IN")),String.valueOf(map.get("LIVE_NUM")),String.valueOf(map.get("DATE_OUT")),String.valueOf(map.get("BILL_STATE"))});
			}
		} 
		
	}
	//进行条件查询
	public  void showDateInfo(List<Map<String ,Object>> list){
		table.removeAll();//移除所有数据
		if(list!=null){
			TableItem tm;
			for(Map<String ,Object> map:list){
				tm=new TableItem(table, SWT.NONE);
				tm.setText(new String[]{String.valueOf(map.get("CUSTOMER_NAME")),String.valueOf(map.get("NUMBER_HOUSE")),String.valueOf(map.get("CASH")),String.valueOf(map.get("DATE_IN")),String.valueOf(map.get("LIVE_NUM")),String.valueOf(map.get("DATE_OUT")),String.valueOf(map.get("BILL_STATE"))});
				//System.out.println("成功");
			}
		} 
		
	}
	
	@Override
	protected  void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
