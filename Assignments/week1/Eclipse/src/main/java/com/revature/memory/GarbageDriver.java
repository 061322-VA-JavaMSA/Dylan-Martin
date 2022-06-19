package com.revature.memory;

public class GarbageDriver {

	public int id;
	public String name;
	
	public GarbageDriver(int id) {
		this.id = id;
	}
	public static void main(String[] args) {
		for(int i = 0; i < 1000; i++) {
			GarbageDriver gd = new GarbageDriver(i);
			
			System.gc();
		}
		
	}

	@Override
	protected void finalize() {
		System.out.println("id: " + id + " has been garbage collected.");
	}
}