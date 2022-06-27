package com.revature.services;

import java.util.List;
import java.util.logging.LogManager;

import org.apache.logging.log4j.Logger;

import com.revature.daos.ItemsDao;
import com.revature.daos.ItemsPostgres;
import com.revature.models.Items;
import com.revature.models.ItemsMenu;

public class ItemService {
	
	private ItemsDao i = new ItemsPostgres();
	
	public List<Items> getItems(){
		return i.retrieveItems();
	}

}
