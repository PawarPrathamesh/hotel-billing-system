package hotel_managment.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import hotel_managment.dal.add_table_getset;
import hotel_managment.dal.add_user_getset;
import hotel_managment.dal.data_managment;

public class add_table extends JFrame {

	JTextField Seats_txt = new JTextField();
	JTextField Table_no_txt = new JTextField();

	JTextField name_txt = new JTextField();

	JLabel result = new JLabel();
	data_managment user = new data_managment();

	public add_table() {

		setTitle("Add Table");
		setBounds(500, 150, 600, 450);

		// lable
		JLabel name_lb = new JLabel("Table type:");
		// position
		name_lb.setBounds(100, 25, 100, 100);

		// set position
		name_txt.setBounds(250, 68, 150, 20);

		// lable
		JLabel Table_nolb = new JLabel("Table no.:");
		// position
		Table_nolb.setBounds(100, 75, 100, 100);

		// set position
		Table_no_txt.setBounds(250, 115, 150, 20);

		// created lable
		JLabel Seats_lb = new JLabel("Seats:");
		// position
		Seats_lb.setBounds(100, 115, 100, 100);

		// set position
		Seats_txt.setBounds(250, 155, 150, 20);

		// created button
		JButton save_But = new JButton("Save");
		save_But.setBounds(250, 250, 75, 20);
		save_But.addActionListener(new ButtonClicklistner());

		result.setBounds(250, 300, 100, 25);

		add(name_lb);
		add(name_txt);
		add(Table_nolb);
		add(Table_no_txt);
		add(Seats_lb);
		add(Seats_txt);

		add(save_But);

		add(result);

		setLayout(null);
		setVisible(true);

	}

	private class ButtonClicklistner implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			String comman = e.getActionCommand();

			if (comman.equals("Save")) {

				add_table_getset a = new add_table_getset();

				a.setTable_type(name_txt.getText());

				String table_no = Table_no_txt.getText();
				int table_no_int = Integer.parseInt(table_no);

				a.setTable_no(table_no_int);

				String seat = Seats_txt.getText();
				int seat_int = Integer.parseInt(seat);

				a.setSeats(seat_int);

				if (user.add_tables(a)) {
					result.setText("Table inserted");
				} else {
					result.setText("Table not inserted");
				}
			}
		}
	}
}
