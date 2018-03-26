package com.kalicut.datastructure.linkedlist;

public class SortedLinkedList {
	int count;
	private Node head;
	
	public void add(Node newNode) {
		if (head == null || head.getValue() > newNode.getValue()) {
			newNode.setNext(head);
			head = newNode;
		} else {
			Node cur = head;

			while (cur.getNext() != null) {
				if(cur.getNext().getValue() < newNode.getValue()) {
					cur = cur.getNext();
				} else {
					break;
				}
			}
			
			newNode.setNext(cur.getNext());
			cur.setNext(newNode);
		}
		
		displayLL();
	}
	
	public void displayLL() {
		Node cur = head;
		while (cur!=null) {
			System.out.print("->" + cur.getValue());
			cur = cur.getNext();
		}
		System.out.println();
	}
	
	public static void main(String []args) {
		SortedLinkedList slList = new SortedLinkedList();
		
		slList.add(new Node(10));
		slList.add(new Node(100));
		slList.add(new Node(5));
		slList.add(new Node(15));
		slList.add(new Node(1));
	}
}
