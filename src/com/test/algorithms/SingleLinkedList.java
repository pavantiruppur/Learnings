/*
 * Copyright 2015 Mindtree Ltd, Inc. All rights reserved.Mindtree proprietary/confidential. Use is subject to license terms.
 */
package com.test.algorithms;


/**
 * Test - SingleLinkedList.java, 25-Jul-2015, 6:07:15 pm
 * @author <a href="mailto:M1028326@mindtree.com">Pavan</a>
 */

public class SingleLinkedList<T> {
	
	private int size;
	private T value;
	private SingleLinkedList<T> nextNode;
	
	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}
	
	/**
	 * @return the value
	 */
	public T getValue() {
		return value;
	}
	
	/**
	 * @param value the value to set
	 */
	public void setValue(T value) {
		this.value = value;
	}
	
	/**
	 * @return the nextNode
	 */
	public SingleLinkedList<T> getNextNode() {
		return nextNode;
	}
	
	/**
	 * @param nextNode the nextNode to set
	 */
	public void setNextNode(SingleLinkedList<T> nextNode) {
		this.nextNode = nextNode;
	}
}
