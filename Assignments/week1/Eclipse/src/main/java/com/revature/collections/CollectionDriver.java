package com.revature.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

public class CollectionDriver {

	public static void main(String[] args) {


		int[] intArr = {1, 2, 3}; // fixed size
		System.out.println(intArr[2]);
		
		System.out.println();
		
//		ArrayList<Integer> al = new ArrayList<Integer>();
		List<Integer> al = new ArrayList<>();
		al.add(1);
		al.add(3);
		al.add(2);

		for(Integer i : al) {
			System.out.println(i);
		}
		
		System.out.println();
		
		// a common way to iterate over collections
		Iterator<Integer> i = al.iterator();
		//has next method that checks whether or not there is another element in the collection, next() returns it
		while(i.hasNext()) {
			System.out.println(i.next());
		}
		
		System.out.println();
		
		Set<String> hs = new HashSet<>();
		hs.add("Hello");
		hs.add("World");
		hs.add("World");
		
		Iterator<String> j = hs.iterator();
		while(j.hasNext()) {
			System.out.println(j.next());
		}
		
		System.out.println();
		
		Queue<Integer> ll = new LinkedList<>();
		ll.add(1);
		ll.add(2);
		ll.add(3);
		
		System.out.println(ll.peek());
		System.out.println(ll.poll());
		System.out.println(ll.poll());
		
		System.out.println();
		
		Map<Integer, String> hm = new HashMap<>();
		hm.put(1, "Hello");
		hm.put(2, "1");
		hm.put(500, "2");
		hm.put(42, "4");
		hm.put(-200, "3");
//		hm.put(null, "World");
		
		
		
		// retrieving a set (the keys) which can be iterated over
		for(Integer k : hm.keySet()) {
			System.out.println(hm.get(k));
		}
	}

}