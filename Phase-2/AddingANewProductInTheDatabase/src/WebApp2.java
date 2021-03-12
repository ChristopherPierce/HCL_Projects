import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/WebApp2")
public class WebApp2 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public WebApp2() {
		super();
	}

	@Override
	public void init() throws ServletException {}
    
    @Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
        response.setContentType("text/html;charset=UTF-8"); 
        //PrintWriter out = response.getWriter();
        //out.print("");

        RequestDispatcher view = request.getRequestDispatcher("index.jsp");
        view.include(request, response);
        //System.out.println("test");
    }
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		//System.out.println("test");
		response.setContentType("text/html;charset=UTF-8");  
		PrintWriter out = response.getWriter();
        
		String productName = request.getParameter("product_name");
		String productPriceString = request.getParameter("product_price");
		String productDesc = request.getParameter("product_desc");
		
		String errorMsg = "";
		if(productName.length()==0) {
			errorMsg += "Error: Invalid Product Name!<br>";
		}
		double productPrice = 0;
		try {
			productPrice = Double.parseDouble(productPriceString);
		} catch(NumberFormatException e) {
			errorMsg += "Error: Invalid Product Price!<br>";
		}
		if(productDesc.length()==0) {
			errorMsg += "Error: Invalid Product Description!<br>";
		}
		
        RequestDispatcher view = request.getRequestDispatcher("index.jsp");
        view.include(request, response);
		
		if(errorMsg.length()!=0) {
			out.print("<br><p>" + errorMsg + "</p>");
		} else {
			Product product = new Product(productName, productPrice, productDesc);
			//Integer productID = null;
			Integer productID = addProduct(product);
			if(productID==null) {
				out.print("<br><p>" + "Error: Failed to add product to the database!" + "</p>");
			} else {
				out.print("<br><p>" + "Success: Added product to the database, Product ID: " + productID + "</p>");
			}
		}
	}
	
	public Integer addProduct(Product product) {
		DBHelper helper = new DBHelper();
		int id = helper.addProduct(product);
		return id;
		//return 0;
	}
	
    @Override
	public void destroy() {}

}
