package com.test.sorting;

public class SwappingWorkouts {

	public static void main(String[] args) {
		
		int[] arr = new int[100];
		for(int i = 0; i < arr.length; i++){
			arr[i] = (int) (Math.random() * 100);
		}
		long startTime;
		long endTime;
		startTime = System.nanoTime();
		for(int i = 0; i<arr.length; i++){
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
		}
		endTime = System.nanoTime();
		System.out.println("With Temp variable = "+ (endTime - startTime) +"ns");
		startTime = System.nanoTime();
		for(int i = 0; i<arr.length; i++){
			// a = a + b;
			arr[0] = arr[0] + arr[i];
			// b = a - b;
			arr[i] = arr[0] - arr[i];
			// a = a - b;
			arr[0] = arr[0] - arr[i];
		}
		endTime = System.nanoTime();
		System.out.println("Without Temp variable = "+ (endTime - startTime) +"ns");
	}
}
