package com.revature.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.daos.OwnedDao;
import com.revature.daos.OwnedPostgres;
import com.revature.models.Owned;

public class OwnedService {
	
	public OwnedDao oid = new OwnedPostgres();
	private static Logger log = LogManager.getLogger(OwnedService.class);
	
	public Owned createOwned(Owned oi) {
		Owned own = oid.createOwned(oi);
		log.info("Owned item " + own + " has been created");
		return own;
	}
	
	public List<Owned> getOwned(int id) {
		return oid.retrieveOwned(id);
	}
	
	public List<Owned> getOwnedByItemId(int itemId) {
		return oid.retrieveOwnedByItemId(itemId);
	}
}
