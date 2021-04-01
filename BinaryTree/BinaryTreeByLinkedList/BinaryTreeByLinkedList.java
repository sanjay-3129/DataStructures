package com.ds.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

import com.ds.nodes.BinaryNode;

public class BinaryTreeByLinkedList<T> {
	BinaryNode<T> root;

	public BinaryTreeByLinkedList() {
		this.root = null;
	}

	public void insert(T value) {
		BinaryNode<T> temp = new BinaryNode<>();
		temp.setData(value);
		if (root == null) {
			root = temp;
			System.out.println("Successfully inserted new node at Root!");
			return;
		}
		Queue<BinaryNode<T>> queue = new LinkedList<BinaryNode<T>>();
		queue.add(root);
		while (!queue.isEmpty()) {
			BinaryNode<T> presentNode = queue.remove();
			if (presentNode.getLeft() == null) {
				presentNode.setLeft(temp);
				System.out.println("Successfully inserted new node !");
				break;
			} else if (presentNode.getRight() == null) {
				presentNode.setRight(temp);
				System.out.println("Successfully inserted new node !");
				break;
			} else {
				queue.add(presentNode.getLeft());
				queue.add(presentNode.getRight());
			}
		}
	}

	public void search(T value) {
		Queue<BinaryNode<T>> queue = new LinkedList<BinaryNode<T>>();
		queue.add(root);
		while (!queue.isEmpty()) {
			BinaryNode<T> presentNode = queue.remove();
			if (presentNode.getData().equals(value)) {
				System.out.println("Value-" + value + " is found in Tree !");
				return;
			} else {
				if (presentNode.getLeft() != null) {
					queue.add(presentNode.getLeft());
				}
				if (presentNode.getRight() != null) {
					queue.add(presentNode.getRight());
				}
			}
		}
		System.out.println("Value-" + value + " is not found in Tree !");
	}

	public void deleteNodeOfBinaryTree(T value) {
		Queue<BinaryNode<T>> queue = new LinkedList<BinaryNode<T>>();
		queue.add(root);
		while (!queue.isEmpty()) {
			BinaryNode<T> presentNode = queue.remove();
			if (presentNode.getData().equals(value)) {
				presentNode.setData(getDeepestNode().getData());
				deleteDeepestNode();
				System.out.println("Deleted the node !!");
				return;
			} else {
				if (presentNode.getLeft() != null) {
					queue.add(presentNode.getLeft());
				}
				if (presentNode.getRight() != null) {
					queue.add(presentNode.getRight());
				}
			}
		}
		System.out.println("Did not find the node!!");
	}

	public void deleteDeepestNode() {
		Queue<BinaryNode<T>> queue = new LinkedList<BinaryNode<T>>();
		queue.add(root);
		BinaryNode<T> previousNode, presentNode = null;
		while (!queue.isEmpty()) {
			previousNode = presentNode;
			presentNode = queue.remove();
			if (presentNode.getLeft() == null) {
				previousNode.setRight(null);
				return;
			} else if (presentNode.getRight() == null) {
				presentNode.setLeft(null);
				return;
			}
			queue.add(presentNode.getLeft());
			queue.add(presentNode.getRight());
		}
	}

	public BinaryNode<T> getDeepestNode() {
		Queue<BinaryNode<T>> queue = new LinkedList<BinaryNode<T>>();
		queue.add(root);
		BinaryNode<T> presentNode = null;
		while (!queue.isEmpty()) {
			presentNode = queue.remove();
			if (presentNode.getLeft() != null)
				queue.add(presentNode.getLeft());
			if (presentNode.getRight() != null)
				queue.add(presentNode.getRight());
		}
		return presentNode;
	}

	public void preOrderTraversal(BinaryNode<T> node) {
		if (node == null)
			return;
		System.out.print(node.getData() + " ");
		preOrderTraversal(node.getLeft());
		preOrderTraversal(node.getRight());
	}

	public void postOrderTraversal(BinaryNode<T> node) {
		if (node == null)
			return;
		preOrderTraversal(node.getLeft());
		preOrderTraversal(node.getRight());
		System.out.print(node.getData() + " ");
	}

	public void inOrderTraversal(BinaryNode<T> node) {
		if (node == null)
			return;
		preOrderTraversal(node.getLeft());
		System.out.print(node.getData() + " ");
		preOrderTraversal(node.getRight());
	}

	public void levelOrderTraversal() {
		Queue<BinaryNode<T>> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			BinaryNode<T> presentNode = queue.remove();
			System.out.println(presentNode.getData() + " ");
			if (presentNode.getLeft() != null)
				queue.add(presentNode.getLeft());
			if (presentNode.getRight() != null)
				queue.add(presentNode.getRight());
		}
	}

	public void deleteTree() {
		root = null;
		System.out.println("Binary Tree has been deleted successfully");
	}

}
