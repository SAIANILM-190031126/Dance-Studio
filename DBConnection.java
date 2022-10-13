import java.sql.*;
class DBConnection{
   public static void main(String args[ ]) throws Exception{
   
     Driver drv = new oracle.jdbc.driver.OracleDriver();
     DriverManager.registerDriver(drv);

     Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");

     if(con!=null)  
        System.out.println("Connected"); 
     else
        System.out.println("Not Connected"); 
 }
}