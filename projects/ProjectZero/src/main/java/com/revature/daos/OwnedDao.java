package com.revature.daos;

import java.util.List;

import com.revature.models.Owned;

public interface OwnedDao {
	List<Owned> retrieveOwned(int id);
}
