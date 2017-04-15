package BST;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Aditya on 2017-03-30.
 */
public class BinarySearchTree {

    public static void main(String[] args) {
        Node root = null;

        //root = createTree(root);
        root = createNonRecursiveTree(root);

        Node maxNode = findMaxOfTree(root);
        System.out.println("Maximum of a tree is : " + maxNode.getData());

        Node minNode = findMinOfTree(root);
        System.out.println("Minimum of a tree is : " + minNode.getData());

        int height = findHeightOfNode(root);
        System.out.println("Height of Tree is : " + height);

        int depth = findDepthOfNode(root, 6);
        System.out.println("Depth of Node " + 6 + " is : " + depth);

        BFSTraversal(root);
        System.out.println();

        root = deleteNodeFromTree(root, 2);
        inorderTraversal(root);
        System.out.println();

        preorderTraversal(root);
        System.out.println();

        postorderTraversal(root);
        System.out.println();
    }

    private static Node createTree(Node root) {
        root = addNode(6, root);
        root = addNode(4, root);
        root = addNode(10, root);
        root = addNode(2, root);
        root = addNode(5, root);
        root = addNode(7, root);
        root = addNode(11, root);
        root = addNode(1, root);
        root = addNode(3, root);
        root = addNode(9, root);
        root = addNode(8, root);
        return root;
    }

    private static Node addNode(int data, Node root) {
        if (root == null) {
            root = new Node(data);
        } else {
            appendChild(root, data);
        }
        return root;
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

    private static Node createNonRecursiveTree(Node root) {
        root = addNodeInTree(6, root);
        root = addNodeInTree(4, root);
        root = addNodeInTree(10, root);
        root = addNodeInTree(2, root);
        root = addNodeInTree(5, root);
        root = addNodeInTree(7, root);
        root = addNodeInTree(11, root);
        root = addNodeInTree(1, root);
        root = addNodeInTree(3, root);
        root = addNodeInTree(9, root);
        root = addNodeInTree(8, root);
        return root;
    }

    private static Node addNodeInTree(int data, Node root) {
        if (root == null) {
            return new Node(data);
        }
        Node current = root;
        Node parent = null;
        while (current != null) {
            parent = current;
            if (data <= current.getData()) {
                current = current.getLeftChild();
            } else {
                current = current.getRightChild();
            }
        }
        Node child = new Node(data);
        if (data <= parent.getData()) {
            parent.setLeftChild(child);
        } else {
            parent.setRightChild(child);
        }
        return root;
    }

    private static Node findMaxOfTree(Node rootNode) {
        while (null != rootNode.getRightChild()) {
            rootNode = rootNode.getRightChild();
        }
        return rootNode;
    }

    private static Node findMinOfTree(Node rootNode) {
        while (null != rootNode.getLeftChild()) {
            rootNode = rootNode.getLeftChild();
        }
        return rootNode;
    }

    private static int findHeightOfNode(Node root) {
        if (null == root) {
            return -1;
        }
        int minValue = Math.max(findHeightOfNode(root.getLeftChild()), findHeightOfNode(root.getRightChild()));
        return minValue + 1;
    }

    private static int findDepthOfNode(Node root, int data) {
        if (root.getData() == data) {
            return 0;
        }
        int depth = 0;
        while (root.getData() != data) {
            if (data < root.getData()) {
                root = root.getLeftChild();
            } else {
                root = root.getRightChild();
            }
            depth++;
        }
        return depth;
    }

    private static Node deleteNodeFromTree(Node root, int data) {
        if (root == null) {
            return null;
        }
        if (data < root.getData()) {
            root.setLeftChild(deleteNodeFromTree(root.getLeftChild(), data));
        } else if (data > root.getData()) {
            root.setRightChild(deleteNodeFromTree(root.getRightChild(), data));
        } else {
            if (root.getLeftChild() == null
                    && root.getRightChild() == null) {
                return null;
            } else if (root.getLeftChild() == null) {
                root = root.getRightChild();
            } else if (root.getRightChild() == null) {
                root = root.getLeftChild();
            } else {
                Node minNode = findMinOfTree(root.getRightChild());
                root.setData(minNode.getData());
                root.setRightChild(deleteNodeFromTree(root.getRightChild(), minNode.getData()));
            }
        }
        return root;
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

    private static void BFSTraversal(Node root) {
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
}
