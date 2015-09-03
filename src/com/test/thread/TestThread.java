/*
 * Copyright 2015 Mindtree Ltd, Inc. All rights reserved.Mindtree proprietary/confidential. Use is subject to license terms.
 */
package com.test.thread;

/**
 * Test - TestThread.java, 18-Aug-2015, 12:15:28 pm
 * 
 * @author <a href="mailto:M1028326@mindtree.com">Pavan</a>
 */

public class TestThread implements Runnable{
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		try {
			test();
//			test1();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public synchronized void test() throws InterruptedException{
		String name = Thread.currentThread().getName();
		System.out.println(name + " method 1-1");
		System.out.println(name + " method 1-2");
		Thread.sleep(3000l);
		System.out.println(name + " method 1-3");
	}
	
	public synchronized void test1() throws InterruptedException{
		String name = Thread.currentThread().getName();
		System.out.println(name +" method 2-1");
		System.out.println(name +" method 2-2");
		Thread.sleep(3000l);
		System.out.println(name +"method 2-3");
	}
	
	public static void main(String[] args) throws InterruptedException {
		TestThread test = new TestThread();
		Thread t1 = new Thread(test);
		Thread t2 = new Thread(test);
		t1.start();
//		Thread.sleep(1000l);
//		String s = null;
//		if(s.equals("")){
//		}
//		t2.start();
	}
}
