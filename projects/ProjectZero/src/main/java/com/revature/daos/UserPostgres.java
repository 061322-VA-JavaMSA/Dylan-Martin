package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.User;
import com.revature.util.ConnectionUtil;

public class UserPostgres implements UserDao{

	@Override
	public User createUser(User u) {
		String sql = "insert into users (firstname, lastname, username, password) values (?,?,?,?) returning id;";
		try(Connection c = ConnectionUtil.getConnectionFromEnv()){
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, u.getFirstName());
			ps.setString(2, u.getLastName());
			ps.setString(3, u.getUsername());
			ps.setString(4, u.getPassword());
			
			ResultSet rs = ps.executeQuery(); // return the id generated by the database
			if(rs.next()) {
				u.setId(rs.getInt("id"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return u;
	}

	@Override
	public User retrieveUserById(int id) {
		String sql = "select * from users where id = ?;";
		User user = null;
		
		try(Connection c = ConnectionUtil.getConnectionFromEnv()){
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setInt(1, id); // this refers to the 1st ? in the sql String
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setFirstName(rs.getString("firstname"));
				user.setLastName(rs.getString("lastname"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public List<User> retrieveUsers() {
		String sql = "select * from users;";
		List<User> users = new ArrayList<>();
		
		try(Connection c = ConnectionUtil.getConnectionFromEnv()){
			// no user input taken, no need for prepared statement
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				// extract each field from rs for each record, map them to a User object and add them to the users arrayliost
				User u = new User();
				u.setId(rs.getInt("id"));
				u.setFirstName(rs.getString("firstname"));
				u.setLastName(rs.getString("lastname"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				
				users.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return users;
	}

	@Override
	public User retrieveUserByUsername(String username) {
		String sql = "select * from users where username  = ?;";
		User u = null;
		
		try (Connection c = ConnectionUtil.getConnectionFromEnv();){
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setString(1, username); // this refers to the 1st "?" in the sql string, allows to inject data

			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				u = new User();
				u.setId(rs.getInt("id"));
				u.setFirstName(rs.getString("firstname"));
				u.setLastName(rs.getString("lastname"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return u;
	}

	@Override
	public boolean updateUser(User u) {
		String sql = "update users set firstname = ?, lastname = ?, username = ?, password = ? where id = ?;";
		int rowsChanged = -1;
		
		try(Connection c = ConnectionUtil.getConnectionFromEnv()){
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, u.getFirstName());
			ps.setString(2, u.getLastName());			
			ps.setString(3, u.getUsername());
			ps.setString(4, u.getPassword());
			ps.setInt(5, u.getId());
			
			rowsChanged = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(rowsChanged < 1) {
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteUserById(int id) {
		String sql = "delete from users where id = ?;";
		int rowsChanged = -1;
		try(Connection c = ConnectionUtil.getConnectionFromEnv()){
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			rowsChanged = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if(rowsChanged < 1) {
			return false;
		}
		return true;
	}

}