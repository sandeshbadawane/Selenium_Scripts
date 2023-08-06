package Database_Testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class DB_Testing 
{
public static void main(String[] args) throws Exception
{
	Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost","oracleuser","Ril#1357");
	Statement st=con.createStatement();
	ResultSet rs;
	
	st.executeUpdate("insert into EmpDetails values('A-18','PQR')");
	String id,name;
	 rs=st.executeQuery("select * from EmpDetails");
	while (rs.next()) 
	{
		id=rs.getString(1);
		name=rs.getString("Emp_name");
		
		System.out.println(id+"--"+name);
		
	}
	st.executeUpdate("update EmpDetails set EMP_ID='A-16' where EMP_NAME='ABC'");
	System.out.println("After updation");
	 rs=st.executeQuery("select * from EmpDetails");
		while (rs.next()) 
		{
			id=rs.getString(1);
			name=rs.getString("Emp_name");
			
			System.out.println(id+"--"+name);
			
		}
		
}
}
