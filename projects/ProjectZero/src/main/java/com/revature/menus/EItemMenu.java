package com.revature.menus;

import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.models.Item;
import com.revature.services.ItemService;
import com.revature.services.UserService;

public class EItemMenu extends IMenu {

	public EItemMenu(UserService us) {
		super(us);
		// TODO Auto-generated constructor stub
	}

	static Scanner scan;
	static ItemService is;

	private static Logger log = LogManager.getLogger(EItemMenu.class);

	public void eItemMenu() {
		System.out.println("Welcome to the Items Menu!");
		System.out.println();
		EItemMenu eItemMenu1 = new EItemMenu(us);
		eItemMenu1.eItemMenu1();
	}

	public void eItemMenu1() {
		scan = new Scanner(System.in);
		is = new ItemService();

		// *********Display the item list***********

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

		System.out.println("Please select the option: " + "\n1: Add a new Item" + "\n2: Remove an Item"
				+ "\n3: Return to the employee menu");

		String choice = "";
		choice = scan.nextLine();
		if (choice.equals("1")) {

			System.out.println("Please enter the item name:");
			String iname = scan.nextLine();
			System.out.println("Please enter a description for the item:");
			String idesc = scan.nextLine();
			System.out.println("Please enter the item's availability");
			int istate = Integer.parseInt(scan.nextLine());
			Item itemTBC = new Item();
			itemTBC.setName(iname);
			itemTBC.setDescription(idesc);
			itemTBC.setAvailability(istate);
			log.info(is.createItem(itemTBC));
			EItemMenu eItemMenu1 = new EItemMenu(us);
			eItemMenu1.eItemMenu1();

		} else if (choice.equals("2")) {
			System.out.println("Please enter the Id for the item to be removed");
			int iid = Integer.parseInt(scan.nextLine());
			;
			Item itemTBD = new Item();
			itemTBD.setId(iid);
			log.info(is.deleteItemByID(itemTBD));
			EItemMenu eItemMenu1 = new EItemMenu(us);
			eItemMenu1.eItemMenu1();

		} else if (choice.equals("3")) {
			EmployeeMenu employeeMenu = new EmployeeMenu(us);
			employeeMenu.employeeMenu();
			scan.close();
		}
	}

}
