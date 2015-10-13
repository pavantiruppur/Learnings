package com.test.hackerrank;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class PopularDestination {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int _count;
		_count = Integer.parseInt(in.nextLine());

		OutputMostPopularDestination(_count, in);

	}
	
	static void OutputMostPopularDestination(int count, Scanner in) {
		Map<String, Integer> destinationMap = new HashMap<>();
		String destination = "";
		int maxCount = 0;
		Set<String> maxSearchedDestinations = new HashSet<>();
		for(int i = 0; i < count; i++){
			destination = in.nextLine();
			Integer destinationCount = destinationMap.get(destination);
			if(destinationCount == null){
				destinationCount = 0;
			}
			
			destinationMap.put(destination, ++destinationCount);
			if(destinationCount > maxCount){
				maxSearchedDestinations.clear();
				maxSearchedDestinations.add(destination);
				maxCount = destinationCount;
			} else if(destinationCount == maxCount){
				maxSearchedDestinations.add(destination);
			}
		}
		for(String mostSrcDestination : maxSearchedDestinations){
			System.out.println(mostSrcDestination);
		}
	}
}
