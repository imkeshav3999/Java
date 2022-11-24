import java.util.*;

import javax.swing.tree.TreeNode;

public class tree {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int idx = -1;

        public Node buildTree(int nodes[]) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }
    }

    // O(n)
    // Root, left, right
    // DFS - depth First search
    public static void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // left, root, right
    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // left, right, root
    public static void postorder(Node root) {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    // BFS - breadth first search
    // Q.) find the sum of nodes at kth level?
    public static void levelOrder(Node root) {
        if (root == null) {
            return;
        }
        // queue is used for its FIFO property
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node currNode = q.remove();
            if (currNode == null) {
                System.out.println();
                // if last node
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(currNode.data + " ");
                if (currNode.left != null) {
                    q.add(currNode.left);
                }
                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        }
    }

    public static int countOfNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int leftNodes = countOfNodes(root.left);
        int rightNoeds = countOfNodes(root.right);
        return leftNodes + rightNoeds + 1;
    }

    public static int sumOfNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int leftSum = sumOfNodes(root.left);
        int rightSum = sumOfNodes(root.right);
        return leftSum + rightSum + root.data;
    }

    public static int heigthOfTree(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeigth = heigthOfTree(root.left);
        int rightHeight = heigthOfTree(root.right);
        int myHeigth = Math.max(leftHeigth, rightHeight) + 1;
        return myHeigth;
    }

    // O(n^2), Approach 1
    public static int diameter1(Node root) {
        if (root == null) {
            return 0;
        }
        int diam1 = diameter1(root.left);
        int diam2 = diameter1(root.right);
        int diam3 = heigthOfTree(root.left) + heigthOfTree(root.right) + 1;
        return Math.max(diam1, Math.max(diam2, diam3));
    }

    // O(n), Approach 2
    static class TreeInfo {
        int ht;
        int diam;

        TreeInfo(int ht, int diam) {
            this.ht = ht;
            this.diam = diam;
        }
    }

    public static TreeInfo diameter2(Node root) {
        if (root == null) {
            return new TreeInfo(0, 0);
        }
        TreeInfo left = diameter2(root.left);
        TreeInfo right = diameter2(root.right);

        int myHeigth = Math.max(left.ht, right.ht) + 1;

        int diam1 = left.diam;
        int diam2 = right.diam;
        int diam3 = left.ht + right.ht + 1;

        int myDiam = Math.max(diam1, Math.max(diam2, diam3));

        TreeInfo myInfo = new TreeInfo(myHeigth, myDiam);
        return myInfo;

    }

    public boolean isSubtree(Node root, Node subRoot) {
        if (subRoot) {

        }
    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println(root.data);
        preorder(root);
        System.out.println();
        inorder(root);
        System.out.println();
        postorder(root);
        System.out.println();
        levelOrder(root);
        System.out.println(countOfNodes(root));
        System.out.println(sumOfNodes(root));
        System.out.println(heigthOfTree(root));
        System.out.println(diameter1(root));
        System.out.println(diameter2(root).diam);
    }
}
