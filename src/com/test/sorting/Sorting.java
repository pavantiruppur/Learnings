package com.test.sorting;

public class Sorting {
	
	public static void main(String[] args) {
		int[] arr = {6,2,9,6,5};
		arr = sortAcen(arr);
		for(int value : arr){
			System.out.println(value);
		}
	}
	
	public static int[] sortAcen(int[] arr){
		
		for(int i = 0; i < arr.length - 1; i++){
			int j = i + 1;
			while(j < arr.length){
				if(arr[i] > arr[j]){
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
				j++;
			}
		}
		return arr;
	}
}
