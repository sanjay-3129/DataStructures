package com.ds.binaryTree;

public class BinaryTreeByArray {

	private int[] arr;
	private int lastUsedIndex;

	@SuppressWarnings("unused")
	private BinaryTreeByArray() {
	}

	public BinaryTreeByArray(int size) {
		arr = new int[size + 1]; // bcs we store values from index 1
		lastUsedIndex = 0;
	}

	public void add(int value) {
		if (isTreeFull()) {
			System.out.println("Tree is full, cant add value's!!!");
			return;
		} else {
			lastUsedIndex++;
			arr[lastUsedIndex] = value;
		}
	}

	public void traverse(String order) {
		if (order.contains("pre")) {
			preOrderTraverse(1);
		} else if (order.contains("in")) {
			inOrderTraverse(1);
		} else if (order.contains("post")) {
			postOrderTraverse(1);
		} else { // level
			levelOrderTraverse();
		}
	}

	private void preOrderTraverse(int index) {
		if (index > lastUsedIndex) {
			return;
		}
		System.out.print(arr[index] + " ");
		preOrderTraverse(2 * index); // left
		preOrderTraverse(2 * index + 1);
	}

	private void inOrderTraverse(int index) {
		if (index > lastUsedIndex) {
			return;
		}
		inOrderTraverse(2 * index); // left
		System.out.print(arr[index] + " "); // root
		inOrderTraverse(2 * index + 1); // right
	}

	private void postOrderTraverse(int index) {
		if (index > lastUsedIndex) {
			return;
		}
		postOrderTraverse(2 * index); // left
		postOrderTraverse(2 * index + 1); // right
		System.out.print(arr[index] + " "); // root
	}

	private void levelOrderTraverse() {
		for (int i = 1; i <= lastUsedIndex; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public int search(int value) {
		for (int i = 1; i <= lastUsedIndex; i++) {
			if (arr[i] == value) {
				System.out.println(value + " exist in the tree!!!");
				return i;
			}
		}
		return -1;
	}

	public void delete(int value) {
		int location = search(value);

		if (location == -1) {
			System.out.println(value + " doesnt exist, cant delete");
			return;
		}
		arr[location] = arr[lastUsedIndex];
		lastUsedIndex--;
		System.out.println("Successfully deleted " + value + " from the Tree !");
	}

	public void deleteTree() {
		arr = null;
		lastUsedIndex = 0;
		System.out.println("Tree deleted!!!");
	}

	public boolean isTreeFull() {
		if (arr.length - 1 == lastUsedIndex) {
			return true;
		} else {
			return false;
		}
	}

	public int[] getArr() {
		return arr;
	}

	public void setArr(int[] arr) {
		this.arr = arr;
	}

	public int getLastUsedIndex() {
		return lastUsedIndex;
	}

	public void setLastUsedIndex(int lastUsedIndex) {
		this.lastUsedIndex = lastUsedIndex;
	}

}
