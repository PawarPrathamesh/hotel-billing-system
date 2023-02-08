package hotel_managment.ui;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class logout_page extends JFrame {
	logout_page() {
		setTitle("Logout");
		setBounds(700, 200, 250, 200);
		JLabel logout_lb = new JLabel("***Logout sucessfully***");
		logout_lb.setBounds(50, 25, 200, 40);

		add(logout_lb);
		setLayout(null);
		setVisible(true);

	}

}
