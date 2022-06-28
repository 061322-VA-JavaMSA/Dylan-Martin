package com.revature.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.daos.ItemDao;
import com.revature.daos.ItemPostgres;
import com.revature.models.Item;

public class ItemService {
	
	private ItemDao id = new ItemPostgres();
	private static Logger log = LogManager.getLogger(ItemService.class);
	
	public List<Item> getItems(){
		return id.retrieveItems();
	}
	
	public Item getItemByID(int item_id){		
		return id.retrieveItemByID(item_id);
	}
	
	public Item createItem(Item i) {
		Item item = id.createItem(i);
		log.info("Item: " + item + "was created");
		return item;
	}
	
	public boolean deleteItemByID(Item itemTBD) {
		return false;
		
	}
	
	Item retrieveItemsByItem_Name(String item_name) {
		return id.retrieveItemsByItem_Name(item_name);
	}
}
