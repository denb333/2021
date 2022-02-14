package DetaiJava;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import formfb.dangnhapfb;

import java.sql.*;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
public class New_customer extends JFrame implements ActionListener, MouseListener,KeyListener{
 JLabel lbsys,lbName,lbMeterNo,lbGrade,lbBirth,lbCity,lbEmail,lbPhone,lbIconAdd;
 JTextField tfName,tfMeterNo,tfBirth,tfCity,tfEmail,tfPhone;
 String[]grade= {"Male","Female","Orther"};
 JComboBox cbgrade = new JComboBox(grade);
 JButton btAdd,btDelete,btCancel,btselect,btsearch,btupdate,btBill;
 JTable tbem;
 DefaultTableModel model;
 JPanel p = new JPanel();
 New_customer(){
	 super("Add Customer");
	  this.setSize(850,700);
	  

	  p.setLayout(new GridLayout(7,3));
	  p.setBackground(Color.WHITE);
	  p.setForeground(Color.YELLOW);
	  p.setBackground(SystemColor.controlShadow);
	  
	  cbgrade.setForeground(Color.BLUE);

	  
	  lbName = new JLabel("Name", JLabel.CENTER);
      lbName.setFont(new Font("Tahoma",Font.BOLD,15));
	  tfName = new JTextField();
	  tfName.setForeground(Color.BLUE);
	  lbName.setForeground(Color.black);
	  btAdd = new JButton("Add");
//	  btAdd.setBounds(10,20,10,10);
      btAdd.setFont(new Font("Tahoma",Font.BOLD,15));
	  p.add(lbName);
	  p.add(tfName);
	  p.add(btAdd);
	  
	  lbMeterNo = new JLabel("Meter No",JLabel.CENTER);
      lbMeterNo.setFont(new Font("Tahoma",Font.BOLD,15));
	  tfMeterNo = new JTextField();
	  tfMeterNo.setForeground(Color.BLUE);
	  lbMeterNo.setForeground(Color.BLACK);
	  btDelete = new JButton("Delete");
	  p.add(lbMeterNo);
	  p.add(tfMeterNo);
	  p.add(btDelete);
	  
	  lbGrade = new JLabel("Grade", JLabel.CENTER);
      lbGrade.setFont(new Font("Tahoma",Font.BOLD,15));
	  lbGrade.setForeground(Color.BLACK);
	  btselect = new JButton("Select");
      p.add(lbGrade);
      p.add(cbgrade);
      p.add(btselect);
      
      lbBirth = new JLabel("Birthday", JLabel.CENTER);
      lbBirth.setFont(new Font("Tahoma",Font.BOLD,15));
      lbBirth.setForeground(Color.BLACK);
      tfBirth = new JTextField();
      tfBirth.setForeground(Color.BLUE);
	  btsearch = new JButton("Search");
      p.add(lbBirth);
      p.add(tfBirth);
      p.add(btsearch);
      
      lbCity = new JLabel("City",JLabel.CENTER);
      lbCity.setFont(new Font("Tahoma",Font.BOLD,15));
      lbCity.setForeground(Color.BLACK);
      tfCity = new JTextField();
      tfCity.setForeground(Color.BLUE);
	  btupdate = new JButton("Update");
      p.add(lbCity);
      p.add(tfCity);
      p.add(btupdate);
      
      lbEmail = new JLabel("Email",JLabel.CENTER);
      lbEmail.setFont(new Font("Tahoma",Font.BOLD,15));
      lbEmail.setForeground(Color.BLACK);
      tfEmail = new JTextField();
      tfEmail.setForeground(Color.BLUE);
      btBill =  new JButton("Bill");
      p.add(lbEmail);
      p.add(tfEmail);
      p.add(btBill);
      
      lbPhone = new JLabel("Phone Number",JLabel.CENTER);
      lbPhone.setFont(new Font("Tahoma",Font.BOLD,15));
      lbPhone.setForeground(Color.BLACK);
      tfPhone = new JTextField();
      tfPhone.setForeground(Color.BLUE);
	  btCancel = new JButton("Cancel");
      p.add(lbPhone);
      p.add(tfPhone);
      p.add(btCancel);
      
      lbsys=new JLabel("                                   ELECTRICITY BILL SYSTEM       "
      		+ "\n");
      lbsys.setFont(new Font("Senserif",Font.PLAIN,26));
      lbsys.setBackground(Color.BLACK);
      lbsys.setForeground(Color.BLUE);
      add(lbsys);
      
     
      btAdd.setBackground(Color.WHITE); 
      btAdd.setForeground(Color.RED);
      btAdd.setFont(new Font("Tahoma",Font.BOLD,15));
      btAdd.setBounds(800,830,50,30);
      
      btDelete.setBackground(Color.WHITE);
      btDelete.setForeground(Color.RED);
      btDelete.setFont(new Font("Tahoma",Font.BOLD,15));
      
      btselect.setBackground(Color.WHITE);
      btselect.setForeground(Color.RED);
      btselect.setFont(new Font("Tahoma",Font.BOLD,15));
      
      btCancel.setBackground(Color.PINK);
      btCancel.setForeground(Color.RED);
      btCancel.setFont(new Font("Tahoma",Font.BOLD,15));
      
      btBill.setBackground(Color.PINK);
      btBill.setForeground(Color.RED);
      btBill.setFont(new Font("Tahoma",Font.BOLD,15));
      
      btsearch.setBackground(Color.WHITE);
      btsearch.setForeground(Color.RED); 
      btsearch.setFont(new Font("Tahoma",Font.BOLD,15));
      
      btselect.setBackground(Color.WHITE);
      btselect.setForeground(Color.RED);
      btselect.setFont(new Font("Tahoma",Font.BOLD,15));
      
      btupdate.setBackground(Color.WHITE);
      btupdate.setForeground(Color.RED);
      btupdate.setFont(new Font("Tahoma",Font.BOLD,15));
      
      setLayout(new BorderLayout());
      add(p,BorderLayout.CENTER);
      add(lbsys,BorderLayout.NORTH);
      
      ImageIcon ic1 = new ImageIcon(("images/hicon1.jpg"));
      Image i3 = ic1.getImage().getScaledInstance(150, 280,Image.SCALE_DEFAULT);
      ImageIcon ic2 = new ImageIcon(i3);
      lbIconAdd = new JLabel(ic2);

      add(lbIconAdd,BorderLayout.WEST);
      
      
      getContentPane().setBackground(Color.WHITE);
      
//      setBackground(SystemColor.controlShadow);

      btAdd.addActionListener(this);
      btDelete.addActionListener(this);
      btsearch.addActionListener(this);
      btupdate.addActionListener(this);
      btBill.addActionListener(this);
      btselect.addActionListener(this);
      tfName.addKeyListener(this);
      btCancel.addActionListener(this);
      this.setLocationRelativeTo(null);
  	  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 }

@Override
 public void actionPerformed(ActionEvent e) {
	 // TODO Auto-generated method stub 
	 String name = tfName.getText();
	 String meter = tfMeterNo.getText();
	
	 String grade = (String) cbgrade.getSelectedItem();
	 String birth = tfBirth.getText();
	 String city = tfCity.getText();
	 String email = tfEmail.getText();
	 String phone= tfPhone.getText();
	 
	
	 btAdd.addActionListener(new ActionListener(){
		 public void actionPerformed( ActionEvent e) {
			 String sql = ("exec sp_add ?,?,?,?,?,?,?");
			 try {
//				 btAdd.addActionListener(this);
				ConnectDB5 conn = new ConnectDB5();
			  	Connection co = conn.connectSQL();
			  	PreparedStatement ps = co.prepareStatement(sql);
			  	ps.setString(1,tfMeterNo.getText());
			  	
				ps.setString(2,tfName.getText());
				ps.setString(3,(String) cbgrade.getSelectedItem().toString());
				ps.setString(4,tfBirth.getText());
				ps.setString(5,tfCity.getText());
				ps.setString(6,tfEmail.getText());
				ps.setString(7,tfPhone.getText());
			  	ps.executeUpdate();

			  

			  
				  ImageIcon icon = new ImageIcon("images/dautich1.jpg");
				  JOptionPane.showMessageDialog(null, icon, "Notify", JOptionPane.PLAIN_MESSAGE);
//				  Listemp();
//				  setVisible(true);
			  
			} catch (Exception e2) {
				// TODO: handle exception
				 e2.printStackTrace();
				 ImageIcon icon1 = new ImageIcon("images/fail1.png");
				 JOptionPane.showMessageDialog(null, icon1, "Notify", JOptionPane.PLAIN_MESSAGE);

			}
		 }
	 });
	 
	 

	btDelete.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			ConnectDB5 conn = new ConnectDB5();

			String query = " delete from empl where meter_number=?" ;
		  Connection	co = conn.connectSQL();
			try {
//				btDelete.addActionListener(this);
				PreparedStatement ps = co.prepareStatement(query);
				ps.setString(1,tfMeterNo.getText()) ;
			    ps.executeUpdate();
			    	  ImageIcon icon = new ImageIcon("images/dautich1.jpg");
			    	  JOptionPane.showMessageDialog(null, icon, "Notify", JOptionPane.PLAIN_MESSAGE);
			    	  Listemp();
			    	  setVisible(true);
				   
				
					
			} catch (Exception e2) {
				// TODO: handle exception
				e2.getStackTrace();
				 ImageIcon icon = new ImageIcon("images/fail1.png");
				 JOptionPane.showMessageDialog(null, icon, "Notify", JOptionPane.PLAIN_MESSAGE);
			
			}
		}
		
	}) ;

	 btsearch.addActionListener(new ActionListener(){
		 public void actionPerformed(ActionEvent e) {
			 String sql = "select *from empl where meter_number="+tfMeterNo.getText();
			 try {
				ConnectDB5 conn = new ConnectDB5();
				ResultSet rs=conn.ListAccount(sql);
				if(rs.next()) {
					tfName.setText(rs.getString("name"));
					tfMeterNo.setText(rs.getString("meter_number"));
					cbgrade.setToolTipText(rs.getString("grade"));
					tfBirth.setText(rs.getString("birthday"));
					tfCity.setText(rs.getString("city"));
					tfEmail.setText(rs.getString("email"));
					tfPhone.setText(rs.getString("phone"));
				}
			} catch (Exception e2) {
				// TODO: handle exception
				e2.getStackTrace();
			}
			
		 }
	 });
	 
