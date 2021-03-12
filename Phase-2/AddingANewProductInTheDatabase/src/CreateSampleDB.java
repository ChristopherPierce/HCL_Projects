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
			stmt.executeUpdate("DROP DATABASE IF EXISTS product;");
			stmt.executeUpdate("CREATE DATABASE product;");
			stmt.executeUpdate("USE product;");
			stmt.executeUpdate(
				"CREATE TABLE product ( " +
					"product_id INT NOT NULL auto_increment, " +
					"product_name TEXT, " +
					"product_price DOUBLE, " +
					"product_desc TEXT, " +
					"PRIMARY KEY ( product_id ) " +
				");"
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
