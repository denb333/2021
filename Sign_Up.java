package DetaiJava;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class Sign_Up extends JFrame implements ActionListener{
  JLabel lbSignUp,lbUser,lbPass, lbgrade,lbemail,lbicon;
  JTextField tfUser,tfemail;
  JPasswordField pfPass;
  String[] s= {"Male","Female","Orther"};
  JComboBox cbgrade=new JComboBox(s);
  JButton btSignUp,btCancel;
  JPanel p,pbt;
  Sign_Up(){
	  p = new JPanel();
	  pbt = new JPanel();
	  p.setLayout(new GridLayout(5,2,30,30));
	  p.setBackground(Color.WHITE);
	  
	  pbt.setLayout(new GridLayout(1,2,30,30));
	  pbt.setBackground(Color.WHITE);
	  lbSignUp=new JLabel("Sign Up");
	  lbUser=new JLabel("UserName");
	  lbPass=new JLabel("Pass");
	  lbgrade=new JLabel("Grade");
	  lbemail=new JLabel("Email");
	  
	  tfUser=new JTextField();
	  tfemail=new JTextField();
	  pfPass=new JPasswordField();
	  
	  btSignUp=new JButton("Sign Up");
	  btCancel = new JButton("Cancel");
	  
	  btSignUp.setBackground(Color.BLACK);
      btSignUp.setForeground(Color.WHITE);
      
      btCancel.setBackground(Color.BLACK);
      btCancel.setForeground(Color.WHITE);
      
      ImageIcon i1 = new ImageIcon(("images/signup1.jpg"));
      Image i2 = i1.getImage().getScaledInstance(180, 270,Image.SCALE_DEFAULT);
      ImageIcon i3 = new ImageIcon(i2);
      lbicon = new JLabel(i3);
      
      lbSignUp.setFont(new Font("Senserif",Font.PLAIN,26));
      lbSignUp.setHorizontalAlignment(JLabel.CENTER);
      
      p.add(lbUser);
      p.add(tfUser);
      p.add(lbPass);
      p.add(pfPass);
      p.add(lbgrade);
      p.add(cbgrade);
      p.add(lbemail);
      p.add(tfemail);
      
      
      ImageIcon icsignup=new ImageIcon("images/cancel.jpg");
      Image i4=icsignup.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
      btCancel=new JButton("Cancel",new ImageIcon(i4));
      
      ImageIcon ic2=new ImageIcon("images/icon4.png");
      Image icc=ic2.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
      btSignUp=new JButton("Sign Up",new ImageIcon(icc));
      
      pbt.add(btSignUp);
      pbt.add(btCancel);
      
      
      setLayout(new BorderLayout(30,30));
      
      add(lbSignUp,"North");
      add(p,"Center");
      add(lbicon,"West");
      add(pbt,"South");
      getContentPane().setBackground(Color.WHITE);
      setSize(650,500);
      setLocation(300,150);
      btSignUp.addActionListener(this);
      btCancel.addActionListener(this);
  }
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	btSignUp.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String sql = ("exec sp_addctm1 ?,?,?,?");
			try {
				ConnectDB5 conn = new ConnectDB5();
				Connection co = conn.connectSQL();
				PreparedStatement ps = co.prepareStatement(sql);
				ps.setString(1,tfUser.getText());
				ps.setString(2,tfUser.getText());
				ps.setString(3,(String)cbgrade.getSelectedItem().toString());
				ps.setString(4,tfemail.getText());
				ps.executeUpdate();

				  ImageIcon icon = new ImageIcon("images/dautich1.jpg");
				  JOptionPane.showMessageDialog(null, icon, "Notify", JOptionPane.PLAIN_MESSAGE);
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
				 ImageIcon icon1 = new ImageIcon("images/fail1.png");
				 JOptionPane.showMessageDialog(null, icon1, "Notify", JOptionPane.PLAIN_MESSAGE);
			}
		}
		
	});
	btCancel.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			setVisible(false);
			new Login().setVisible(true);
		}
		
	});
}
 public static void main(String[] args) {
	new Sign_Up().setVisible(true);
}  
}
