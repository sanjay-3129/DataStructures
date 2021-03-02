package com.ds.binaryTree;

public class BinaryTreeByArrayMain {
	
	public static void main(String[] args) {
		BinaryTreeByArray tree = new BinaryTreeByArray(5);
		tree.add(10);
		tree.add(20);
		tree.add(30);
		tree.traverse("pre");
		System.out.println();
		tree.traverse("in");
		System.out.println();
		tree.traverse("post");
		System.out.println();
		tree.traverse("level");
		System.out.println();
		System.out.println();
		
		tree.add(40);
		tree.add(50);
		tree.traverse("pre");
		System.out.println();
		tree.traverse("in");
		System.out.println();
		tree.traverse("post");
		System.out.println();
		tree.traverse("level");
		System.out.println();
		System.out.println();
		
		tree.add(100);
		tree.traverse("pre");
		System.out.println();
		tree.traverse("in");
		System.out.println();
		tree.traverse("post");
		System.out.println();
		tree.traverse("level");
		System.out.println();
		System.out.println();
		
		tree.search(40);
		tree.delete(10);
		tree.traverse("pre");
		System.out.println();
		tree.traverse("in");
		System.out.println();
		tree.traverse("post");
		System.out.println();
		tree.traverse("level");
		System.out.println();
		System.out.println();
		
		tree.delete(50);
		tree.traverse("pre");
		System.out.println();
		tree.traverse("in");
		System.out.println();
		tree.traverse("post");
		System.out.println();
		tree.traverse("level");
		System.out.println();
		System.out.println();

		tree.deleteTree();
	}

}
