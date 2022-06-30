package com.revature.menus;

import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.models.Item;
import com.revature.models.Offer;
import com.revature.services.ItemService;
import com.revature.services.OfferService;
import com.revature.services.OwnedService;
import com.revature.services.UserService;

public class EOfferMenu extends IMenu {

	public EOfferMenu(UserService us) {
		super(us);
		// TODO Auto-generated constructor stub
	}

	static Scanner scan;
	static OfferService os;
	static ItemService is;
	static OwnedService ois;
	static int requested_item_id;

	private static Logger log = LogManager.getLogger(EOfferMenu.class);

	public void eOfferMenu() {
		scan = new Scanner(System.in);
		os = new OfferService();
		is = new ItemService();
		ois = new OwnedService();

		List<Item> items = is.getItems();

		System.out.println("                             Items                                 ");
		System.out.println("-------------------------------------------------------------------");
		System.out.format("%4s  %-5s  %-10s  %-8s", "Item ID" + "  |  ", "Item Name" + "     |  ",
				"Item Description" + "     |  ", "Quantity" + "\n");
		System.out.println("-------------------------------------------------------------------");
		System.out.println();

		for (int i = 0; i < items.size(); i++) {
			System.out.format("%7d  |  %-15s  |  %-22s  |  %5s" + "\n", items.get(i).getId(), items.get(i).getName(),
					items.get(i).getDescription(), items.get(i).getAvailability());
		}

		System.out.println();

		System.out.println("Pull up offers for which item id?");
		int item_id = Integer.parseInt(scan.nextLine());
		int requested_item_id = item_id;
		List<Offer> offers = os.getOffersByItemId(item_id);
		System.out
				.println("                                             Offers                                       ");
		System.out
				.println("------------------------------------------------------------------------------------------");
		System.out.format("%4s  %-5s  %5s  %-8s  %5s", "Offer ID" + "  |  ", "Item ID" + "     |  ",
				"Offer Amt. in $" + "     |  ", "Offer Status" + "     |  ", "Customer ID" + "\n");
		System.out
				.println("------------------------------------------------------------------------------------------");
		System.out.println();

		for (int i = 0; i < offers.size(); i++) {
			System.out.format("%8d  |  %12s  |  %20s  |  %17s  |  %3s" + "\n", offers.get(i).getId(),
					offers.get(i).getId(), offers.get(i).getAmt(), offers.get(i).getStatus(),
					offers.get(i).getCustomerId());
		}

		System.out.println();

		System.out.println("Please enter 1 to choose an offer to accept or 2 to return to the previous menu.");
		String decide = "";
		decide = scan.nextLine();
		if (decide.equals("1")) {
			System.out.println("Please enter the offer id of the offer you would like to accept.");
			int offer_id = Integer.parseInt(scan.nextLine());
			Offer getOffers = os.getOfferById(offer_id);
			System.out.println("You have selected offer id " + getOffers.getId()
					+ ", please enter Y to accept the offer or N to go back.");
			String yayOrNay = "";
			yayOrNay = scan.nextLine();
			if (yayOrNay.equals("Y")) {
				os.updateOffer(offer_id);

				os.getOfferById(offer_id);
				os.rejectOffer(item_id);

				is.getItemByID(item_id);
				is.updateItem(item_id);

				System.out.println("The offer " + offer_id + " has been accepted, and other offers for item "
						+ requested_item_id + " have been rejected.");
				System.out.println();
				System.out.println("Returning to the main menu.");
				System.out.println();
				EmployeeMenu employeeMenu = new EmployeeMenu(us);
				employeeMenu.employeeMenu();
			} else if (yayOrNay.equals("N")) {
				EOfferMenu eOfferMenu = new EOfferMenu(us);
				eOfferMenu.eOfferMenu();
			} else if (decide.equals("2")) {
				System.out.println("Returning to the main menu.");
				EmployeeMenu employeeMenu = new EmployeeMenu(us);
				employeeMenu.employeeMenu();
			}
		}
	}
}
