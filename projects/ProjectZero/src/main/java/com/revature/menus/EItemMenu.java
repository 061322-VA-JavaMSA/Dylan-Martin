package com.revature.menus;

import java.util.List;
import java.util.Scanner;

import com.revature.models.Item;
import com.revature.services.ItemService;

public class EItemMenu {
	
	static Scanner scan;
	static ItemService is;
	
	public static void eItemMenu() {
		scan = new Scanner(System.in);
		is = new ItemService();
		
		System.out.println("Welcome to the Items Menu!");
		System.out.println();
		List<Item> items = is.getItems();
		
		System.out.println("Item ID |    Item Name    |   Item Description   |   Item Availability");
		System.out.println("======================================================================");
		for(int i = 0; i < items.size(); i++) {
			System.out.println("   " + items.get(i).getId() + "    : " + items.get(i).getName() +  "    | " + 
					items.get(i).getDescription() + "    |  " + items.get(i).getStatus());
		}
		
		System.out.println();
		System.out.println("Please select the option: "
				+ "\n1: Add a new Item"
				+ "\n2: Remove an Item"
				+ "\n3: Return to the employee menu");
	}

}