//	 btupdate.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				try {
//					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//				String url = "jdbc:sqlserver://ADMIN\\SQLEXPRESS:1433;databaseName=TINH_TIEN_DIEN;user=sa;password=123456";
//				Connection con = DriverManager.getConnection(url);
//				int row = tbem.getSelectedRow();
//				String value = tbem.getModel().getValueAt(row, 1).toString();
//				String query = " UPDATE empl SET meter_number=?, name=?,grade=?,birthday=?,city=?,email=? ,phone=? where meter_number="+value ;
//				PreparedStatement pst = con.prepareStatement(query);
//				pst.setString(1,tfMeterNo.getText());
//				pst.setString(2,tfName.getText());
//				pst.setString(3,(String) cbgrade.getSelectedItem());
//				pst.setString(4,tfBirth.getText());
//				pst.setString(5,tfCity.getText());
//				pst.setString(6,tfEmail.getText());
//				pst.setString(7,tfPhone.getText());
//				int rec =pst.executeUpdate();
//				if(rec>0) {
//				
//				  ImageIcon icon = new ImageIcon("images/dautich1.jpg");
//			      JOptionPane.showMessageDialog(null, icon, "Notify", JOptionPane.PLAIN_MESSAGE);
//			      setVisible(false);
//			      
//			      DefaultTableModel model = (DefaultTableModel)tbem.getModel();
//			      model.setRowCount(0);
//			      Listemp();
//			      setVisible(true);
//				}else if(rec==0) {
//					setVisible(false);
//					ImageIcon icon = new ImageIcon("images/fail1.png");
//					 JOptionPane.showMessageDialog(null, icon, "Notify", JOptionPane.PLAIN_MESSAGE);
//				}
//					// TODO Auto-generated catch block
//				} catch (Exception e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//
//				}
//			}
//		});

	 
   btupdate.addActionListener(new ActionListener() {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		ConnectDB5 conn = new ConnectDB5();
		Connection co =conn.connectSQL();
		String query = " UPDATE empl SET  name=?,grade=?,birthday=?,city=?,email=? ,phone=? where meter_number=?";
		try {
			
			PreparedStatement ps = co.prepareStatement(query);
			ps.setString(1,tfName.getText());
			ps.setString(2,(String) cbgrade.getSelectedItem().toString());
			ps.setString(3,tfBirth.getText());
			ps.setString(4,tfCity.getText());
			ps.setString(5,tfEmail.getText());
			ps.setString(6,tfPhone.getText());
			ps.setString(7, tfMeterNo.getText());
			int rec = ps.executeUpdate();

			if(rec>0) {
				
				  ImageIcon icon = new ImageIcon("images/dautich1.jpg");
			      JOptionPane.showMessageDialog(null, icon, "Notify", JOptionPane.PLAIN_MESSAGE);
			      Listemp();
//			      setVisible(true);
//			      setVisible(true);
//			      setVisible(false);
			      
				}
			else  {
//					setVisible(false);
					ImageIcon icon = new ImageIcon("images/fail1.png");
					 JOptionPane.showMessageDialog(null, icon, "Notify", JOptionPane.PLAIN_MESSAGE);
				}
					
				

				
		} catch (Exception e2) {
			// TODO: handle exception
			e2.getStackTrace();
		}
	}
	 
   });
	 
	 
	 btBill.addActionListener(new ActionListener(){
		 public void actionPerformed(ActionEvent e) {
			 try {
				 setVisible(false);
				calculate_bill bill = new calculate_bill();
				bill.setVisible(true);
			} catch (Exception e2) {
				// TODO: handle exception
				e2.getStackTrace();
			}
		 }
	 });

	 btselect.addActionListener(new ActionListener(){
		 public void actionPerformed(ActionEvent e) {
			 try {
//				 btselect.addActionListener(this);
				 Listemp();
				setVisible(true);
				
				
                   tbem.getSelectionModel().addListSelectionListener((ListSelectionListener) new ListSelectionListener() {
					@Override
					public void valueChanged(ListSelectionEvent e) {
						// TODO Auto-generated method stub
						if(tbem.getSelectedRow()>=0) {
							tfName.setText(tbem.getValueAt(tbem.getSelectedRow(),0)+" ");
							tfMeterNo.setText(tbem.getValueAt(tbem.getSelectedRow(), 1)+" ");
							String jk = (String)tbem.getValueAt(tbem.getSelectedRow(), 2);
							cbgrade.setSelectedItem(jk);
							tfBirth.setText(tbem.getValueAt(tbem.getSelectedRow(), 3)+" ");
							tfCity.setText(tbem.getValueAt(tbem.getSelectedRow(), 4)+" ");
							tfEmail.setText(tbem.getValueAt(tbem.getSelectedRow(), 5)+" ");
							tfPhone.setText(tbem.getValueAt(tbem.getSelectedRow(), 6)+" ");
						}
					}
				});
				
			} catch (Exception e2) {
				// TODO: handle exception
				e2.getStackTrace();
			}
		 }
	 });
