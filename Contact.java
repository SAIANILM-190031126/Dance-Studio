

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Contact
 */
public class Contact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Contact() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String Email = request.getParameter("email");
		String password = request.getParameter("pass");
		String comment = request.getParameter("cmt");
		
		 try {
	            Class.forName("oracle.jdbc.OracleDriver");
	            System.out.println("Driver Loaded");
	            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","Mbvsk");
	            System.out.println("connected to database");
	            
	            String sql="insert into contactus values(?,?,?,?,?)";
	            PreparedStatement pstmt=con.prepareStatement(sql);
	            pstmt.setString(1,fname);
	            pstmt.setString(2,lname);
	            pstmt.setString(3, Email);
	            pstmt.setString(4,password);
	            pstmt.setString(5,comment);

	            ResultSet rs=pstmt.executeQuery();
	            
	           
	            if(rs.next()) {
	            	RequestDispatcher rd=request.getRequestDispatcher("Home.html");
	            	
	            	System.out.println("First Name : " + fname);
	            	System.out.println("Last Name : " + lname);
	            	System.out.println("Email : " + Email);
	            	System.out.println("password : " + password);
	            	System.out.println("Comment :  " + comment);
	            	
	            	System.out.println("Your contact form is submitted Successfully....!!!");
	            	rd.forward(request, response);
	            }
	            else {
	            	//RequestDispatcher rd=request.getRequestDispatcher("contactus.html");
	            	System.out.println("Please contact our office...!!!");
	            	//rd.forward(request, response);
	            }
	            con.close();
	        }
	        catch(Exception e){
	            System.out.println(e);
	            
	        }
				        
		
	}

	private void alert(String string) {
		// TODO Auto-generated method stub
		
	}
	}

