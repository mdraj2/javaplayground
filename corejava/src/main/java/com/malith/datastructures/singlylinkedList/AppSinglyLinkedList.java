package com.malith.datastructures.singlylinkedList;

public class AppSinglyLinkedList {
	
	public static void main(String[] args) {
		//create a new singlylinkedList
		SinglyLinkedList newList = new SinglyLinkedList();
		newList.push(7);
		newList.pop();
		newList.printNodeValues();
		newList.getLength();
	}

}
