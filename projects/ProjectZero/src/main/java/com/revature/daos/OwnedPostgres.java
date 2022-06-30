package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Owned;
import com.revature.util.ConnectionUtil;

public class OwnedPostgres implements OwnedDao {

	@Override
	public List<Owned> retrieveOwned(int id) {
		String sql = "SELECT\r\n" + "    C.customer_id,\r\n" + "    C.firstname,\r\n" + "    C.lastname,\r\n"
				+ "    O.offer_id,\r\n" + "    O.offer_amount,\r\n" + "    O.offer_status,\r\n" + "    I.item_name,\r\n"
				+ "    I.item_id,\r\n" + "    I.item_description\r\n" + "FROM offers O\r\n" + "JOIN customers C ON\r\n"
				+ "    C.customer_id = O.cust_id\r\n" + "JOIN items I ON\r\n"
				+ "    I.item_id = O.requested_item_id\r\n" + "WHERE 1=1\r\n" + "    AND\r\n"
				+ "    O.offer_status = 'accepted'\r\n" + "    AND\r\n" + "    C.customer_id = ?;";
		List<Owned> own = new ArrayList<>();

		try (Connection c = ConnectionUtil.getConnectionFromEnv()) {
			// no user input taken, no need for prepared statement
			PreparedStatement ps = c.prepareStatement(sql);

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Owned oi = new Owned();
				oi.item_name = rs.getString("item_name");
				oi.item_id = rs.getInt("item_id");
				oi.offer_id = rs.getInt("offer_id");

				own.add(oi);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return own;
	}

}
