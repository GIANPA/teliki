package org.teipir.softeng.teliki;

import javax.swing.*;

import java.awt.event.*;
import java.sql.*;



public class gui1  {

	Connection con;
	Statement st;
	ResultSet rs;
	
	JFrame f=new JFrame("diaxirisi");
	JLabel l=new JLabel("onoma parastasis:");
	JLabel l1=new JLabel("hmerominia:");
	JLabel l2=new JLabel("wra:");
	JTextField t=new JTextField(10);
	JTextField t1=new JTextField(10);
	JTextField t2=new JTextField(10);
	
	JButton b1=new JButton("Next");
	JButton b2=new JButton("Previous");
	JButton ud=new JButton("Update");
	JButton del=new JButton("Delete");
	JButton nr=new JButton("New");
	JButton save=new JButton("Save");
	
	
	
	public gui1(){
		connect();
		frame();
		btnAction();
		
	}
	 
	public void connect()
	{ 
		try
		{
			
		
		String driver="sun.jdbc.odbc.JdbcOdbcDriver";
		Class.forName(driver);
		
		String db="jdbc:odbc:diaxdb";
		con=DriverManager.getConnection(db);
		
		
		
		
		
		st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		String sql="select * from diaxdb";
		rs=st.executeQuery(sql);
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
		p.add(t1);
		p.add(l2);
		p.add(t2);
		p.add(b1);
		p.add(b2);
		p.add(ud);
		p.add(del);
		p.add(nr);
		p.add(save);
	
		f.add(p);
		
		 try{
		rs.next();
    	t.setText(rs.getString("on_parastasis"));
    	t1.setText(rs.getString("hmeromhnia"));
    	t2.setText(rs.getString("wra"));
		 }catch(Exception ex){
		    	
		    }
		
		
		
		
	}	
		public void btnAction()
		{
			b1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					try{
						
						if (rs.next()){
							
							t.setText(rs.getString("on_parastasis"));
							t1.setText(rs.getString("hmeromhnia"));
							t2.setText(rs.getString("wra"));
						}
						
						else
						{
							rs.previous();
							JOptionPane.showMessageDialog(null,"No more records");
							
							
						}
							
							
					}catch(Exception ex)
					{
						
					}
					
					
					
					
				}
			});
			
			
			b2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					try{
						
						if (rs.previous()){
							
							t.setText(rs.getString("on_parastasis"));
							t1.setText(rs.getString("hmeromhnia"));
							t2.setText(rs.getString("wra"));
						}
						
						else
						{
							rs.next();
							JOptionPane.showMessageDialog(null,"No more records");
							
							
						}
							
							
					}catch(Exception ex)
					{
						
					}
					
					
					
					
				}
			});
			
			ud.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					String l=t.getText();
					String l1=t1.getText();
					String l2=t2.getText();
					
					
					try{ 
						
						rs.updateString("on_parastasis",l);
						rs.updateString("hmeromhnia", l1);
						rs.updateString("wra",l2);
					    rs.updateRow();
					    
					    JOptionPane.showMessageDialog(null,"Record Updated");
						
					}catch(Exception ex)
						{	
					
					
					}
					
					
				}	
					
				
			});
			
			
			del.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					
					
					
					try{ 
						
						rs.deleteRow();
					    st.close();
					    rs.close();
					    st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
						String sql="select * from diaxdb";
						rs=st.executeQuery(sql);
						
						rs.next();
					    
						t.setText(rs.getString("on_parastasis"));
						t1.setText(rs.getString("hmeromhnia"));
						t2.setText(rs.getString("wra"));
					    
						JOptionPane.showMessageDialog(null,"Record Deleted");
						
					}catch(Exception ex)
						{	
					
					
					}
					
					
				}	
					
				
			});
			
			nr.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					t.setText(" ");
					t1.setText(" ");
					t2.setText(" ");
					
					
					
					
				}
			});
			
			save.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					
					String l=t.getText();
					String l1=t1.getText();
					String l2=t2.getText();
					
					try{
						
						rs.moveToInsertRow();
						rs.updateString("on_parastasis",l);
						rs.updateString("hmeromhnia", l1);
						rs.updateString("wra",l2);
					    rs.insertRow();
					    
					    st.close();
					    rs.close();
						
					    st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
						String sql="select * from diaxdb";
						rs=st.executeQuery(sql);
						
rs.next();
					    
						t.setText(rs.getString("on_parastasis"));
						t1.setText(rs.getString("hmeromhnia"));
						t2.setText(rs.getString("wra"));
						
						
						
					}catch(Exception ex)
					{
						
					}
				
					
					
					
					
				}
			});
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
		
		
		
		
		//b.addActionListener(new ActionListener(){
		//	public void actionPerformed(ActionEvent e)
			{
				//try
				//{
				//String on_parastasis = t.getText().trim();
				//String wra = t2.getText().trim();
				
				
				//String sql="select * from diaxdb"; //where user= '"+user+"'and pass= '"+pass+"'";
				//rs=st.executeQuery(sql);
				//}
				
				
			//catch (Exception ex)
			{
				
			}
			
				
			
		
		
		
	}
	public static void main(String[] args){
	
	
	new gui1();
	
	

	}
}