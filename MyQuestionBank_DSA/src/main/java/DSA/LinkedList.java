package DSA;

class Node {
    Node next = null;
    Node previous = null;
    String data = null;
}
class SinglyLinkedList {

    private static Node head = null;

    private static void NewNode(String data) {
        Node newnode = new Node();
        newnode.data = data;
        if (head == null) {
            head = newnode;
        } else {
            Node traversal = head;
            while (traversal.next != null) {
                traversal = traversal.next;
            }
            traversal.next = newnode;
        }
    }

    private static void AddAtStart(String data) {
        Node node = new Node();
        node.data = data;
        node.next = head;
        head = node;
    }

    private static void AddAtSomeRandom(String data, int index) { //while index is 5
        if(index == 0)
            AddAtStart(data);
        Node node = new Node();
        node.data = data;
        Node Temp = head;
        for (int i = 0; i < index - 1; i++) {
            Temp = Temp.next;
        }
        node.next = Temp.next;
        Temp.next = node;
    }

    private static void Delete(int index) {
        Node Temp = head , Temp2;
        if(index != 0){
            for (int i = 0; i < index;i++) {
                Temp = Temp.next;
            }
            Temp2 = Temp.next;
            Temp.next = Temp2.next;
        } else {
            head = Temp.next;
        }
    }

    private static void print() {
        Node Temp = head;
        while (Temp.next != null) {
            System.out.println(Temp.data);
            Temp = Temp.next;
        }
        System.out.println(Temp.data);
    }

    public static void main(String[] args) {
        int i = 1;
        while(i <= 5){
            if(i != 3){
                NewNode(i + "");
            }
            ++i;
        }
        print();
        System.out.println();
        System.out.println();
        AddAtStart(0 + "");
        print();
        System.out.println();
        System.out.println();
        AddAtSomeRandom(3 + "", 3);
        print();
        System.out.println();
        System.out.println();
        Delete( 0);
        print();

    }
}

class DoublyList {

    private static Node  head = null , tail = null;

    private static void insert(String data) {
        Node node = new Node();
        node.data = data;
        if(head  ==  null) {
            head = node;
            tail = node;
            return;
        }
        Node traversal = head;
        while(traversal.next != null) {
            traversal = traversal.next;
        }
        traversal.next = node;
        node.previous = tail;
        tail = node;
    }

    private static void AddAtStart(String data) {
        Node node = new Node();
        node.data = data;
        head.previous = node;
        node.next = head;
        head = node;
    }

    private static void InsertAtRandom(int index , String data) {
        Node node = new Node();
        node.data = data;
        Node temp = head , tempforprevious;
        if (index == 0) {
            AddAtStart(data);
            return;
        }
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        try {
            node.next = temp;
            node.previous = temp.previous;
            tempforprevious = temp.previous;
            temp.previous = node;
            tempforprevious.next = node;
        } catch (NullPointerException e) {
            System.out.println("use Insert func! This the last element");
        }
    }

    private static void delete(int index) {
        Node deletionNode = head , tempforprevious = null , tempfornext = null;
        if(index == 0) {
            head = head.next;
            head.previous = null;
            return;
        }
        for(int i = 0;i < index;i++) {
            deletionNode = deletionNode.next;
        }

        tempforprevious = deletionNode.previous;
        tempfornext = deletionNode.next;

        tempforprevious.next = tempfornext;
        if(tempfornext != null)
        tempfornext.previous = tempforprevious;

    }

    private static void TraverseFront() {
        Node temp = head;
        while(temp.next != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
            System.out.print(temp.data + " ");
        System.out.println();
    }

    private static void TraverseBack() {
        Node temp = tail;
        while(temp.previous != null) {
            System.out.print(temp.data + " ");
            temp = temp.previous;
        }
        System.out.println(temp.data);
    }

    public static void main(String[] args) {
        for(int i = 0;i <= 10;i++) {
            if(i != 2){
                if(i != 4){
                    if(i != 9) {
                        insert(i+"");
                    }
                }
            }
        }
        TraverseFront();
        System.out.println();
        delete(0);
        TraverseFront();
        System.out.println();
        TraverseBack();
        System.out.println();
        AddAtStart(0 + "");
        TraverseFront();
        System.out.println();
        InsertAtRandom(2 , 2 + "");
        TraverseFront();
        System.out.println();
        TraverseBack();
        System.out.println();
        InsertAtRandom(4 , 4 + "");
        TraverseFront();
        System.out.println();
        InsertAtRandom(9 , 9 + "");
        System.out.println();
        TraverseFront();
        System.out.println();
        System.out.println();
        TraverseBack();
    }
}

public class LinkedList { }