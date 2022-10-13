import java.io.*;  
import java.sql.*;  
import javax.servlet.ServletException;  
import javax.servlet.http.*;  
  
public class Master_Register extends HttpServlet {  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
          
String name=request.getParameter("name");  
String Email=request.getParameter("email");  
String Mobile=request.getParameter("mobile");  
String Gender=request.getParameter("gender");  
String doj = request.getParameter("do"); 
String country = request.getParameter("country");
String Dance_Name = request.getParameter("dname");


System.out.println("username : " + name);
System.out.println(" email : "+ Email);
System.out.println("mobile no : " + Mobile);
System.out.println("gender : " + Gender);
System.out.println("Date: "+doj);
System.out.println("country:  "+country);
System.out.println("Dance_Name : "+Dance_Name);
          
try{  
Class.forName("oracle.jdbc.driver.OracleDriver");  
Connection con=DriverManager.getConnection(  
"jdbc:oracle:thin:@localhost:1521:xe","system","Mbvsk");  
  
PreparedStatement ps=con.prepareStatement(  
"insert into Master_register values(?,?,?,?,?,?,?)");  
  
ps.setString(1,name);  
ps.setString(2,Email);  
ps.setString(3,Mobile);  
ps.setString(4,Gender); 
ps.setString(5,doj); 
ps.setString(6,country); 
ps.setString(7,Dance_Name); 
 
          
int i=ps.executeUpdate();  
if(i>0)  
System.out.println("You are successfully registered...");  
      
          
}catch (Exception e2) {System.out.println(e2);}  
          
out.close();  
}  
  
}