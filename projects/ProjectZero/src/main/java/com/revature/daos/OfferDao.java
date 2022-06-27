package com.revature.daos;

import java.util.List;

import com.revature.models.Offer;

public interface OfferDao {
	Offer createOffer(Offer o);
	Offer retrieveOfferById(int offer_id);
	List<Offer> retrieveOffers();
	Offer retrieveOffersByOfferAmount(int offer_amount);
	Offer retrieveOffersByOfferStatus(String offer_status);
	boolean updateOffer(Offer o);
	boolean deleteOfferByID(int offer_id);
}
