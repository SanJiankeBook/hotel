package com.yc.caidan;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.FillLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;

import com.yc.productInfo.dao.KehuDao;

import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.wb.swt.SWTResourceManager;

public class Kehu extends Composite {
	protected static final String TableItem = null;
	private Table table;
	private Text text;
	private Text text_1;
	private Map map;
	private TableItem tm;
	private KehuDao kehuDao=new KehuDao();
	private Text text_3;
	private Text text_4;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public Kehu(final Composite parent, int style) {
		super(parent, style);
		setLayout(new FillLayout(SWT.HORIZONTAL));
		
		SashForm sashForm = new SashForm(this, SWT.NONE);
		sashForm.setOrientation(SWT.VERTICAL);
		
		Composite composite = new Composite(sashForm, SWT.NONE);
		composite.setBackgroundMode(SWT.INHERIT_DEFAULT);
		composite.setBackgroundImage(SWTResourceManager.getImage(Kehu.class, "/Image/96g58PICMPs_1024.jpg"));
		
		text = new Text(composite, SWT.BORDER);
		text.setBounds(130, 7, 139, 23);
		
		Label lblNewLabel = new Label(composite, SWT.NONE);
		lblNewLabel.setText("请输入顾客身份证号：");
		lblNewLabel.setBounds(10, 10, 120, 17);
		
		Label lblNewLabel_1 = new Label(composite, SWT.NONE);
		lblNewLabel_1.setBounds(308, 10, 96, 17);
		lblNewLabel_1.setText("请输入顾客姓名：");
		
		text_1 = new Text(composite, SWT.BORDER);
		text_1.setBounds(407, 7, 81, 23);
		
		final Button btnNewButton = new Button(composite, SWT.NONE);
		btnNewButton.setBounds(511, 5, 80, 27);
		btnNewButton.setText("搜索");
		
		Button btnNewButton_1 = new Button(composite, SWT.NONE);

		btnNewButton_1.setBounds(622, 5, 80, 27);
		btnNewButton_1.setText("返回");
		
		final Composite composite_1 = new Composite(sashForm, SWT.NONE);
		composite_1.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		table = new Table(composite_1, SWT.BORDER | SWT.FULL_SELECTION);

		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(60);
		tblclmnNewColumn.setText("顾客编号");
		
		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_1.setWidth(60);
		tblclmnNewColumn_1.setText("顾客姓名");
		
		TableColumn tblclmnNewColumn_2 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_2.setText("身份证号");
		tblclmnNewColumn_2.setWidth(129);
		
		TableColumn tblclmnNewColumn_3 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_3.setWidth(36);
		tblclmnNewColumn_3.setText("性别");
		
		TableColumn tblclmnNewColumn_4 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_4.setWidth(36);
		tblclmnNewColumn_4.setText("年龄");
		
		TableColumn tblclmnNewColumn_5 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_5.setWidth(85);
		tblclmnNewColumn_5.setText("联系方式");
		
		TableColumn tblclmnNewColumn_6 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_6.setWidth(133);
		tblclmnNewColumn_6.setText("邮箱");
		
		TableColumn tblclmnNewColumn_7 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_7.setWidth(60);
		tblclmnNewColumn_7.setText("顾客类型");
		
	    tm = new TableItem(table, SWT.NONE);

	    Menu menu = new Menu(table);
	    table.setMenu(menu);
	    
	    MenuItem menuItem = new MenuItem(menu, SWT.NONE);

	    menuItem.setText("选择修改");
		
		Composite composite_2 = new Composite(sashForm, SWT.NONE);
		composite_2.setBackgroundMode(SWT.INHERIT_DEFAULT);
		composite_2.setBackgroundImage(SWTResourceManager.getImage(Kehu.class, "/Image/96g58PICMPs_1024.jpg"));
		
		Button btnNewButton_2 = new Button(composite_2, SWT.NONE);
		
		btnNewButton_2.setBounds(319, 55, 80, 27);
		btnNewButton_2.setText("确定");
		
		Label label = new Label(composite_2, SWT.NONE);
		label.setBounds(40, 20, 61, 17);
		label.setText("顾客类型：");
		
		Label label_1 = new Label(composite_2, SWT.NONE);
		label_1.setBounds(40, 60, 80, 17);
		label_1.setText("顾客联系方式：");
		
		text_3 = new Text(composite_2, SWT.BORDER);
		text_3.setBounds(126, 57, 109, 23);
		
		Label label_2 = new Label(composite_2, SWT.NONE);
		label_2.setBounds(277, 20, 36, 17);
		label_2.setText("邮箱：");
		
		text_4 = new Text(composite_2, SWT.BORDER);
		text_4.setBounds(319, 20, 161, 23);
		
		final Combo combo = new Combo(composite_2, SWT.NONE);
		combo.setBounds(107, 12, 88, 25);
		combo.add("普通");
		combo.add("贵宾");
		sashForm.setWeights(new int[] {66, 329, 88});
		
		//一开始显示所有数据
		ShowAll(); 
		
		
		//删除
		/*btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				TableItem[] tab=table.getSelection();
				if(tab==null || tab.length<=0){
					MessageDialog.openError(getShell(), "错误","此行没有数据");
				}else{
					int i=0;
					StringBuffer str=new StringBuffer();
					for(i=0;i<tab.length-1;i++){
						str.append(tab[i].getText(0)+",");
					}
					str.append(tab[i].getText(0));
					
					if(MessageDialog.openConfirm(getShell(), "警告", "你要删除这些数据吗？")){
						if(KehuDao.del(str.toString())>0){
							//ShowAll();
						}
					}
					
					
				}
			}
		});*/
		
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				TableItem[] tab=table.getSelection();
	    		if(tab!=null && tab.length>0){
	    			combo.setText(tab[0].getText(7));
	    			//System.out.println("text_2="+text_2);
	    			text_4.setText(tab[0].getText(6));
	    			//System.out.println("text_4="+text_4);
	    			text_3.setText(tab[0].getText(5));
	    			//System.out.println("text_3="+text_3);
	    		}
			}
		});
		
		/*//右键选择修改
		menuItem.addSelectionListener(new SelectionAdapter() {
		    	@Override
		    	public void widgetSelected(SelectionEvent e) {
		    		TableItem[] tab=table.getSelection();
		    		if(tab!=null && tab.length>0){
		    			combo.setText(tab[0].getText(7));
		    			//System.out.println("text_2="+text_2);
		    			text_4.setText(tab[0].getText(6));
		    			//System.out.println("text_4="+text_4);
		    			text_3.setText(tab[0].getText(5));
		    			//System.out.println("text_3="+text_3);
		    		}	
		    	}
		 });*/
		 
		 
		 //点击确定按钮
		 btnNewButton_2.addMouseListener(new MouseAdapter() {
				@Override
				//顾客类型text_2 邮箱text_4 联系方式text_3
				public void mouseDown(MouseEvent e) {
					try {
						String s1=combo.getText().trim();
						//System.out.println(s1);
						String s2=text_4.getText().trim();
						//System.out.println(s2);
						String s3=text_3.getText().trim();
						//System.out.println(s3);
						tm=table.getSelection()[0];
						//System.out.println(tm+"tm等于");
						String st=tm.getText(0).trim();
						//System.out.println("st="+st);
						String st1=tm.getText(1).trim();
						//System.out.println("st1="+st1);
						List<Map<String, Object>> list=KehuDao.update(s3,s2,s1,st);
						List<Map<String, Object>> list1=KehuDao.findName(st1);
						if(list!=null){
							ShowData(list);
							ShowData(list1);
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
		});
		 
		//选择返回按钮
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
		
		//根据条件显示数据(搜索)
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				List<Map<String, Object>> list=new ArrayList<Map<String, Object>>();
				String st=text.getText().trim();
				//System.out.println("st="+st);
				String st1=text_1.getText().trim();
				if(text!=null && st!=""){
					list=KehuDao.find(text.getText().trim());
					//list=KehuDao.find(text_1.getText().trim());
					ShowData(list);
					//MessageDialog.openWarning(composite_1.getShell(), "很抱歉","没有此人");
				}else if(text_1!=null && st1!=""){
					list=KehuDao.findName(text_1.getText().trim());
					ShowData(list);
				}else{
						MessageDialog.openError(getShell(), "很抱歉","没有此人");
				}
				text.setText("");
				text_1.setText("");
				
			}
		});

	}
	
	//显示所有数据
	public void ShowAll(){
		table.removeAll();
		List<Map<String, Object>> list=kehuDao.All();
		int len=kehuDao.count();
		if(list!=null && list.size()>0){
			for(int i=0;i<len;i++){
				tm=new TableItem(table,SWT.NONE);
				tm.setText(new String[]{String.valueOf(list.get(i).get("CUSTOMER_ID")),String.valueOf(list.get(i).get("CUSTOMER_NAME")),
						String.valueOf(list.get(i).get("CARD_ID")),String.valueOf(list.get(i).get("SEX")),
						String.valueOf(list.get(i).get("AGE")),String.valueOf(list.get(i).get("TEL")),String.valueOf(list.get(i).get("MAIL")),
						String.valueOf(list.get(i).get("TYPE_CUSTOMER"))});			
			}
		}
	}
	
	
	
	//条件选择数据
	public void ShowData(List<Map<String, Object>> list){
		table.removeAll();
		//String s=null;
		//List<Map<String, Object>> list=kehuDao.find(s);
		if(list!=null && list.size()>0){
			for(Map<String,Object> map:list){
				//map=new HashMap();
				//TableItem tm;
				tm=new TableItem(table,SWT.NONE);
				tm.setText(new String[]{String.valueOf(list.get(0).get("CUSTOMER_ID")),String.valueOf(list.get(0).get("CUSTOMER_NAME")),
				String.valueOf(list.get(0).get("CARD_ID")),String.valueOf(list.get(0).get("SEX")),
				String.valueOf(list.get(0).get("AGE")),String.valueOf(list.get(0).get("TEL")),String.valueOf(list.get(0).get("MAIL")),
				String.valueOf(list.get(0).get("TYPE_CUSTOMER"))});
			}
		}//customer_id customer_name card_id sex age tel mail type_customer
	}
	
	//修改表格的宽度
	public void ChangeColumnWidth(){
		TableColumn[] cols=table.getColumns();//获取表格的字段数
		int width=(table.getSize().x)/(cols.length);//用剩余的长度除以减去1的列数（字段数）
		for(int i=0;i<cols.length;i++){
			cols[i].setWidth(width);
		}
	}

	
	
	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}