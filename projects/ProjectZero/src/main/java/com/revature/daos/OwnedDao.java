package com.revature.daos;

import java.util.List;

import com.revature.models.Owned;

public interface OwnedDao {
	Owned createOwned(Owned oi);
	Owned retrieveOwnedById(int owned_id);
	List<Owned> retrieveOwnedByUsername(Int id);
	boolean updateOwned(Owned oi);
}
