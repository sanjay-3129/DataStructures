package com.ds.linkedlist;

import com.ds.nodes.DoubleNode;

public class DoubleLinkedList<T> {

	private DoubleNode<T> head;
	private DoubleNode<T> tail;
	private int size;

	// exists linked list
	public boolean existsLinkedList() {
		return head != null;
	}

	// add elements first or last
	public void add(T value) {
		DoubleNode<T> node = new DoubleNode<>();
		node.setData(value);
		// if size = 0 && linkedlist not exist
		if (size == 0 && !existsLinkedList()) { // set in head
			head = new DoubleNode<T>();

			node.setNext(null);
			node.setPrev(null);
			head = node;
			tail = node;
		} else { // size != 0, then add at last/tail
			node.setNext(null);
			node.setPrev(tail);
			tail.setNext(node);
			tail = node;
		}
		setSize(getSize() + 1); // incrementing by 1
	}

	// insert elements using index
	public void add(int index, T value) {
		// no linkedlist but index location is greater than 0
		boolean isLL = existsLinkedList();

		DoubleNode<T> node = new DoubleNode<>();
		node.setData(value);

		if (!isLL && (index > 0 || index < 0)) {
			// throw error
			throw new IndexOutOfBoundsException("Index: " + index + " Size: " + size);
		} else if (!isLL && index == 0) {
			head = new DoubleNode<T>();

			node.setNext(null);
			node.setPrev(null);
			head = node;
			tail = node;
		} else { // if linkedlist exists
			if (index == 0) { // insert at first position
				node.setPrev(null);
				node.setNext(head);
				head.setPrev(node);
				head = node;
			} else if (index >= size) { // insert at last
				node.setNext(null);
				node.setPrev(tail);
				tail.setNext(node);
				tail = node;
			} else { // insert anywhere between first and last
				DoubleNode<T> tempNode = head;
				int i = 0;
				while (i < index - 1) { // index-1: is need bcs we initially point to head which points to first element
					tempNode = tempNode.getNext();
					i++;
				}
				node.setNext(tempNode.getNext());
				node.setPrev(tempNode);
				tempNode.getNext().setPrev(node);
				tempNode.setNext(node);
			}
		}
		setSize(getSize() + 1); // atlast to add by one for wherever one value is added
	}

	// print all elements in linkedlist
	public void traverseLinkedList() {
		if (existsLinkedList()) {
			DoubleNode<T> tempNode = head;
			for (int i = 0; i < getSize(); i++) {
				System.out.print(tempNode.getData());
				if (i != getSize() - 1) {
					System.out.print(" -> ");
				}
				tempNode = tempNode.getNext();
			}
		} else {
			System.out.println("LinkedList not exist!!!");
		}
		System.out.println();
	}

	// print all elements in linkedlist
	public void reverseLinkedList() {
		if (existsLinkedList()) {
			DoubleNode<T> tempNode = tail;
			for (int i = 0; i < getSize(); i++) {
				System.out.print(tempNode.getData());
				if (i != getSize() - 1) {
					System.out.print(" -> ");
				}
				tempNode = tempNode.getPrev();
			}
		} else {
			System.out.println("LinkedList not exist!!!");
		}
		System.out.println();
	}

	public boolean contains(T searchItem) {
		if (existsLinkedList()) {
			DoubleNode<T> tempNode = head;
			for (int i = 0; i < getSize(); i++) {
				if (searchItem.equals(tempNode.getData())) {
					System.out.println("Found at location - " + i);
					return true;
				}
				tempNode = tempNode.getNext();
			}
		}
		System.out.println("Not found!!!");
		return false;
	}

	// delete last element
	public void deleteNode() {
		if (!existsLinkedList()) {
			throw new IndexOutOfBoundsException("No linked list is created to delete");
		} else {
			DoubleNode<T> tempNode = head;
			for (int i = 0; i < getSize() - 1; i++) {
				tempNode = tempNode.getNext();
			}
			if (tempNode == head) { // only one element in linkedlist
				head = tail = null;
				setSize(getSize() - 1);
				return;
			}
			tail = tail.getPrev();
			tail.setNext(null);
			setSize(getSize() - 1);
		}
	}

	// delete specified element
	public void deleteNode(int index) {
		if (!existsLinkedList()) {
			throw new IndexOutOfBoundsException("No linked list is created to delete");
		} else if (index == 0) { // deletion of first node
			head = head.getNext();
			head.setPrev(null);
			setSize(getSize() - 1);
			if (getSize() == 0) { // if it is only one element
				head = tail = null;
			}
		} else if (index >= getSize()) { // deletion of last node
			DoubleNode<T> tempNode = head;
			for (int i = 0; i < getSize() - 1; i++) {
				tempNode = tempNode.getNext();
			}
			if (tempNode == head) {
				head = tail = null;
				setSize(getSize() - 1);
				return;
			}
			tail = tail.getPrev();
			tail.setNext(null);
			setSize(getSize() - 1);
		} else { // deletion at middle
			DoubleNode<T> tempNode = head;
			int i = 0;
			while (i < index - 1) {
				tempNode = tempNode.getNext();
				i++;
			}
			tempNode.getNext().getNext().setPrev(tempNode);
			tempNode.setNext(tempNode.getNext().getNext());
			setSize(getSize() - 1);
		}
	}

	public void deleteSLL() {
		head = null;
		tail = null;
		System.out.println("Linked List Deleted");
	}

	public DoubleNode<T> getHead() {
		return head;
	}

	public void setHead(DoubleNode<T> head) {
		this.head = head;
	}

	public DoubleNode<T> getTail() {
		return tail;
	}

	public void setTail(DoubleNode<T> tail) {
		this.tail = tail;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

}
