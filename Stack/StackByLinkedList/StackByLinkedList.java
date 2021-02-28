package com.ds.stack;

import com.ds.linkedlist.SingleLinkedList;
import com.ds.nodes.SingleNode;

public class StackByLinkedList<T> {
	SingleLinkedList<T> list;  // previously created linkedlist and saved in linkedlist directory

	public StackByLinkedList() {
		list = new SingleLinkedList<T>();
	}

	// O(1)
	public void push(T value) {
		list.add(0, value);
		System.out.println(value + " added to stack!!!");
	}

	// O(1)
	public int pop() {
		int value = -1;
		if (isEmpty()) {
			System.out.println("Stack underflow error!!");
		} else {
			value = (int) list.getHead().getData();
			list.deleteNode(0); // delete at head to make it O(1)
		}
		return value;
	}

	// O(1)
	public void peek() {
		if (isEmpty()) {
			System.out.println("The stack is empty!!");
		} else {
			System.out.println("Peek element is: " + list.getHead().getData());
		}
	}

	// O(n)
	public void traverse() {
		traverse(list.getHead());
	}

	private void traverse(SingleNode<T> head) {
		if (head == null) {
			return;
		}
		traverse(head.getNext());
		System.out.print(head.getData() + " ");
	}

	public int length() {
		return list.getSize();
	}

	public boolean isEmpty() {
		if (list.getHead() == null)
			return true;
		else
			return false;
	}

	// O(1)
	public void deleteStack() {
		list.setHead(null);
		list = null;
		System.out.println("Stack deleted!!!");
	}

}
