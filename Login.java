package DetaiJava;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class Login extends JFrame implements ActionListener{
	    JFrame f;
        JLabel lbUserName,lbPass,lbicon;
        JTextField tfUser ;
        JPasswordField pfPass;
        JButton btLogin,btsignup,btCancel;
        JPanel pn1,pn2,pn3,pn4;
        public Login(){
        	
//        	f = new JFrame("Login Page");
        	super("Login");
        	lbUserName = new JLabel("User Name");
        	lbPass = new JLabel("PassWord");
        	tfUser = new JTextField(15);
        	pfPass = new JPasswordField(15);
        	ImageIcon ic1=new ImageIcon("images/login.jpg");
            Image i1=ic1.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
            btLogin=new JButton("Login",new ImageIcon(i1));
            
            ImageIcon icsignup=new ImageIcon("images/cancel.jpg");
            Image i4=icsignup.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
            btCancel=new JButton("Cancel",new ImageIcon(i4));
            
            ImageIcon ic2=new ImageIcon("images/icon12.png");
            Image i2=ic2.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
            btsignup=new JButton("Sign Up",new ImageIcon(i2));
            
//            btLogin.addActionListener(this);
//            btCancel.addActionListener(this);
//            
            ImageIcon ic3=new ImageIcon("images/hinh1.jpg");
            Image i3=ic3.getImage().getScaledInstance(340,370,Image.SCALE_DEFAULT);
            ImageIcon icc3=new ImageIcon(i3);
            
            lbicon = new JLabel(icc3);
            
            setLayout(new BorderLayout());
//            pn1 = new JPanel();
            pn2 = new JPanel();
//            pn3 = new JPanel();
            pn4 = new JPanel();
            add(lbicon,BorderLayout.WEST);
            
            pn2.add(lbUserName);
            pn2.add(tfUser);
            pn2.add(lbPass);
            pn2.add(pfPass);
            add(pn2, BorderLayout.CENTER);
            
            pn4.add(btLogin);
            pn4.add(btsignup);
            pn4.add(btCancel);
            add(pn4,BorderLayout.SOUTH);
            
            pn2.setBackground(Color.WHITE);
            pn4.setBackground(Color.WHITE);
            
            btLogin.addActionListener(this);
            btCancel.addActionListener(this);
            btsignup.addActionListener(this);

//            pack();
            this.setSize(650,450);
//            this.setLocation(400,250);
            this.setLocationRelativeTo(null);
            this.setVisible(true);
        	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        @Override
        public void actionPerformed(ActionEvent e) {
        	// TODO Auto-generated method stub
       btLogin.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			ConnectDB5 conn = new ConnectDB5();
           try {
        	   String user = tfUser.getText();
        	   String pass = pfPass.getText();
        	   String sql ="select * from Customer where UserName = '"+user+"' and PassWord='"+pass+"'";
        	   ResultSet rs = conn.ListAccount(sql);
			if(rs.next()) {
				 setVisible(false);
				New_customer cuss = new New_customer();
				cuss.setVisible(true);
			}else {
				 JOptionPane.showMessageDialog(null, "Nhập sai rồi\n Nhập lại đi");
				 
	             setVisible(true);
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
			setVisible(false);
		}
    	   
       });
       btsignup.addActionListener(new ActionListener() {

   		@Override
   		public void actionPerformed(ActionEvent e) {
   			// TODO Auto-generated method stub
   			new Sign_Up().setVisible(true);
   		}
       	   
          });
        }
        public static void main(String[] args) {
        	 new Login().setVisible(true);
		}
	
	
}
