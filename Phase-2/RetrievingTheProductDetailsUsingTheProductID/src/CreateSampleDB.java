import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class CreateSampleDB {

	public CreateSampleDB() {
		Connection conn = null;
		Statement stmt = null;

		try {
			InputStream in = CreateSampleDB.class.getResourceAsStream("/config.properties");
			Properties props = new Properties();
			props.load(in);
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(props.getProperty("url"), props.getProperty("userid"), props.getProperty("password"));
			stmt = conn.createStatement();
			stmt.executeUpdate("DROP DATABASE IF EXISTS products;");
			stmt.executeUpdate("CREATE DATABASE products;");
			stmt.executeUpdate("USE products;");
			stmt.executeUpdate(
				"CREATE TABLE product_list ( " +
					"product_id INT, " +
					"product_name TEXT, " +
					"product_price DOUBLE, " +
					"product_desc TEXT, " +
					"PRIMARY KEY ( product_id ) " +
				");"
			);
			stmt.executeUpdate(
				"INSERT INTO product_list ( product_id, product_name, product_price, product_desc ) " +
				"VALUES" +
					"(1, 'Apple', 0.99, 'Apples for $0.99 each.'), " +
					"(2, 'Eggs', 2.99, '1 dozen eggs for $2.99.'), " +
					"(3, 'Milk', 3.49, '1 gallon of milk for $3.49.'); "
			);
		} catch (SQLException | IOException | ClassNotFoundException e1) {
			e1.printStackTrace();
		}

		if (stmt != null)
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if (conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}
