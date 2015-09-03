/*
 * Copyright 2015 Mindtree Ltd, Inc. All rights reserved.Mindtree proprietary/confidential. Use is subject to license terms.
 */
package com.test.thread;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

/**
 * Test - Test.java, 13-Aug-2015, 8:05:47 pm
 * 
 * @author <a href="mailto:M1028326@mindtree.com">Pavan</a>
 */

public class Serialize implements Serializable {
	
	public static String test = "asdf";
	public String te = "sdfasdfasdfasdfasdfasdfasdfasdf";
	
	
	/**
	 * 
	 */
	public Serialize() {
		throw new NullPointerException();
	}
	
	public static void main(String[] args) throws IOException {
		Serialize test = new Serialize();
		OutputStream file = new FileOutputStream("quarks.ser");
		OutputStream buffer = new BufferedOutputStream(file);
		ObjectOutput outputObject = new ObjectOutputStream(buffer);
		try {
			outputObject.writeObject(test);
			System.out.println(outputObject);
		} catch (IOException e) {
			
		} finally{
			outputObject.close();
		}
	}
}
