package com.kalicut.datastructure.linkedlist;

import java.util.Hashtable;

public class SinglyLinkedList {
	int count;
	Node head;
	
	public void addAt(Node node, int position) {
		if (head==null) {
			head = node;
		} else if (position <= 0) {
			Node tmp = head;
			head = node;
			head.setNext(tmp);
		} else {
			position = position > count ? count : position;
			
			Node cur = head;
			for (int i=0; i<position-1; i++) {
				cur = cur.getNext();
			}
			
			Node _tmp = cur.getNext();
			cur.setNext(node);
			node.setNext(_tmp);
		}
		
		++count;
	}
	
	public void removeAt(int position) {
		position = position > count ? count : position;
		
		if (head==null) {
			return;
		} else if (position<=0) {
			head = head.getNext();
		} else {
			Node cur = head;
			for (int i=0; i<position-1; i++) {
				cur = cur.getNext();
			}
			
			cur.setNext(cur.getNext().getNext());
		}
		--count;
	}
	
	public void removeDups() {
		Node _outer = head;
		while (_outer!=null) {
			Node prev = _outer;
			Node cur = prev.getNext();
			
			while (cur!=null) {
				if (_outer.getValue()==cur.getValue()) {
					prev.setNext(cur.getNext());
				} 
				prev = cur;
				cur = cur.getNext();
			}
			
			_outer = _outer.getNext();
		}
	}
	
	public void removeDupsUsingExtraStorage() {
		Hashtable<Integer, Integer> hash = new Hashtable<Integer, Integer>();
		
		if (head==null) {
			return;
		}
		
		Node prev = head;
		Node cur = prev.getNext();
		while (cur!=null) {
			if(hash.containsKey(cur.getValue())) {
				prev.setNext(cur.getNext());
			} else {
				hash.put(cur.getValue(), 0);
			}
			prev = cur;
			cur = cur.getNext();
		}
	}
	
	public void reverseIteratively() {
		Node prev = null;
		Node cur = head;
		Node next = null;
		
		while (cur != null) {
			next = cur.getNext();
			cur.setNext(prev);
			prev = cur;
			cur = next;
		}
		head = prev;
	}
	
	public void reverseRecursively(Node curr, Node prev) {
		if (curr == null)
		{
			return;
		}
		reverseRecursively(curr.getNext(), curr);
		
		if (curr.getNext() == null)
		{
			head = curr;
		}
		
		curr.setNext(prev);
	}

	public boolean detectAndRemoveLoop(Node node) {
		Node slow = node;
		Node fast = node;
		
		while (slow!=null && fast!=null && fast.getNext()!=null) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
			
			if (slow==fast) {
				removeLoop(slow, node);
				return true;
			}
		}
		
		return false;
	}
	
	private void removeLoop(Node loop, Node head) {
		Node p1 = loop;
		Node p2 = loop;
		
		int num_of_nodes_in_loop = 1;
		while (p1.getNext() != p2) {
			p1 = p1.getNext();
			num_of_nodes_in_loop++;
		}				
		
		p1 = head;
		p2 =  head;
		for(int i=0; i<num_of_nodes_in_loop; i++) {
			p2 = p2.getNext();
		}
		
		while (p1!=p2) {
			p1 = p1.getNext();
			p2 = p2.getNext();
		}
		
		System.out.println(p2);
		
		while(p2.getNext()!=p1) {
			p2 = p2.getNext();
		}
		p2.setNext(null);
		
		displayLL();
	}
	
	public int getCount() {
		return count;
	}
	
	public void displayLL() {
		//System.out.print("[size=" + count +"]");
		Node cur = head;
		while (cur!=null) {
			System.out.print("->" + cur.getValue());
			cur = cur.getNext();
		}
		System.out.println();
	}
	
	
	public static void main(String []args) {
		/*
		SinglyLinkedList slList = new SinglyLinkedList();
		
		slList.addAt(new Node(10), 0);
		slList.addAt(new Node(100), -10);
		slList.addAt(new Node(5), 1);
		slList.addAt(new Node(5), 11);
		slList.addAt(new Node(15), 5);
		
		slList.displayLL();

		slList.removeAt(3);
		slList.displayLL();

		slList.addAt(new Node(65), 3);
		slList.addAt(new Node(6), 1);
		slList.displayLL();
		
		slList.removeAt(0);
		slList.addAt(new Node(65), 1);
		slList.displayLL();

		//slList.removeDups();
		slList.removeDupsUsingExtraStorage();
		slList.displayLL();
		
		slList.reverseIteratively();
		slList.displayLL();
		
		slList.reverseRecursively(slList.head, null);
		slList.displayLL();
		*/
		SinglyLinkedList slList = new SinglyLinkedList();
		slList.head = new Node(10);
		slList.head.setNext(new Node(20));
		slList.head.getNext().setNext(new Node(30));
		slList.head.getNext().getNext().setNext(new Node(40));
		slList.head.getNext().getNext().getNext().setNext(new Node(50));
		slList.head.getNext().getNext().getNext().getNext().setNext(new Node(60));
		slList.head.getNext().getNext().getNext().getNext().getNext().setNext(new Node(70));
		slList.head.getNext().getNext().getNext().getNext().getNext().getNext().setNext(new Node(80));
		slList.head.getNext().getNext().getNext().getNext().getNext().getNext().getNext().setNext(new Node(90));
		
		slList.head.getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().setNext(slList.head.getNext().getNext().getNext());
		
		System.out.println(slList.detectAndRemoveLoop(slList.head));
		
		
		
		
	}
}
