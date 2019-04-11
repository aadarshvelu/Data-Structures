package DSA;

public class Hashing {

    public static void main(String[] args) {

    }
    /*
   *
   * Hashing in normal way   | h(x) = h(x) % size of the givenArray |
   *
   ***/


    private static int[] hashTable = new int[10];

    private static void hash(int element) {
        hashTable[element % hashTable.length] = element;
    }

}

class OpenHashing {

    /*
     * Open Hashing uses LinkedList to save the data.
     * Open Hashing uses the technique called chaining.
     *
     * */

    static class Node {
        int data;
        Node previous = null;
        Node next = null;
    }

    private static Object[] hashTable = new Object[10];

    private static void hash(int element) {

        int hash = element % hashTable.length;

        if (hashTable[hash] == null) {

            Node node = new Node();
            node.data = element;

            node.previous = (Node) hashTable[hash];
            hashTable[hash] = node;

        } else {

            Node node = new Node();
            node.data = element;

            Node traversal = (Node) hashTable[hash];

            while (traversal.next != null) {
                traversal = traversal.next;
            }

            traversal.next = node;
            node.previous = traversal;

        }
    }

    private static void print() {

        for (Object i : hashTable) {

            Node traversal = (Node) i;

            if (traversal != null) {
                while (traversal.next != null) {
                    System.out.print(traversal.data + " ->  ");
                    traversal = traversal.next;
                }
                System.out.print(traversal.data);
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 13, 8, 18 , 28, 19, 9};

        for (int i : arr) {
            hash(i);
        }

        print();
    }
}

class ClosedHashing {
    /*
    * Consist of two types :
    *
    * Linear probing.    -> | h(x) = [ h(x) + f(i)   ] % size of the array. |
    *
    * Quadratic probing. -> | h(x) = [ h(x) + f(i^2) ] % size of the array. |
    *
    *
    **/

    static class LinearProbing {
        private static int[] hashTable = new int[20];

        private static void hash(int element) {
            int i = 0;

            while (true) {
                if( hashTable[ (element + i) % hashTable.length ] == 0 ) {
                    hashTable[ (element + i) % hashTable.length ] = element;
                    return;
                } else {
                    ++i;
                }
            }

        }

        private static void print() {
            for(int i : hashTable)
                System.out.print(i + " ");
        }

        public static void main(String[] args) {
            int[] arr = new int[]{2, 12, 22, 33, 4, 44, 8, 5};

            for (int i : arr)
                hash(i);

            print();
        }
    }

    static class QuadraticProbing {

        private static int[] hashTable = new int[20];

        private static void hash(int element) {
            int i = 0;

            while (true) {
                if( hashTable[(int) ((element + Math.pow(i , 2)) % hashTable.length)] == 0 ) {
                    hashTable[(int) ((element + Math.pow(i , 2)) % hashTable.length)] = element;
                    return;
                } else {
                    ++i;
                }
            }

        }

        private static void print() {
            for(int i : hashTable)
                System.out.print(i + " ");
        }

        public static void main(String[] args) {
            int[] arr = new int [] { 2 , 12 , 22  , 33 , 4 ,44 , 8 , 5 };

            for(int i : arr)
                hash(i);

            print();
        }
    }

}