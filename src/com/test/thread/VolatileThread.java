/*
 * Copyright 2015 Mindtree Ltd, Inc. All rights reserved.Mindtree proprietary/confidential. Use is subject to license terms.
 */
package com.test.thread;



/**
 * Test - VolatileThread.java, 21-Aug-2015, 3:48:50 pm
 * @author <a href="mailto:M1028326@mindtree.com">Pavan</a>
 */

public class VolatileThread implements Runnable {
	
	ThreadLocal<String> tLocal = new ThreadLocal<>();
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		tLocal.set(Thread.currentThread().getName());
		try {
			Thread.sleep(2000l);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+ " "+ tLocal.get());
	}
	
	private static class Employee{
		public String name;
	}
	
	public static void main(String[] args) throws InterruptedException {
		VolatileThread obj = new VolatileThread();
		Thread t1 = new Thread(obj); 
		Thread t2 = new Thread(obj);
		t1.start();
		Thread.sleep(500l);
		t2.start();
	}
	
}
