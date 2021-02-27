package com.ds.nodes;

public class SingleNode<T> {
	private T data;
	private SingleNode<T> next;

	public SingleNode() {
		super();
	}

	public SingleNode(T data, SingleNode<T> next) {
		super();
		this.data = data;
		this.next = next;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public SingleNode<T> getNext() {
		return next;
	}

	public void setNext(SingleNode<T> next) {
		this.next = next;
	}
}
