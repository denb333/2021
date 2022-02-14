package DetaiJava;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class calculate_bill extends JFrame implements ActionListener
{
    JLabel lbCEB,lbMeterNo,lbMonth,lbicon,lbUnitsCosumed;
    JTextField tfInit,tfMeter;
    Choice cMonth;
    JButton btSubmit,btCancel;
    JPanel p;
    calculate_bill(){

        p = new JPanel();
        p.setLayout(new GridLayout(4,2,30,30));
        p.setBackground(Color.WHITE);

        lbCEB = new JLabel("Calculate Electricity Bill");
        lbMeterNo = new JLabel("Meter No");
        lbUnitsCosumed = new JLabel("Electric number");
        lbMonth= new JLabel("Month");
        tfMeter=new JTextField();
        tfInit = new JTextField();

        

        cMonth = new Choice();
        cMonth.add("January");
        cMonth.add("February");
        cMonth.add("March");
        cMonth.add("April");
        cMonth.add("May");
        cMonth.add("June");
        cMonth.add("July");
        cMonth.add("August");
        cMonth.add("September");
        cMonth.add("October");
        cMonth.add("November");
        cMonth.add("December");

        btSubmit = new JButton("Submit");
        btCancel = new JButton("Cancel");

        btSubmit.setBackground(Color.BLACK);
        btSubmit.setForeground(Color.WHITE);

        btCancel.setBackground(Color.BLACK);
        btCancel.setForeground(Color.WHITE);

        ImageIcon i1 = new ImageIcon(("images/hicon2.jpg"));
        Image i2 = i1.getImage().getScaledInstance(180, 270,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        lbicon = new JLabel(i3);



        lbCEB.setFont(new Font("Senserif",Font.PLAIN,26));
        //Move the label to center
        lbCEB.setHorizontalAlignment(JLabel.CENTER);



        p.add(lbMeterNo);
        p.add(tfMeter);
        p.add(lbMonth);
        p.add(cMonth);
        p.add(lbUnitsCosumed);
        p.add(tfInit);
        p.add(btSubmit);
        p.add(btCancel);

        setLayout(new BorderLayout(30,30));

        add(lbCEB,"North");
        add(p,"Center");
        add(lbicon,"West");


        btSubmit.addActionListener(this);
        btCancel.addActionListener(this);

        getContentPane().setBackground(Color.WHITE);
        setSize(650,500);
        setLocation(300,150);
    }
   public void actionPerformed(ActionEvent e) {
	   String a= tfMeter.getText();
	   String b=cMonth.getSelectedItem();
	   String c = tfInit.getText();
	   int p1 = Integer.parseInt(c);
	   int p2=p1*1200;
	   int p3 = p2+(p2*10/100);
	   
	btSubmit.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			     setVisible(false);
			   String record = "insert into bill values('"+a+"','"+b+"','"+c+"','"+p3+"')";
				  try {
					  ConnectDB5 conn = new ConnectDB5();
					 int rec =  conn.excuteDB(record);
					 if(rec>0) {
					   JOptionPane.showMessageDialog(null,"Dữ liệu hóa đơn đã được lưu trên thiết bị!");
					   generate_bill bill = new  generate_bill();
					   bill.setVisible(true);
					 }else {
						 JOptionPane.showMessageDialog(null,"Vui lòng nhập đúng dữ liệu!");
						new calculate_bill().setVisible(true);
					 }
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
		}

		
		
	});
	btCancel.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			  try {
					new New_customer().setVisible(true);
				} catch (Exception e2) {
					// TODO: handle exception
					e2.getStackTrace();
				}
		}
	});
   }


    public static void main(String[] args){
        new calculate_bill().setVisible(true);
    }
}
