package hotel_managment.ui;


import java.awt.Container;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import hotel_managment.dal.connection_class;
import hotel_managment.dal.data_managment;
import hotel_managment.dal.searcch_getset;

class popup_allfooditems extends JFrame 
{
	
	DefaultTableModel model = new DefaultTableModel();
    Container cnt = this.getContentPane();
    JTable jtbl = new JTable(model);

    connection_class a = new connection_class();
        
	public popup_allfooditems() {
		setTitle("Food");
		setBounds(500, 150, 600, 600);
		
		cnt.setLayout(new FlowLayout(FlowLayout.LEFT));
        model.addColumn("Name");
        model.addColumn("Price");
        model.addColumn("Qty");
       
        Connection conn = a.getConnection();

		PreparedStatement stmt = null;
        try {
            
             stmt = conn.prepareStatement("select * from food_menu ");
           
            
             
            ResultSet Rs = stmt.executeQuery();
            while(Rs.next()){
            	 String d = Rs.getString("Name");
            	    int e = Rs.getInt("Price");
            	    int f = Rs.getInt("Quantity");
            	    model.addRow(new Object[]{d, e, f});
            	}
            }
         catch (Exception e) {
            System.out.println(e.getMessage());
        }
        JScrollPane pg = new JScrollPane(jtbl);
        cnt.add(pg);
        this.pack();
        setLayout(null);
		setVisible(true);
    }
}


