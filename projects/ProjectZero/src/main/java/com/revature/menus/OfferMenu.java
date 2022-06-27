package com.revature.menus;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.models.Item;
import com.revature.models.Offer;
import com.revature.services.ItemService;
import com.revature.services.OfferService;

public class OfferMenu {
	
	static Scanner scan;
	static ItemService is;
	static OfferService os; 
	
	private static Logger log = LogManager.getLogger(OfferMenu.class);
	
	public static void offerMenu() {
		
		scan = new Scanner(System.in);
		is = new ItemService();	
		os = new OfferService();
		
		int item_id = Integer.parseInt(scan.nextLine());
		Item getItems = is.getItemByID(item_id);
			System.out.println("You have selected the item " + getItems.getName() + ", please enter your offer amount.");
			int oamt = Integer.parseInt(scan.nextLine());
			Offer offerTBC = new Offer();
			offerTBC.setAmt(oamt);
			log.info(os.createOffer(offerTBC));
			
			System.out.println("Your offer for $" + oamt + " has beem created and is awaiting review by an Employee.");
			System.out.println("You will now be returned to the item menu.");
			
			ItemMenu.startItemMenu();
	}

}
