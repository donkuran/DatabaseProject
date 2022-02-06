package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root" , "WordPass");
		
		Statement stmt = con.createStatement();
		
		ResultSet result = stmt.executeQuery("select * from eproduct");
		
		while(result.next()) {
			
			System.out.println(result.getInt("ID"));
			System.out.println(result.getString("name"));
			System.out.println(result.getString("price"));
			System.out.println("Item " + result.getInt("ID") + ": " + result.getString("name") + ", Price: " + result.getString("price"));
		}
		
		con.close();
	}

}

