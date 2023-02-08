package hotel_managment.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import hotel_managment.dal.connection_class;
import hotel_managment.dal.data_managment;
import hotel_managment.dal.searcch_getset;

class popup_fooditems extends JDialog  {
//	public Boolean rsl = false;
	
//	Container cnt = this.getContentPane();
//	
//	searcch_getset a = new searcch_getset();
//	connection_class con = new connection_class();
//	
//
//	private JTable table;
//	DefaultTableModel model;
//	ArrayList<FoodModel> select_data = new ArrayList();
//
//	public popup_fooditems(String searchword) {
//
//		setModal(true);
//
//		JPanel topPanel = new JPanel();
//		JPanel bottomPanel = new JPanel();
//
//		setTitle("Search Menu");
//		Object[] col = { "Id", "Name", "Price", "Select" };
//
//		orderMgmt order = new orderMgmt();
//
//		ArrayList<FoodModel> data = order.GetMenuData(searchword);
//
//		model = new DefaultTableModel(col, 0);
//
//		JTable table = new JTable(model) {
//
//			private static final long serialVersionUID = 1L;
//
//			@Override
//			public Class getColumnClass(int column) {
//				switch (column) {
//				case 0:
//					return Long.class;
//				case 1:
//					return String.class;
//				case 2:
//					return Double.class;
//				default:
//					return Boolean.class;
//				}
//			}
//		};
//
//		for (FoodModel m : data) {
//			Object[] objs = { m.getId(), m.getName(), m.getPrice(), false };
//			model.addRow(objs);
//		}
//
//		table.setPreferredScrollableViewportSize(table.getPreferredSize());
//		JScrollPane scrollPane = new JScrollPane(table);
//		topPanel.add(scrollPane);
//
//		JButton ok = new JButton("OK");
//		ok.setBounds(100, 100, 60, 10);
//		ok.addActionListener(new buttonClick());
//		bottomPanel.add(ok);
//
//		getContentPane().add(topPanel, BorderLayout.NORTH);
//		getContentPane().add(bottomPanel, BorderLayout.SOUTH);
//
//		setSize(500, 250);
//		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
//		setLocationRelativeTo(null);
//		setVisible(true);
//
//	}
//
//	private class buttonClick implements ActionListener {
//		@Override
//		public void actionPerformed(ActionEvent e) {
//
//			for (int i = 0; i < model.getRowCount(); i++) {
//
//				Boolean value = (Boolean) model.getValueAt(i, 3);// check state
//
//				if (value) {
//					// System.out.println(model.getValueAt(i, 1));// second column value
//					select_data.add(new FoodModel(Long.parseLong(model.getValueAt(i, 0).toString()),
//							(String) model.getValueAt(i, 1), Long.parseLong(model.getValueAt(i, 2).toString()), false));
//
//				}
//			}
//			setVisible(false);
//
//		}
//
//	}
//
//	public ArrayList<FoodModel> GetSelectedItem() {
//		
//		return select_data;
//	}
//}
	
//	public void popup_fooditems(a) {
//		setTitle("Food");
//		setBounds(500, 150, 600, 600);
//       
//		
//		cnt.setLayout(new FlowLayout(FlowLayout.LEFT));
//		
//		model.addColumn("Name");
//		model.addColumn("Price");
//		model.addColumn("Qty");
//	
//		//jtbl.setModel( model );
//		
//		
//		//cnt.remove(jtbl);
//		// int g = 0;
//		Connection conn = con.getConnection();
//
//		PreparedStatement stmt = null;
//		model.getDataVector().removeAllElements();
//		try {
//
//			stmt = conn.prepareStatement("select Name,Prize,Qty from food_menu where Name like ? ");
//
//			stmt.setString(1, a.food);
//
//			ResultSet Rs = stmt.executeQuery();
//			String d=null;
//             int e=0,f=0;
//			while (Rs.next()) {
//				d = Rs.getString("Name");
//				 e = Rs.getInt("Prize");
//				 f = Rs.getInt("Qty");
//				model.addRow(new Object[] { d, e, f });
//
//			}
////         boolean columnCount = Rs.getBoolean(g);
////         
////         if(columnCount== false) {
////        	 rsl = false;
////        	
////         }
////         else {
////        	 rsl = true;
////        	  
////         }
//
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//		
//		JScrollPane pg = new JScrollPane(jtbl);
//	//	pg.revalidate();
////	pg.repaint();
//		//pg.add();
//		
//		cnt.add(pg);
//		this.pack();
//		setLayout(null);
//		setVisible(true);
//
//		// return rsl;
//
//	}
//
}