//     tbem.getSelectionModel().addListSelectionListener((ListSelectionListener) new ListSelectionListener() {
//					@Override
//					public void valueChanged(ListSelectionEvent e) {
//						// TODO Auto-generated method stub
//						if(tbem.getSelectedRow()>=0) {
//							tfName.setText(tbem.getValueAt(tbem.getSelectedRow(),0)+" ");
//							tfMeterNo.setText(tbem.getValueAt(tbem.getSelectedRow(), 1)+" ");
//							String jk = (String)tbem.getValueAt(tbem.getSelectedRow(), 2);
//							cbgrade.setSelectedItem(jk);
//							tfBirth.setText(tbem.getValueAt(tbem.getSelectedRow(), 3)+" ");
//							tfCity.setText(tbem.getValueAt(tbem.getSelectedRow(), 4)+" ");
//							tfEmail.setText(tbem.getValueAt(tbem.getSelectedRow(), 5)+" ");
//							tfPhone.setText(tbem.getValueAt(tbem.getSelectedRow(), 6)+" ");
//						}
//					}
//				});
	 btCancel.addActionListener(new ActionListener(){
		 public void actionPerformed(ActionEvent e) {
			 try {
				 btCancel.addActionListener(this);
				setVisible(false);

			} catch (Exception e2) {
				// TODO: handle exception
				e2.getStackTrace();
			}
		 }
	 });
	 
 }


 public void keyListener(KeyListener e) {
	 tfName.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				try {
					String name = tfName.getText();
					 searchbytable(name);

				} catch (Exception e2) {
					// TODO: handle exception
					e2.getStackTrace();
				}
			}
		});
}

	public void Listemp() {
		ConnectDB5 conn = new ConnectDB5();
		ResultSet rs = conn.ListAccount("select *from empl");
		String column[]= {"Name","Meter Number","Grade","Birthday","City","Email","Phone"};
		DefaultTableModel tm =new DefaultTableModel(column,0);
		try {
		while(rs.next()) {
			Object data[]= { rs.getString("name"),rs.getString("meter_number"),rs.getString("grade") ,rs.getString("birthday"),rs.getString("city"),rs.getString("email"),rs.getString("phone")};
			tm.addRow(data);
			tbem= new JTable(tm);
			JScrollPane sp  =new JScrollPane(tbem);
			keyListener(this);

			add(sp,BorderLayout.SOUTH);

         

		}
		btCancel.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e) {
				 try {
					 
					new New_customer().setVisible(true);
				} catch (Exception e2) {
					// TODO: handle exception
					e2.getStackTrace();
				}
			
			 }
		 });
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}
		 btCancel.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e) {
				 try {
					setVisible(false);
				} catch (Exception e2) {
					// TODO: handle exception
					e2.getStackTrace();
				}
			 }
		 });
	
	}
	 public void searchbytable(String str) {
			model=(DefaultTableModel) tbem.getModel();
			TableRowSorter<DefaultTableModel> ts = new TableRowSorter<>(model);
			tbem.setRowSorter(ts);
			ts.setRowFilter(RowFilter.regexFilter(str));

		}
 public static void main(String[] args) {
	 try {
			
//			UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
			
			new New_customer().setVisible(true);
		} catch (Exception ex) {
			ex.printStackTrace();
		}	

	// Look And Feel

}
@Override
public void mouseClicked(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mousePressed(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseReleased(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void keyPressed(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
}
