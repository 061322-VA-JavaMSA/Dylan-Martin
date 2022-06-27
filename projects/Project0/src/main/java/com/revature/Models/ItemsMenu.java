package com.revature.models;

import java.util.List;
import java.util.Scanner;

import com.revature.services.ItemService;

public class ItemsMenu {
	
	static Scanner scan;
	static ItemService is;
	
	public static void startItemMenu() {
		scan = new Scanner(System.in);
		is = new ItemService();
		
		System.out.println("Welcome to the Items Menu!");
		List<Items> items = is.getItems();
		
		System.out.println("Item ID  |  	Item Name  	|  Item Description  |  Item Availability");
		System.out.println("=====================================================================================");
		for(int i = 0; i < items.size(); i++) {
			System.out.println(" " + items.get(i).getId() + " 	 :	" + items.get(i).getName() +  " 	| " + 
					items.get(i).getDescription() + " | " + items.get(i).getStatus());
		}
	}
}
