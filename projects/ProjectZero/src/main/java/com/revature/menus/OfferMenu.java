package com.revature.menus;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.models.Item;
import com.revature.models.Offer;
import com.revature.services.ItemService;
import com.revature.services.OfferService;
import com.revature.services.UserService;

public class OfferMenu extends IMenu {
		
	public OfferMenu(UserService us) {
		super(us);
		// TODO Auto-generated constructor stub
	}

	static Scanner scan;
	static ItemService is;
	static OfferService os;
	
	private static Logger log = LogManager.getLogger(OfferMenu.class);
	
	public void offerMenu() {
		
		scan = new Scanner(System.in);
		is = new ItemService();	
		os = new OfferService();
		
		System.out.println();
		System.out.println("Please enter an item id to make an offer on an item:");
		
		int item_id = Integer.parseInt(scan.nextLine());
		Item getItems = is.getItemByID(item_id);
			System.out.println("You have selected the item " + getItems.getName() + ", please enter your offer amount.");
			int oamt = Integer.parseInt(scan.nextLine());
			Offer offerTBC = new Offer();
			offerTBC.setRequestedItemId(item_id);
			offerTBC.setAmt(oamt);
			offerTBC.setCustomerId(getCurrentUser().getId());
			log.info(os.createOffer(offerTBC));
			
			System.out.println("Your offer for $" + oamt + " has been created and is awaiting review by an Employee.");
			System.out.println("You will now be returned to the item menu.");
			
			ItemMenu itemMenu = new ItemMenu(us);
			itemMenu.startItemMenu1();
	}

}