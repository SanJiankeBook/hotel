package com.yc.caidan;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.FillLayout;

import javax.swing.SwingUtilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.wb.swt.SWTResourceManager;

import com.yc.Info.DataInfo;
import com.yc.productInfo.dao.DengluDao;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.RowData;

public class Zhujiemian {
	Denglu deng=new Denglu();
	protected Shell shell;
	private int clickx;//x的坐标
	private int clicky;//y的坐标
	private boolean flag=false;//鼠标是不是按在面板上
	private DengluDao denglu=new DengluDao();
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Zhujiemian window = new Zhujiemian();
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
		shell.setLocation(clicky, clicky); //固定窗口的位置
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
		shell = new Shell();
		shell.setImage(SWTResourceManager.getImage(Zhujiemian.class, "/Image/2013119141134705_看图王.jpg"));
		shell.setSize(new Point(1366, 768));
		shell.setSize(1366, 768);
		shell.setText("巨无霸大酒店"+"  "+"操作用户："+deng.chuangzhi());
		shell.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		SashForm sashForm = new SashForm(shell, SWT.NONE);
		sashForm.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_DARK_SHADOW));
		sashForm.setOrientation(SWT.VERTICAL);
		
		Composite composite = new Composite(sashForm, SWT.NONE);
		composite.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		composite.setLayout(new RowLayout(SWT.HORIZONTAL));
		
		final Composite composite_2 = new Composite(composite, SWT.NONE);
		composite_2.setBackgroundImage(SWTResourceManager.getImage(Zhujiemian.class, "/Image/16款卡通酒店图标矢量素材_看图王(1).jpg"));
		composite_2.setLayoutData(new RowData(SWT.DEFAULT, 64));
		//String path="/Image/16款卡通酒店图标矢量素材_看图王.jpg"
		//composite_2.setBounds(0, 0, this.getWidth(), this.getHeight());
		
		Composite composite_3 = new Composite(composite, SWT.NONE);
		composite_3.setBackgroundImage(SWTResourceManager.getImage(Zhujiemian.class, "/Image/预定_看图王.jpg"));
		composite_3.setLayoutData(new RowData(SWT.DEFAULT, 64));
		
		Composite composite_4 = new Composite(composite, SWT.NONE);
		composite_4.setBackgroundImage(SWTResourceManager.getImage(Zhujiemian.class, "/Image/16款卡通酒店图标矢量素材_看图王.jpg"));
		composite_4.setLayoutData(new RowData(SWT.DEFAULT, 64));
		
		Composite composite_5 = new Composite(composite, SWT.NONE);
		composite_5.setBackgroundImage(SWTResourceManager.getImage(Zhujiemian.class, "/Image/查询_看图王.jpg"));
		composite_5.setLayoutData(new RowData(SWT.DEFAULT, 64));
		
		Composite composite_6 = new Composite(composite, SWT.NONE);
		composite_6.setBackgroundImage(SWTResourceManager.getImage(Zhujiemian.class, "/Image/邮箱.jpg"));
		composite_6.setLayoutData(new RowData(SWT.DEFAULT, 64));
		
		Composite composite_7 = new Composite(composite, SWT.NONE);
		composite_7.setBackgroundImage(SWTResourceManager.getImage(Zhujiemian.class, "/Image/客房管理_看图王.jpg"));
		composite_7.setLayoutData(new RowData(SWT.DEFAULT, 64));
		
		Composite composite_8 = new Composite(composite, SWT.NONE);
		composite_8.setBackgroundImage(SWTResourceManager.getImage(Zhujiemian.class, "/Image/操作人员管理_看图王.jpg"));
		composite_8.setLayoutData(new RowData(SWT.DEFAULT, 64));
		
		final Composite composite_1 = new Composite(sashForm, SWT.NONE);
		sashForm.setWeights(new int[] {72, 654});
		
		composite_1.setLayout(DataInfo.stackLayout);
		DataInfo.chaxun=new Chaxun(composite_1,SWT.NONE);
		DataInfo.kehu=new Kehu(composite_1,SWT.NONE);
		DataInfo.yuding=new Yuding(composite_1,SWT.NONE);
		DataInfo.house=new HouseMessage(composite_1,SWT.NONE);
		DataInfo.qian=new QianTai1(composite_1,SWT.NONE);
		DataInfo.user=new UserManager(composite_1,SWT.NONE);
		DataInfo.mail=new Mail(composite_1,SWT.NONE);
		
		composite_2.addMouseListener(new MouseAdapter() {//前台
			@Override
			public void mouseDown(MouseEvent e) {
				//composite_1.getSize();
				//composite_1.getLocation();
				DataInfo.qian=new QianTai1(composite_1,SWT.NONE);
				composite_1.layout();
				//shell.setMaximized(true );
				//composite_1.setBounds(0, 0, composite_1.getSize().x+1, composite_1.getSize().y-200);
				DataInfo.qian.setVisible(true);
				DataInfo.house.setVisible(false);
				DataInfo.yuding.setVisible(false);
				DataInfo.kehu.setVisible(false);
				DataInfo.chaxun.setVisible(false);
				DataInfo.user.setVisible(false);
				DataInfo.mail.setVisible(false);
				DataInfo.stackLayout.topControl=DataInfo.qian;
				
				
			}
		});
			DataInfo.qian.setVisible(true);
			DataInfo.house.setVisible(false);
			DataInfo.yuding.setVisible(false);
			DataInfo.kehu.setVisible(false);
			DataInfo.chaxun.setVisible(false);
			DataInfo.user.setVisible(false);
			DataInfo.mail.setVisible(false);
			DataInfo.stackLayout.topControl=DataInfo.qian;
		
		
		composite_3.addMouseListener(new MouseAdapter() { //预定
			@Override
			public void mouseDown(MouseEvent e) {
				//shell.setMaximized(false );
				DataInfo.yuding.ShowAll();
				DataInfo.qian.setVisible(false);
				DataInfo.house.setVisible(false);
				DataInfo.yuding.setVisible(true);
				DataInfo.kehu.setVisible(false);
				DataInfo.chaxun.setVisible(false);
				DataInfo.user.setVisible(false);
				DataInfo.mail.setVisible(false);
				DataInfo.stackLayout.topControl=DataInfo.yuding;
			}
		});
		
		composite_4.addMouseListener(new MouseAdapter() { //客户
			@Override
			public void mouseDown(MouseEvent e) {
				//shell.setMaximized(false );
				DataInfo.kehu.ShowAll();
				DataInfo.qian.setVisible(false);
				DataInfo.house.setVisible(false);
				DataInfo.kehu.setVisible(true);
				DataInfo.chaxun.setVisible(false);
				DataInfo.yuding.setVisible(false);
				DataInfo.user.setVisible(false);
				DataInfo.mail.setVisible(false);
				DataInfo.stackLayout.topControl=DataInfo.kehu;
				
			}
		});
		
		composite_5.addMouseListener(new MouseAdapter() { //查询
			@Override
			public void mouseDown(MouseEvent e){
				//shell.setMaximized(false );
				DataInfo.qian.setVisible(false);
				DataInfo.house.setVisible(false);
				DataInfo.chaxun.setVisible(true);
				DataInfo.kehu.setVisible(false);
				DataInfo.yuding.setVisible(false);
				DataInfo.user.setVisible(false);
				DataInfo.mail.setVisible(false);
				DataInfo.chaxun.showDate();
				DataInfo.stackLayout.topControl=DataInfo.chaxun;
			}
		});
		
		composite_6.addMouseListener(new MouseAdapter() { //邮箱
			@Override
			public void mouseDown(MouseEvent e) {
				
				//shell.setMaximized(false );
				DataInfo.house.housefind();
				DataInfo.qian.setVisible(false);
				DataInfo.house.setVisible(false);
				DataInfo.yuding.setVisible(false);
				DataInfo.kehu.setVisible(false);
				DataInfo.chaxun.setVisible(false);
				DataInfo.user.setVisible(false);
				DataInfo.mail.setVisible(true);
				DataInfo.mail.ShowAll();
				DataInfo.stackLayout.topControl=DataInfo.mail;
			}
		});
		
		composite_7.addMouseListener(new MouseAdapter() { //房间管理
			@Override
			public void mouseDown(MouseEvent e) {
				//shell.setMaximized(false );
				List<Map<String, Object>>  list= new ArrayList<Map<String,Object>>();
				list=denglu.quanXian(Denglu.chuangzhi());
				if((list.get(0).get("ROLL_NAME")).equals("管理人员")){
					DataInfo.house.housefind();
					DataInfo.qian.setVisible(false);
					DataInfo.house.setVisible(true);
					DataInfo.yuding.setVisible(false);
					DataInfo.kehu.setVisible(false);
					DataInfo.chaxun.setVisible(false);
					DataInfo.user.setVisible(false);
					DataInfo.mail.setVisible(false);
					DataInfo.stackLayout.topControl=DataInfo.house;
				
				}else{
					MessageDialog.openError(shell, "温馨提示", "对不起，您的权限不够，不能使用该功能");
				}
			}
		});
		
		composite_8.addMouseListener(new MouseAdapter() { //操作用户管理管理
			@Override
			public void mouseDown(MouseEvent e) {
				
				//shell.setMaximized(false );
				List<Map<String, Object>>  list= new ArrayList<Map<String,Object>>();
				list=denglu.quanXian(Denglu.chuangzhi());
				if((list.get(0).get("ROLL_NAME")).equals("管理人员")){
					DataInfo.qian.setVisible(false);
					DataInfo.house.setVisible(false);
					DataInfo.yuding.setVisible(false);
					DataInfo.kehu.setVisible(false);
					DataInfo.chaxun.setVisible(false);
					DataInfo.user.setVisible(true);
					DataInfo.mail.setVisible(false);
					DataInfo.stackLayout.topControl=DataInfo.user;
				}else{
					MessageDialog.openError(shell, "温馨提示", "对不起，您的权限不够，不能使用该功能");
				}
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
//	public Image getImage(){
//		
//	}
	

}
