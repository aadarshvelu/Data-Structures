package DSA;

public class Stack {
    static class Node {
        int data;
        Node next = null;
    }
    private static Node Tail = null;

        public static void push(int data) {
            Node node = new Node();
            node.data = data;
            node.next = Tail;
            Tail = node;
        }
        // Delete the top most element
        public static Node pop () {
            return Tail = Tail.next;
        }

        // Returns the top most element present in stack;
        public static int peek () {
             return Tail.data;
        }

        public static boolean isEmpty() {
            return Tail == null;
        }
        //prints the all stack element
        static void print() {
            Node temp = Tail;
            while(temp != null) {
                System.out.println(temp.data);
                temp = temp.next;
            }
        }
        public static void main (String[]args){
            int i = 0;
            while (i < 4) {
                push(i);
                ++i;
            }
                print();
            pop();
            System.out.println();
            System.out.println();
            print();
            System.out.println();
            System.out.println();
            System.out.println(peek());
            pop();
            System.out.println(peek());
            }
        }

