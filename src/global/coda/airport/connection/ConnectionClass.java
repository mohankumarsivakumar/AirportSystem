package global.coda.airport.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionClass {
	public static Connection establish() {
		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airportdb", "root", "root");
			
		} catch (SQLException e) {

			e.printStackTrace();
			
		}
		return con;
	}

	public static void closeConnection(Connection c) throws SQLException {
		c.close();
	}
}
