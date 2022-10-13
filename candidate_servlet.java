import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class candidate_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public candidate_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		 String name=request.getParameter("name");
		    String email=request.getParameter("email");
		    String mobile=request.getParameter("mobile");
		    String gender=request.getParameter("gender");
		    String tod=request.getParameter("Type of dance");
		    String time = request.getParameter("TS");
		    String Master = request.getParameter("Mas");
		    String cname=request.getParameter("cname");
		    String date=request.getParameter("do");
		        
		        
		    System.out.println("username : " + name);
		    System.out.println(" email : "+ email);
		    System.out.println("mobile no : " + mobile);
		    System.out.println("gender : " + gender);
		    System.out.println("Date: "+date);
		    System.out.println("type of dance"+tod);
		    System.out.println("Time Slot : "+time);
		    System.out.println("Master Name "+ Master);
		    System.out.println("country:  "+cname);

		    
		    
		     try {
		              Class.forName("oracle.jdbc.OracleDriver");
		              System.out.println("Driver Loaded");
		              Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","Mbvsk");
		              System.out.println("connected to database");
		              
		              String sql="insert into slotbooking values(?,?,?,?,?,?,?,?,?)";
		              PreparedStatement pstmt=con.prepareStatement(sql);
		              pstmt.setString(1,name);
		              pstmt.setString(2,email);
		              pstmt.setString(3,mobile);
		              pstmt.setString(4,gender);
		              pstmt.setString(5,tod);
		              pstmt.setString(6,time);
		              pstmt.setString(7,Master);
		              pstmt.setString(8, cname);
		              pstmt.setString(9,date);

		              ResultSet rs=pstmt.executeQuery();
		              
		             
		              if(rs.next()) {
		            	RequestDispatcher rd=request.getRequestDispatcher("ha.html");  
		            	rd.forward(request, response);
		                System.out.println("Booked  Succesfully");
		              }
		              else {
		                System.out.println("Booking Failed");
		              }
		              con.close();
		          }
		          catch(Exception e){
		              System.out.println(e);
		              
		          }
		  }
	}

