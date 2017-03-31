package BST;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Aditya on 2017-03-30.
 */
public class BinarySearchTree {

    private static Node root;

    public static void main(String[] args) {
        createTree();

        int max = findMaxOfTree();
        System.out.println("Maximum of a tree is : " + max);

        int min = findMinOfTree();
        System.out.println("Minimum of a tree is : " + min);

        int height = findHeightOfTree(root);
        System.out.println("Height of Tree is : " + height);

        BFSTraversal();
        System.out.println();

        inorderTraversal(root);
        System.out.println();

        preorderTraversal(root);
        System.out.println();

        postorderTraversal(root);
        System.out.println();
    }

    private static void inorderTraversal(Node root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.getLeftChild());
        System.out.print(root.getData() + " ");
        inorderTraversal(root.getRightChild());
    }

    private static void preorderTraversal(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.getData() + " ");
        preorderTraversal(root.getLeftChild());
        preorderTraversal(root.getRightChild());
    }

    private static void postorderTraversal(Node root) {
        if (root == null) {
            return;
        }
        postorderTraversal(root.getLeftChild());
        postorderTraversal(root.getRightChild());
        System.out.print(root.getData() + " ");
    }

    private static void BFSTraversal() {
        Queue<Node> nodeList = new LinkedBlockingQueue<>();
        nodeList.add(root);
        while (nodeList.size() > 0) {
            Node node = nodeList.remove();
            System.out.print(node.getData() + " ");
            if (null != node.getLeftChild())
                nodeList.add(node.getLeftChild());
            if (null != node.getRightChild())
                nodeList.add(node.getRightChild());
        }
    }

    private static int findHeightOfTree(Node root) {
        if (null == root) {
            return -1;
        }
        int minValue = Math.max(findHeightOfTree(root.getLeftChild()), findHeightOfTree(root.getRightChild()));
        return minValue + 1;
    }

    private static int findMinOfTree() {
        Node rootNode = root;
        int min = 0;
        while (null != rootNode.getLeftChild()) {
            rootNode = rootNode.getLeftChild();
            min = rootNode.getData();
        }
        return min;
    }

    private static int findMaxOfTree() {
        Node rootNode = root;
        int max = 0;
        while (null != rootNode.getRightChild()) {
            rootNode = rootNode.getRightChild();
            max = rootNode.getData();
        }
        return max;
    }

    private static void createTree() {
        addNode(6);
        addNode(4);
        addNode(10);
        addNode(2);
        addNode(5);
        addNode(7);
        addNode(11);
        addNode(1);
        addNode(3);
        addNode(9);
        addNode(8);
    }

    private static void addNode(int data) {
        if (root == null) {
            root = new Node(data);
        } else {
            appendChild(root, data);
        }
    }

    private static void appendChild(Node root, int data) {
        if (data < root.getData()) {
            Node leftChildNode = root.getLeftChild();
            if (leftChildNode == null) {
                root.setLeftChild(new Node(data));
                return;
            }
            appendChild(leftChildNode, data);
        } else {
            Node rightChildNode = root.getRightChild();
            if (rightChildNode == null) {
                root.setRightChild(new Node(data));
                return;
            }
            appendChild(rightChildNode, data);
        }
    }
}
