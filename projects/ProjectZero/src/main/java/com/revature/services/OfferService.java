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
	
	public List<Offer> getOffersByItemId(int item_id) {
		return	od.retrieveOffersByItemId(item_id);	
	}
	
//	public List<Offer> getOffersByRequested_ItemID(int requested_item_id){
//		return od.retrieveOffersByRequested_ItemId(requested_item_id);
//	}

	public Offer getOfferById(int offer_id) {		
		return od.retrieveOfferById(offer_id);
	}

	public boolean updateOffer(int offer_id) {
		boolean acceptedOffer = od.updateOffer(offer_id);
		log.info("Offer: " + acceptedOffer + " was updated.");
		return false;
	}

	public boolean rejectOffer(int item_id) {
		boolean rejectedOffer = od.rejectOffer(item_id);
		log.info("Offer: " + rejectedOffer + " was rejected.");
		return false;
	}
}