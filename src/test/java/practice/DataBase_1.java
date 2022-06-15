 package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBase_1 {
	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		try {
			Driver driverRef = new Driver();
			
			DriverManager.registerDriver(driverRef);
			
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/practice", "root", "root");
			
			Statement stmt = conn.createStatement();
			String query ="select * from students_info;";
			
			ResultSet resultSet = stmt.executeQuery(query);
			
			while (resultSet.next()) {
				System.out.println(resultSet.getString(1)+"\t"+resultSet.getString(2));
			}
			
		} catch (Exception e) {
			
		}
		finally {
			conn.close();
			System.out.println("end");
		}
	

	}
}
	
		


