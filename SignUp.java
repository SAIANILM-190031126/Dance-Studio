
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
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
	
		String username=request.getParameter("name");

		String email=request.getParameter("email");

		String password=request.getParameter("password");
		String confirmpassword=request.getParameter("rpass");
		System.out.println("username : " + username);
		System.out.println(" email : "+ email);
		System.out.println("password : " + password);
		System.out.println("rpass : " + confirmpassword);
		
		 try {
	            Class.forName("oracle.jdbc.OracleDriver");
	            System.out.println("Driver Loaded");
	            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","Mbvsk");
	            System.out.println("connected to database");
	            
	            String sql="insert into register1 values(?,?,?,?)";
	            PreparedStatement pstmt=con.prepareStatement(sql);
	            pstmt.setString(1,username);
	            pstmt.setString(2,email);
	            //pstmt.setString(4, mobile);
	            pstmt.setString(3, password);
	            pstmt.setString(4, confirmpassword);
	            ResultSet rs=pstmt.executeQuery();
	            
	           
	            if(rs.next()) {
	            	RequestDispatcher rd=request.getRequestDispatcher("login1.html");
	            	System.out.println("Register Succesfully");
	            	rd.forward(request, response);
	            }
	            else {
	            	RequestDispatcher rd=request.getRequestDispatcher("contactus.html");
	            	System.out.println("Register Failed");
	            	rd.forward(request, response);
	            }
	            con.close();
	        }
	        catch(Exception e){
	            System.out.println(e);
	            
	        }
		  
		
		
	}

}

