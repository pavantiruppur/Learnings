package com.test.performance;

public class ModuloTest {
	
	private static final int MAX_LIMIT = 1000;
	
    public static void main(String[] args) {
        final int size = 3;
        int index = 0;

        long start = System.nanoTime();
		for(int i = 0; i < MAX_LIMIT; i++) {
            System.out.println(getNextIndex(size, i));
        }
        long end = System.nanoTime();
        System.out.println("Time taken by Modulo (%) operator --> " + (end - start) + "ns.");

        start = System.nanoTime();
        final int shiftFactor = size - 1;
        for(int i = 0; i < 10; i++) {
        	System.out.println(getNextIndexBitwise(shiftFactor, i));
        }
        end = System.nanoTime();
        System.out.println("Time taken by bitwise AND --> " + (end - start) + "ns.");
    }

    private static int getNextIndex(int size, int nextInt) {
        return nextInt % size;
    }

    private static int getNextIndexBitwise(int size, int nextInt) {
        return nextInt & size;
    }
}
