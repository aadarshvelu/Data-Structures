package DSA;

public class BinarySearchTree {

    static class Node {
        int data;
        Node leftChild = null, rightChild = null;
        Node parent = null;
    }

    private static Node root = null;

    private static void insert(int data) {

        Node node = new Node();
        node.data = data;

        if(root == null) {
            root = node;
            return;
        }

        Node tempParent = root;

        while (node.parent == null) {

            if(node.data < tempParent.data) {

                if(tempParent.leftChild == null) {
                    tempParent.leftChild = node;
                    node.parent = tempParent;
                } else {
                    tempParent = tempParent.leftChild;
                }

            } else {

                if (tempParent.rightChild == null) {
                    tempParent.rightChild = node;
                    node.parent = tempParent;
                } else {
                    tempParent = tempParent.rightChild;
                }

            }

        }

    }

    private static void preOrder(Node root) {

            if(root != null) {
                System.out.print(root.data + " ");
                preOrder(root.leftChild);
                preOrder(root.rightChild);
            }

    }

    private static void postOrder(Node root) {

            if(root != null) {
                postOrder(root.leftChild);
                postOrder(root.rightChild);
                System.out.print(root.data + " ");
            }

    }

    private static void inOrder(Node root) {

            if(root != null) {
                inOrder(root.leftChild);
                System.out.print(root.data + " ");
                inOrder(root.rightChild);
            }

    }

    public static void main(String[] args) {
        int [] arr = new int [] {10 , 7 , 14 , 20 , 1 , 8 };

        for(int i : arr) {
            insert(i);
        }

        System.out.print("PreOrder : ");
        preOrder(root);
        System.out.print("PostOrder : ");
        postOrder(root);
        System.out.print("InOrder : ");
        inOrder(root);
    }
}