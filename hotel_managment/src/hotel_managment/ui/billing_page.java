package hotel_managment.ui;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import hotel_managment.dal.billing_getset;
import hotel_managment.dal.data_managment;
//import hotel_managment.ui.add_user.ButtonClicklistner;

//import hotel_managment.ui.order.ButtonClicklistner;

public class billing_page extends JFrame {

	JRadioButton cash;

	JRadioButton credit;

	JButton save_But;
	int order__id, total__;
	String date_time;
	ButtonGroup G1;
	String pay;
	JLabel payment_lb;
	JLabel card_no_lb;
	JLabel result = new JLabel();
	JLabel expiry_lb;
	JLabel name_lb;
	JLabel mobile_lb;
	JTextField card_no_txt;
	JTextField name_txt;
	JTextField mobile_txt;
	JTextField expiry_txt;
	data_managment user = new data_managment();

	public billing_page(int order_id, int fin_total) {
		setTitle("Billing");

		setBounds(500, 150, 600, 550);

		Date dt = new Date();
		SimpleDateFormat fr = new SimpleDateFormat("dd MMM,yyyy");
		String date_sys = fr.format(dt);
		JLabel date = new JLabel("Date:" + date_sys);

		date.setBounds(100, 25, 150, 100);
		date.setFont(new Font("Serif", Font.BOLD, 16));

		SimpleDateFormat tm = new SimpleDateFormat("hh:mm a");
		String time_sys = tm.format(dt);

		JLabel time = new JLabel("Time:" + time_sys);
		time.setBounds(250, 65, 150, 20);
		time.setFont(new Font("Serif", Font.BOLD, 16));

		date_time = date_sys + " " + time_sys;

		JLabel price = new JLabel("Total:Rs" + fin_total);
		price.setBounds(250, 400, 150, 20);
		price.setFont(new Font("Serif", Font.BOLD, 20));

		JLabel orderid = new JLabel("Order No:" + order_id);
		orderid.setBounds(450, 65, 150, 20);
		orderid.setFont(new Font("Serif", Font.BOLD, 20));
		order__id = order_id;
		total__ = fin_total;
		add(price);
		add(orderid);

//	cbg = new CheckboxGroup();
//  //  Label cash_lb = new Label("Cash:");
//    //Label card_lb = new Label("Creid Card");
//    Label payment_lb = new Label("Payment Method:");
//    payment_lb.setBounds(100,250, 70, 20);
//   
//    cash = new Checkbox("Cash:",cbg,false);
//    cash.setBounds(200,250, 70, 20);
//   
//    creid = new Checkbox("Creid Card",cbg,false);
//    creid.setBounds(275,250, 70, 20);
//     
//    add(date);
//	add(time);
//	add(payment_lb);
//	add(cash);
//	add(creid);
		// this.setLayout(null);

		save_But = new JButton("Save");
		save_But.setBounds(250, 450, 100, 20);
		save_But.addActionListener(new Buttonlistener());

		G1 = new ButtonGroup();

		payment_lb = new JLabel("Payment Method:");
		payment_lb.setBounds(100, 250, 100, 20);

		cash = new JRadioButton();
		cash.setText("Cash");
		cash.setBounds(225, 250, 70, 20);
		cash.addActionListener(new ButtonClicklistner());

		credit = new JRadioButton();
		credit.setText("Credit Card");
		credit.setBounds(300, 250, 100, 20);
		credit.setActionCommand(credit.getText());
		credit.addActionListener(new ButtonClicklistner());

		card_no_lb = new JLabel("Card No:");
		card_no_lb.setBounds(100, 300, 100, 20);
		card_no_lb.setVisible(false);

		expiry_lb = new JLabel("Expiry Date:");
		expiry_lb.setBounds(100, 350, 100, 20);
		expiry_lb.setVisible(false);

		card_no_txt = new JTextField();
		card_no_txt.setBounds(200, 300, 150, 20);
		card_no_txt.setVisible(false);

		expiry_txt = new JTextField();
		expiry_txt.setBounds(200, 350, 150, 20);
		expiry_txt.setVisible(false);

		name_txt = new JTextField();
		name_txt.setBounds(200, 120, 100, 20);

		mobile_txt = new JTextField();
		mobile_txt.setBounds(200, 170, 100, 20);

		name_lb = new JLabel("Name");
		name_lb.setBounds(100, 120, 100, 20);

		mobile_lb = new JLabel("Mobile No");
		mobile_lb.setBounds(100, 170, 100, 20);
		result.setBounds(100, 450, 150, 20);

		add(name_txt);
		add(mobile_txt);
		add(name_lb);
		add(mobile_lb);
		add(cash);

		add(credit);

		add(save_But);

		add(payment_lb);
		add(card_no_txt);
		add(expiry_txt);
		add(result);
		G1.add(cash);
		G1.add(credit);
		add(date);
		add(time);

		// ok_bt.addActionListener(new ButtonClicklistner());
		add(card_no_lb);
		add(expiry_lb);

		setLayout(null);
		setVisible(true);
	}

	private class ButtonClicklistner implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();

			if (command.equals("Credit Card")) {
				card_no_lb.setVisible(true);
				expiry_lb.setVisible(true);
				expiry_txt.setVisible(true);
				card_no_txt.setVisible(true);
				pay = "Credit Card";
//				if(command.equals("Save")) {
//					
//					billing_getset a = new billing_getset();
//					
//					a.setName(name_txt.getText());
//					int mobile_no= Integer.parseInt(mobile_txt.getText());
//					a.setMoblie(mobile_no);
//					
//					a.setOrder_id(order__id);
//					a.setDate_time(date_time);
//					a.setAmount(total__);
//					a.setPayment_type("Credit Card");
//					a.setCredit_card(card_no_txt.getText());
//					a.setExpiry_date(expiry_txt.getText());
//					
//					user.billing(a);
////					ButtonClicklistner c = new ButtonClicklistner();
////					c.savedata();

				// }
			} else if (command.equals("Cash")) {
				card_no_lb.setVisible(false);
				expiry_lb.setVisible(false);
				expiry_txt.setVisible(false);
				card_no_txt.setVisible(false);
				pay = "Cash";
				// if(command.equals("Save")) {
//				
//				billing_getset a = new billing_getset();
//				
////				a.setName(name_txt.getText());
////				int mobile_no= Integer.parseInt(mobile_txt.getText());
////				a.setMoblie(mobile_no);
//				
//				a.setOrder_id(order__id);
//				a.setDate_time(date_time);
//				a.setAmount(total__);
//				a.setPayment_type("Cash");
//				
//				user.billing(a);

			}

			// }

		}

	}

	private class Buttonlistener implements ActionListener {

		public void actionPerformed(ActionEvent b) {
			String comman = b.getActionCommand();

			if (comman.equals("Save")) {

				billing_getset a = new billing_getset();

				a.setName(name_txt.getText());
				int mobile_no = Integer.parseInt(mobile_txt.getText());
				a.setMoblie(mobile_no);

				a.setOrder_id(order__id);
				a.setDate_time(date_time);
				a.setAmount(total__);

				a.setPayment_type(pay);
				a.setCredit_card(card_no_txt.getText());
				a.setExpiry_date(expiry_txt.getText());

				user.billing(a);
				if(user.billing(a))
						{
					result.setText("Order Successfully Saved");
						}
				else
				{
					result.setText("Order Not Saved");
				}
			}
		}
	}

}
