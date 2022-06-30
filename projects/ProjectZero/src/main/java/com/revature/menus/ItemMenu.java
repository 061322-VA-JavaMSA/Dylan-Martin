package com.revature.menus;

import java.util.List;
import java.util.Scanner;

import com.revature.models.Item;
import com.revature.services.ItemService;
import com.revature.services.UserService;

public class ItemMenu extends IMenu {

	public ItemMenu(UserService us) {
		super(us);
		// TODO Auto-generated constructor stub
	}

	static Scanner scan;
	static ItemService is;

	public void startItemMenu() {
		System.out.println("Welcome to the Items Menu!");
		System.out.println();
		startItemMenu1();
	}

	public void startItemMenu1() {
		scan = new Scanner(System.in);
		is = new ItemService();

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

		System.out.println(
				"Please select an option: " + "\n1: Make an offer on and item" + "\n2: Return to the Main Menu");
		String choice = "";
		choice = scan.nextLine();
		if (choice.equals("1")) {
			OfferMenu offerMenu = new OfferMenu(us);
			offerMenu.offerMenu();
		} else if (choice.equals("2")) {

			MainMenu mainMenu = new MainMenu(us);
			mainMenu.mainStart();
		}
	}
}