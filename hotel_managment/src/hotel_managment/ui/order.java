package hotel_managment.ui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import hotel_managment.dal.SearchMenu;
import hotel_managment.dal.add_ordergetset;
import hotel_managment.dal.data_managment;
import hotel_managment.dal.food_item_getset;
import hotel_managment.dal.searcch_getset;
//import hotel_managment.ui.add_user.ButtonClicklistner;

public class order extends JFrame {
	JTextField email_txt = new JTextField();
	JTextField lastname_txt = new JTextField();
	JTextField password_txt = new JTextField();
	JTextField add_txt = new JTextField();
	JLabel time_txt = new JLabel();
	JLabel date_txt = new JLabel();

	 
	
	JTextField search_txt;
	JLabel result = new JLabel();
	JLabel abc = new JLabel();
	JLabel total_lb = new JLabel("Total:");

	JComboBox waiter_cmb;
	JComboBox captain_cmb;
	JComboBox table_cmb;
	int gst=0,total = 0,fin_total=0,order_id=0;
	String date_sys;
	String time_sys;
	data_managment user = new data_managment();

	DefaultTableModel model;

	public order() {
		setTitle("Add order");
		setBounds(450, 50, 800, 800);
		setLayout(new BorderLayout());

		Date dt = new Date();
		SimpleDateFormat fr = new SimpleDateFormat("dd MMM,yyyy");
		date_sys = fr.format(dt);

		// Date dt =new Date();
		SimpleDateFormat tm = new SimpleDateFormat("hh:mm a");
		time_sys = tm.format(dt);

		// lable
		JLabel date_lb = new JLabel("Date:");
		// position
		date_lb.setBounds(150, 20, 100, 100);

		// created
		date_txt.setText(date_sys);
		// set position
		date_txt.setBounds(250, 60, 70, 20);

		JLabel time_lb = new JLabel("Time:");
		// position
		time_lb.setBounds(350, 20, 100, 100);
		time_txt.setText(time_sys);
		time_txt.setBounds(410, 60, 70, 20);

		ArrayList<String> waiter_list = user.getwaiter();

		String[] waiter = waiter_list.toArray(new String[waiter_list.size()]);

		waiter_cmb = new JComboBox(waiter);
		waiter_cmb.setBounds(250, 115, 150, 20);

		JLabel waiter_lb = new JLabel("Waiter:");
		// position
		waiter_lb.setBounds(150, 75, 100, 100);

		// created lable
		JLabel captain_lb = new JLabel("Captain:");
		// position
		captain_lb.setBounds(150, 115, 100, 100);

		ArrayList<String> captain_list = user.getcaptain();

		String[] captain = captain_list.toArray(new String[captain_list.size()]);

		captain_cmb = new JComboBox(captain);
		captain_cmb.setBounds(250, 155, 150, 20);

		// created lable
		JLabel table_lb = new JLabel("Table:");
		// position
		table_lb.setBounds(150, 160, 100, 100);

		ArrayList<String> table_list = user.gettable_info();

		String[] table = table_list.toArray(new String[table_list.size()]);

		table_cmb = new JComboBox(table);
		table_cmb.setBounds(250, 195, 150, 20);

		// created lable
		JLabel Search_lb = new JLabel("Search:");
		// position
		Search_lb.setBounds(150, 200, 100, 100);

		// set position
		search_txt = new JTextField();
		search_txt.setBounds(250, 240, 150, 20);
		result.setBounds(650, 240, 150, 25);
		result.setFont(new Font("Serif", Font.PLAIN, 14));

		total_lb.setBounds(600, 240, 150, 25);
		// created button
		JButton save_But = new JButton("Save");
		save_But.setBounds(500, 240, 75, 20);
		save_But.addActionListener(new ButtonClicklistner());

		JButton search_But = new JButton("Search");
		search_But.setBounds(410, 240, 75, 20);
		search_But.addActionListener(new ButtonClicklistner());

		JPanel endPanel = new JPanel();

		endPanel.setSize(150, 150);

		Object[] columnNames = { "Id", "Name", "Price" };

		orderMgmt order = new orderMgmt();

		// ArrayList<FoodModel> data = order.GetMenuData();

		model = new DefaultTableModel(columnNames, 0);
		JTable table1 = new JTable(model);
		table1.setLocation(100, 100);
//		for (FoodModel m : data) {
//			Object[] objs = { m.getId(), m.getName(), m.getPrice(), false };
//			model.addRow(objs);
//		}

		// table.setPreferredScrollableViewportSize(table.getPreferredSize());

		JScrollPane scrollPane = new JScrollPane(table1);
		table1.setSize(this.getWidth(), this.getHeight() - 100);
		endPanel.add(scrollPane);
		add(date_lb);
		add(date_txt);

		add(time_lb);
		add(time_txt);

		add(waiter_cmb);

		add(waiter_lb);
		add(captain_lb);
		add(captain_cmb);
		add(table_lb);
		add(table_cmb);

		add(Search_lb);
		add(search_txt);

		add(save_But);
		add(search_But);
		add(total_lb);
		add(result);
		add(abc);
		getContentPane().add(endPanel, BorderLayout.SOUTH);
		setLocationRelativeTo(null);

		// setLayout(null);
		setVisible(true);

	}

	private class ButtonClicklistner implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			// TODO Auto-generated method stub

			String comman = e.getActionCommand();

			if (comman.equals("Search")) {
				// String food = search_txt.getText();
				// food = food + "%";

				SearchMenu mObj = new SearchMenu(search_txt.getText());

				ArrayList<FoodModel> items = mObj.GetSelectedItem();

				for (FoodModel m : items) {
					Object[] objs = { m.getId(), m.getName(), m.getPrice(), false };
					model.addRow(objs);
					
					//gst=(total*(18/100));
					total = (int) (total+ m.getPrice());
					gst=(total*18/(100));
					
				}
                fin_total= total+gst; 
				String total_st = Integer.toString(fin_total);
				result.setText("Rs." + total_st);

				add(abc);

			} else if (comman.equals("Save")) {

				// String waiter = (String) waiter_cmb.getSelectedItem();
				int waiter_id = 17;// Integer.parseInt(waiter.split(" ")[0]);

				// String captain = (String) captain_cmb.getSelectedItem();
				int captain_id = 15;// Integer.parseInt(waiter.split(" ")[0]);

				String table = (String) table_cmb.getSelectedItem();
				table = (table.split(":")[1]);
				table = (table.split("--")[0]);
				int table_id = Integer.parseInt(table);
				add_ordergetset a = new add_ordergetset();
			
				a.setDate_sys(date_sys);
				a.setTime_sys(time_sys);
				a.setWaiter_id(waiter_id);
				a.setCaptain_id(captain_id);
				a.setTable_id(table_id);
				user.addorder(a);
				 order_id = a.getOrder_Id();
				for(int i=0;i<model.getRowCount();i++)
				{
					int food_id = (int) model.getValueAt(i,0);
					user.add_ordered_data(order_id,food_id);
				}
					dispose();
				new	billing_page(order_id, fin_total);
//					if (user.addorder(a)) {
//					total_lb.setText("Info saved");
//
//				}
			}
		}

	}
}
