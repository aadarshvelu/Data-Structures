package DSA;

public class Queue {
    public static Node peek() {
        return head;
    }

    static class Node {
        int data;
        Node next;
    }
    protected static Node head = null;

     static void enQueue(int data) {
        Node node = new Node();
        node.data = data;
        if(head == null) {
            head = node;
            return;
        }
        Node temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    static int deQueue() {
        try {
            Node temp = head;
            head = head.next;
            return temp.data;
        } catch (NullPointerException e) {
            head = null;
            return 0;
        }
    }

    static boolean isEmpty() {
         return head == null;
    }
    public static void main(String[] args) {
        for(int i = 0;i < 5;i++)
            enQueue(i);
        for(int j = 0;j < 6;j++)
            deQueue();
        for(int k = 0;k < 4;k++)
            enQueue(k);
        for(int x = 0;x < 4;x++)
            deQueue();
        System.out.println(isEmpty());
    }
}
