package com.yc.caidan;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.custom.SashForm;

import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.yc.productInfo.dao.UserManagerDao;

import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.wb.swt.SWTResourceManager;

public class UserManager extends Composite {
	private Table table;
	private Text text;
	private Text text_1;
	private UserManagerDao uminfo=new UserManagerDao();
	private String pid=null;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public UserManager(final Composite parent, int style) {
		super(parent, style);
		setLayout(new FillLayout(SWT.HORIZONTAL));
		
		SashForm sashForm = new SashForm(this, SWT.VERTICAL);
		
		Composite composite = new Composite(sashForm, SWT.NONE);
		composite.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		table = new Table(composite, SWT.BORDER | SWT.FULL_SELECTION);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(100);
		tblclmnNewColumn.setText("用户编号");
		
		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_1.setWidth(100);
		tblclmnNewColumn_1.setText("用户名");
		
		TableColumn tblclmnNewColumn_2 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_2.setWidth(100);
		tblclmnNewColumn_2.setText("用户密码");
		
		TableColumn tblclmnNewColumn_3 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_3.setWidth(100);
		tblclmnNewColumn_3.setText("用户类型");
		
		Menu menu = new Menu(table);
		table.setMenu(menu);
		
		MenuItem menuItem = new MenuItem(menu, SWT.NONE);
		menuItem.setText("修改");
		
		MenuItem menuItem_1 = new MenuItem(menu, SWT.NONE);
		menuItem_1.setText("删除");
		
		Composite composite_1 = new Composite(sashForm, SWT.NONE);
		composite_1.setBackgroundMode(SWT.INHERIT_DEFAULT);
		composite_1.setBackgroundImage(SWTResourceManager.getImage(UserManager.class, "/Image/96g58PICMPs_1024.jpg"));
		
		final Button btnNewButton = new Button(composite_1, SWT.NONE);
		
		btnNewButton.setBounds(52, 67, 80, 25);
		btnNewButton.setText("修改");
		btnNewButton.setVisible(false);
		
		Button btnNewButton_1 = new Button(composite_1, SWT.NONE);
		btnNewButton_1.setText("添加");
		btnNewButton_1.setBounds(443, 67, 80, 25);
		
		Label lblNewLabel = new Label(composite_1, SWT.NONE);
		lblNewLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_FOREGROUND));
		lblNewLabel.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 15, SWT.BOLD));
		lblNewLabel.setBounds(10, 10, 73, 27);
		lblNewLabel.setText("用户名：");
		
		text = new Text(composite_1, SWT.BORDER);
		text.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 13, SWT.NORMAL));
		text.setBounds(89, 10, 73, 27);
		
		Label lblNewLabel_1 = new Label(composite_1, SWT.NONE);
		lblNewLabel_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 15, SWT.BOLD));
		lblNewLabel_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_FOREGROUND));
		lblNewLabel_1.setBounds(209, 10, 94, 27);
		lblNewLabel_1.setText("用户密码：");
		
		text_1 = new Text(composite_1, SWT.BORDER);
		text_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 13, SWT.NORMAL));
		text_1.setBounds(309, 10, 80, 27);
		
		Label lblNewLabel_2 = new Label(composite_1, SWT.NONE);
		lblNewLabel_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_FOREGROUND));
		lblNewLabel_2.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 15, SWT.BOLD));
		lblNewLabel_2.setBounds(415, 10, 99, 27);
		lblNewLabel_2.setText("用户类型：");
		
		final Label lblNewLabel_3 = new Label(composite_1, SWT.NONE);
		lblNewLabel_3.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 13, SWT.BOLD));
		lblNewLabel_3.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_FOREGROUND));
		lblNewLabel_3.setBounds(520, 10, 85, 27);
		sashForm.setWeights(new int[] {284, 102});
		//表格控制大小
		table.addControlListener(new ControlAdapter() {
			public void controlResized(ControlEvent e) {
				changeColumnWidth();
				showData();
			}
		});
		//右击删除
		menuItem_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				TableItem[] tis =table.getSelection();
				if(tis==null||tis.length<=0){
					MessageDialog.openWarning(getShell(), "温馨提示", "没有要删除的数据!!");
				}else{
					int i =0;
					StringBuffer ids =new StringBuffer();
					for(i=0;i<tis.length-1;i++){
						ids.append(tis[i].getText(0)+",");
					}
					ids.append(tis[i].getText(0));
					if(MessageDialog.openConfirm(getShell(), "删除确认", "你确定要删除数据吗？")){
						if(!lblNewLabel_3.getText().trim().equals("管理人员")){
							if(uminfo.del(ids.toString())>0){
								showData();
							}else{
								MessageDialog.openError(getShell(), "失败提示", "删除数据失败!!");
							}
						}else{
							MessageDialog.openError(getShell(), "失败提示", "不能进行自杀");
						}
						
					}else {
						return ;
					}
				}
				
			}
		});
		
		//点击表的时候
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				TableItem[] tab=table.getSelection();
	    		if(tab!=null && tab.length>0){
	    			text.setText(tab[0].getText(1));
					text_1.setText(tab[0].getText(2));
	    			text_1.setEchoChar('*');
					lblNewLabel_3.setText(tab[0].getText(3));
					pid=tab[0].getText(0);
	    			
	    			
	    		}
			}
		});
		//右击修改
		menuItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				btnNewButton.setVisible(true);
				TableItem[] tis =table.getSelection();
				if(tis!=null&&tis.length>0){
					text.setText(tis[0].getText(1));
					text_1.setText(tis[0].getText(2));
					lblNewLabel_3.setText(tis[0].getText(3));
					pid=tis[0].getText(0);
				}
			}
		});
		//点击修改
		btnNewButton.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						
						String pname =text.getText().trim();
						String pwssowd =text_1.getText().trim();
				
						//System.out.println(pname+" "+pwssowd+"这个是修改的测试"+" "+ pid);
						if(uminfo.update(pname, pwssowd,pid)>0){
							showData();
							btnNewButton.setVisible(false);
							lblNewLabel_3.setText("");
							text.setText("");
							text_1.setText("");
						}else{
							MessageDialog.openError(getShell(), "失败提示", "数据库更新失败");
						}
					}
				});
		//点击添加
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String pname =text.getText().trim();
				String pwssowd =text_1.getText().trim();
				if(pname!=null&&! pname.equals("")&& pwssowd!=null &&! pwssowd.equals("")){
					if(uminfo.add(pname, pwssowd)>0){
						text.setText("");
						text_1.setText("");
						lblNewLabel_3.setText("");
						showData();
					}else{
						MessageDialog.openInformation(parent.getShell(), "温馨提示", "用户添加失败,请注意账号的唯一性和信息的完整性");
					}
				}
			}
		});
	
	}
	
	//表中显示数据
		public void showData() {
			 table.removeAll();
			 List<Map<String, Object>> vector =uminfo.Find();
			 System.out.println(vector+"这个是测试");
			 if(vector!=null&&vector.size()>0){
				 TableItem ti;
			  
			 for(Map<String, Object> map:vector){
				ti=new TableItem(table, SWT.NONE);
				ti.setText(new String[]{String.valueOf(map.get("USER_ID")),String.valueOf(map.get("USER_NAME")),"***",String.valueOf(map.get("ROLL_NAME"))});
				//String.valueOf(map.get("USERI_PASSWORD"))
			 	}
			 }
		}
		
	
	
	//表中数据居中
	public void  changeColumnWidth(){
		TableColumn[] cols =table .getColumns();
		int width =(table.getSize().x)/(cols.length);
		for(int i =0;i<cols.length;i++){
			cols[i].setWidth(width);
		}
	}
}
