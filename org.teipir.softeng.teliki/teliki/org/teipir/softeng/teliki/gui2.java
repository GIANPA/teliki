package org.teipir.softeng.teliki;

import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
public class gui2  {

	Connection con;
	Statement st;
	ResultSet rs;
	
	JFrame f=new JFrame("forma ektypwshs");
	JLabel l=new JLabel("onoma parastasis:");
	JLabel l1=new JLabel("hmerominia:");
	JLabel l2=new JLabel("wra:");
	JTextField t=new JTextField(10);
	JTextField t1=new JTextField(10);
	JTextField t2=new JTextField(10);
	
	JButton b1=new JButton("Next");
	JButton b2=new JButton("Previous");
	JLabel l3=new JLabel("discount");
	JLabel l4=new JLabel("theseis");
	
	JLabel l5=new JLabel("");
	
	
	

	String[] items1={"1","2","3","4","5","6","7","8","9","10"};
	String[] items={"Kanoniko","Anergos","Foititis","Anilikos"};
	
	
	
	JComboBox c1=new JComboBox(items1);
	JComboBox c=new JComboBox(items);
	
	
	
	
	JButton prt=new JButton("Print");
	
	
	
	
	public gui2(){
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
		
		p.add(l4);
		p.add(c1);
		
		p.add(l3);
		p.add(c);
		p.add(prt);
	    p.add(l5);
		
		
	    f.add(p);
	    
	    prt.addActionListener(new ActionListener(){
	    	
	    	public void actionPerformed(ActionEvent e){
	    		
	    		String s=c.getSelectedItem().toString();
	    		String s1=c1.getSelectedItem().toString();
	    		
	    		
	    		try {
					

JOptionPane.showMessageDialog(null," Θέση: "+s1+"  Είδος έκπτωσης: "+s+ "  Όνομα παράστασης: "+rs.getString("on_parastasis")+"  Ημερομηνία: "+rs.getString("hmeromhnia")+"  Ώρα: "+rs.getString("wra")+"  Τελική τιμή:"+30+"");
				
					
					
				} catch (SQLException e1) {
					
					
				}
	    		
	    		
	    	}
	    }
	    );
	    
	    try{
	    	rs.next();
	    	t.setText(rs.getString("on_parastasis"));
	    	t1.setText(rs.getString("hmeromhnia"));
	    	t2.setText(rs.getString("wra"));
	    	
	    	
	    	String s=c.getSelectedItem().toString();
    		String s1=c1.getSelectedItem().toString();
			JOptionPane.showMessageDialog(null," Θέση: "+s1+"  Είδος έκπτωσης: "+s+ "  Όνομα παράστασης: "+rs.getString("on_parastasis")+"  Ημερομηνία: "+rs.getString("hmeromhnia")+"  Ώρα: "+rs.getString("wra")+"  Τελική τιμή:"+30+"");
	    	
	    }catch(Exception ex){
	    	
	    }
	    
	    
	    
	    
	}
		
	    public void btnAction()
		{
			b1.addActionListener(new ActionListener(){
				public void 

actionPerformed(ActionEvent e)
				{
					try{
						
						if (rs.next()){
							
							

t.setText(rs.getString("on_parastasis"));
							

t1.setText(rs.getString("hmeromhnia"));
							

t2.setText(rs.getString("wra"));
							
							
							

String s=c.getSelectedItem().toString();
				    		String 

s1=c1.getSelectedItem().toString();
							

JOptionPane.showMessageDialog(null," Θέση: "+s1+"  Είδος έκπτωσης: "+s+ "  Όνομα παράστασης: "+rs.getString("on_parastasis")+"  Ημερομηνία: "+rs.getString("hmeromhnia")+"  Ώρα: "+rs.getString("wra")+"  Τελική τιμή:"+30+"");
							
							
							
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
				public void 

actionPerformed(ActionEvent e)
				{
					try{
						
						if 

(rs.previous()){
							
							

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
			
			
			
		
		
			
		
		
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
			public static void main(String[] args){
				
				
				new gui2();
				
				

				}
			}