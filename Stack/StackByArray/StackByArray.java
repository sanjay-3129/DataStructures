package com.ds.stack;

public class StackByArray {
	
	int[] arr;
	int top;
	
	@SuppressWarnings("unused")
	private StackByArray() {
		// user should not use this, bcs he cant set size to the array
	}
	
	public StackByArray(int size) {
		this.arr = new int[size];
		this.top = -1;
		System.out.println("Stack Array created!!!");
	}
	
	public void push(int value) {
		if(isFull()) {
			System.out.println("Stack is full, cant push data: " + value);
		} else {
			top++;
			arr[top] = value;
			System.out.println("Successfully pushed: " + value);
		}
	}
	
	public void pop() {
		if(isEmpty()) {
			System.out.println("Stack is empty, cant pop elements!!!");
		} else {
			top--;
			System.out.println("popped out and new top is: " + arr[top]);
		}
	}
	
	public void peek() {
		if(isEmpty()) {
			System.out.println("Stack is empty!!! no data to peek!!!");
		} else {
			System.out.println("Top of stack: " + arr[top]);
		}
	}
	
	public void traverse() {
		for(int i=0; i<=top; i++) {
			System.out.print(arr[i] + " | ");
		}
	}
	
	public void reverse() {
		for(int i=top; i>=0; i--) {
			System.out.print(arr[i] + " | ");
		}
	}
	
	public void deleteStack() {
		top = -1;
		arr = null;
		System.out.println("Stack is successfully deleted");
	}
	
	public int length() {
		return top+1;
	}
	
	public boolean isFull() {
		return top == arr.length-1;
	}
	
	public boolean isEmpty() {
		return top == -1;
	}

}
