package DSA;

public  class GraphTheory {

    static class MatrixRepresentation {

        private static int[][] matrix = new int[0][0];

        private static int dynamicIncreaser = 1;

        private static void insert(int element) {
            try {
                matrix[element][element-1] = 1;
            } catch (ArrayIndexOutOfBoundsException e) {
                getIncrease();
                insert(element);
            }
        }

        private static void adjacent(int element , int flag) {
            try {
                matrix[element][flag-1] = 1;
            } catch (Exception e) {
                getIncrease();
                adjacent(element , flag);
            }
        }

        private static void hasConnection(int element , int adjacent) {
            try {
                if(matrix[element][adjacent-1] == 0)
                    System.out.println("False");
                else
                    System.out.println("True");
            } catch (Exception e) {
                System.out.println("False");
            }

        }

        private static void BFS(int element) {
            System.out.print("BFS : ");
            int[] visitedArray = new int[dynamicIncreaser];
            Queue.enQueue(element);
            boolean plug = true;
            while (!Queue.isEmpty()) {
                if(!Queue.isEmpty())
                    element = Queue.head.data;
                for(int i = 0;i < visitedArray.length;i++) {
                    if (i != element - 1) {
                        if (visitedArray[i] == 0) {
                            if (matrix[element][i] == 1) {
                                Queue.enQueue(i + 1);
                                visitedArray[i] = 1;
                            }
                        }
                    }
                }
                if(plug){ visitedArray[element-1] = 1; }
                plug = false;
                System.out.print( Queue.deQueue() + " " );
            }

        }

        private static int[] visitedArray;

        private static void DFS(int element) {
            System.out.print("DFS : ");
            visitedArray = new int[dynamicIncreaser];
            boolean plug = true;
            Stack.push(element);
            System.out.print(element + " ");
            while(!Stack.isEmpty()) {
                element = Stack.peek();
                if(hasVisited(element))
                    Stack.pop();
                for(int i = 0;i < visitedArray.length;i++) {
                    if (i != element - 1) {
                        if (visitedArray[i] == 0) {
                            if (matrix[element][i] == 1) {
                                Stack.push(i + 1);
                                visitedArray[i] = 1;
                                System.out.print(i+1 + " ");
                                break;
                            }
                        }
                    }
                }
                if(plug)
                    visitedArray[element-1] = 1;
                plug = false;

            }
        }

