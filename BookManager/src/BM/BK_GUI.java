package BM;


import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JEditorPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.Component;
import javax.swing.SwingConstants;

public class BK_GUI extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	BookManager BM=new BookManager();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BK_GUI frame = new BK_GUI();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BK_GUI() {
		setTitle("BKMS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 1200, 1200);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setVisible(true);
		panel.setBounds(29, 17, 376, 241);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setVisible(false);
		panel_1.setBounds(29, 17, 376, 241);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setVisible(false);
		panel_2.setBounds(29, 17, 376, 241);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		String Names[] = {"书名","作者","价格","出版社"};
		DefaultTableModel defaultTableModel = new DefaultTableModel(null,Names);
		JTable table= new JTable(defaultTableModel);
		DefaultTableCellRenderer r = new  DefaultTableCellRenderer();   
	    r.setHorizontalAlignment(JLabel.CENTER);     
	    table.setDefaultRenderer(Object.class, r);
	    JScrollPane scrollPane=new JScrollPane();
	    scrollPane.setEnabled(false);
	    scrollPane.setSize(376, 200); 
	    scrollPane.setViewportView(table);
	    panel_2.add(scrollPane); 
	    
	    
	    
	    JPanel panel_3 = new JPanel();
	    panel_3.setVisible(false);
		panel_3.setBounds(29, 17, 376, 241);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setVisible(false);
		panel_4.setBounds(29, 17, 376, 241);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		DefaultTableModel defaultTableModel_1 = new DefaultTableModel(null,Names);
		JTable table_1= new JTable(defaultTableModel_1);
		DefaultTableCellRenderer r_1 = new  DefaultTableCellRenderer();   
	    r_1.setHorizontalAlignment(JLabel.CENTER);     
	    table_1.setDefaultRenderer(Object.class, r);
	    JScrollPane scrollPane_1=new JScrollPane();
	    scrollPane_1.setLocation(0, 86);
	    scrollPane_1.setSize(376, 41); 
	    scrollPane_1.setViewportView(table_1);
	    panel_4.add(scrollPane_1);
		
	    JPanel panel_5 = new JPanel();
	    panel_5.setVisible(false);
		panel_5.setBounds(29, 17, 376, 241);
		contentPane.add(panel_5);
		panel_5.setLayout(null);
		
		
		JLabel label_2 = new JLabel("增添书籍");
		label_2.setFont(new Font("楷体", Font.PLAIN, 14));
		label_2.setBounds(158, 10, 61, 36);
		panel_3.add(label_2);
		
		JLabel lblNewLabel = new JLabel("书籍名称");
		lblNewLabel.setFont(new Font("楷体", Font.PLAIN, 13));
		lblNewLabel.setBounds(114, 56, 54, 15);
		panel_3.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(189, 53, 87, 21);
		panel_3.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("作者");
		lblNewLabel_1.setFont(new Font("楷体", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(114, 90, 54, 15);
		panel_3.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(189, 87, 87, 21);
		panel_3.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("价格");
		lblNewLabel_2.setFont(new Font("楷体", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(114, 123, 54, 15);
		panel_3.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(189, 120, 87, 21);
		panel_3.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("出版社");
		lblNewLabel_3.setFont(new Font("楷体", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(114, 163, 54, 15);
		panel_3.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(189, 160, 87, 21);
		panel_3.add(textField_3);
		textField_3.setColumns(10);
		
		JButton button_4 = new JButton("\u8FD4\u56DE\u83DC\u5355");
	    button_4.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		panel.setVisible(false);
				panel_1.setVisible(true);
				panel_2.setVisible(false);
				panel_3.setVisible(false);
				panel_4.setVisible(false);
				panel_5.setVisible(false);
	    	}
	    });
	    button_4.setBounds(253, 201, 93, 23);
	    panel_2.add(button_4);
		
		
		JButton btnNewButton_8 = new JButton("确认添加");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String BK_name=textField.getText();
				String BK_author=textField_1.getText();
				String price=textField_2.getText();
				double BK_price=Double.valueOf(price);
				String BK_publisher=textField_3.getText();
				BM.addBook(BK_name, BK_author, BK_price, BK_publisher);
				JOptionPane.showMessageDialog(panel_1, "添加成功", "标题",JOptionPane.WARNING_MESSAGE);
			}
		});
		btnNewButton_8.setBounds(75, 188, 93, 23);
		panel_3.add(btnNewButton_8);
		
		JButton button_6 = new JButton("\u8FD4\u56DE\u83DC\u5355");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				panel_1.setVisible(true);
				panel_2.setVisible(false);
				panel_3.setVisible(false);
				panel_4.setVisible(false);
				panel_5.setVisible(false);
			}
		});
		button_6.setBounds(223, 191, 93, 23);
		panel_3.add(button_6);
		
		JLabel lblWelcome = new JLabel("welcome");
		lblWelcome.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		lblWelcome.setBounds(145, 0, 93, 38);
		panel.add(lblWelcome);
		
		
		
		
		passwordField = new JPasswordField();
		passwordField.setBorder(new LineBorder(new Color(204, 204, 204)));
		passwordField.setBounds(166, 111, 106, 23);
		panel.add(passwordField);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBorder(new LineBorder(new Color(204, 204, 204)));
		editorPane.setBounds(166, 63, 106, 21);
		panel.add(editorPane);
		
		JButton button = new JButton("登陆");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String acount=editorPane.getText();
				char pass[]=passwordField.getPassword();
				String password =new String(pass);
				editorPane.setText(password);
				if(BM.login_m(acount, password))
				{
					panel.setVisible(false);
					panel_1.setVisible(true);
					panel_2.setVisible(false);
					panel_3.setVisible(false);
					panel_4.setVisible(false);
					panel_5.setVisible(false);
				}
			}
		});
		button.setBounds(82, 178, 93, 23);
		panel.add(button);
		
		JButton btnNewButton = new JButton("退出");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				System.exit(0);
			}
		});
		btnNewButton.setBounds(229, 178, 84, 23);
		panel.add(btnNewButton);
		
		
		JLabel label = new JLabel("账号");
		label.setFont(new Font("新宋体", Font.PLAIN, 14));
		label.setBounds(119, 63, 28, 21);
		panel.add(label);
		
		JLabel label_1 = new JLabel("密码");
		label_1.setFont(new Font("新宋体", Font.PLAIN, 14));
		label_1.setBounds(119, 115, 28, 15);
		panel.add(label_1);
		
		
		
		JButton button_1 = new JButton("显示所有书籍");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
				int num=BM.getNum();
				 while(defaultTableModel.getRowCount()>0){
					 defaultTableModel.removeRow(defaultTableModel.getRowCount()-1);
				 }
				if(num==0)
				{
					JOptionPane.showMessageDialog(panel_1, "系统中没有储存书籍", "标题",JOptionPane.WARNING_MESSAGE);  
				}
				if(num>0)
				{
					String data[][]=BM.getDATA();
					for(Object ob[]:data)
					{
						defaultTableModel.addRow(ob);
					}
					panel.setVisible(false);
					panel_1.setVisible(false);
					panel_2.setVisible(true);
					panel_3.setVisible(false);
					panel_4.setVisible(false);
					panel_5.setVisible(false);
				
				}
				
			}
		});
		button_1.setBounds(124, 36, 118, 23);
		panel_1.add(button_1);
		
		JButton btnNewButton_1 = new JButton("添加书籍");
		btnNewButton_1.setActionCommand("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				panel.setVisible(false);
				panel_1.setVisible(false);
				panel_2.setVisible(false);
				panel_3.setVisible(true);
				panel_4.setVisible(false);
				panel_5.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(124, 69, 118, 23);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_4 = new JButton("\u67E5\u627E\u4E66\u7C4D");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				panel_1.setVisible(false);
				panel_2.setVisible(false);
				panel_3.setVisible(false);
				panel_4.setVisible(true);
				panel_5.setVisible(false);
			}
		});
		btnNewButton_4.setBounds(124, 102, 118, 23);
		panel_1.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("修改密码");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				panel.setVisible(false);
				panel_1.setVisible(false);
				panel_2.setVisible(false);
				panel_3.setVisible(false);
				panel_4.setVisible(false);
				panel_5.setVisible(true);
			}
		});
		btnNewButton_5.setBounds(124, 135, 118, 23);
		panel_1.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("\u9000\u51FA");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BM.saveData();
				System.exit(0);
			}
		});
		btnNewButton_6.setFont(new Font("楷体", Font.PLAIN, 16));
		btnNewButton_6.setBounds(77, 186, 221, 45);
		panel_1.add(btnNewButton_6);
		
		JLabel lblNewLabel_8 = new JLabel("\u83DC\u5355");
		lblNewLabel_8.setFont(new Font("楷体", Font.PLAIN, 15));
		lblNewLabel_8.setBounds(164, 0, 30, 26);
		panel_1.add(lblNewLabel_8);
		
		
		
		JLabel lblNewLabel_4 = new JLabel("\u67E5\u8BE2");
		lblNewLabel_4.setFont(new Font("楷体", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(161, 5, 60, 30);
		panel_4.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\u8BF7\u8F93\u5165\u4E66\u7C4D\u540D");
		lblNewLabel_5.setFont(new Font("楷体", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(57, 61, 78, 15);
		panel_4.add(lblNewLabel_5);
		
		
		
		textField_4 = new JTextField();
		textField_4.setBounds(142, 55, 87, 21);
		panel_4.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton_7 = new JButton("删除");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String t_name=textField_4.getText();
				
				boolean flag=BM.deleteBook(t_name);
				if(flag)
				{
					JOptionPane.showMessageDialog(panel_4, " 删除成功","",JOptionPane.WARNING_MESSAGE);
					defaultTableModel_1.removeRow(0);
					table_1.validate();
				}
				if(!flag)
				{
					JOptionPane.showMessageDialog(panel_4, " 删除失败","",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnNewButton_7.setBounds(20, 179, 93, 23);
		panel_4.add(btnNewButton_7);
		
		JButton button_2 = new JButton("搜索");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 while(defaultTableModel_1.getRowCount()>0)
				 {
					 defaultTableModel_1.removeRow(defaultTableModel_1.getRowCount()-1);
				 }
				String t_name=textField_4.getText();
				String data[]=BM.search(t_name);
				if(data==null)
				{
					JOptionPane.showMessageDialog(panel_4, " 未找到","",JOptionPane.WARNING_MESSAGE);
				}
			    Object ob[] =data;
				defaultTableModel_1.addRow(ob);
			}
		});
		button_2.setBounds(261, 53, 60, 30);
		panel_4.add(button_2);
		
		JButton btnNewButton_2 = new JButton("修改");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
				int select=table_1.getSelectedRow();
				
				table_1.clearSelection();
				String old_target =textField_4.getText();
				Object[] value=new Object[4];
				for(int i=0;i<4;i++)
				{
					value[i] = defaultTableModel_1.getValueAt(select,i);
				}
				String jug_target=String.valueOf(value[0]);
				if(!old_target.equals(jug_target))
				{
					JOptionPane.showMessageDialog(panel_4, " 书籍名称不能修改","",JOptionPane.WARNING_MESSAGE);
					defaultTableModel_1.removeRow(0);	
				}
				String author=String.valueOf(value[1]);
				double price=Double.valueOf(String.valueOf(value[2]));
				String publisher=String.valueOf(value[3]);
				if(BM.modifyBook(old_target, author, price, publisher))
				{
					JOptionPane.showMessageDialog(panel_4, "修改成功","",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnNewButton_2.setBounds(142, 179, 93, 23);
		panel_4.add(btnNewButton_2);
		
		JLabel lblNewLabel_6 = new JLabel("\u4FEE\u6539\u4EE5\u540E\u8BB0\u5F97\u56DE\u8F66\u54DF");
		lblNewLabel_6.setFont(new Font("方正姚体", Font.PLAIN, 12));
		lblNewLabel_6.setBounds(142, 137, 115, 15);
		panel_4.add(lblNewLabel_6);
		
		JButton button_5 = new JButton("\u8FD4\u56DE\u83DC\u5355");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				panel_1.setVisible(true);
				panel_2.setVisible(false);
				panel_3.setVisible(false);
				panel_4.setVisible(false);
				panel_5.setVisible(false);
			
			}
		});
		button_5.setBounds(273, 179, 93, 23);
		panel_4.add(button_5);
		
		
		
		JLabel lblNewLabel_7 = new JLabel("\u65B0\u5BC6\u7801");
		lblNewLabel_7.setFont(new Font("楷体", Font.PLAIN, 13));
		lblNewLabel_7.setBounds(76, 64, 54, 15);
		panel_5.add(lblNewLabel_7);
		
		JLabel label_3 = new JLabel("\u4FEE\u6539\u5BC6\u7801");
		label_3.setBounds(156, 10, 64, 24);
		label_3.setFont(new Font("楷体", Font.PLAIN, 14));
		label_3.setEnabled(false);
		panel_5.add(label_3);
		
		textField_5 = new JTextField();
		textField_5.setBounds(140, 61, 104, 21);
		panel_5.add(textField_5);
		textField_5.setColumns(10);
		
		JButton button_3 = new JButton("\u786E\u8BA4");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String newPassword=textField_5.getText();
				BM.changePassword(newPassword);
			}
		});
		button_3.setBounds(140, 144, 93, 23);
		panel_5.add(button_3);
		
		JButton button_7 = new JButton("\u8FD4\u56DE\u83DC\u5355");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				panel_1.setVisible(true);
				panel_2.setVisible(false);
				panel_3.setVisible(false);
				panel_4.setVisible(false);
				panel_5.setVisible(false);
			}
		});
		button_7.setBounds(254, 191, 93, 23);
		panel_5.add(button_7);
		
		
		

	}
}
