package com.kalicut.datastructure.tree;

public class BinarySearchTree {

    // node
    class Node {
        int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    // BST root
    Node root;

    public void insert(int val) {
        root = insertRecursively(root, val);
    }

    private Node insertRecursively(Node root, int val) {
        if ( root==null ) {
            root = new Node(val);
            return root;
        } 

        if ( val<root.val ) {
            root.left = insertRecursively(root.left, val);
        } else {
            root.right = insertRecursively(root.right, val);
        }

        return root;
    }

    public void inorder() {
        inorderRecursively(root);
    }

    private void inorderRecursively(Node root) {
        if ( root==null ) {
            return;
        }


    	// left 
        inorderRecursively(root.left);
        System.out.println(root.val);

        // right
        inorderRecursively(root.right);
        //System.out.println(root.val);
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        
        bst.insert(100);
        bst.insert(20);
        bst.insert(50);
        bst.insert(30);
        bst.insert(10);
        bst.insert(70);
        bst.insert(80);
        bst.insert(40);
        bst.insert(90);
        bst.insert(0);

        bst.inorder();
    }
}