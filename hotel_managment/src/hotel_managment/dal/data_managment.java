package hotel_managment.dal;

import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.x.protobuf.MysqlxSql.StmtExecute;

import hotel_managment.ui.FoodModel;

public class data_managment extends connection_class {

	public boolean login(String username, String password) {
		Connection conn = getConnection();
		PreparedStatement stmt = null;
		boolean validuser = false;

		try {
			stmt = conn.prepareStatement("SELECT * FROM user_login where User_Name = ? and User_Password = ?");
			stmt.setString(1, username);
			stmt.setString(2, password);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				validuser = true;
				break;
			}
		} catch (Exception ex) {

		}
		return validuser;

	}

	public boolean addUser(add_user_getset userinfo) {
		Connection conn = getConnection();
		PreparedStatement statm = null;
		boolean recordinstred = false;

		try {

			statm = conn.prepareStatement("insert into user_login (User_id,User_Name,User_Password)values(?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			statm.setInt(1, userinfo.getUser_id());
			statm.setString(2, userinfo.getEmail());
			statm.setString(3, userinfo.getPassword());

			int rw = statm.executeUpdate();

			if (rw == 0) {
				recordinstred = false;
				return recordinstred;
			}

			else {
				int user_id = 0;
				try (ResultSet rs = statm.getGeneratedKeys()) {
					if (rs.next()) {
						user_id = rs.getInt(1);
					}
					rs.close();

					statm = conn.prepareStatement(
							"insert into user_info(ID,Name,Last_name,Phone_no,Address,Gender,Role_id,User_login_id) values (?,?,?,?,?,?,?,?)",
							Statement.RETURN_GENERATED_KEYS);

					statm.setInt(1, userinfo.getId());
					statm.setString(2, userinfo.getFirst_name());
					statm.setString(3, userinfo.getLast_name());
					statm.setString(4, userinfo.getPhone_no());
					statm.setString(5, userinfo.getAddress());
					statm.setString(6, userinfo.getGender());
					statm.setInt(7, userinfo.role);
					statm.setInt(8, user_id);

					rw = statm.executeUpdate();

					if (rw == 0) {
						recordinstred = false;
					} else {
						recordinstred = true;
					}
				} catch (Exception ex) {
					recordinstred = false;
				}

			}

		} catch (Exception ex) {
			recordinstred = false;
		}

		return recordinstred;

	}

	public ArrayList<String> getRole() {

		ArrayList<String> data = new ArrayList<String>();

		Connection conn = getConnection();

		PreparedStatement stmt = null;

		try {

			stmt = conn.prepareStatement("select * from role");

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				String role_data = rs.getInt("Id") + "-" + rs.getString("Role");
				data.add(role_data);
			}

		} catch (Exception ex) {

		}
		return data;

	}

	public boolean addrole(add_role_getset roleinfo) {

		Connection conn = getConnection();
		PreparedStatement statm = null;
		boolean recordinstred = false;

		// Statement a =conn.createStatement();

		try {

			statm = conn.prepareStatement("insert into role(Id,Role)values(?,?)",
					Statement.RETURN_GENERATED_KEYS);
			statm.setInt(1, roleinfo.getId());
			statm.setString(2, roleinfo.getRole_name());

			int rw = statm.executeUpdate();

			if (rw == 0) {
				recordinstred = false;
			} else {
				recordinstred = true;
			}
		} catch (Exception ex) {
			recordinstred = false;
		}
		return recordinstred;
	}

	public boolean addfood_cat(add_food_cat_getset foodinfo) {
		Connection conn = getConnection();
		PreparedStatement statm = null;
		boolean recordinstred = false;

		// Statement a =conn.createStatement();

		try {

			statm = conn.prepareStatement("insert into food_catagory(Food_cat_No,Food_cat_Name,comments)values(?,?,?)",
					Statement.RETURN_GENERATED_KEYS);

			statm.setInt(1, foodinfo.getId());
			statm.setString(2, foodinfo.getFood_cat_name());
			statm.setString(3, foodinfo.getComments());
			int rw = statm.executeUpdate();

			if (rw == 0) {
				recordinstred = false;
			} else {
				recordinstred = true;
			}
		} catch (Exception ex) {
			recordinstred = false;
		}
		return recordinstred;
	}

	public boolean addfoodItem(food_item_getset food) {
		Connection conn = getConnection();
		PreparedStatement statm = null;
		boolean recordinstred = false;
		try {

			statm = conn.prepareStatement(
					"insert into food_menu(ID,Name,Price,Food_cat_id,Quantity,Measure_id)values(?,?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			statm.setInt(1, food.getId());
			statm.setString(2, food.getName());
			statm.setInt(3, food.getPrize());
			statm.setInt(4, food.getCat_id());
			statm.setInt(5, food.getQyt());
			statm.setInt(6, food.getMesure_id());

			int rw = statm.executeUpdate();

			if (rw == 0) {
				recordinstred = false;
			} else {
				recordinstred = true;
			}
		} catch (Exception ex) {
			recordinstred = false;
		}
		return recordinstred;

	}

	public ArrayList<String> getmesure_id() {

		ArrayList<String> data = new ArrayList<String>();

		Connection conn = getConnection();

		PreparedStatement stmt = null;

		try {

			stmt = conn.prepareStatement("select * from measurement_type");

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				String role_data = rs.getInt("ID") + "-" + rs.getString("Name");
				data.add(role_data);
			}

		} catch (Exception ex) {

		}
		return data;

	}

	public ArrayList<String> getcat_id() {

		ArrayList<String> data = new ArrayList<String>();

		Connection conn = getConnection();

		PreparedStatement stmt = null;

		try {

			stmt = conn.prepareStatement("select * from food_catagory");

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				String cat_data = rs.getInt("Food_cat_no") + "-" + rs.getString("Food_Cat_name") + "-"
						+ rs.getString("comments");
				data.add(cat_data);
			}

		} catch (Exception ex) {

		}
		return data;

	}

	public boolean add_mesurement(add_mesure_getset mesure) {
		Connection conn = getConnection();
		PreparedStatement statm = null;
		boolean recordinstred = false;

//Statement a =conn.createStatement();

		try {

			statm = conn.prepareStatement("insert into measurement_type(ID,Name)values(?,?)",
					Statement.RETURN_GENERATED_KEYS);
			statm.setInt(1, mesure.getId());
			statm.setString(2, mesure.getMesure_name());

			int rw = statm.executeUpdate();

			if (rw == 0) {
				recordinstred = false;
			} else {
				recordinstred = true;
			}
		} catch (Exception ex) {
			recordinstred = false;
		}
		return recordinstred;

	}

	public boolean add_tables(add_table_getset table) {
		Connection conn = getConnection();
		PreparedStatement statm = null;
		boolean recordinstred = false;

		// Statement a =conn.createStatement();

		try {

			statm = conn.prepareStatement("insert into table_mgmt(ID,Table_type,Table_no,seats)values(?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);

			statm.setInt(1, table.getId());
			statm.setString(2, table.getTable_type());
			statm.setInt(3, table.getTable_no());
			statm.setInt(4, table.getSeats());
			int rw = statm.executeUpdate();

			if (rw == 0) {
				recordinstred = false;
			} else {
				recordinstred = true;
			}
		} catch (Exception ex) {
			recordinstred = false;
		}
		return recordinstred;
	}

	public ArrayList<String> getwaiter() {

		ArrayList<String> data = new ArrayList<String>();

		Connection conn = getConnection();

		PreparedStatement stmt = null;

		try {

			stmt = conn.prepareStatement("select * from user_info where Role_id=5");

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				String waiter_data = rs.getString("Name") + " " + rs.getString("Last_name");

				data.add(waiter_data);
			}

		} catch (Exception ex) {

		}
		return data;

	}

	public ArrayList<String> getcaptain() {

		ArrayList<String> data = new ArrayList<String>();

		Connection conn = getConnection();

		PreparedStatement stmt = null;

		try {

			stmt = conn.prepareStatement("select * from user_info where Role_id=1");

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				String captain_data = rs.getString("Name") + " " + rs.getString("Last_name");

				data.add(captain_data);
			}

		} catch (Exception ex) {

		}
		return data;

	}

	public ArrayList<String> gettable_info() {

		ArrayList<String> data = new ArrayList<String>();

		Connection conn = getConnection();

		PreparedStatement stmt = null;

		try {

			stmt = conn.prepareStatement("select * from table_mgmt");

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				String table_data = "No:" + rs.getInt("Table_no") + "--" + rs.getString("Table_type") + "--Seats:"
						+ rs.getInt("seats");

				data.add(table_data);
			}

		} catch (Exception ex) {

		}
		return data;

	}

	public boolean addorder(add_ordergetset order_data) {
		Connection conn = getConnection();
		PreparedStatement statm = null;
		boolean recordinstred = false;

		// Statement a =conn.createStatement();

		try {

			statm = conn.prepareStatement(
					"insert into orders(ID,Table_id,Waiter_id,Captain_id,Date,Time)values(?,?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);

			statm.setInt(1, order_data.getOrder_Id());
			statm.setInt(2, order_data.getTable_id());
			statm.setInt(3, order_data.getWaiter_id());
			statm.setInt(4, order_data.getCaptain_id());
			statm.setString(5, order_data.getDate_sys());
			statm.setString(6, order_data.getTime_sys());
			int rw = statm.executeUpdate();

			if (rw == 0) {
				recordinstred = false;
			} else {

				int order_id = 0;
				try (ResultSet rs = statm.getGeneratedKeys()) {
					if (rs.next()) {
						order_id = rs.getInt(1);
						order_data.setOrder_Id(order_id);
					}
					rs.close();
				
					if (rw == 0) {
						recordinstred = false;
					} else {
						recordinstred = true;
					}

				} catch (Exception ex) {
					recordinstred = false;
				}

			}
		} catch (Exception ex) {
			recordinstred = false;
		}

		return recordinstred;

	}

	public boolean add_ordered_data(int order_id,int food_id) {
		Connection conn = getConnection();
		PreparedStatement statm = null;
		boolean recordinstred = false;

		try {

			statm = conn.prepareStatement("insert into order_food(order_id,Food_id) values (?,?)",
					Statement.RETURN_GENERATED_KEYS);

			statm.setInt(1, order_id);

			statm.setInt(2, food_id);
			int rw = statm.executeUpdate();
			if (rw == 0) {
				recordinstred = false;
			} else {
				recordinstred = true;
			}
		} catch (Exception ex) {

		}
		return recordinstred;

	}

	public boolean billing(billing_getset billing_info) {
		
		
		Connection conn = getConnection();
		PreparedStatement statm = null;
		boolean recordinstred = false;

		try {

			statm = conn.prepareStatement("insert into customer(ID,Name,mobile)values(?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			statm.setInt(1, billing_info.getCustomer_id());
			statm.setString(2, billing_info.getName());
			statm.setInt(3, billing_info.getMoblie());

			int rw = statm.executeUpdate();

			if (rw == 0) {
				recordinstred = false;
				
			}

			else {
				int cust_id = (int)billing_info.getCustomer_id();
				try (ResultSet rs = statm.getGeneratedKeys()) {
					if (rs.next()) {
						cust_id = rs.getInt(1);
					}
					rs.close();
					statm = conn.prepareStatement("insert into bill(ID,Order_id,Date_Time,Amount,Payment_type,Credit_card,Expiry_date,Customer_id)values(?,?,?,?,?,?,?,?)",
							Statement.RETURN_GENERATED_KEYS);
					
					
					statm.setInt(1, billing_info.getBill_id());
					statm.setInt(2, billing_info.getOrder_id());
					statm.setString(3, billing_info.getDate_time());
					statm.setInt(4, billing_info.getAmount());
					statm.setString(5, billing_info.getPayment_type());
					statm.setString(6, billing_info.getCredit_card());
					statm.setString(7, billing_info.getExpiry_date());
					statm.setInt(8,cust_id);
					
					 rw = statm.executeUpdate();
					
					 if (rw == 0) {
						recordinstred = false;
					} else {
						recordinstred = true;
					}
				} catch (Exception ex) {
					recordinstred = false;
				}

			}

		} catch (Exception ex) {
			recordinstred = false;
		}

		return recordinstred;


		

			}
}
