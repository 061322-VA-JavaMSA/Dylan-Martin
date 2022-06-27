package com.revature.services;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.daos.OfferDao;
import com.revature.daos.OfferPostgres;
import com.revature.models.Offer;

public class OfferService {
	
	private OfferDao od = new OfferPostgres();
	private static Logger log = LogManager.getLogger(OfferService.class);
	
	public List<Offer> getOffers() {
		return od.retrieveOffers();
	}
	
	public Offer createOffer(Offer o) {
		
		Offer offer = od.createOffer(o);
		log.info("Offer: " + offer + " was created.");
		return offer;
	}

}
