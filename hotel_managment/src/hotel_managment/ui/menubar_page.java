package hotel_managment.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class menubar_page extends JFrame

{
	public menubar_page() {
		setTitle("Menu Page ");
		setBounds(500, 150, 600, 550);

		JMenuBar login_menubar = new JMenuBar();

		JMenu add_menu = new JMenu("Add");
		JMenu order_menu = new JMenu("Place Order");
		JMenu logout_menu = new JMenu("Logout");

		JMenuItem add_user = new JMenuItem("User");
		add_user.setActionCommand("Add user");
		add_menu.add(add_user);

		JMenuItem add_foodcat = new JMenuItem("Food Category");
		add_foodcat.setActionCommand("Add Category");
		add_menu.add(add_foodcat);

		JMenuItem add_role = new JMenuItem("Add Role");
		add_role.setActionCommand("Add Role");
		add_menu.add(add_role);

		JMenuItem add_table = new JMenuItem("Table");
		add_table.setActionCommand("Add Table");
		add_menu.add(add_table);

		JMenuItem add_food = new JMenuItem("Food");
		add_food.setActionCommand("Add Food");
		add_menu.add(add_food);

		JMenuItem add_mesure = new JMenuItem("Mesurement");
		add_mesure.setActionCommand("Add Mesurement");
		add_menu.add(add_mesure);

		JMenuItem place_order = new JMenuItem("Order");
		place_order.setActionCommand("Order");
		order_menu.add(place_order);

		JMenuItem Logout = new JMenuItem("Logout");
		Logout.setActionCommand("Logout");
		logout_menu.add(Logout);

		JPanel panel = new JPanel();
		JPanel endpanel = new JPanel();
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("images\\welcome_page_img.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		ImageIcon icon = new ImageIcon(img);
		Image im = icon.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT);

		JLabel imagelb = new JLabel();
		imagelb.setIcon(new ImageIcon(im));

		JLabel wel = new JLabel("Login Succesfully");
		wel.setBounds(240, 400, 100, 40);
		wel.setFont(new Font("Serif", Font.BOLD, 16));

		JLabel opp = new JLabel("Select option in Menu bar");
		opp.setBounds(220, 500, 200, 40);
		opp.setFont(new Font("Serif", Font.BOLD, 16));

		panel.add(imagelb, BorderLayout.CENTER);
		getContentPane().add(endpanel, BorderLayout.SOUTH);
		// endpanel.add(wel);

		endpanel.add(opp);
		panel.setPreferredSize(new Dimension(600, 550));

		add(panel);
		pack();

		add_user.addActionListener(new menulistener());
		add_foodcat.addActionListener(new menulistener());
		add_role.addActionListener(new menulistener());
		add_table.addActionListener(new menulistener());
		add_food.addActionListener(new menulistener());
		add_mesure.addActionListener(new menulistener());
		place_order.addActionListener(new menulistener());
		Logout.addActionListener(new menulistener());

		login_menubar.add(add_menu);
		login_menubar.add(order_menu);
		login_menubar.add(logout_menu);

		setJMenuBar(login_menubar);
		// setLayout(null);
		setVisible(true);
	}

	class menulistener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String clickedMenu = e.getActionCommand();
			if (clickedMenu.equals("Add user")) {
				new add_user();

			} else if (clickedMenu.equals("Add Category")) {
				new food_cat();
			} else if (clickedMenu.equals("Add Role")) {
				new role();
			} else if (clickedMenu.equals("Add Table")) {
				new add_table();
			} else if (clickedMenu.equals("Add Food")) {
				new food_menu();
			} else if (clickedMenu.equals("Order")) {
				new order();
			}else if (clickedMenu.equals("Add Mesurement")) {
				new add_mesure();
			} else if (clickedMenu.equals("Logout")) {
				dispose();
				new logout_page();
			}
		}
	}
}
