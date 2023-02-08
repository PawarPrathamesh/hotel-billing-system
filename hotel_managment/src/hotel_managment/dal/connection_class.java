package hotel_managment.dal;

import java.sql.Connection;
import java.sql.DriverManager;

public class connection_class {

	
	public Connection getConnection() {
		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/resto_bill?useTimezone=true&serverTimezone=GMT%2B8", "root", "");
		} catch (Exception ex) {

			String err = ex.getMessage();
System.out.print(err);
		}
		return conn;

	


	}
}
