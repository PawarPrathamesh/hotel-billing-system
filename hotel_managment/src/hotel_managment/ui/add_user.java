package hotel_managment.ui;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import hotel_managment.dal.add_user_getset;
import hotel_managment.dal.data_managment;

import javax.swing.*;

public class add_user extends JFrame {
	JTextField email_txt = new JTextField();
	JTextField lastname_txt = new JTextField();
	JTextField password_txt = new JTextField();
	JTextField add_txt = new JTextField();
	JTextField name_txt = new JTextField();
	JTextField phone_txt = new JTextField();
	JLabel result = new JLabel();
	data_managment user = new data_managment();
	JComboBox role_cmb = new JComboBox ();
	JComboBox gender_cmb = new JComboBox();
	
	
			
	public add_user() {
		
		setTitle("Add user");
		setBounds(500, 150, 600, 550);

		// lable
		JLabel name_lb = new JLabel("First Name:");
		// position
		name_lb.setBounds(100, 25, 100, 100);
		// msg1.setFont(new Font("Serif", Font.PLAIN, 14));

		// created text box
		
		// set position
		name_txt.setBounds(250, 68, 150, 20);

		// lable
		JLabel lastname_lb = new JLabel("Last Name:");
		// position
		lastname_lb.setBounds(100, 75, 100, 100);
		// msg1.setFont(new Font("Serif", Font.PLAIN, 14));

		// created text box
		
		// set position
		lastname_txt.setBounds(250, 115, 150, 20);

		// created lable
		JLabel email_lb = new JLabel("Email:");
		// position
		email_lb.setBounds(100, 115, 100, 100);

		// created text box
		
		// set position
		email_txt.setBounds(250, 155, 150, 20);

		// created lable
		JLabel password_lb = new JLabel("Password");
		// position
		password_lb.setBounds(100, 160, 100, 100);

		// created text box
		
		// set position
		password_txt.setBounds(250, 195, 150, 20);

		// created lable
		JLabel phone_lb = new JLabel("Phone No:");
		// position
		phone_lb.setBounds(100, 200, 100, 100);

		// created text box
		
		// set position
		phone_txt.setBounds(250, 240, 150, 20);

		// created lable
		JLabel add_lb = new JLabel("Address:");
		// position
		add_lb.setBounds(100, 255, 100, 100);

		// created text box
		
		// set position
		add_txt.setBounds(250, 275, 150, 50);

		// created lable
		JLabel gender_lb = new JLabel("Gender:");
		// position
		gender_lb.setBounds(100, 350, 100, 20);

		String[] gender = { "'Select'", "Male", "Female", "Other" };
	    gender_cmb = new JComboBox(gender);
		gender_cmb.setBounds(250, 350, 100, 20);

		JLabel role_lb = new JLabel("Role:");
		// position
		role_lb.setBounds(100, 390, 100, 20);

		
		ArrayList<String> role_list =user.getRole();
		
		String[] role = role_list.toArray(new String[role_list.size()]);
		
		role_cmb = new JComboBox(role);
		role_cmb.setBounds(250, 390, 100, 20);

		// created button
		JButton save_But = new JButton("Save");
		save_But.setBounds(250, 450, 75, 20);
		save_But.addActionListener(new ButtonClicklistner());

		JButton edit_But = new JButton("Edit");
		edit_But.setBounds(350, 450, 75, 20);
		
		
		result.setBounds(450, 450, 100, 25);

		add(name_lb);
		add(name_txt);
		add(lastname_lb);
		add(lastname_txt);
		add(email_lb);
		add(email_txt);
		add(password_lb);
		add(password_txt);
		add(phone_lb);
		add(phone_txt);
		add(add_lb);
		add(add_txt);
		add(gender_lb);
		add(gender_cmb);
		add(role_lb);
		add(role_cmb);
		add(save_But);
		add(edit_But);
		add(result);

		setLayout(null);
		setVisible(true);

	}

	private class ButtonClicklistner implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			String comman = e.getActionCommand();

			if (comman.equals("Save")) {
				
				String item=(String)role_cmb.getSelectedItem();
				int role_id = Integer.parseInt(item.split("-")[0]);
				
				add_user_getset a = new add_user_getset();
				
				
				a.setFirst_name(name_txt.getText());
				a.setLast_name(lastname_txt.getText());
				a.setEmail(email_txt.getText());
				a.setPassword(password_txt.getText());
				a.setPhone_no(phone_txt.getText());
				a.setAddress(add_txt.getText());
				a.setGender((String)gender_cmb.getSelectedItem());
				a.setRole(role_id);
				//dispose();
				// new menubar_page();
				if(user.addUser(a)) {
					result.setText("User inserted");
				}
				else {
					result.setText("User not inserted");
				}
			}
		}
	}
}
