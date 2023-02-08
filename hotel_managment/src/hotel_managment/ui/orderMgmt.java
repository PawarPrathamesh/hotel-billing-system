package hotel_managment.ui;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import hotel_managment.dal.connection_class;

public class orderMgmt extends connection_class{

	public Object[][] getData()
	{
		Object[][] data = {};
return data;
	}
	public ArrayList<FoodModel> GetMenuData(String searchword){
		ArrayList<FoodModel> data = new ArrayList<FoodModel> ();
		
		
		String search_word = searchword+"%";
		
		Connection conn = getConnection();

		PreparedStatement stmt = null;

		try {

			stmt = conn.prepareStatement("select * from food_menu where Name like ?");
			stmt.setString(1, search_word);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
			
				data.add(new FoodModel(rs.getInt("ID"),rs.getString("Name"),rs.getInt("Price")));
			}

		} catch (Exception ex) {

		}
		return data;

	}
}

