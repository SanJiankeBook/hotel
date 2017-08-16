package com.yc.caidan;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.custom.SashForm;

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
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Text;

import com.yc.productInfo.dao.MailDao;

import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.wb.swt.SWTResourceManager;

public class Mail extends Composite {
	private Table table;
	private TableItem tm;
	MailDao mail=new MailDao();
	SendMail sendmail=new SendMail();
	private Text text;
	private Text text_1;
	private Text text_2;
	private static String zhuTi=null;
	private static String neiRong=null;
	private static String fuJian=null;
	private int len;//存储选中行的数量
	private SendMail send;
	private int count=0;
	private List<String> YouXian1=new ArrayList<String>();

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public Mail(Composite parent, int style) {
		super(parent, style);
		setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BORDER));
		setLayout(new FillLayout(SWT.HORIZONTAL));
		
		SashForm sashForm = new SashForm(this, SWT.NONE);
		sashForm.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BORDER));
		
		Composite composite = new Composite(sashForm, SWT.NONE);
		composite.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		table = new Table(composite, SWT.BORDER | SWT.FULL_SELECTION | SWT.MULTI);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(104);
		tblclmnNewColumn.setText("顾客编号");
		
		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_1.setWidth(124);
		tblclmnNewColumn_1.setText("顾客姓名");
		
		TableColumn tblclmnNewColumn_2 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_2.setWidth(216);
		tblclmnNewColumn_2.setText("           邮箱");
		
		tm = new TableItem(table, SWT.NONE);
		
		

		Composite composite_1 = new Composite(sashForm, SWT.NONE);
		composite_1.setBackgroundMode(SWT.INHERIT_DEFAULT);
		composite_1.setBackgroundImage(SWTResourceManager.getImage(Mail.class, "/Image/96g58PICMPs_1024.jpg"));
		composite_1.setLayout(null);
		
		Label lblNewLabel = new Label(composite_1, SWT.NONE);
		lblNewLabel.setBounds(75, 10, 34, 17);
		lblNewLabel.setText("主题:");
		
		Button btnNewButton_2 = new Button(composite_1, SWT.NONE);
		btnNewButton_2.setBounds(48, 442, 80, 27);
		btnNewButton_2.setText("添加附件");
		
		Composite composite_6 = new Composite(sashForm, SWT.NONE);
		composite_6.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		SashForm sashForm_1 = new SashForm(composite_6, SWT.NONE);
		sashForm_1.setOrientation(SWT.VERTICAL);
		
		Composite composite_2 = new Composite(sashForm_1, SWT.NONE);
		composite_2.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		text = new Text(composite_2, SWT.BORDER);
		
		Composite composite_3 = new Composite(sashForm_1, SWT.NONE);
		composite_3.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		text_1 = new Text(composite_3, SWT.BORDER | SWT.V_SCROLL | SWT.MULTI);
		
		Composite composite_4 = new Composite(sashForm_1, SWT.NONE);
		composite_4.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		text_2 = new Text(composite_4, SWT.BORDER);
		
		Composite composite_5 = new Composite(sashForm_1, SWT.NONE);
		composite_5.setBackgroundImage(SWTResourceManager.getImage(Mail.class, "/Image/96g58PICMPs_1024.jpg"));
		composite_5.setLayout(null);
		
		Button btnNewButton = new Button(composite_5, SWT.NONE);
		btnNewButton.setBounds(34, 18, 80, 27);
		btnNewButton.setText("发送");
		
		Button btnNewButton_1 = new Button(composite_5, SWT.NONE);
		btnNewButton_1.setBounds(272, 18, 80, 27);
		btnNewButton_1.setText("取消");
		sashForm_1.setWeights(new int[] {34, 269, 107, 40});
		sashForm.setWeights(new int[] {322, 68, 323});
		//String ma=tab[0].getText(2);
		//sendmail.send();
		//
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				 List<String> YouXian=new ArrayList<String>();
				TableItem[] tab=table.getSelection();
				System.out.println(tab.length+"这个是看选择了几行");
				len=tab.length;
	    		if(tab!=null && tab.length>0){
	    			
	    			for(int i=0;i<len;i++){
	    				 YouXian.add(tab[i].getText(2));//获取邮箱号	
	    			}
	    			YouXian1=YouXian;
	    			//System.out.println(YouXian.toString());
	    			
	    		}
			}
		});
		
		//点击发送 
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				if(text.getText().trim()!=null && !text.getText().equals("") ){
					zhuTi=text.getText().trim();
					neiRong=text_1.getText().trim();
					fuJian=text_2.getText().trim();
					System.out.println(len);
					for(int i=0;i<len;i++){
						send=new SendMail();
						send.setSmtpServer("smtp.163.com");//网易的SMTP服务
					        //此处设置登录的用户名
						send.setUsername("15886471065@163.com");
					        //此处设置登录的密码
						send.setPassword("123456789pt");//授权密码
					        //设置收件人的地址
						send.setTo(YouXian1.get(i));
						System.out.println(YouXian1.get(i));
					        //设置发送人地址
						send.setFrom("15886471065@163.com");
						 //设置标题
						send.setSubject(zhuTi);
				        //设置内容
						send.setContent(neiRong); 
				        //粘贴附件
						send.attachfile(fuJian);
						if(send.send()){
							count++;
						}else{
							MessageDialog.openError(getShell(), "温馨提示", "客户的邮箱地址有误，请选择一个正确的地址来发送邮件");
						}
					}
					if(count>0){
						MessageDialog.openInformation(getShell(), "温馨提示", "邮件发送成功，共计发出"+count+"份邮件");
						count=0;
					}
				}else{
					MessageDialog.openError(getShell(), "温馨提示", "邮件发送主题不能让它为空");
				}
				
				
				
			}
		});
		
	
		//添加附件
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				FileDialog fd=new FileDialog(getShell(), SWT.Selection);
				fd.setText("选择附件");
				fd.setFilterPath("SystemRoot");
				text_2.setText(fd.open());
			}
		});
	
	//取消按钮
	btnNewButton_1.addMouseListener(new MouseAdapter() {
		
		public void mouseDown(MouseEvent e) {
			text.setText("");
			text_1.setText("");
			text_2.setText("");
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
	public void ShowAll(){
		table.removeAll();
			List<Map<String, Object>> list=mail.All();
			int len=mail.count();
			if(list!=null && list.size()>0){
				for(int i=0;i<len;i++){
					tm=new TableItem(table,SWT.NONE);//房间号、房间类型、房间状态、所在楼层、房间单价
					tm.setText(new String[]{String.valueOf(list.get(i).get("CUSTOMER_ID")),String.valueOf(list.get(i).get("CUSTOMER_NAME")),
							String.valueOf(list.get(i).get("MAIL"))});
				}
			}
	}
	
	//修改表格的宽度
	public void ChangeColumnWidth(){
		TableColumn[] cols=table.getColumns();//获取表格的字段数
		int width=(table.getSize().x)/(cols.length);//用剩余的长度除以减去1的列数（字段数）
		for(int i=0;i<cols.length;i++){
			cols[i].setWidth(width);
		}
	}

}
