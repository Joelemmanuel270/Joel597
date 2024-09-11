package ddt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class DataBaseTest { 
	
	@Test
	public void Base() throws SQLException{

		Driver driveref = new Driver();
		DriverManager.registerDriver(driveref);

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/advanceselenium", "root", "joel27");

		// step3:-Create sql statement
		Statement state = con.createStatement();
		String query = "select * from selenium";
		String query2 = "insert into selenium(first_name,last_name,address)values('priya','magesan','kashmir')";
		int executeUpdate = state.executeUpdate(query2);
		System.out.println(executeUpdate);
		ResultSet result = state.executeQuery(query);
		System.out.println(executeUpdate);

		// step4:-Execute Statement/Query
		// result = state.executeQuery("select id from selenium");

		while (result.next()) {
			System.out.println();
			System.out.println("Id:  " + result.getInt(1) + ", ");
			System.out.println("first name: " + result.getString(2) + ", ");
			System.out.println("last name: " + result.getString(3));
			System.out.println("==================================");

		}

		// step5:- close database
		con.close();

	}

}
