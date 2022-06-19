package com.revature.oop.daos;

import java.io.Serializable;

import com.revature.oop.models.Task;

public interface TaskDAO extends Serializable, Cloneable {

	public abstract Task getTaskById(int id);
	Task addTask(Task newTask); // implicitly public and abstract
	default boolean deleteTask(int id) {
		return true;
	}
//	boolean deleteTask(int id);
}