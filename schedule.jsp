<%@page import="java.sql.DriverManager"%>
		<%@page import="java.sql.*"%>
		<%@page import="java.sql.Statement"%>
		<%@page import="java.sql.Connection"%>
		
<!DOCTYPE html>
<html>
<head>
<title>timings</title>
<link rel="stylesheet" href="sched.css">
<center><h1><i>Time Table</i></h1><hr></center>
</head>
<body>

    <%
		try{
			Connection connection = null;
			Class.forName("oracle.jdbc.driver.OracleDriver");
    		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system","Mbvsk");
    		String str=request.getParameter("fname");
    		String query = "select * from slotbooking where fname='"+str+"'";
    		Statement st = con.createStatement();
    		ResultSet rs = st.executeQuery(query);
    		while(rs.next()){
		%>
		<center>
<div class="row">
<div class="column">
    <div class="card">

      <h3>Date</h3>
      <h3>Type of Dance</h3>
      <h3>Time of Slot</h3>
      <h3>Master</h3>
    </div>
  </div>
  <div class="column">
    <div class="card">

      <h3><%=rs.getString("doj") %></h3>
      <p><%=rs.getString("tod") %></p>
      <p><%=rs.getString("time") %></p>
      <p><%=rs.getString("mas") %>
    </div>
  </div>
</div>
</center>
<%
		}
		connection.close();
		} catch (Exception e) {
		e.printStackTrace();
		}
		%>
</body>
</html>
