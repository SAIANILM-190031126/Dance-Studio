<%@page import="java.sql.DriverManager"%>
		<%@page import="java.sql.*"%>
		<%@page import="java.sql.Statement"%>
		<%@page import="java.sql.Connection"%>
		<%
					
		%>
		<!DOCTYPE html>
		<html>
		<body>

		<h1>Admin page</h1>
		<table border="1">
		<tr>
		<td>User name</td>
		<td>email</td>
		<td>Password</td>
		<td>Rpass</td>

		</tr>
		<%
		try{
			Connection connection = null;
			Class.forName("oracle.jdbc.driver.OracleDriver");
    		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system","Mbvsk");
			PreparedStatement  pstmt= con.prepareStatement("select * from register1 ");
			ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
		%>
		<tr>
		<td><%=rs.getString("username") %></td>
		<td><%=rs.getString("email") %></td>
		<td><%=rs.getString("password") %></td>
		<td><%=rs.getString("rpass") %></td>
		</tr>
		<%
		}
		connection.close();
		} catch (Exception e) {
		e.printStackTrace();
		}
		%>
		</table>
		</body>
		</html>		