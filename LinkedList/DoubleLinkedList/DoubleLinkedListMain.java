package com.ds.linkedlist;

// import java.util.LinkedList;

public class DoubleLinkedListMain {

	public static void main(String[] args) {
//		LinkedList<String> list = new LinkedList<String>();
//		list.add(-1, "hi");
//		System.out.println(list.size());
//		
		// create linked list
		DoubleLinkedList<String> list = new DoubleLinkedList<>();
		// now i can work on any type

		// insert elements
		list.add("10");
		list.add("15");
		list.add("20");
		list.add("25");

		list.traverseLinkedList();
		list.reverseLinkedList();

		list.add(0, "5");
		list.traverseLinkedList();
		list.reverseLinkedList();
		
		list.add(2, "33");
		list.traverseLinkedList();
		list.reverseLinkedList();

		list.add(8, "100");
		list.traverseLinkedList();
		list.reverseLinkedList();

		// search
		System.out.println("Search:");
		list.contains("25");
		list.contains("101");
		
		// delete elements
		System.out.println("Delete Item:");
		list.deleteNode();
		list.traverseLinkedList();
		list.reverseLinkedList();
		list.deleteNode(0);
		list.traverseLinkedList();
		list.reverseLinkedList();
		list.deleteNode(2);
		list.traverseLinkedList();
		list.reverseLinkedList();
		list.deleteNode(10);
		list.traverseLinkedList();
		list.reverseLinkedList();
		
		// delete SLL
		System.out.println("Delete linked list: ");
		list.deleteSLL();
		System.out.println("size: " + list.getSize());
	}

}
