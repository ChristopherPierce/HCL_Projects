import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/WebApp")
public class WebApp extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private QueryDB query = null;
	
	public WebApp() {
		super();
		System.out.println("Attempting to connect with the product database...");
		try {
			query = new QueryDB();
			System.out.println("Successfully connected to the product database!");
		} catch (ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace();
			System.out.println("Failed to connect to the product database!");
		}
	}

	public void init() throws ServletException {}
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
        response.setContentType("text/html;charset=UTF-8"); 
        //PrintWriter out = response.getWriter();
        //out.print("");

		request.setAttribute("productDetails", "");
        RequestDispatcher view = request.getRequestDispatcher("index.jsp");
        view.include(request, response);
    }
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		response.setContentType("text/html;charset=UTF-8");  
		//PrintWriter out = response.getWriter();
        //out.print("");
        
		String productDetails = null;
		String productID = request.getParameter("product_id");
		if(productID.length() > 0) {
			Integer ID = null;
			try {
				ID = Integer.parseInt(productID);
			} catch (NumberFormatException e) {
				productDetails = "Error: Please enter a valid number for the product's ID";
			}
			if (ID != null) {
				try {
					ResultSet rs = query.getProductDetails(ID);
				    while(rs.next()){
				    	int product_id = rs.getInt("product_id");
				    	String product_name = rs.getString("product_name");
				    	double product_price = rs.getDouble("product_price");
				    	String product_desc = rs.getString("product_desc");
				    	if(productDetails == null) productDetails = "";
				    	productDetails += "Product ID: " + product_id +
				    			"\nProduct Name: " + product_name +
				    			"\nProduct Price: " + product_price +
				    			"\nProduct Description: " + product_desc + "\n\n";
				    			
				    }
				    if(productDetails == null) productDetails = "Error: Product ID does not exist!";
				} catch (SQLException e) {
					e.printStackTrace();
					productDetails = "Error: Failed to retrieve product details!";
				}
			}
		} else {
			productDetails = "Error: Please enter a valid number for the product's ID";
		}
		
		//if(productDetails==null) productDetails = "";
		request.setAttribute("productDetails", productDetails);
        RequestDispatcher view = request.getRequestDispatcher("index.jsp");
        view.include(request, response);
	}
	
    public void destroy() {}

}
