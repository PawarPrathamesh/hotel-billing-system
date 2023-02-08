package hotel_managment.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import hotel_managment.dal.add_role_getset;
import hotel_managment.dal.add_user_getset;
import hotel_managment.dal.data_managment;

import javax.swing.*;
//import hotel_managment.ui.food_cat.ButtonClicklistner;

public class role extends JFrame {
	JTextField role_txt;
	JLabel result= new JLabel();
	public role() {
		setTitle("Add role");
		setBounds(500, 150, 400, 400);
		
		
		JLabel role_lb = new JLabel("Role:");
		// position
		role_lb.setBounds(100, 65, 100, 20);

	   result.setBounds(150, 150, 100, 20);
		
		role_txt = new JTextField();
		// set position
	    role_txt.setBounds(150,65 , 150, 20);


	    JButton save_but = new JButton("Save");
		save_but.setBounds(150, 100, 75, 20);
		save_but.addActionListener(new ButtonClicklistner());
		
		add(role_lb);
		add(role_txt);
		add(save_but);
	    add(result);
		setLayout(null);
		setVisible(true);;
	}
	private class ButtonClicklistner implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			
			String comman = e.getActionCommand();
			
			if(comman.equals("Save")){
				data_managment user = new data_managment();
				add_role_getset b = new add_role_getset();
				
			
				b.setRole_name(role_txt.getText());
				
				if(user.addrole(b)) {
					result.setText("Role inserted");
				}
				//dispose();
				//new menubar_page(); 
				
			else {
				result.setText("role not inserted");

			}
			}
		}
}
}
