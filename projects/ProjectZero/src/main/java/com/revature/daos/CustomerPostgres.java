package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Customer;
import com.revature.util.ConnectionUtil;

public class CustomerPostgres implements CustomerDao {

	@Override
	public Customer createCustomer(Customer cu) {
		String sql = "insert into customers (firstname, lastname) values (?,?) returning customer_id;";
		try (Connection c = ConnectionUtil.getConnectionFromEnv()){
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1,  cu.getFirstName());
			ps.setString(2, cu.getLastName());
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				cu.setId(rs.getInt("customer_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cu;
	}

	@Override
	public Customer retrieveCustomerById(int customer_id) {
		String sql = "select * from customers where customer_id = ?;";
		Customer customer = null;
		
		try(Connection c = ConnectionUtil.getConnectionFromEnv()){
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setInt(1, customer_id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				customer = new Customer();
				customer.setId(rs.getInt("customer_id"));
				customer.setFirstName(rs.getString("firstname"));
				customer.setLastName(rs.getString("lastname"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customer;
	}

	@Override
	public List<Customer> retrieveCustomers() {
		String sql = "select * from customers;";
		List<Customer> customers = new ArrayList<>();
		
		try(Connection c = ConnectionUtil.getConnectionFromEnv()){
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				Customer cu = new Customer();
				cu.setId(rs.getInt("customer_id"));
				cu.setFirstName(rs.getString("firstname"));
				cu.setLastName(rs.getString("lastname"));
				
				customers.add(cu);
			}
		} catch (SQLException e) {
			
		}
		return customers;
	}

	@Override
	public Customer retrieveCustomerByName(String firstname) {
		String sql = "select * from customers where firstname = ?;";
		Customer cu = null;
		
		try (Connection c = ConnectionUtil.getConnectionFromEnv();){
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setString(1, firstname); // this refers to the 1st "?" in the sql string, allows to inject data

			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				cu = new Customer();
				cu.setId(rs.getInt("id"));
				cu.setFirstName(rs.getString("firstname"));
				cu.setLastName(rs.getString("lastname"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cu;
	}

	@Override
	public boolean updateCustomer(Customer cu) {
		String sql = "update customers set firstname = ?, lastname = ? where customer_id = ?;";
		int rowsChanged = -1;
		
		try(Connection c = ConnectionUtil.getConnectionFromEnv()){
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setString(1,  cu.getFirstName());
			ps.setString(2,  cu.getLastName());
			ps.setInt(3, cu.getId());
			
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
	public boolean deleteCustomerById(int customer_id) {
		String sql = "delete from customers where customer_id = ?;";
		int rowsChanged = -1;
		
		try(Connection c = ConnectionUtil.getConnectionFromEnv()){
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setInt(1, customer_id);
			
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
