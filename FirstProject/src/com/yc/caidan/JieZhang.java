package com.yc.caidan;

import org.eclipse.swt.widgets.Display;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;

import com.sun.mail.handlers.message_rfc822;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;

public class JieZhang {

	protected Shell shell;
	private Text text;
	private String str1=null;
	private static int number=1;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			JieZhang window = new JieZhang();
			window.open(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open(List<Object> list) {
		Display display = Display.getDefault();
		createContents(list);
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
	 * @param list 
	 */
	protected void createContents(List<Object> list) {
	
		System.out.println(list+"这是测试");
	
		shell = new Shell();
		shell.setSize(614, 389);
		shell.setText("结账");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setText("账单单号：");
		lblNewLabel.setBounds(26, 20, 69, 23);
		
		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setBounds(109, 20, 125, 23);
		lblNewLabel_1.setText((String) list.get(0));
		
		Label lblNewLabel_2 = new Label(shell, SWT.NONE);
		lblNewLabel_2.setBounds(351, 20, 61, 15);
		lblNewLabel_2.setText("结账房间：");
		
		Label label = new Label(shell, SWT.NONE);
		label.setBounds(433, 20, 145, 23);
		label.setText((String) list.get(1));//
		
		Label lblNewLabel_3 = new Label(shell, SWT.NONE);
		lblNewLabel_3.setBounds(26, 63, 61, 15);
		lblNewLabel_3.setText("消费金额：");
		
		final Label lblNewLabel_4 = new Label(shell, SWT.NONE);
		lblNewLabel_4.setBounds(103, 63, 131, 23);
		lblNewLabel_4.setText((String) list.get(2));
		
		Label lblNewLabel_5 = new Label(shell, SWT.NONE);
		lblNewLabel_5.setText("顾客姓名：");
		lblNewLabel_5.setBounds(351, 63, 61, 15);
		
		Label lblNewLabel_6 = new Label(shell, SWT.NONE);
		lblNewLabel_6.setBounds(429, 63, 79, 23);
		lblNewLabel_6.setText((String) list.get(3));
		
		Label lblNewLabel_7 = new Label(shell, SWT.NONE);
		lblNewLabel_7.setBounds(26, 113, 61, 15);
		lblNewLabel_7.setText("顾客类型：");
		
		Label lblNewLabel_8 = new Label(shell, SWT.NONE);
		lblNewLabel_8.setBounds(121, 113, 91, 23);
		lblNewLabel_8.setText((String) list.get(4));
		
		Label lblNewLabel_9 = new Label(shell, SWT.NONE);
		lblNewLabel_9.setBounds(351, 113, 61, 15);
		lblNewLabel_9.setText("折扣：");
		
		
		Label lblNewLabel_10 = new Label(shell, SWT.NONE);
		lblNewLabel_10.setBounds(433, 113, 79, 23);
		if(lblNewLabel_8.getText().equals("普通")){
			lblNewLabel_10.setText("无折扣");
		}else{
			lblNewLabel_10.setText("七折");

		}
		
		Label lblNewLabel_11 = new Label(shell, SWT.NONE);
		lblNewLabel_11.setText("优惠金额：");
		lblNewLabel_11.setBounds(26, 167, 61, 15);
		
		final Label lblNewLabel_12 = new Label(shell, SWT.NONE);
		lblNewLabel_12.setBounds(119, 167, 104, 23);
		if(lblNewLabel_10.getText().trim().equals("七折")){
			//System.out.println("老子是贵宾，折扣呢");
			int count=(int) (0.7*Integer.parseInt(lblNewLabel_4.getText().trim()));
			lblNewLabel_12.setText(String.valueOf(count));
		}else{
			lblNewLabel_12.setText("0");
		}
		
		Label lblNewLabel_13 = new Label(shell, SWT.NONE);
		lblNewLabel_13.setText("押金：");
		lblNewLabel_13.setBounds(351, 167, 61, 15);
		
		final Label lblNewLabel_14 = new Label(shell, SWT.NONE);
		lblNewLabel_14.setBounds(433, 167, 98, 23);
		lblNewLabel_14.setText((String) list.get(5));
		
		Label lblNewLabel_15 = new Label(shell, SWT.NONE);
		lblNewLabel_15.setText("顾客支付金额：");
		lblNewLabel_15.setBounds(26, 218, 79, 15);
			
		text = new Text(shell, SWT.BORDER);
		text.setText("0");
		text.setBounds(117, 212, 91, 21);
		
		
		Label lblNewLabel_17 = new Label(shell, SWT.NONE);
		lblNewLabel_17.setBounds(351, 218, 61, 15);
		lblNewLabel_17.setText("顾客找零：");
	
		final Label lblNewLabel_18 = new Label(shell, SWT.NONE);
		lblNewLabel_18.setBounds(433, 218, 98, 28);
		final int count1=Integer.parseInt(lblNewLabel_14.getText().trim());//押金
		int count2=Integer.parseInt(text.getText().trim());//顾客支付
		int count4=Integer.parseInt(lblNewLabel_12.getText().trim());//优惠金额
		lblNewLabel_18.setText(String.valueOf((count1+count2-count4)));
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.setBounds(94, 286, 80, 25);
		btnNewButton.setText("确认");
		
		Button btnNewButton_1 = new Button(shell, SWT.NONE);
		btnNewButton_1.setBounds(282, 286, 80, 25);
		btnNewButton_1.setText("取消");
		
		Label lblNewLabel_16 = new Label(shell, SWT.NONE);
		lblNewLabel_16.setBounds(400, 286, 61, 15);
		lblNewLabel_16.setText("营业人员：");
		
		Label lblNewLabel_19 = new Label(shell, SWT.NONE);
		lblNewLabel_19.setBounds(467, 286, 121, 15);
		lblNewLabel_19.setText(Denglu.chuangzhi());
		
		text.addKeyListener(new KeyAdapter() {//文本框的值随着输入而不断改变
			@Override
			public void keyPressed(KeyEvent e) {
				try {
					if(e.keyCode==13){//如果输入的值是一个enter键
						int count1=Integer.parseInt(lblNewLabel_14.getText().trim());//押金
						int count2=Integer.parseInt(text.getText().trim());//顾客支付
						int count3=Integer.parseInt(lblNewLabel_4.getText().trim());//消费金额
						int count4=Integer.parseInt(lblNewLabel_12.getText().trim());//优惠金额
						lblNewLabel_18.setText(String.valueOf((count1+count2+count4-count3)));
					}
					
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		//点击确认按钮
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
					int count1=Integer.parseInt(lblNewLabel_14.getText().trim());//押金
					int count2=Integer.parseInt(text.getText().trim());//顾客支付
					int count3=Integer.parseInt(lblNewLabel_4.getText().trim());//消费金额
					int count4=Integer.parseInt(lblNewLabel_12.getText().trim());//优惠金额
					lblNewLabel_18.setText(String.valueOf((count1+count2+count4-count3)));
					if((count1+count2+count4-count3)>=0){
						number=1;
						shell.dispose();
					}else{
						MessageDialog.openInformation(shell, "警告"," 您目前交给酒店的钱不够付房费，请及时补上金额");
					}
			
				
				
			}
		});
		//点击取消按钮
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				number=0;
				shell.dispose();
			}
		});

	}
	public static int getNumber(){
		return number;
	}
}
