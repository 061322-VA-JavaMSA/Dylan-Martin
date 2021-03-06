package com.revature.daos;

import java.util.List;

import com.revature.models.Offer;

public interface OfferDao {
	Offer createOffer(Offer o);
	Offer retrieveOfferById(int offer_id);
	List<Offer> retrieveOffers();
	List<Offer>	retrieveOffersByItemId(int item_id);
	Offer retrieveOffersByOfferAmount(int offer_amount);
	Offer retrieveOffersByOfferStatus(String offer_status);
	boolean deleteOfferByID(int offer_id);
	boolean updateOffer(int offer_id);
	boolean rejectOffer(int item_id);
}
