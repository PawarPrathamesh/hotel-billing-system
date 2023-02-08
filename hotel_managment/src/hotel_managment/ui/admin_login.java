package hotel_managment.ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import hotel_managment.dal.data_managment;

public class admin_login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JTextField id = new JTextField();
	JPasswordField pass = new JPasswordField();

	JLabel buttonmsg = new JLabel();

	public admin_login() {

		setBounds(500, 150, 500, 500);
		setTitle("Admin login");

		// lable
		JLabel user_lb = new JLabel("User Email:");
		// position
		user_lb.setBounds(50, 50, 100, 100);
		// msg1.setFont(new Font("Serif", Font.PLAIN, 14));

		// lable
		JLabel pass_lb = new JLabel("Password:");
		// position
		pass_lb.setBounds(50, 100, 65, 100);
		// msg2.setFont(new Font("Serif", Font.PLAIN, 14));

		// created text box
		// set position
		id.setBounds(150, 95, 150, 20);

		// created text box

		// set position
		pass.setBounds(150, 145, 150, 20);

		// button created
		JButton loginButton = new JButton("login");
		// JButton forgetButton = new JButton("Forget Password");

		// button set
		loginButton.setBounds(150, 180, 65, 20);
		// forgetButton.setBounds(225, 180, 150, 20);

		loginButton.addActionListener(new ButtonClicklistner());
		// forgetButton.addActionListener(new ButtonClicklistner());

		buttonmsg.setBounds(150, 250, 200, 20);

		// add(forgetButton);
		add(loginButton);
		add(user_lb);
		add(pass_lb);
		add(id);
		add(pass);
		add(buttonmsg);

		// layout set
		setLayout(null);

		// visibility
		setVisible(true);

	}

	private class ButtonClicklistner implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			// TODO Auto-generated method stub

			String comman = e.getActionCommand();

			if (comman.equals("login")) {

				data_managment user = new data_managment();
				boolean validuser = user.login(id.getText(), pass.getText());
				if (validuser) {
					dispose();
					new menubar_page();
				} else {
					buttonmsg.setText("Please Enter correct Password");

				}

			}

		}
	}
}
