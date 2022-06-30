package com.revature.menus;

import java.util.List;
import java.util.Scanner;

import com.revature.models.Owned;
import com.revature.services.OwnedService;
import com.revature.services.UserService;

public class OwnedMenu extends IMenu {
	
	public OwnedMenu(UserService us) {
		super(us);
	}
	
	static Scanner scan;
	static OwnedService ois;
	
	
	public void startOwnedItems() {
		scan = new Scanner(System.in);
		ois = new OwnedService();
				
		System.out.println("Welcome to your purchases!");
		
		List<Owned> own = ois.getOwned(us.getCurrentUser().getId());
		
		System.out.println("            Your Items                  ");
		System.out.println("----------------------------------------");
		System.out.format("%4s  %-5s  %2s", "Purchase #" + "  |  ", "Item ID" + "  |  ", "Item Name" + "\n");
		System.out.println("----------------------------------------");
		System.out.println();
		
		for (int i = 0; i < own.size(); i++) {
			System.out.format("%7d  |  %-14s  |  %3s" + "\n", own.get(i).offer_id, own.get(i).item_id, own.get(i).item_name);
		}
		System.out.println();
		
		System.out.println("Please enter 1 to return to the Main Menu.");
		String back = "";
		back = scan.nextLine();
		if (back.equals("1")) {
			MainMenu mainMenu = new MainMenu(us);
			mainMenu.mainStart();
		}
	}

}
