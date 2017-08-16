package com.yc.caidan;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.prefs.BackingStoreException;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.wb.swt.SWTResourceManager;

import com.yc.productInfo.dao.DengluDao;

import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.MouseTrackAdapter;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tray;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.ModifyEvent;

public class Denglu{

	protected Shell shell;
	private int clickx=350;//x的坐标
	private int clicky=150;//y的坐标
	private boolean flag=false;//鼠标是不是按在面板上
	private Text text_1;
	private DengluDao lg=new DengluDao();
	public static String uname;
	private Button btnNewButton_1;

	/**
	 * Launch the application
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Denglu window = new Denglu();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		shell.setLocation(clickx, clicky);
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell(SWT.NONE);
		shell.setImage(SWTResourceManager.getImage(Denglu.class, "/Image/2013119141134705_看图王.jpg"));
		shell.setBackgroundImage(SWTResourceManager.getImage(Denglu.class, "/image/Login1.jpg"));
		shell.setBackgroundMode(SWT.INHERIT_DEFAULT);
		shell.setSize(686, 436);
		shell.setText("用户登入");
		shell.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setBackgroundMode(SWT.INHERIT_DEFAULT);
		composite.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 15, SWT.NORMAL));
		
		final Label lblNewLabel = new Label(composite, SWT.NONE);
		lblNewLabel.setImage(SWTResourceManager.getImage(Denglu.class, "/Image/2013119141134705_看图王.jpg"));
		lblNewLabel.setAlignment(SWT.CENTER);
		lblNewLabel.setForeground(SWTResourceManager.getColor(72, 61, 139));
		lblNewLabel.setFont(SWTResourceManager.getFont("楷体", 38, SWT.BOLD));
		lblNewLabel.setBounds(57, 44, 573, 69);
		lblNewLabel.setText("欢迎来到巨无霸大酒店");
		
		Label label = new Label(composite, SWT.NONE);
		label.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 15, SWT.NORMAL));
		label.setBounds(141, 227, 82, 32);
		label.setText("用户名：");
		
		Label lblNewLabel_1 = new Label(composite, SWT.NONE);
		lblNewLabel_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 16, SWT.NORMAL));
		lblNewLabel_1.setBounds(141, 273, 61, 26);
		lblNewLabel_1.setText("密码：");
		
		final Combo combo = new Combo(composite, SWT.NONE);
		combo.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 15, SWT.NORMAL));
		combo.setBounds(229, 224, 241, 23);
		combo.setText("请输入您的账号");
		
		text_1 = new Text(composite, SWT.BORDER);
		text_1.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
			}
		});
		text_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 15, SWT.NORMAL));
		text_1.setText("请输入您的密码");
		text_1.setBounds(229, 273, 241, 33);
		
		Button btnNewButton = new Button(composite, SWT.NONE);
		btnNewButton.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 15, SWT.NORMAL));
		btnNewButton.setBounds(359, 350, 80, 41);
		btnNewButton.setText("退出");
		
		btnNewButton_1 = new Button(composite, SWT.NONE);
		btnNewButton_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 15, SWT.NORMAL));
		btnNewButton_1.setBounds(242, 350, 80, 41);
		btnNewButton_1.setText("登入");
		
		Label lblNewLabel_2 = new Label(composite, SWT.NONE);
		lblNewLabel_2.setImage(SWTResourceManager.getImage(Denglu.class, "/image/btn_close_highlight.png"));
		lblNewLabel_2.setBounds(635, 0, 39, 20);
		
		Label lblNewLabel_3 = new Label(composite, SWT.NONE);

		lblNewLabel_3.setImage(SWTResourceManager.getImage(Denglu.class, "/image/btn_mini_highlight.png"));
		lblNewLabel_3.setBounds(591, 0, 39, 20);
		
		final Label lblNewLabel_4 = new Label(composite, SWT.NONE);
		lblNewLabel_4.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 13, SWT.NORMAL));
		lblNewLabel_4.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblNewLabel_4.setBounds(185, 189, 314, 29);
		//把数据库中已经存在的账号存进账号框
		List<Map<String, Object>> map=new ArrayList<Map<String, Object>>();
			map=lg.Info();
			if(map!=null && !map.isEmpty()&& map.size()>0){
				for(int i=0,len=map.size();i<len;i++){
					combo.add(String.valueOf(map.get(i).get("USER_NAME")));
					System.out.println(i);
				}
			}
		//处理登入出错的问题
			combo.addModifyListener(new ModifyListener() {//一旦combo文本框内容有所改动，怎么触发该监控
				public void modifyText(ModifyEvent arg0) {
					lblNewLabel_4.setText("");
//					String key=combo.getText();//这个是在账号框中有已经存入注册表的账号，那么密码框也会显示当前账号对应的密码
//					text_1.setEchoChar('*');//密码用*显示
//					if(map.containsKey(key)){//判断是否存在这个账号
//						text_1.setText(map.get(key));
//					}
				}
			});
			text_1.addModifyListener(new ModifyListener() {//一旦text文本框内容有所改动，怎么触发该监控
				public void modifyText(ModifyEvent arg0) {
					lblNewLabel_4.setText("");
				}
			});
		
		
		//输入密码框获取影响和丢失焦点
		text_1.addFocusListener(new FocusAdapter() {
					@Override
					public void focusGained(FocusEvent e) {
						if("请输入您的密码".equals(text_1.getText().trim())){//String.trim()的作用是去掉一行字符串前面和后面的空格
							text_1.setText("");
							text_1.setEchoChar('*');
						}
					}
					@Override
					public void focusLost(FocusEvent e) {
						
					}
				});
		//一旦账号输入完
		combo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {//但键盘松开时
				if(e.keyCode==13){//如果松开的键是回车键（13）
					text_1.setFocus();//setFocus是设置焦点，这条语句意味着当账号框出现一个回车键，那么密码框text将获取这个焦点，即鼠标将自动有账号框到密码框
				}
			}
		});
		
		
		text_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.keyCode==13){//如果松开的键是回车键（13）
					btnNewButton_1.setFocus();//setFocus是设置焦点，这条语句意味着当账号框出现一个回车键，那么密码框text将获取这个焦点，即鼠标将自动有账号框到密码框
				}
			}
		});
		//输入账号框获取影响和丢失影响
		combo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {		
				if("请输入您的账号".equals(combo.getText().trim())){//String.trim()的作用是去掉一行字符串前面和后面的空格
					combo.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if("".equals(combo.getText().trim())){//String.trim()的作用是去掉一行字符串前面和后面的空格
					combo.setText("请输入您的账号");
				}
			}
		});
		//进行登入
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				 uname=combo.getText();
				String pwd=text_1.getText().trim();
				//System.out.println(map.get(uname));
				try {
					List<Map<String, Object>>  list33= new ArrayList<Map<String,Object>>();
					list33=lg.find(uname);
					if(pwd.equals(String.valueOf(list33.get(0).get("USERI_PASSWORD")))){//由于我们这个密码和账号是在数据库中操作，所以在这里不要在操作什么
						Zhujiemian zhu=new Zhujiemian();
						shell.close();
						zhu.open();
						
					}else{
						lblNewLabel_4.setText(" 你输入的账号或密码错误....");
						combo.setFocus();
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		//点击退出按钮时候
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.dispose();
			}
		});
		//当点击最小化按钮时候
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				shell.setMinimized(true);
			}
		});
		//当点击关闭按钮时候
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				shell.dispose();
			}
		});
		
	/**
	 * 下面这块是移动整个面板	
	 */
		//鼠标按下的时候
		composite.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {//按下去
				flag=true;
				clickx=e.x;
				clicky=e.y;
			}
			@Override
			public void mouseUp(MouseEvent e) {//松开
				flag=false;
			}
		});
		
		//当面板移动时候
		composite.addMouseMoveListener(new MouseMoveListener() {
			public void mouseMove(MouseEvent arg0) {
				if(flag){
					shell.setLocation(shell.getLocation().x+arg0.x-clickx,shell.getLocation().y+arg0.y-clicky);
				}
			}
			
		});
	}
	
	//传值
	public static String chuangzhi(){
		String u=uname;
		return u;
	}
	
}
