import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/WebApp3")
public class WebApp3 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public WebApp3() {
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
        
		String msg = "";
		if (request.getParameter("login_submit") != null) {
		    String username = request.getParameter("login_username");
		    String password = request.getParameter("login_password");
		    if(username.length()==0 || password.length()==0) {
			    if(username.length()==0) msg += "Please enter a username!<br>";
			    if(password.length()==0) msg += "Please enter a password!<br>";
		    } else {
		    	//verify login
		    	User user = new User(username, password);
		    	DBHelper helper = new DBHelper();
		    	try {
					Integer id = helper.loginUser(user);
					if(id == null) msg += "Failed to login!<br>";
					else msg += "Successfully logged in; User ID: " +id + "<br>";
				} catch (Exception e) {
					msg += e.getMessage() + "<br>";
				}
		    }
		} else if (request.getParameter("register_submit") != null) {
		    String username = request.getParameter("register_username");
		    String password = request.getParameter("register_password");
		    String password2 = request.getParameter("register_repeat_password");
		    if(username.length()==0 || password.length()==0 || password2.length()==0) {
			    if(username.length()==0) msg += "Please enter a username!<br>";
			    if(password.length()==0) msg += "Please enter a password!<br>";
			    if(password2.length()==0) msg += "Please confirm your password!<br>";
		    } else {
		    	if(password.length() < 8) msg += "Your password must be at least 8 characters long!";
		    	else if(password.equals(password2)) {
		    		//verify registration
		    		User user = new User(username, password);
		    		DBHelper helper = new DBHelper();
		    		try {
						Integer id = helper.registerUser(user);
						if(id == null) msg += "Failed to register user!<br>";
						else msg += "Successfully registered user; User ID: " +id + "<br>";
					} catch (Exception e) {
						msg += e.getMessage() + "<br>";
					}
		    		
		    	} else msg += "The passwords do not match!";
		    }
		} else {
	        RequestDispatcher view = request.getRequestDispatcher("index.jsp");
	        view.include(request, response);
	        //msg += "Please fill out the form before submitting!";
		}
		
		out.print("<br><p>" + msg + "</p><br>");
		out.print("<button type=\"button\" onclick=\"window.location.replace('/CreateASampleLoginAndRegistrationApplication/WebApp3');\">Return</button>");
		
		
	}
	
    @Override
	public void destroy() {}

}
