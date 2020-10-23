package com.malith.datastructures.singlylinkedList;

import java.util.Objects;

public class SinglyLinkedList {
	
	private Node head;
	private Node tail;
	private int length = 0;
	
	public SinglyLinkedList push(int value) {
		//go to the tail
		//you could do this with the edge cases aswell
		if(this.length == 0) {
			Node newNode = new Node(value);
			this.head = newNode;
			this.tail = newNode;
		} else {
		
		Node newNode = new Node(value);
			this.tail.next = newNode;
			this.tail = newNode;
		}
		
		this.length++;
		return this;
	}
	
	public int pop() {
		//pop the value from the next of the list
		//we want to take the value of the node at the tail and update the tail to the previos node
		int valueToPop = this.tail.value;
		//you need to traverse the entire list and 
		Node currentNode = this.head;
		Node previousNode = this.head;
		while(Objects.nonNull(currentNode.next)) {
			previousNode = currentNode;
			currentNode = currentNode.next;
		}
		this.tail = previousNode;
		//but what if this.tail.next is null?
		if(Objects.isNull(this.tail.next)) {
			//do nothing? or rather what happens because now you do not have anything here.
			this.tail = null;
			this.head = null;
		} else {
			this.tail.next = null;
		}
		this.length--;
		if(Objects.isNull(this.tail)) {
			return 0;
		} else {
			return valueToPop;
		}
	}
	
	public SinglyLinkedList unshift(int value) {
		//go to the tail
		Node newNode = new Node(value);
		newNode.next = this.head;
		this.head = newNode;
		this.length++;
		return this;
	}
	
	public int shift() {
		//go to begining and get the head
		
		int value = this.head.value;
		//now move to this.head need to point to the this.head.next
		this.head = this.head.next;
		this.length--;
		//you add if condiftion when the length is 0 where the tail also becomes null.
		return value;
	}
	
	public void printNodeValues() {
		Node currentNode = head;
		while(Objects.nonNull(currentNode)) {
			System.out.println(currentNode.value);
			currentNode = currentNode.next;
		}
	}
	
	public int getLength() {
		System.out.println(this.length);
		return this.length;
	}
}
