package hotel_managment.ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import hotel_managment.dal.data_managment;
import hotel_managment.dal.food_item_getset;

//import hotel_managment.ui.food_menu.ButtonClicklistner;

public class food_menu extends JFrame{
	
	JTextField foodname_txt = new JTextField();
	JTextField prize_txt = new JTextField();
	
	JTextField quantity_txt = new JTextField();
	JComboBox mesumesure_id_cmb ;
	JComboBox cat_id_cmb ;
	
	JLabel result = new JLabel();
	data_managment user = new data_managment();
	
	public food_menu()
	{
		setTitle("Add Food");
		setBounds(500, 150, 600, 550);
		
		JLabel foodname_lb = new JLabel("Food Name:");
		// position
		foodname_lb.setBounds(100, 25, 100, 100);
		foodname_lb.setFont(new Font("Serif", Font.PLAIN, 14));
		foodname_txt.setBounds(250, 68, 150, 20);
		
		
		JLabel prize_lb = new JLabel("Price");
		// position
		prize_lb.setBounds(100, 75, 100, 100);
		prize_lb.setFont(new Font("Serif", Font.PLAIN, 14));

		prize_txt.setBounds(250, 115, 150, 20);
		
		JLabel quantity_lb = new JLabel("Quantity:");
		// position
		quantity_lb.setBounds(100, 115, 100, 100);
		quantity_lb.setFont(new Font("Serif", Font.PLAIN, 14));
		quantity_txt.setBounds(250, 155, 150, 20);
		
		
		JLabel mesumesure_id_lb  = new JLabel("Mesure Id :");
		// position
		mesumesure_id_lb.setBounds(100, 160, 100, 100);
		mesumesure_id_lb.setFont(new Font("Serif", Font.PLAIN, 14));
		
ArrayList<String> mesure_list =user.getmesure_id();
		
		String[] mesure = mesure_list.toArray(new String[mesure_list.size()]);
		
		
		mesumesure_id_cmb = new JComboBox(mesure);
		mesumesure_id_cmb.setBounds(250, 195, 150, 20);
		
ArrayList<String> cat_list =user.getcat_id();
		
		String[] cat = cat_list.toArray(new String[cat_list.size()]);
		
		cat_id_cmb = new JComboBox(cat);
		cat_id_cmb.setBounds(250, 240, 175, 20);
		
		JLabel cat_id_lb  = new JLabel("Cat Id :");
		// position
		cat_id_lb.setBounds(100, 200, 100, 100);
		cat_id_lb.setFont(new Font("Serif", Font.PLAIN, 14));
		
		

		JButton save_But = new JButton("Save");
		save_But.setBounds(250, 450, 75, 20);
		save_But.addActionListener(new ButtonClicklistner());
		
		result.setBounds(250, 350, 100, 25);
		
		add(foodname_lb);
		add(foodname_txt);
		add(prize_lb);
		add(prize_txt);
		add(quantity_lb);
		add(quantity_txt);
		add(mesumesure_id_lb);
		add(mesumesure_id_cmb);
		add(cat_id_lb);
		add(cat_id_cmb);
		add(save_But);
		add(result);
		
		setLayout(null);
		setVisible(true);

	}
private class ButtonClicklistner implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		String comman = e.getActionCommand();

		if (comman.equals("Save")) {
		
			String mesumesure_id=(String)mesumesure_id_cmb.getSelectedItem();
			int mesure_id = Integer.parseInt(mesumesure_id.split("-")[0]);
			 
			String item=(String)cat_id_cmb.getSelectedItem();
			int cat_id = Integer.parseInt(item.split("-")[0]);
			
			food_item_getset a = new food_item_getset();
			
			a.setName(foodname_txt.getText());
			
			String prize = prize_txt.getText();
			int prize_int = Integer.parseInt(prize);
			a.setPrize(prize_int);
			
			
			String qyt = quantity_txt.getText();
			int qyt_in = Integer.parseInt(qyt);
			a.setQyt(qyt_in);
			
			a.setMesure_id(mesure_id);
			a.setCat_id(cat_id);
			
			if(user.addfoodItem(a)) {
				result.setText("Food Inserted");
			}
			
			
			else {
				result.setText("Not inserted");
			}
		
	}
		
	
	
	
	
}
}
}
