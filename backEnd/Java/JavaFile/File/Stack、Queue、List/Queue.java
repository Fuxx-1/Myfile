/**
 * @create: 2021-04-26 14:25
 **/
//队列

/**
 * @create: 2021-04-26 13:46
 **/
//栈
class QueueTest<T> {
    private Node Head, Tail;
    private int N;

    public QueueTest() {
        this.Head = new Node(null, null, null);
        Tail = Head;
        this.N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void Add(T item) {
        Node NewNode = new Node(item, Head, Head.next);
        if (N == 0) {
            Tail = NewNode;
        }
        if (Head.next != null) {
            Head.next.pre = NewNode;
        }
        Head.next = NewNode;
        N++;
    }

    public Node Pop() {
        Node val;
        val = Tail;
        Tail.pre.next = null;
        Tail = Tail.pre;
        N--;
        return val;
    }

    public class Node {
        T item;
        Node next, pre;

        public Node(T item, Node pre, Node next) {
            this.item = item;
            this.pre = pre;
            this.next = next;
        }

        public T getItem() {
            return item;
        }
    }

}


public class Queue {
    public static void main(String[] args) {
        QueueTest<Object> Qu = new QueueTest<>();
        Qu.Add("qsdfghjksdfhjk");
        Qu.Add(12344123);
        System.out.println(Qu.Pop().getItem());
        System.out.println(Qu.Pop().getItem());
    }
}
