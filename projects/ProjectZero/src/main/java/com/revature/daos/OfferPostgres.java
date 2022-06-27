package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Offer;
import com.revature.util.ConnectionUtil;

public class OfferPostgres implements OfferDao {
	
	@Override
	public Offer createOffer(Offer o) {
		String sql = "insert into offers (offer_amount, offer_status) values (?,?) returning offer_id;";
		try (Connection c = ConnectionUtil.getConnectionFromEnv()){
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, o.getAmt());
			ps.setString(2, "pending");
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				o.setId(rs.getInt("offer_id"));
				o.setStatus("offer_status");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return o;
	}

	@Override
	public Offer retrieveOfferById(int offer_id) {
		String sql = "select * from offers where offer_id = ?;";
		Offer offer = null;
		
		try (Connection c = ConnectionUtil.getConnectionFromEnv()){
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setInt(1, offer_id);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				offer = new Offer();
				offer.setId(rs.getInt("offer_id"));
				offer.setAmt(rs.getInt("offer_amount"));
				offer.setStatus(rs.getString("offer_status"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return offer;
	}

	@Override
	public List<Offer> retrieveOffers() {
		String sql = "select * from offers;";
		List<Offer> offers = new ArrayList<>();
		
		try (Connection c = ConnectionUtil.getConnectionFromEnv()) {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while (rs.next()) {
				Offer o = new Offer();
				o.setId(rs.getInt("offer_id"));
				o.setAmt(rs.getInt("offer_amount"));
				o.setStatus(rs.getString("offer_status"));
				
				offers.add(o);				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return offers;
	}

	@Override
	public Offer retrieveOffersByOfferAmount(int offer_amount) {
		String sql = "select * from offers where offer_amount = ?;";
		Offer o = null;
		
		try (Connection c = ConnectionUtil.getConnectionFromEnv()) {
			PreparedStatement ps = c.prepareStatement(sql);
				
			ps.setInt(1, offer_amount);
				
			ResultSet rs = ps.executeQuery();
				
			while(rs.next()) {
				o = new Offer();
				o.setId(rs.getInt("offer_id"));
				o.setAmt(rs.getInt("offer_amount"));
				o.setStatus(rs.getString("offer_status"));				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return o;
	}
	
	@Override
	public Offer retrieveOffersByOfferStatus(String offer_status) {
		String sql = "select * from offer_status where = ?;";
		Offer o = null;
		
		try (Connection c = ConnectionUtil.getConnectionFromEnv()) {
			PreparedStatement ps = c.prepareStatement(sql);
				
			ps.setString(1, offer_status);
				
			ResultSet rs = ps.executeQuery();
				
			while(rs.next()) {
				o = new Offer();
				o.setId(rs.getInt("offer_id"));
				o.setAmt(rs.getInt("offer_amount"));
				o.setStatus(rs.getString("offer_status"));				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return o;
	}	

	@Override
	public boolean updateOffer(Offer o) {
		String sql = "update offers set offer_amount = ?, offer_status = ? where offer_id = ?;";
		int rowsChanged = -1;
		
		try (Connection c = ConnectionUtil.getConnectionFromEnv()){
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, o.getAmt());
			ps.setString(2, o.getStatus());
			ps.setInt(3, o.getId());
			
			rowsChanged = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (rowsChanged < 1) {
			return false;
		}
				
		return true;
	}

	@Override
	public boolean deleteOfferByID(int id) {
		String sql = "delete from offers where offer_id = ?;";
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
