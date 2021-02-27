package com.ds.linkedlist;

// SingleNode is in DataStructures/LinkedList/Node/SingleNode in github
import com.ds.nodes.SingleNode;

public class SingleLinkedList<T> {

	private SingleNode<T> head;
	private SingleNode<T> tail;
	private int size;

	// exists linked list
	public boolean existsLinkedList() {
		return head != null;
	}
	
	// add elements first or last
	public void add(T value) {
		SingleNode<T> node = new SingleNode<>();
		node.setData(value);
		node.setNext(null);
		// if size = 0 && linkedlist not exist
		if(size == 0 && !existsLinkedList()) {  // set in head
			head = new SingleNode<T>();
			
			head = node;
			tail = node;
		} else {    // size != 0, then add at last/tail
			tail.setNext(node);
			tail = node;
		}
		setSize(getSize()+1); // incrementing by 1
	}
	
	// insert elements using index
	public void add(int index, T value) {
		// no linkedlist but index location is greater than 0
		boolean isLL = existsLinkedList();
		
		SingleNode<T> node = new SingleNode<>();
		node.setData(value);
		
		if(!isLL && (index>0 || index<0)) {
			// throw error
			throw new IndexOutOfBoundsException("Index: " + index + " Size: " + size);
		} else if(!isLL && index == 0) {
			head = new SingleNode<T>();
			
			node.setNext(null);
			head = node;
			tail = node;
		} else {  // if linkedlist exists
			if(index == 0) {   // insert at first position
				node.setNext(head);
				head = node;
			} 
			else if(index >= size) {  // insert at last
				node.setNext(null);
				tail.setNext(node);
				tail = node;
			}
			else {   // insert anywhere between first and last
				SingleNode<T> tempNode = head;
				int i = 0;
				while(i < index - 1) {   // index-1: is need bcs we initially point to head which points to first element
					tempNode = tempNode.getNext();
					i++;
				}
				node.setNext(tempNode.getNext());
				tempNode.setNext(node);
			}
		}
		setSize(getSize()+1); // atlast to add by one for wherever one value is added
	}
	
	// print all elements in linkedlist
	public void traverseLinkedList() {
		if(existsLinkedList()) {
			SingleNode<T> tempNode = head;
			for(int i=0; i<getSize(); i++) {
				System.out.print(tempNode.getData());
				if(i != getSize()-1) {
					System.out.print(" -> ");
				}
				tempNode = tempNode.getNext();
			}
		} else {
			System.out.println("LinkedList not exist!!!");
		}
		System.out.println();
	}
	
	public boolean contains(T searchItem) {
		if(existsLinkedList()) {
			SingleNode<T> tempNode = head;
			for(int i=0; i<getSize(); i++) {
				if(searchItem.equals(tempNode.getData())) {
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
		if(!existsLinkedList()) {
			throw new IndexOutOfBoundsException("No linked list is created to delete");
		} else {
			SingleNode<T> tempNode = head;
			for(int i=0; i<getSize()-1; i++) {
				tempNode = tempNode.getNext();
			}
			if(tempNode == head) { // only one element in linkedlist
				head = tail = null;
				setSize(getSize()-1);
				return;
			}
			tempNode.setNext(null);
			tail = tempNode;
			setSize(getSize()-1);
		}
	}
	
	// delete specified element
	public void deleteNode(int index) {
		if(!existsLinkedList()) {
			throw new IndexOutOfBoundsException("No linked list is created to delete");
		}
		else if(index == 0) {   // deletion of first node
			head = head.getNext();
			setSize(getSize()-1);
			if(getSize() == 0) {  // if it is only one element
				tail = null;
			}
		}
		else if(index >= getSize()) {    // deletion of last node
			SingleNode<T> tempNode = head;
			for(int i=0; i<getSize()-1; i++) {
				tempNode = tempNode.getNext();
			}
			if(tempNode == head) {
				head=tail=null;
				setSize(getSize()-1);
				return;
			}
			tempNode.setNext(null);
			tail = tempNode;
			setSize(getSize()-1);
		}
		else {  // deletion at middle 
			SingleNode<T> tempNode = head;
			int i=0;
			while(i < index-1) {
				tempNode = tempNode.getNext();
				i++;
			}
			tempNode.setNext(tempNode.getNext().getNext());
			setSize(getSize()-1);
		}
	}
	
	public void deleteSLL() {
		head = null;
		tail = null;
		System.out.println("Linked List Deleted");
	}

	public SingleNode<T> getHead() {
		return head;
	}

	public void setHead(SingleNode<T> head) {
		this.head = head;
	}

	public SingleNode<T> getTail() {
		return tail;
	}

	public void setTail(SingleNode<T> tail) {
		this.tail = tail;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

}
