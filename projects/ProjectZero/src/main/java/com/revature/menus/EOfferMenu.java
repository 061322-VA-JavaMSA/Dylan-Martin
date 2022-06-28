package com.revature.menus;

import java.util.List;
import java.util.Scanner;

import com.revature.models.Item;
import com.revature.models.Offer;
import com.revature.services.ItemService;
import com.revature.services.OfferService;
import com.revature.services.UserService;

public class EOfferMenu extends IMenu {
	
	public EOfferMenu(UserService us) {
		super(us);
		// TODO Auto-generated constructor stub
	}

	static Scanner scan;
	static OfferService os;
	static ItemService is;
	
	public void eOfferMenu() {
		scan = new Scanner(System.in);
		os = new OfferService();
		is = new ItemService();
		
		List<Item> items = is.getItems();
		
		System.out.println("Item ID |    Item Name    |   Item Description   |   Item Availability");
		System.out.println("======================================================================");
		for(int i = 0; i < items.size(); i++) {
			System.out.println("   " + items.get(i).getId() + "    : " + items.get(i).getName() + "    |  "  + items.get(i).getDescription() + " 	| " + items.get(i).getAvailability());
		}
		
		System.out.println("Pull up offers for which item id?");
		int item_id = Integer.parseInt(scan.nextLine());		
		List<Offer> offersForItem = os.getOffersByItemId(item_id);
		for(Offer o : offersForItem) {
			System.out.println(o);
		}
		
		System.out.println("Please enter 1 to choose an offer to accept or 2 to return to the previous menu.");
		String choice = "";
		choice = scan.nextLine();
		if (choice.equals("1")) {
			System.out.println("Please enter the offer id of the offer you would like to accept.");
			Int offer_id = Integer.parseInt(scan.nextLine());
		} else if (choice.equals("2"));
		EmployeeMenu employeeMenu = new EmployeeMenu(us);
		employeeMenu.employeeMenu();		
	}
}
