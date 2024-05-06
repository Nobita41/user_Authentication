package com.UserDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.DbConnection.DbConnection;
import com.DbConnection.DbConnection.DBConnection;
import com.userBeans.UserRegistrationBeans;

public class User {

	public int userRegistration(UserRegistrationBeans ub) {
		int status = 0;

		Connection con = DBConnection.openConnection();
		PreparedStatement ps = null;

		String insert = "insert into userregistration(id, name, email, password)values(?,?,?,?)";

		try {
			ps = con.prepareStatement(insert);
			ps.setInt(1, ub.getId());
			ps.setString(2, ub.getName());
			ps.setString(3, ub.getEmail());
			ps.setString(4, ub.getPassword());

			status = ps.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return status;

	}

	public UserRegistrationBeans login(String email, String password) {
		Connection con = DBConnection.openConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;

		UserRegistrationBeans us = null;
		String selectQuery = "select * from userregistration where email=? and password=?";

		try {
			ps = con.prepareStatement(selectQuery);
			ps.setString(1, email);
			ps.setString(2, password);
			rs = ps.executeQuery();
			// id, name, email, password
			if (rs.next() == true) {
				us = new UserRegistrationBeans();
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email1 = rs.getString("email");
				String pass = rs.getString("password");

				us.setId(id);
				us.setName(name);
				us.setEmail(email1);

				us.setPassword(pass);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return us;

	}
	public boolean editProfile(UserRegistrationBeans user) {
		// Database Connection
		Connection con = DBConnection.openConnection();
		PreparedStatement ps = null;

		boolean f= false;
		// object of registration beans
		UserRegistrationBeans ur = null;

		// id, name, email, password
		String updateQuery = "update  userregistration set  name= ?,email= ?, password=? where id=?";
		
		try {
			ps= con.prepareStatement(updateQuery);
			
			 ps.setString(1, user.getName());
			 ps.setString(2, user.getEmail());
			 ps.setString(3, user.getPassword());
			 ps.setInt(4, user.getId());
			
			 ps.executeUpdate();
			 f= true;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		// return reference variable for UserRegistrationBeans
		return f;

	}

}
