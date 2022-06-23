package com.revature.services;

import java.util.List;

import com.revature.daos.TaskDao;
import com.revature.daos.TaskPostgres;
import com.revature.models.Task;

public class TaskService {

	private TaskDao td = new TaskPostgres();
	
	public List<Task> getTasksByUserId(int id){
		//
		return td.retrieveTasksByUserId(id);
	}
}