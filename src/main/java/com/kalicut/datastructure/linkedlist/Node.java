package com.kalicut.datastructure.linkedlist;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Node {
	private int value;
	private Node next;
	
	public Node(int value) {
		this.value = value;
		this.next = null;
	}
	
	public String toString() {
		return "value = " + this.value;
	}
}
