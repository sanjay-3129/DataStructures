package com.ds.stack;

public class StackByLinkedListMain {
	
	public static void main(String[] args) {
		StackByLinkedList<Integer> stack = new StackByLinkedList<Integer>();
		System.out.println("Push!!!");
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		stack.traverse();
		
		System.out.println("Pop!!!");
		int pop = stack.pop();
		System.out.println(pop + " element popped out of the stack!!!");
		stack.traverse();
		
		System.out.println("Peek!!!");
		stack.peek();
		stack.traverse();
		
		System.out.println("length!!!");
		int length = stack.length();
		System.out.println("length: " + length);
		
		System.out.println("Delete stack!!!");
		stack.deleteStack();
	}

}
