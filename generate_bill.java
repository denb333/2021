package DetaiJava;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;

public class generate_bill extends JFrame implements ActionListener{
JLabel lbbill;
JTextArea tabill;
JTextField tfmeter;
JButton btgenerate,bttotal,btCancel;
Choice cmonth;
JPanel pbill,psorth;
Date timenow = new Date();
 generate_bill() {
	setSize(500,680);
	setLayout(new BorderLayout());
	pbill = new JPanel();
	psorth = new JPanel();
	lbbill = new JLabel("Generate Bill");
     
	cmonth = new Choice();
	 cmonth.add("January");
     cmonth.add("February");
     cmonth.add("March");
     cmonth.add("April");
     cmonth.add("May");
     cmonth.add("June");
     cmonth.add("July");
     cmonth.add("August");
     cmonth.add("September");
     cmonth.add("October");
     cmonth.add("November");
     cmonth.add("December");
	
     tabill = new JTextArea(50,15);
     JScrollPane jsp = new JScrollPane(tabill);
	tabill.setFont(new Font("Senserif",Font.ITALIC,18));
	
    ImageIcon icbill=new ImageIcon("images/icon1.jpg");
    Image ibill=icbill.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
    btgenerate = new JButton("Generate Bill", new ImageIcon(ibill));
    
    ImageIcon ictotal=new ImageIcon("images/icon9.png");
    Image itotal=ictotal.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
	bttotal = new JButton("       Total", new ImageIcon(ibill));
	
	ImageIcon icsignup=new ImageIcon("images/cancel.jpg");
    Image isignup=icsignup.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
    btCancel=new JButton("Cancel",new ImageIcon(isignup));
    
	btgenerate.setForeground(Color.blue);
    bttotal.setForeground(Color.blue);
    btCancel.setForeground(Color.blue);
    
	tfmeter = new JTextField(10);
	pbill.add(lbbill);
	pbill.add(tfmeter);
	pbill.add(cmonth);
	add(pbill, "North");
	add(jsp,"Center");
	
	psorth.add(btgenerate);
	psorth.add(bttotal);
	psorth.add(btCancel);
	
	add(psorth,BorderLayout.SOUTH);
	btgenerate.addActionListener(this);
	bttotal.addActionListener(this);
	btCancel.addActionListener(this);
	setLocation(350,30);
	
}
 public void actionPerformed(ActionEvent ae) {
	 ConnectDB5 conn = new ConnectDB5();
	 btgenerate.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String month = cmonth.getSelectedItem();
			 tabill.setText("\tReliance Power Limited\nELECTRICITY BILL FOR THE MONTH OF "+month+" ,2022\n"+"                       "+timenow+"\n\n");
			 ResultSet rs = conn.ListAccount("select * from empl where meter_number="+tfmeter.getText());
			 ResultSet rs1=conn.ListAccount("select *from bill where meter_number="+tfmeter.getText());
			try {
				while(rs.next()) {
					tabill.append("\n    Meter Number:              "+rs.getString("meter_number"));
				tabill.append("\n    Customer Name:           "+rs.getString("name"));
				tabill.append("\n    Grade :                         "+rs.getString("grade"));
				tabill.append("\n    Birthday:                       "+rs.getString("birthday"));
				tabill.append("\n    City:                             "+rs.getString("city"));
				tabill.append("\n    Email :                         "+rs.getString("email"));
				tabill.append("\n    Phone   :                      "+rs.getString("phone"));
				tabill.append("\n");
				tabill.append("\n-----------------------------------------");
				tabill.append("\n");
				tabill.append("\n");
				}
				if(rs1.next()) {
			    tabill.append("\n    Current Month :  \t"+rs1.getString("month"));
			    tabill.append("\n    Electric Number :\t"+rs1.getString("units_cosumed")+"    KW");
			    tabill.append("\n    Total Charges :\t"+rs1.getString("total_payable")+"    vnđ");
			    tabill.append("\n");
			    tabill.append("\n-----------------------------------------");
			    tabill.append("\n");
			    tabill.append("\n    TOTAL PAYABLE :\t"+rs1.getString("total_payable")+"  vnđ");
				}
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		 
	 });
	 bttotal.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String month = cmonth.getSelectedItem();
			 tabill.setText("\tReliance Power Limited\nELECTRICITY BILL FOR THE MONTH OF "+month+" ,2022\n"+ "                       "+timenow+"\n\n");
			 ResultSet rs2=conn.ListAccount("exec sp_total '"+month+"'");
			 try {
				while(rs2.next()) {
					tabill.append("\n    Month :             \t"+month+"\n\n");
					tabill.append("\n    Unit cosumed :      \t"+rs2.getString("Units_cosumed")+"   KW");
					tabill.append("\n    Total money :       \t"+rs2.getString("Total_payable")+"    vnđ");
					
				}
			} catch (Exception e2) {
				// TODO: handle exception
				e2.getStackTrace();
			}
		}
		 
	 });
	 btCancel.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			new New_customer().setVisible(true);
		}
		 
	 });
 }
 public static void main(String[] args) {
	new generate_bill().setVisible(true);
}
}
