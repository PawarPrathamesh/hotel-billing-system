package hotel_managment.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import hotel_managment.dal.add_mesure_getset;
import hotel_managment.dal.add_role_getset;
import hotel_managment.dal.data_managment;

//import hotel_managment.ui.role.ButtonClicklistner;

public class add_mesure extends JFrame {
	
	JTextField Measurement_txt;
	JLabel result= new JLabel();
	public add_mesure() {
		setTitle("Add Measurement");
		setBounds(500, 150, 400, 400);
		
		
		JLabel Measurement_lb = new JLabel("Measurement:");
		// position
		Measurement_lb.setBounds(60, 65, 100, 20);

	   result.setBounds(100, 150, 200, 20);
		
	   Measurement_txt = new JTextField();
		// set position
	   Measurement_txt.setBounds(150,65 , 150, 20);


	    JButton save_but = new JButton("Save");
		save_but.setBounds(150, 100, 75, 20);
		save_but.addActionListener(new ButtonClicklistner());
		
		add(Measurement_lb);
		add(Measurement_txt);
		add(save_but);
	    add(result);
		setLayout(null);
		setVisible(true);;
	}
	private class ButtonClicklistner implements ActionListener{
		
	

	@Override
	public void actionPerformed(ActionEvent e){
		String comman = e.getActionCommand();
		
		if(comman.equals("Save")){
			data_managment user = new data_managment();
			add_mesure_getset b = new add_mesure_getset();
			
		
			b.setMesure_name(Measurement_txt.getText());
			
			if(user.add_mesurement(b)) {
				result.setText("Measurement inserted");
			}
			//dispose();
			//new menubar_page(); 
			
		}else {
			result.setText("Measurement not inserted");

		}
		
	}	
		
		
	}
}
