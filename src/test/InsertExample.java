package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertExample {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root" , "WordPass");
		
		Statement stmt = con.createStatement();
		
		stmt.executeUpdate("insert into eproduct (name, price, date_added) values ('Tablet', 1500.00, now())");

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
