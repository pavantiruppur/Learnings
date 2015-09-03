package com.test.algorithms;

public class SequenceSquare {
	
	private static final int MAX_LIMIT = 10000;

	public static void main(String[] args) {
		
		/**
		 * The Given problem is There are 100 doors and 100 people. The doors
		 * have two states (open/closed). All the doors are closed at first.
		 * Then the first person opens all the doors, the second person toggles
		 * the doors in multiples of 2 (e.g. door 2,4,6..). The third person
		 * toggles the doors in multiples of 3 (3,6,9...). This continues until
		 * person 100 toggles the door 100. So how many doors are open and how
		 * many are closed.
		 */
		boolean[] doors = new boolean[MAX_LIMIT];
		System.out.println("Total Time taken with 2 iteration = " + twoIteration(doors) +"ns");
		
		System.out.println("Total Time taken with 1 iteration = " + oneIteration(doors) +"ns");
		
		System.out.println("Total Time taken using sqrt = " + usingSqrt(doors) +"ns");
	}

	/**
	 * This approach is just changing only in perfect square root element.
	 * Since after all the persons finished toggles only perfect square root elements are in OPENED state.
	 * Because i th person toggles the door in j th iteration, the same door will be toggles by the j th person in i th iteration.
	 * So once it opened it will closed by pier.
	 * 
	 * But only the perfect square elements are toggles odd number of time, because i th and j th person and iteration are same so 
	 * only once it toggles the door. so it remains in the Open state.
	 * eg: for door number 16
	 * 		16 will be toggles by below persons
	 * 		1	2	4	8	16
	 * 		1 -- > opens will be closed by 16 ( 1 x 16 = 16 )
	 * 		2 -- > opens will be closed by 8 ( 2 x 8 = 16 )
	 * 
	 * 		whereas 4 x 4 = 16 , since both the number are 4 it toggles only once, so it remains OPEN.
	 * 
	 * Based on the above approach this below implementation is just changing/toggles the perfect square root elements value
	 * 
	 * So the time complexity of the below method is O(Sqrt of n) ie O(log n)
	 * @param doors
	 * @return
	 */
	private static long usingSqrt(boolean[] doors) {
		long startTime;
		long endTime;
		startTime = System.nanoTime();
		for(int i = 1; i * i <= doors.length; i++){
			doors[i*i - 1] = doors[i * i - 1] ? false : true;
		}
		endTime = System.nanoTime();
		return endTime - startTime;
	}

	/**
	 * This approach is to toggles the door by all the person in all the iterations
	 * eg: for door number 16 will be toggles every time when it is divisible by any of its below element
	 * 		ie: 1	2	4	8	16
	 * 
	 * So the time complexity of the below method is O(n log n)
	 * 
	 * @param doors
	 * @return
	 */
	private static long twoIteration(boolean[] doors) {
		long startTime = System.nanoTime();
		for(int i = 1; i <= doors.length; i++){
			for(int j = i; j <= doors.length; j+=i){
				doors[j-1] = doors[j-1] ? false : true;
			}
		}
		long endTime = System.nanoTime();
		return endTime - startTime;
	}

	/**
	 * This approach is to find the number of times a number is perfectly divisible and changes/toggles only in the 
	 * odd count doors. not in even count doors.
	 * this approach is also toggles only once in the OPEN state door.
	 * 
	 *  
	 *  So the time complexity of the below method is O(n log n)
	 *  Even this is also O(n log n) it has modulus % operation it is more costly than 2 iteration approach.
	 *  
	 * @param doors
	 * @return
	 */
	private static long oneIteration(boolean[] doors) {
		long startTime = System.nanoTime();
		for(int i = 1; i <= doors.length; i++){
			int count = 0;
			for(int j = 1; j <= i; j++){
				if(i % j == 0){
					count++;
				}
			}
			if(count % 2 != 0){
				doors[i-1] = doors[i-1] ? false : true;
			}
		}
		long endTime = System.nanoTime();
		return endTime - startTime;
	}
	
}
