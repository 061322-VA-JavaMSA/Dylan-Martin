package com.revature.daos;

import java.util.List;

import com.revature.models.Items;

public interface ItemsDao {
	Items createItem(Items i);
	Items retrieveItemByID(int item_id);
	List<Items> retrieveItems();
	Items retrieveItemsByItem_Name(String item_name);
	boolean updateItem(Items i);
	boolean deleteItemById(int id);
} 