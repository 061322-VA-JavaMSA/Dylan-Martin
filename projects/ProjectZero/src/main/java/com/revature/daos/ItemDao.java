package com.revature.daos;

import java.util.List;

import com.revature.models.Item;

public interface ItemDao {
	Item createItem(Item i);
	Item retrieveItemByID(int item_id);
	List<Item> retrieveItems();
	Item retrieveItemsByItem_Name(String item_name);
	boolean updateItem(Item i);
	boolean deleteItemById(int item_id);
} 