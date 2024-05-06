package com.DbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	public class DBConnection {
		private static Connection con;
		public static Connection openConnection(){
			
			try {
				// step 1 : load the diver into specific RDBMS
				Class.forName("com.mysql.cj.jdbc.Driver");
				// Step 2: Create Communication Channel
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userauthentication","root","root");
			}
			catch(SQLException|ClassNotFoundException se) {
				System.out.println(se);
			}
			return con;
	}
}
	
}