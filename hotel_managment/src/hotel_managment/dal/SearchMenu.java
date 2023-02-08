package hotel_managment.dal;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import hotel_managment.ui.FoodModel;
import hotel_managment.ui.orderMgmt;

public class SearchMenu extends JDialog {

	private JTable table;
	DefaultTableModel model;
	ArrayList<FoodModel> select_data = new ArrayList();

	public SearchMenu(String searchword) {
		setLayout(new BorderLayout());
		setModal(true);

		JPanel topPanel = new JPanel();
		JPanel bottomPanel = new JPanel();

		setTitle("Search Menu");
		Object[] col = { "ID", "Name", "Price", "Action" };

		orderMgmt order = new orderMgmt();

		ArrayList<FoodModel> data = order.GetMenuData(searchword);

		model = new DefaultTableModel(col, 0);
	
	//	TableColumnModel columnModel = table.getColumnModel();
	//	columnModel.getColumn(0).setPreferredWidth(50);
		 table = new JTable(model) {
			
			private static final long serialVersionUID = 1L;

			@Override
			public Class getColumnClass(int column) {
				switch (column) {
				case 0:
					return Long.class;
				case 1:
					return String.class;
				case 2:
					return Double.class;
				default:
					return Boolean.class;
				}
			}
		};

		for (FoodModel m : data) {
			Object[] objs = { m.getId(), m.getName(), m.getPrice(), false };
			model.addRow(objs);
		}
	
		table.setPreferredScrollableViewportSize(table.getPreferredSize());
		JScrollPane scrollPane = new JScrollPane(table);
		topPanel.add(scrollPane);

		JButton ok_but = new JButton("OK");
		ok_but.setBounds(100, 100, 60, 10);
		ok_but.addActionListener(new buttonClick());
		bottomPanel.add(ok_but);
		bottomPanel.setSize(50, 50);
		getContentPane().add(topPanel, BorderLayout.CENTER);
		getContentPane().add(bottomPanel, BorderLayout.SOUTH);

		setSize(500, 500);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);

	}

	private class buttonClick implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			for (int i = 0; i < model.getRowCount(); i++) {

				Boolean value = (Boolean) model.getValueAt(i, 3);// check state

				if (value) {
				//	System.out.println(model.getValueAt(i, 1));
					select_data.add(new FoodModel(Integer.parseInt(model.getValueAt(i, 0).toString()),
							(String)(model.getValueAt(i, 1)),
							(Integer.parseInt(model.getValueAt(i, 2).toString()))));

				}
			}
			setVisible(false);

		}

	}

	public ArrayList<FoodModel> GetSelectedItem() {
		return select_data;
	}
}


