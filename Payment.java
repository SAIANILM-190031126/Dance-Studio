

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

/**
 * Servlet implementation class Payment
 */
public class Payment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Payment() {
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
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String name=request.getParameter("name");
		
		String Nname=request.getParameter("Nname");


		String email=request.getParameter("email");

		String date=request.getParameter("do");
		String Month = request.getParameter("do1");
		String Year = request.getParameter("do2");
		String gender = request.getParameter("gender");
		String pay =  request.getParameter("pay");
		String card_Name = request.getParameter("card_name");
		String cvc = request.getParameter("cvc");

		String MM = request.getParameter("MM");

		String YY = request.getParameter("YY");

		String amount = request.getParameter("amount");


		
		System.out.println("Username : " + name);
		System.out.println("NickName : "+ Nname);
		System.out.println("Email : " + email);
		System.out.println("Date : " + date);
		System.out.println("Month : " + Month);
		System.out.println("Year : " + Year);
		System.out.println("Gender : " + gender);
		System.out.println("Pay : " + pay);
		System.out.println("Card Name : " + card_Name);
		System.out.println("CVC  : " + cvc);
		System.out.println("Month : " + MM);
		System.out.println("Year : " +  YY);
		System.out.println("amount :"+amount);

		
		 try {
	            Class.forName("oracle.jdbc.OracleDriver");
	            System.out.println("Driver Loaded");
	            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","anil");
	            System.out.println("connected to database");
	            
	            String sql="insert into payment values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
	            PreparedStatement pstmt=con.prepareStatement(sql);
	            pstmt.setString(1,name);
	            pstmt.setString(2,Nname);
	            pstmt.setString(3, email);
	            pstmt.setString(4, date);
	            pstmt.setString(5, Month);
	            pstmt.setString(6, Year);
	            pstmt.setString(7, gender);
	            pstmt.setString(8, pay);
	            pstmt.setString(9, card_Name);
	            pstmt.setString(10, cvc);
	            pstmt.setString(11, MM);
	            pstmt.setString(12, YY);
	            pstmt.setString(13, amount);




	            



	            
	            ResultSet rs=pstmt.executeQuery();
	            
	           
	            if(rs.next()) {
	            	RequestDispatcher rd=request.getRequestDispatcher("NAV.html");
	            	System.out.println("Your payment was Successful");
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
