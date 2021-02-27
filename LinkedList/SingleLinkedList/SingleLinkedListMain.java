package com.ds.linkedlist;

// import java.util.LinkedList;

public class SingleLinkedListMain {

	public static void main(String[] args) {
//		LinkedList<String> list = new LinkedList<String>();
//		list.add(-1, "hi");
//		System.out.println(list.size());
//		
		// create linked list
		SingleLinkedList<String> list = new SingleLinkedList<>();
		// now i can work on any type

		// insert elements
		list.add("10");
		list.add("15");
		list.add("20");
		list.add("25");

		list.traverseLinkedList();

		list.add(0, "5");
		list.traverseLinkedList();

		list.add(2, "33");
		list.traverseLinkedList();

		list.add(8, "100");
		list.traverseLinkedList();

		// search
		System.out.println("Search:");
		list.contains("25");
		list.contains("101");
		
		// delete elements
		System.out.println("Delete Item:");
		list.deleteNode();
		list.traverseLinkedList();
		list.deleteNode(0);
		list.traverseLinkedList();
		list.deleteNode(2);
		list.traverseLinkedList();
		list.deleteNode(10);
		list.traverseLinkedList();
		
		// delete SLL
		System.out.println("Delete linked list: ");
		list.deleteSLL();
		System.out.println("size: " + list.getSize());
	}

}
