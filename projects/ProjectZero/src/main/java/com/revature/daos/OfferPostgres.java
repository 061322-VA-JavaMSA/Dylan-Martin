package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Item;
import com.revature.models.Offer;
import com.revature.util.ConnectionUtil;

public class OfferPostgres implements OfferDao {
	
	@Override
	public Offer createOffer(Offer o) {
		String sql = "insert into offers (requested_item_id, offer_amount, offer_status, cust_id) values (?,?,?,?) returning offer_id;";
		try (Connection c = ConnectionUtil.getConnectionFromEnv()){
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, o.getRequestedItemId());
			ps.setInt(2, o.getAmt());
			ps.setString(3, "pending");
			ps.setInt(4, o.getCustomerId());
			
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
		
		try(Connection c = ConnectionUtil.getConnectionFromEnv()){
			// no user input taken, no need for prepared statement
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				// extract each field from rs for each record, map them to a User object and add them to the users arraylist
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
	public List<Offer> retrieveOffersByItemId(int item_id) {
		String sql = "select o.offer_id, o.cust_id, o.offer_amount, o.offer_status, o.requested_item_id, i.item_name, i.item_description, i.item_availability from offers o join items i on o.requested_item_id = i.item_id where requested_item_id = ?;";
		List<Offer> offers = new ArrayList<>();
		
		try (Connection c = ConnectionUtil.getConnectionFromEnv()) {
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setInt(1, item_id);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Offer o = new Offer();
				o.setId(rs.getInt("offer_id"));
				o.setAmt(rs.getInt("offer_amount"));
				o.setStatus(rs.getString("offer_status"));
				o.setCustomerId(rs.getInt("cust_id"));
				
				Item i = new Item();
				i.setId(rs.getInt("requested_item_id"));
				i.setName(rs.getString("item_name"));
				i.setDescription(rs.getString("item_description"));
				i.setAvailability(rs.getInt("item_availability"));
				
				o.setRequestedItem(i);
				
				offers.add(o);				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return offers;
	}
	
//	@Override
//	public List<Offer> retrieveOffersByRequested_ItemId(int requested_item_id) {
//		String sql = "select o.offer_id, o.cust_id, o.offer_amount, o.offer_status, o.requested_item_id, i.item_name, i.item_description, i.item_availability from offers o join items i on o.requested_item_id = i.item_id where requested_item_id = ?;";
//		List<Offer> offers = new ArrayList<>();
//		
//		try (Connection c = ConnectionUtil.getConnectionFromEnv()) {
//			PreparedStatement ps = c.prepareStatement(sql);
//			
//			ps.setInt(1, requested_item_id);
//			
//			ResultSet rs = ps.executeQuery();
//			
//			while (rs.next()) {
//				Offer o = new Offer();
//				o.setId(rs.getInt("offer_id"));
//				o.setAmt(rs.getInt("offer_amount"));
//				o.setStatus(rs.getString("offer_status"));
//				o.setCustomerId(rs.getInt("cust_id"));
//				
//				Item i = new Item();
//				i.setId(rs.getInt("requested_item_id"));
//				i.setName(rs.getString("item_name"));
//				i.setDescription(rs.getString("item_description"));
//				i.setAvailability(rs.getInt("item_availability"));
//				
//				o.setRequestedItem(i);
//				
//				offers.add(o);				
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return offers;
//	}

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
	public boolean updateOffer(int offer_id) {
		String sql = "update offers set offer_status = ? where offer_id = ?;";
		int rowsChanged = -1;
		
		try (Connection c = ConnectionUtil.getConnectionFromEnv()){
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, "accepted");
			ps.setInt(2, offer_id);
			
			rowsChanged = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (rowsChanged < 1) {
			return false;
		}
				
		return true;
	}	

//	@Override //was used while testing functionality and setting up the system for automated offer rejection
//	public boolean updateOffer(int offer_id) {
//		String sql = "update offers set offer_status = ? where offer_id = ?;";
//		int rowsChanged = -1;
//		
//		try (Connection c = ConnectionUtil.getConnectionFromEnv()){
//			PreparedStatement ps = c.prepareStatement(sql);
//			ps.setString(1, "pending");
//			ps.setInt(2, offer_id);
//			
//			rowsChanged = ps.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		if (rowsChanged < 1) {
//			return false;
//		}
//				
//		return true;
//	}

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

	@Override
	public boolean rejectOffer(int itemId) {
		String sql = "update offers set offer_status = ? where requested_item_id = ? and offer_status = 'pending';";
		int rowsChanged = -1;
		
		try (Connection c = ConnectionUtil.getConnectionFromEnv()){
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, "rejected");
			ps.setInt(2, itemId);
			rowsChanged = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (rowsChanged < 1) {
			return false;
		}
				
		return true;
	}
}
