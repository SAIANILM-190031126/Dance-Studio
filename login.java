

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("lLogin")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	


		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		try
		{
    		Class.forName("oracle.jdbc.driver.OracleDriver");
    		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system","anil");
    		PreparedStatement pstmt=con.prepareStatement("select * from register where username=? and password=?");
    		pstmt.setString(1,name);
    		pstmt.setString(2,password);
    			
    		int n=pstmt.executeUpdate();
    		if(n==1){
            	RequestDispatcher rd=request.getRequestDispatcher("NAV.html");
            	rd.forward(request, response);


    			System.out.println("Successfully logged in....!!!");
    			System.out.println( "Name : "+name);
    			System.out.println("Password : "+ password);
            	
			}
			else {
            	RequestDispatcher rd=request.getRequestDispatcher("contactus.html");
            	rd.include(request, response);
				System.out.println("Login Failed");
			}				
		}
		catch(Exception e)
		{		
			System.out.println(e);  
		}
				        
		
	}

	private void alert(String string) {
		// TODO Auto-generated method stub
		
	}

}
