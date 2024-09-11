package ddt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class MysqlTest { 
	
	@Test
	public static void main() throws SQLException {
		
		// register/load the driver
		Driver driveref = new Driver();
		DriverManager.registerDriver(driveref);
		
		// establish connection to database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/priya", "root", "joel27");
		
		//create statement
		Statement state = con.createStatement();
		Random ran= new Random();
		int nextInt = ran.nextInt(1000);
		
		String query="CREATE TABLE PARENT"+nextInt
				+ "    (CustomerID INT PRIMARY KEY,"
				+ "    CustomerName VARCHAR(50),"
				+ "    LastName VARCHAR(50),"
				+ "    Country VARCHAR(50),"
				+ "    Age INT CHECK (Age >= 0 AND Age <= 99),"
				+ "    Phone int(10)); ";
		
		int update = state.executeUpdate(query);
		System.out.println(update);
		
		con.close();
		
	}
}