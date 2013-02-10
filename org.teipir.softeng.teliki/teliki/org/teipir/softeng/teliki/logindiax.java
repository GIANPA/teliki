package org.teipir.softeng.teliki;


import javax.swing.*;

import java.awt.event.*;
import java.sql.*;


public class logindiax   {

	Connection con;
	Statement st;
	ResultSet rs;
	
	JFrame f=new JFrame("manager login");
	JLabel l=new JLabel("username:");
	JLabel l1=new JLabel("password:");
	JTextField t=new JTextField(10);
	//JTextField t1=new JTextField(10);
	JPasswordField t2 = new JPasswordField(10);
	JButton b=new JButton("Login");
	
	
	
	public logindiax(){
		connect();
		frame();
		
	}
	 
	public void connect()
	{
		try
		{
			
		
		String driver="sun.jdbc.odbc.JdbcOdbcDriver";
		Class.forName(driver);
		
		String db="jdbc:odbc:logindiaxdb";
		con=DriverManager.getConnection(db);
		st=con.createStatement(); //<--kanoniko
		//gia navigation buttons video 4 gia na kanoume scroll sthn database
		//st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
	}
		
		catch(Exception ex)
		{
		}
	}
	public void frame()
	{
		f.setSize(600,400);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.setVisible(true);
		
		JPanel p=new JPanel();
		p.add(l);
		p.add(t);
		p.add(l1);
		p.add(t2);
		p.add(b);
		
		
		f.add(p);
		
		
		b.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				try
				{
				String user = t.getText().trim();
				String pass = t2.getText().trim();
				
			
				String sql="select user,pass from logindiaxdb where user= '"+user+"'and pass= '"+pass+"'";
				rs=st.executeQuery(sql);
				
				int count=0;
				while(rs.next())
				{
				count=count + 1;
				}
					
				if(count==1){
					
					JOptionPane.showMessageDialog(null,"User Found, Access Granted!");
					
					
					e.getSource();
					gui1 gui = new gui1();
					
				

				}
			
				
				else 
				{
					JOptionPane.showMessageDialog(null,"User not Found");
				}
				
				}
				catch (Exception ex)
				{
			}
			}
		});
		
		
	}
	public static void main(String[] args){
	
	
	new logindiax();
	
	

	}
}
