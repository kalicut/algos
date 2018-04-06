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

        @Override
        public String toString() {
            return "" + this.val;
        }
    }

    // BST root
    Node root;

    public void insert(int val) {
        root = insertRecursively(root, val);
    }

    private Node insertRecursively(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }

        if (val < root.val) {
            root.left = insertRecursively(root.left, val);
        } else {
            root.right = insertRecursively(root.right, val);
        }

        return root;
    }

    public void delete(int val) {
        deleteNode(this.root, val);
    }

    private void deleteNode(Node root, int val) {
        // 1 - find node to delete
        Node[] match = findNode(root, val);

        // 2 - no match found
        if (match == null)
            return;

        Node matchingNode = match[0];
        Node matchingNodeParent = match[1];

        // 3 - p is leaf node
        if (matchingNode.left == null && matchingNode.right == null) {
            if (matchingNodeParent == null) { //matching node is root
                root = null;
            } else if (matchingNodeParent.left == matchingNode) {
                matchingNodeParent.left = null;
            } else {
                matchingNodeParent.right = null;
            }
            return;
        }

        // 4 - only left child
        if (matchingNode.left != null && matchingNode.right == null) {
            if (matchingNodeParent == null) { //matching node is root
                root = matchingNode.left;
            } else if (matchingNodeParent.left == matchingNode) {
                matchingNodeParent.left = matchingNode.left;
            } else {
                matchingNodeParent.right = matchingNode.left;
            }
            return;
        }

        // 5 - only right child
        if (matchingNode.left == null && matchingNode.right != null) {
            if (matchingNodeParent == null) {
                root = matchingNode.right;
            } else if (matchingNodeParent.left == matchingNode) {
                matchingNodeParent.left = matchingNode.right;
            } else {
                matchingNodeParent.right = matchingNode.right;
            }
            return;
        }

        // 6 - both left/right children
        if (matchingNode.left != null && matchingNode.right != null) {
            Node succesorNode = findInorderSuccessor(matchingNode);
            matchingNode.val = succesorNode.val;

            // recursive call
            deleteNode(matchingNode.right, succesorNode.val);
        }

        return;
    }

    // 0 - matching node
    // 1 - matching node's parent
    private Node[] findNode(Node root, int val) {
        Node _cur = root;
        Node _parent = null;

        while (_cur != null) {
            if (_cur.val == val) {
                return new Node[] { _cur, _parent };
            } else {
                _parent = _cur;
                _cur = val < _cur.val ? _cur.left : _cur.right;
            }
        }

        return null;
    }

    private Node findInorderSuccessor(Node p) {
        Node n = p.right;
        while (n.left != null) {
            n = n.left;
        }
        return n;
    }

    

    public void inorder() {
        inorderRecursively(root);
    }

    private void inorderRecursively(Node root) {
        if (root == null) {
            return;
        }

        // left 
        inorderRecursively(root.left);
        System.out.println("-->" + root.val + "(" + root.left + "," + root.right + ")");

        // right
        inorderRecursively(root.right);
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
        bst.insert(140);
        bst.insert(105);
        bst.insert(110);
        bst.insert(145);

        bst.inorder();


        System.out.println("delete leaf node... 90");
        bst.delete(90);
        bst.inorder();

        System.out.println("delete inner node(has both left/right)... 20");
        bst.delete(20);
        bst.inorder();
        
        System.out.println("delete root... 100");
        bst.delete(100);
        bst.inorder();
    }
}