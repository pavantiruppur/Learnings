package com.test.sorting;

import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class SetWorkouts {
	
	public static void main(String[] args) {
		/**
		 * When you want an descending order from Set we can use NavigableSet
		 * which is the another parent of TreeSet implements the descendingSet() to return the 
		 * set in descending order.
		 */
		Set<String> st = new TreeSet<>();
		st.add("sdf");
		st.add("1sdf");
		st.add("asdf");
		st.add("zsdf");
		
		if(st instanceof Set<?>){
			System.out.println("Set");
		}
		
		if(st instanceof TreeSet){
			System.out.println("TreeSet");
		}
		
		NavigableSet<String> dst = (NavigableSet<String>)st;	
		System.out.println(dst.descendingSet());
	}

}
