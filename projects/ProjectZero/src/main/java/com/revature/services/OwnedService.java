package com.revature.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//import com.revature.daos.Int;
import com.revature.daos.OwnedDao;
import com.revature.models.Owned;
import com.revature.util.ConnectionUtil;

public class OwnedService implements OwnedDao {

	@Override
	public Owned createOwned(Owned oi) {
		String sql = "insert into ownedItems (requested_item_id, offer_amount, offer_status, cust_id) values (?,?,?,?) returning offer_id;";
		try (Connection c = ConnectionUtil.getConnectionFromEnv()){
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, o.getRequestedItemId());
			ps.setInt(2, o.getAmt());
			ps.setString(3, "pending");
			ps.setInt(4, o.getCustomerId());
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				oi.setId(rs.getInt("offer_id"));
				oi.setStatus("offer_status");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return oi;
	}

	@Override
	public Owned retrieveOwnedById(int owned_id) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public List<Owned> retrieveOwnedByUsername(Int id) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public boolean updateOwned(Owned oi) {
		// TODO Auto-generated method stub
		return false;
	}

}
