package com.ds.stack;

public class StackByArrayMain {
	
	public static void main(String[] args) {
		StackByArray stack = new StackByArray(5);
		
		System.out.println("push!!!");
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		stack.traverse();
		System.out.println();
		stack.reverse();
		
		stack.push(100);
		
		System.out.println("pop!!!");
		stack.pop();
		stack.traverse();
		System.out.println();
		stack.reverse();
		
		stack.pop();
		stack.traverse();
		System.out.println();
		stack.reverse();
		
		stack.peek();
		stack.traverse();
		System.out.println();
		stack.reverse();
		
		int length = stack.length();
		System.out.println("length of stack: " + length);
		stack.deleteStack();
	}

}
