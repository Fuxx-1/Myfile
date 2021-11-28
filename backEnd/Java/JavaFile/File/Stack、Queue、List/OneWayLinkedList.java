/**
 * @create: 2021-04-26 14:24
 **/

class LinkedListby1Way<T> {
    private Node Head, Tail;
    private int N;

    public LinkedListby1Way() {
        this.Head = new Node(null, null);
        Tail = Head;
        this.N = 0;
    }

    public void ClearList() {
        this.Head.next = null;
        this.N = 0;
    }

    public int Length() {
        return this.N;
    }

    public boolean IsEmpty() {
        return N == 0;
    }

    public T getItem(int i) {
        Node n = Head.next;
        for (int j = 0; j < i; j++) {
            n = n.next;
        }
        return n.item;
    }

    public void AddNode(T t) {
//        Node n = Head;
//        while (n.next != null) {
//            n = n.next;
//        }
        Node NewNode = new Node(t, null);
        Tail.next = NewNode;
        Tail = NewNode;
        N++;
    }

    public void PrintList() {
        Node n = Head;
        while (n.next != null) {
            System.out.println(n.next.item);
            n = n.next;
        }
    }

    private class Node {
        T item;
        Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }
}

public class OneWayLinkedList {
    public static void main(String[] args) {
        LinkedListby1Way<Object> list = new LinkedListby1Way<>();
        list.AddNode("ksjadfd");
        list.AddNode("ksjadfd");
        list.AddNode(2134252134);
        list.PrintList();
    }
}