        private static boolean hasVisited(int element) {
            for(int i = 0;i < visitedArray.length;i++) {
                if (i != element - 1) {
                    if (visitedArray[i] == 0) {
                        if (matrix[element][i] == 1) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }

        private static void getIncrease() {
            int index = 0;
            dynamicIncreaser *= 2;
            int[][] temp = new int[dynamicIncreaser][dynamicIncreaser];
            for(int i = 0; i < dynamicIncreaser; i++) {
                ++index;
                for(int j = 0; j < dynamicIncreaser; j++) {
                    temp[i][j] = 0;
                }
                temp[0][i] = index;
            }
            for(int x = 0;x < matrix.length;x++)
                System.arraycopy(matrix[x], 0, temp[x], 0, matrix.length);
            matrix = temp;
        }

        private static void getMatrixRepresentation() {
            int index = 0;
            for(int i = 0; i < dynamicIncreaser; i++) {
                System.out.print(index + "  ");
                if(index < 10)
                    System.out.print(" ");
                for(int j = 0; j < dynamicIncreaser; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
                ++index;
            }
        }

        private static void flush() {
            matrix = new int[][]{};
            dynamicIncreaser = 1;
        }

        public static void main(String[] args) {

            flush();
            for(int i = 1;i < 8;i++){
                insert(i);
            }
       /* // for 1
        adjacent(1 , 2);
        adjacent(1 , 3);
        // for 2
        adjacent(2 , 1);
        adjacent(2 , 5);
        adjacent(2 , 7);
        // for 3
        adjacent(3 , 1);
        adjacent(3 , 4);
        adjacent(3 , 5);
        // for 4
        adjacent(4 , 3);
        adjacent(4 , 6);
        // for 5
        adjacent(5 , 2);
        adjacent(5 , 3);
        adjacent(5 , 7);
        adjacent(5 , 8);
        // for 6
        adjacent(6 , 4);
        // for 7
        adjacent(7 , 2);
        adjacent(7 , 5);
        adjacent(7 , 8);
        // for 8
        adjacent(8 , 5);
        adjacent(8 , 7);

        hasConnection(3 , 2);
        hasConnection(7 , 1);
*/
            // for 1
            adjacent(1 , 2);
            adjacent(1 , 3);
            // for 2
            adjacent(2 , 5);
            adjacent(2 , 7);
            // for 3
            adjacent(3 , 1);
            adjacent(3 , 4);
            adjacent(3 , 5);
            // for 4
            adjacent(4 , 6);
            // for 5
            adjacent(5 , 2);
            adjacent(5 , 3);
            adjacent(5 , 6);
            // for 6
            adjacent(6 , 4);
            // for 7
            adjacent(7 , 2);
            adjacent(7 , 8);

            hasConnection(3 , 2);
            hasConnection(7 , 1);
            getMatrixRepresentation();

            System.out.println();
            BFS(2);
            System.out.println();
            BFS(5);
            System.out.println();
            DFS(2);
            System.out.println();
            DFS(7);
        }
    }

    static class AdjacentList {

        static class Node extends Queue.Node {
            int  data  = 0;
            Node next  = null;
            Node down = null;
        }

        private static Node head  = null;

        private static int count  = 1;

        private static void insert(int data) {

            Node node = new Node();
            node.data = data;

            if(head == null) {
                head  = node;
                return;
            }

            Node Traversal = head;

            while (Traversal.down != null) {
                Traversal  = Traversal.down;
            }
            Traversal.down = node;
            ++count;
        }

        private static void adjacent(int element , int flag) {

            Node node = new Node();
            node.data = flag;
            Node temp = head;
            while (temp.down != null) {
                if(temp.data == element) {
                    break;
                }
                temp = temp.down;
            }

            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }

        private static void hasConnection(int element , int adjacent) {
            Node traverse = head;

            while (traverse.down != null) {
                if(traverse.data == element) {
                    break;
                }
                traverse = traverse.down;
            }

            while (traverse.next != null) {
                traverse = traverse.next;
                if(traverse.data == adjacent) {
                    System.out.println("true");
                    return;
                }
            }

            System.out.println("false");
        }

        private static void BFS(int element) {
            System.out.print("BFS :");
            Node traverseNode = null;
            int[] visitedArray = new int[count];
            Queue.enQueue(element);
            visitedArray[element-1] = 1;
            while (!Queue.isEmpty()) {
                if(!Queue.isEmpty())
                    traverseNode = getElement(Queue.head.data);
                while (traverseNode != null) {
                    if(traverseNode != head){
                        if(visitedArray[traverseNode.data-1] == 0) {
                            Queue.enQueue(traverseNode.data);
                            visitedArray[traverseNode.data-1] = 1;
                        }
                    } else {
                        if(visitedArray[traverseNode.next.data] == 0) {
                            Queue.enQueue(traverseNode.next.data);
                            visitedArray[traverseNode.next.data-1] = 1;
                        }
                    }
                    traverseNode = traverseNode.next;
                }
                System.out.print(" " +Queue.deQueue());
            }

        }

        private static int[] visitedArray;

        private static void DFS(int element) {
            System.out.print("DFS : ");
            Node traverseNode = null;
            visitedArray = new int[count];
            Stack.push(element);
            visitedArray[element-1] = 1;
            System.out.print(element + " ");
            while (!Stack.isEmpty()) {
                if(!Stack.isEmpty())
                    traverseNode = getElement(Stack.peek());
                if(hasVisited(traverseNode))
                    Stack.pop();
                while(traverseNode != null) {
                    if(traverseNode == head) {
                        if(visitedArray[traverseNode.next.data] == 0) {
                            Stack.push(traverseNode.next.data);
                            visitedArray[traverseNode.next.data-1] = 1;
                            System.out.print(traverseNode.next.data + " ");
                            break;
                        }
                    } if(visitedArray[traverseNode.data-1] == 0) {
                        Stack.push(traverseNode.data);
                        visitedArray[traverseNode.data-1] = 1;
                        System.out.print(traverseNode.data + " ");
                        break;
                    }
                    traverseNode = traverseNode.next;
                }
            }
        }

        private static boolean hasVisited(Node dataNode) {
            Node temp = dataNode;
            while (temp != null) {
                if(visitedArray[temp.data-1] == 0) {
                    return false;
                }
                temp = temp.next;
            }
            return true;
        }

        private static Node getElement(int element) {
            Node temp = head;
            while (temp != null) {
                if(temp.data == element) {
                    return temp;
                }
                temp = temp.down;
            }
            return null;
        }

        private static void nodePrint(Node temp) {
            System.out.print(temp.data);
            while (temp.next != null) {
                temp = temp.next;
                System.out.print(" -> " +temp.data);
            }
            System.out.println();
            System.out.println("|");
        }

        private static void print() {
            Node temp = head;

            while(temp.down != null) {
                nodePrint(temp);
                temp = temp.down;
            }
            nodePrint(temp);
        }

        private static void flush() {
            head = null;
        }

        public static void main(String[] args) {

            flush();
            for(int i = 1;i < 8;i++) {
                insert(i);
            }
       /* // for 7
        adjacent(7 , 8);
        adjacent(7 , 9);
        adjacent(7 , 10);
        adjacent(7 , 11);
        // for 8
        adjacent(8 , 7);
        // for 9
        adjacent(9 , 7);
        adjacent(9 , 13);
        // for 10
        adjacent(10 , 7);
        adjacent(10 , 12);
        adjacent(10 , 15);
        // for 11
        adjacent(11 , 7);
        adjacent(11 , 14);
        adjacent(11 , 15);
        // for 12
        adjacent(12 , 10);
        // for 13
        adjacent(13 , 9);
        // for 14
        adjacent(14 , 11);
        // for 15
        adjacent(15 , 11);*/

            // for 1
            adjacent(1 , 2);
            adjacent(1 , 3);
            // for 2
            adjacent(2 , 5);
            adjacent(2 , 7);
            // for 3
            adjacent(3 , 1);
            adjacent(3 , 4);
            adjacent(3 , 5);
            // for 4
            adjacent(4 , 6);
            // for 5
            adjacent(5 , 2);
            adjacent(5 , 3);
            adjacent(5 , 6);
            // for 6
            adjacent(6 , 4);
            // for 7
            adjacent(7 , 2);

            hasConnection(3 , 2);
            hasConnection(7 , 1);

            print();

            BFS(3);
            System.out.println();
            BFS(5);
            System.out.println();
            DFS(5);
            System.out.println();
            DFS(2);

        }
    }

}