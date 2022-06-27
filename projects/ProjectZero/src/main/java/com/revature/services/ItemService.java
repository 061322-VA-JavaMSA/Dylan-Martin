package com.revature.services;

import java.util.List;

import com.revature.daos.ItemDao;
import com.revature.daos.ItemPostgres;
import com.revature.models.Item;

public class ItemService {
	
	private ItemDao i = new ItemPostgres();
	
	public List<Item> getItems(){
		return i.retrieveItems();
	}
	
	public Item getItemByID(int item_id){		
		return i.retrieveItemByID(item_id);
	}

}
