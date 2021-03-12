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
			stmt.executeUpdate("DROP DATABASE IF EXISTS user;");
			stmt.executeUpdate("CREATE DATABASE user;");
			stmt.executeUpdate("USE user;");
			stmt.executeUpdate(
				"CREATE TABLE user ( " +
					"id INT NOT NULL auto_increment, " +
					"username TEXT, " +
					"password TEXT, " +
					"PRIMARY KEY ( id ) " +
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
