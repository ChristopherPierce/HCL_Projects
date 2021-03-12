import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class QueryDB {
	Connection conn = null;
	Statement stmt = null;

	public QueryDB() throws ClassNotFoundException, IOException, SQLException {
		//String p = getClass().getResource("/").getPath();
		InputStream in = getClass().getResourceAsStream("/config.properties");
		Properties props = new Properties();
		props.load(in);
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(props.getProperty("url"), props.getProperty("userid"), props.getProperty("password"));
		stmt = conn.createStatement();
		stmt.executeUpdate("USE products;");
	}
	
	public ResultSet getProductDetails(int productID) throws SQLException {
		String q = "SELECT * FROM product_list WHERE product_id = ?";
		PreparedStatement p = conn.prepareStatement(q);
	    p.setInt(1, productID);
	    ResultSet rs = p.executeQuery();
	    //ResultSet rs = stmt.executeQuery(q);
		return rs;
	}
}
