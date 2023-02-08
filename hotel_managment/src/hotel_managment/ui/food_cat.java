package hotel_managment.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import hotel_managment.dal.add_food_cat_getset;
import hotel_managment.dal.add_role_getset;
import hotel_managment.dal.data_managment;

//import hotel_managment.ui.add_user.ButtonClicklistner;
import javax.swing.*;
public class food_cat extends JFrame{
	JTextField cat_txt,comment_txt ;
	JLabel result = new JLabel();
	public food_cat()
	{
		
		setTitle("Food Category");
		setBounds(500, 150, 400, 400);

		
		
		
		
		JLabel category_lb = new JLabel("Category:");
		// position
		category_lb.setBounds(75, 65, 100, 20);

		JLabel comment_lb = new JLabel("Comments:");
		// position
		comment_lb.setBounds(75, 100, 100, 20);

		
		result.setBounds(100, 200, 200, 200);
		
		 cat_txt = new JTextField();
		// set position
	    cat_txt.setBounds(150,65, 150, 20);
	   
	    comment_txt = new JTextField();
	    comment_txt.setBounds(150,100 , 150, 20);
	    
	    
	    JButton save_but = new JButton("Save");
		save_but.setBounds(150, 150, 75, 20);
		save_but.addActionListener(new ButtonClicklistner());
		
		add(category_lb);
		add(cat_txt);
		add(comment_txt);
		add(comment_lb);
		add(result);
		add(save_but);
		setLayout(null);
		setVisible(true);

	}
	private class ButtonClicklistner implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			
			String comman = e.getActionCommand();
			
			if(comman.equals("Save")){
				data_managment user = new data_managment();
				add_food_cat_getset b = new add_food_cat_getset();
				
				b.setFood_cat_name(cat_txt.getText());
				b.setComments(comment_txt.getText());
				if(user.addfood_cat(b)) {
					result.setText("Food Category inserted");
				}else {
					result.setText("Food Category not inserted");

				}
				
				
			}
		}
}

}
